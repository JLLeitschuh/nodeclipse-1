package org.nodeclipse.ui.contentassist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Using Orion IndexFiles for libraries for content assist</br>
 * 
<pre>
express={
  "!define": {
    "response": {
      "send": {"!type": "fn(body: String) -> response"},
      "get": {"!type": "fn(field: String) -> String"},
      "location": {"!type": "fn(url: String) -> response"},
      "status": {"!type": "fn(code: Number) -> response"},
      "set": {"!type": "fn(field: Object, val: String) -> response"},
      "links": {"!type": "fn(links: Object) -> response"},
      "download": {"!type": "fn(path: String, filename: String, fn: fn())"}, * 
</pre>
 * @author Paul Verest
 * @since 0.12
 */
public class ContentFromOrionIndexFiles {
	private static boolean verbose = true;
	private static int errorCounter = 0;
	private static Model model = null;

	/* 
	 * Run this As Java Application to check .indexFiles 
	 * 
	 * Reading Libraries IndexFiles finished in 40 ms. errorCounter=2
	 * */
	public static void main(String[] args) {
		model = new Model();
		long startTime = System.currentTimeMillis(); //nanoTime();
//		addIndexFile("amqp");
//		addIndexFile("browser");
//		addIndexFile("ecma5");
//		addIndexFile("express");
//		addIndexFile("mongodb");
//		addIndexFile("mysql");
//		addIndexFile("node");
//		addIndexFile("postgres");
//		addIndexFile("redis");
		addIndexFile(model, "express");
		
		long time = System.currentTimeMillis() - startTime;		
		log("Reading Libraries IndexFiles finished in "+time+" ms. errorCounter="+errorCounter);
	}

	// see analog ContentFromSources.populateModel()
	private static boolean addIndexFile(Model model, String libname) {
		JSONObject libraryIndex = jsonForLibrary(libname);
		if (libraryIndex == null){
			return false;
		}
		try {
			String moduleName = libraryIndex.getString("!name");
			debug(", " + moduleName);
			Module moduleObj = new Module(moduleName);
			model.addModule(moduleObj);
			
			JSONObject module = (JSONObject) libraryIndex.get("!define");
			if (verbose) debug("(("+module.length()+")):");
			
			//DONE add moduleDesc as list of higher level objects
			String moduleDesc = formatedName(moduleName)+module.names();
			Entry moduleEntry = new Entry(moduleObj,EntryType.module,moduleName,moduleName,moduleDesc,null);
			model.addEntry(moduleEntry);	
			
			if (verbose) debug("\n    Model size="+model.entries.size());
			
//	        "response": {
//  	      "send": {"!type": "fn(body: String) -> response"},
			
			Iterator keysIterator = module.keys();
		    while (keysIterator.hasNext()){
		    	String key = keysIterator.next().toString();
		    	JSONObject obj = (JSONObject) module.get(key);
		    	if (verbose) debug("\n"+key+"("+obj.length()+"):");
		    	
		    	String trigger = moduleName+'.'+key;
				String name = key;
				String desc = formatedName(name,trigger);
				//read !proto, !type to make desc
				String proto = obj.optString("!proto");
				if (""!=proto){ desc+="prototype:"+proto+' ';}
				String type = obj.optString("!type");
				if (""!=type){ desc+="type:"+type+' ';}
				
				Entry entry = new Entry(moduleObj,EntryType.unknown,name,trigger,desc,moduleEntry);
				model.addEntry(entry);
				
				// obj may have other objects inside
				populateCheckObj(obj, trigger, moduleObj, entry);
		    	
				if (verbose) debug("\n    Model size="+model.entries.size());
		    }
		    if (verbose) debug(";\n");
						
			
		} catch (ClassCastException e) {
			errorCounter++;
			error(e.getLocalizedMessage() + "\n" + e + "\n");
		} catch (JSONException e) {
			errorCounter++;
			error(e.getLocalizedMessage() + "\n" + e + "\n");
		}

		return true;
	}
	
	public static boolean checkProperties = true;
	
	private static void populateCheckObj(JSONObject obj, String objTrigger, Module moduleObj, Entry parent) throws JSONException {
		if (!checkProperties){
			return;
		}
		
		Iterator keysIterator = obj.keys();
	    while (keysIterator.hasNext()){
	    	String key = keysIterator.next().toString();
	    	if (verbose) debug(key+'`');
	    	if (key.equals("!proto")||key.equals("!type")) { 
	    		continue;
	    	}
	    	//JSONObject objEement = (JSONObject) obj.get(key);
	    	Object objEementObject = obj.get(key);
	    	JSONObject objEement = null;
	    	
	    	String trigger = objTrigger+'.'+key;
	    	String name = key;
	    	String desc = formatedName(name,trigger);
	    	
	    	if (objEementObject instanceof String ){
//		        "express": {
//	    	      "response": "response",
	    	} else{
	    		objEement = (JSONObject) objEementObject;
				//read !proto, !type to make desc
				String proto = objEement.optString("!proto");
				if (""!=proto){ desc+="prototype:"+proto+' ';}
				String type = objEement.optString("!type");
				if (""!=type){ desc+="type:"+type+' ';}
	    	}
			
			Entry entry = new Entry(moduleObj,EntryType.unknown,name,trigger,desc,parent);
			model.addEntry(entry);
	    }
		
	}	
	
	private static String formatedName(String name) {
		return "<b>"+name+"</b><br/>";
	}
	private static String formatedName(String name, String trigger) {
		return formatedName(name)+"<code>"+trigger+"</code><br/>";
	}
	
	private static JSONObject jsonForLibrary(String libname){
		if (libname==null || libname.length()==0)
			return null;
		String filename = "org/nodeclipse/ui/contentassist/indexFiles/"+libname+"Index.js";
		JSONObject libraryIndex = null;
        try {
            InputStream is = ContentFromSources.class.getClassLoader().getResourceAsStream(filename);
            String index = inputStream2StringWithJson(is);
            libraryIndex = new JSONObject(index);
            if (verbose) debug( libname+'='+ libraryIndex.toString(2)+'\n');
        } catch (JSONException e) {
        	errorCounter++;
        	error("error "+errorCounter+" in "+libname+": "+ e.getLocalizedMessage()+"\n");
        } catch (IOException e) {
        	error(e.getLocalizedMessage()+"\n");
        }
		return libraryIndex;
	}
	
    private static String inputStream2StringWithJson(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuilder buffer = new StringBuilder();
        String line = "";
        boolean isJsonStarted = false;
        while ((line = in.readLine()) != null) {
        	if (!isJsonStarted){ //skipping header
        		if (!line.contains("return")){
        			continue;
        		}
        		isJsonStarted = true;
        		buffer.append("{");
        		continue;
        	}
            buffer.append(line);
        }
        return buffer.toString();
    }
	
	
    private static void error(String s){
    	//NodeclipseConsole.write(s);
    	System.err.print(s);
    }
    private static void debug(String s){
    	//NodeclipseConsole.write(s);
    	System.out.print(s);
    }
    private static void log(String s){
    	//NodeclipseConsole.write(s);
    	System.out.print(s);
    }
	

}
