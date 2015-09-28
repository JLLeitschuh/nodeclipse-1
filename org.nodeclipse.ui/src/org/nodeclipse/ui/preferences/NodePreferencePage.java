package org.nodeclipse.ui.preferences;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.internal.browser.WorkbenchBrowserSupport;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.nodeclipse.ui.Activator;
import org.nodeclipse.ui.util.ProcessUtils;
import org.nodeclipse.ui.util.VersionUtil;

/**
 * @author Tomoyuki Inagaki
 * @author Paul Verest
 */
public class NodePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private BooleanFieldEditor nodeclipseConsoleEnabled;

	private BooleanFieldEditor nodeJustNode;
    private FileFieldEditor nodePath;
    private StringFieldEditor nodeOptions;
    private StringFieldEditor nodeApplicationArguments;
    private BooleanFieldEditor nodeAllowMany;
    private BooleanFieldEditor nodePassAllEnvVars;
    private BooleanFieldEditor addJsdtNature;
    private BooleanFieldEditor addTernNature;
    private DirectoryFieldEditor nodeSourcesPath;
    private BooleanFieldEditor useNodejsBaseModuleDefinitions;
    private BooleanFieldEditor useOrionIndexFiles;
    private BooleanFieldEditor useCompletionJson;
    private FileFieldEditor completionsPath;
    private BooleanFieldEditor nodeDebugNoBreak;
    private IntegerFieldEditor nodeDebugPort;
    //private FileFieldEditor nodeMonitorPath;
    private FileFieldEditor expressPath;
    private StringFieldEditor expressVersion;
    private FileFieldEditor coffeePath;
    //private BooleanFieldEditor coffeeJustCoffee;
    private StringFieldEditor coffeeCompileOptions;
    private StringFieldEditor coffeeCompileOutputFolder;
    private FileFieldEditor typescriptCompilerPath;
    private StringFieldEditor typescriptCompilerOptions;

    public NodePreferencePage() {
        super(GRID);
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
	    setImageDescriptor(Activator.getImageDescriptor("icons/node.png"));
        setDescription(
        	VersionUtil.getLongString()+
        	"\n"+
    		"Node.js, Express, CoffeeScript, TypeScript settings");
    }

	@Override
    public void init(IWorkbench workbench) {
	}
	
    private void addLinkWidget(String text, final String urlString){
       	// http://stackoverflow.com/questions/22424993/eclipse-plugin-dev-how-to-add-hyperlink-on-fieldeditorpreferencepage
        Link link = new Link(getFieldEditorParent(), SWT.NONE);
        link.setText(text);
        //link.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 3, 1));
        link.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(final SelectionEvent event) {
				try {
					URL url = new URL(urlString);
					try {
						//WorkbenchBrowserSupport.getInstance().getExternalBrowser().openURL(url );
						PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(url );
					} catch (PartInitException e) {
					}
				} catch (MalformedURLException e) {
				}
        	}
        });
    }

