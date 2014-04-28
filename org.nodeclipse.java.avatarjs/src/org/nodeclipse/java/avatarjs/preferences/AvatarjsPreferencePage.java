package org.nodeclipse.java.avatarjs.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nodeclipse.java.avatarjs.Activator;

/**
 * @author Paul Verest
 * @since 0.11 moved from NodePreferencePage
 */
public class AvatarjsPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private FileFieldEditor javaPath;
    private BooleanFieldEditor javaJustJava;
    private StringFieldEditor javaOptions;
    private StringFieldEditor javaOptionsToRunWithAvatarjs;
    
	public AvatarjsPreferencePage(){
	       super(GRID);
	        setPreferenceStore(Activator.getDefault().getPreferenceStore());
	        setDescription("Java 8 Avatar.js settings");
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected void createFieldEditors() {
		javaPath = new FileFieldEditor(AvatarjsConstants.JAVA_PATH, "Java path:", getFieldEditorParent());
	    addField(javaPath);
	
	    javaJustJava = new BooleanFieldEditor(AvatarjsConstants.JAVA_JUST_JAVA, 
	    		"just `java` (find `java` on PATH. Useful when there are 2 or more JDK 8 instances)", getFieldEditorParent());
	    addField(javaJustJava);
	
	    javaOptions = new StringFieldEditor(AvatarjsConstants.JAVA_OPTIONS, "`Java options:", getFieldEditorParent());
        addField(javaOptions);
    
        javaOptionsToRunWithAvatarjs = new StringFieldEditor(AvatarjsConstants.JAVA_OPTIONS_TO_RUN_WITH_AVATARJS, 
        		"`Java options to run with Avatar.js:", getFieldEditorParent());
        addField(javaOptionsToRunWithAvatarjs);
	}

}
