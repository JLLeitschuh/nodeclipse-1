package org.nodeclipse.vertx.preferences;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nodeclipse.vertx.Activator;
import org.nodeclipse.vertx.VertxConstants;

/**
 * @author Paul Verest
 * @since 0.11 moved from NodePreferencePage; copied from JJSPreferencePage
 */
public class VertxPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

    private DirectoryFieldEditor vertxHomeToUse;
    
	public VertxPreferencePage(){
	       super(GRID);
	        setPreferenceStore(Activator.getDefault().getPreferenceStore());
	        setDescription(VertxConstants.PREFERENCE_PAGE_DESCRIPTION+"\n"
	        +"Vert.x requires JDK 1.7.0 or later. Make sure the JDK bin directory is on your `PATH`.\n"
	        +"create VERTX_HOME pointing to folder where you extracted .zip, add %VERTX_HOME%/bin; to your `PATH`");
	}
	
	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected void createFieldEditors() {
	       vertxHomeToUse = new DirectoryFieldEditor(VertxConstants.VERTX_HOME_TO_USE, "VERTX_HOME to use:", getFieldEditorParent());
	        addField(vertxHomeToUse);
	}
}
