package org.nodeclipse.jjs.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nodeclipse.ui.preferences.PreferenceConstants;

/**
 * @author Paul Verest
 * @since 0.11 moved from NodePreferencePage
 */
public class JJSPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private FileFieldEditor jjsPath;
    private BooleanFieldEditor jjsJustJJS;
	private StringFieldEditor jjsOptions;
    
	public JJSPreferencePage(){
	       super(GRID);
	        setPreferenceStore(org.nodeclipse.ui.Activator.getDefault().getPreferenceStore());
	        setImageDescriptor(org.nodeclipse.jjs.Activator.getImageDescriptor("icons/nashorn_16x16.png"));
	        setDescription("Java 8 Nashorn jjs settings");
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected void createFieldEditors() {
       jjsJustJJS = new BooleanFieldEditor(PreferenceConstants.JJS_JUST_JJS, 
        		"just `jjs` (find `jjs` on PATH. Useful when there are 2 or more JDK 8 instances)", getFieldEditorParent());
       addField(jjsJustJJS);

       jjsPath = new FileFieldEditor(PreferenceConstants.JJS_PATH, "`jjs` path:", getFieldEditorParent());
       addField(jjsPath);

       jjsOptions = new StringFieldEditor(PreferenceConstants.JJS_OPTIONS, "jjs options (jjs -h):", getFieldEditorParent());
       addField(jjsOptions);
	        
	}

}
