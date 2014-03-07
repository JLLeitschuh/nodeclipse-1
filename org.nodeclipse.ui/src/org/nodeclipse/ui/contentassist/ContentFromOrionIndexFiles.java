package org.nodeclipse.ui.contentassist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

/* 
 * Run this As Java Application to check .indexFiles 
 * 
 * Reading Libraries IndexFiles finished in 40 ms. errorCounter=2
 * 
 * */
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
		if (libraryIndex == null)
			return false;
		try {
			String moduleName = libraryIndex.getString("!name");
			debug(", " + moduleName);
			Module moduleObj = new Module(moduleName);
			model.addModule(moduleObj);
			
			JSONObject module = (JSONObject) libraryIndex.get("!define");
			debug("("+module.length()+")");
			
			//DONE add moduleDesc as list of higher level objects
			String moduleDesc = formatedName(moduleName)+module.names();
			Entry moduleEntry = new Entry(moduleObj,EntryType.module,moduleName,moduleName,moduleDesc,null);
			model.addEntry(moduleEntry);	
			
//	        "response": {
//  	      "send": {"!type": "fn(body: String) -> response"},
			
			Iterator keysIterator = module.keys();
		    while (keysIterator.hasNext()){
		    	String key = keysIterator.next().toString();
		    	System.out.println(key);
		    	JSONObject obj = (JSONObject) libraryIndex.get(key);
		    	
		    	String trigger = moduleName+'.'+key;
				String name = key;
				String desc = formatedName(name,trigger);
				
				//TODO read !proto, !type to make desc

				Entry entry = new Entry(moduleObj,EntryType.method,name,trigger,desc,moduleEntry);
				model.addEntry(entry);
				
				// property may have properties, see http.IncomingMessage -> message.httpVersion
				populateCheckProperties(obj, trigger, moduleObj, entry);
		    	
		    	
		    }			
						
			
		} catch (JSONException e) {
			log(e.getLocalizedMessage() + "\n" + e);
		}

		return true;
	}
	
	public static boolean checkProperties = true;
	
	private static void populateCheckProperties(JSONObject obj, String moduleName, Module moduleObj, Entry parent) throws JSONException {
		if (!checkProperties){
			return;
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