////                int style = IWorkbenchBrowserSupport.AS_EDITOR | IWorkbenchBrowserSupport.LOCATION_BAR | IWorkbenchBrowserSupport.NAVIGATION_BAR | IWorkbenchBrowserSupport.STATUS;
////                IWebBrowser browser;
////                try {
////                    browser = WorkbenchBrowserSupport.getInstance().createBrowser(style, "NodeclipsePluginsListID", "NodeclipsePluginsList", "Nodeclipse Plugins List");
////                    browser.openURL(new URL("http://www.nodeclipse.org/updates"));
////                } catch (PartInitException e) {
////                    e.printStackTrace();
////                } catch (MalformedURLException e) {
////                    e.printStackTrace();
////                }
//        		
////				IWorkbenchPreferenceContainer container= (IWorkbenchPreferenceContainer) getContainer();
////				container.openPage("org.eclipse.ui.preferencePages.GeneralTextEditor", null);
 
    	//TODO possible to copy version string
		//    	String verString = VersionUtil.getLongString();
		//        nodeclipseVersionsString = new StringFieldEditor(PreferenceConstants.NODE_OPTIONS, "Node options (node -h):", getFieldEditorParent());
		//        nodeclipseVersionsString.setStringValue(verString);
		//        nodeclipseVersionsString.setTextLimit(verString.length());
		//        nodeclipseVersionsString.setEnabled(false, (Composite) this);
		//        addField(nodeclipseVersionsString);
    @Override
    protected void createFieldEditors() {
    	addLinkWidget("Visit <A>www.nodeclipse.org</A> for news", "http://www.nodeclipse.org/");
    	addLinkWidget(" and <A>history</A>.", "http://www.nodeclipse.org/history");
    	addLinkWidget("<A>GitHub</A>", "https://github.com/nodeclipse/nodeclipse-1/");
    	
        nodeclipseConsoleEnabled = new BooleanFieldEditor(PreferenceConstants.NODECLIPSE_CONSOLE_ENABLED, 
        		"enable Nodeclipse Console", getFieldEditorParent());
        addField(nodeclipseConsoleEnabled);

        nodeJustNode = new BooleanFieldEditor(PreferenceConstants.NODE_JUST_NODE, 
        		"find node on PATH. Otherwise use Node.js instance in location below", getFieldEditorParent());
        addField(nodeJustNode);

        nodePath = new FileFieldEditor(PreferenceConstants.NODE_PATH, "Node.js path:", getFieldEditorParent());
        addField(nodePath);
        
        nodeOptions = new StringFieldEditor(PreferenceConstants.NODE_OPTIONS, "Node options (node -h):", getFieldEditorParent());
        addField(nodeOptions);

        nodeApplicationArguments = new StringFieldEditor(PreferenceConstants.NODE_APPLICATION_ARGUMENTS, "Node Application arguments:", getFieldEditorParent());
        addField(nodeApplicationArguments);
        
        nodeAllowMany = new BooleanFieldEditor(PreferenceConstants.NODE_ALLOW_MANY, 
        		"allow many Node.js instances running", getFieldEditorParent());
        addField(nodeAllowMany);
        
        nodePassAllEnvVars = new BooleanFieldEditor(PreferenceConstants.NODE_PASS_ALL_ENVIRONMENT_VARIABLES, 
        		"pass all environment variables of Eclipse to launched Node.js app", getFieldEditorParent());
        addField(nodePassAllEnvVars);

        addJsdtNature = new BooleanFieldEditor(PreferenceConstants.ADD_JSDT_NATURE, 
        		"add JSDT nature to newly created projects", getFieldEditorParent());
        addField(addJsdtNature);
        addTernNature = new BooleanFieldEditor(PreferenceConstants.ADD_TERN_NATURE, 
        		"add Tern nature to newly created projects", getFieldEditorParent());
        addField(addTernNature);
        
        nodeSourcesPath = new DirectoryFieldEditor(PreferenceConstants.NODE_SOURCES_PATH, "Node sources directory path:", getFieldEditorParent());
        addField(nodeSourcesPath);

        useNodejsBaseModuleDefinitions = new BooleanFieldEditor(PreferenceConstants.USE_NODEJS_BASE_MODULE_DEFINITIONS, 
        		"use Node.js base module definitions (changed after restart)", getFieldEditorParent());
        addField(useNodejsBaseModuleDefinitions);
        useOrionIndexFiles = new BooleanFieldEditor(PreferenceConstants.USE_ORION_INDEX_FILES, 
        		"use Orion IndexFiles (changed after restart)", getFieldEditorParent());
        addField(useOrionIndexFiles);
        useCompletionJson = new BooleanFieldEditor(PreferenceConstants.USE_COMPLETIONS_JSON, 
        		"use completion.json (changed after restart)", getFieldEditorParent());
        addField(useCompletionJson);

        completionsPath = new FileFieldEditor(PreferenceConstants.COMPLETIONS_JSON_PATH, "Alternative completions.json path:", getFieldEditorParent());
        addField(completionsPath);
    	
        // "Node debug no -break (disable interruption of Node.js app on first line, check debug Help)" would make dialog wider
        nodeDebugNoBreak = new BooleanFieldEditor(PreferenceConstants.NODE_DEBUG_NO_BREAK, 
        		"Node debug without -brk (disable interruption of Node.js app start)", getFieldEditorParent());
        addField(nodeDebugNoBreak);

        nodeDebugPort = new IntegerFieldEditor(PreferenceConstants.NODE_DEBUG_PORT, "Node debug port:", getFieldEditorParent());
        addField(nodeDebugPort);

//        nodeMonitorPath = new FileFieldEditor(PreferenceConstants.NODE_MONITOR_PATH, "Node monitor path:", getFieldEditorParent());
//        addField(nodeMonitorPath);

        expressPath = new FileFieldEditor(PreferenceConstants.EXPRESS_PATH, "Express path:", getFieldEditorParent());
        addField(expressPath);
        
        expressVersion = new StringFieldEditor(PreferenceConstants.EXPRESS_VERSION, "Selected Express version:", getFieldEditorParent());
        expressVersion.setEnabled(false, getFieldEditorParent());
        addField(expressVersion);        

        coffeePath = new FileFieldEditor(PreferenceConstants.COFFEE_PATH, "Coffee path:", getFieldEditorParent());
        addField(coffeePath);

		//        coffeeJustCoffee = new BooleanFieldEditor(PreferenceConstants.COFFEE_JUST_COFFEE, 
		//        		"just coffee (let Node.js find coffee CLI)", getFieldEditorParent());
		//        addField(coffeeJustCoffee);

        coffeeCompileOptions = new StringFieldEditor(PreferenceConstants.COFFEE_COMPILE_OPTIONS, "Coffee compile options:", getFieldEditorParent());
        addField(coffeeCompileOptions);

        coffeeCompileOutputFolder = new StringFieldEditor(PreferenceConstants.COFFEE_COMPILE_OUTPUT_FOLDER, "Coffee output folder #76", getFieldEditorParent());
        addField(coffeeCompileOutputFolder);

        typescriptCompilerPath = new FileFieldEditor(PreferenceConstants.TYPESCRIPT_COMPILER_PATH, "TypeScript compiler path:", getFieldEditorParent());
        addField(typescriptCompilerPath);

        typescriptCompilerOptions = new StringFieldEditor(PreferenceConstants.TYPESCRIPT_COMPILER_OPTIONS, "TypeScript compiler options:", getFieldEditorParent());
        addField(typescriptCompilerOptions);

    }
    
    @Override
    protected void initialize() {
    	super.initialize();
		expressPath.setPropertyChangeListener(new MyPropertyChangeListener(this));
    }
    
    private class MyPropertyChangeListener implements IPropertyChangeListener{
    	
    	private FieldEditorPreferencePage page;
    	private boolean isValidPath = true;

		public MyPropertyChangeListener(FieldEditorPreferencePage nodePreferencePage) {
			page = nodePreferencePage;
		}

		@Override
		public void propertyChange(PropertyChangeEvent event) {
			page.propertyChange(event);
			
			// The IS_VALID property is only fired when the valid state changes.
	        if (event.getProperty().equals(FieldEditor.IS_VALID)) {
	            isValidPath = ((Boolean) event.getNewValue()).booleanValue();
	            if (!isValidPath) {
	            	expressVersion.setStringValue( "Selected path is not valid" );
	            }
	            return;
	        }
        	if (!isValidPath) { // if it is still not valid file, we don't need to check again
        		return;
        	}
	        if (event.getProperty().equals(FieldEditor.VALUE)) {
		        String newExecutablePath = (String) event.getNewValue();
//		        File file = new File(newExecutablePath);
//		        if (!file.exists() && file.isFile() ){
//		        	return;
//		        }
	            expressVersion.setStringValue( ProcessUtils.getCurrentVersionOf(newExecutablePath) );
	        }
		}
    }
}