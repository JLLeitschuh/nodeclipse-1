package org.chromium.debug.ui.preferences;

import org.chromium.debug.ui.ChromiumDebugUIPlugin;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * @author Benjamin gurok
 * @author Paul Verest
 */
public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private BooleanFieldEditor treatCompileErrorAsAfterCompile;
	private ColorFieldEditor colorComment;
    private ColorFieldEditor colorDoc;
    private ColorFieldEditor colorKeyword;
    private ColorFieldEditor colorString;
    private ColorFieldEditor colorNumber;
    private ColorFieldEditor colorNormal;
    private BooleanFieldEditor boldAttributeKeyword;
    
    public PreferencePage() {
        super(GRID);
        IPreferenceStore store = ChromiumDebugUIPlugin.getDefault().getPreferenceStore();
        setPreferenceStore(store);
        setDescription("Chromium Debugger JavaScript Editor Settings");
    }
	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected void createFieldEditors() {
		
	    Composite parent = getFieldEditorParent();
	    
	    // Nodeclipse/nodeclipse-1/issues/189
	    treatCompileErrorAsAfterCompile = new BooleanFieldEditor(PreferenceConstants.TREAT_NODE_012_COMPILE_ERROR, 
        		"#189 Treat the 'compileError' event as the 'afterCompile' event "
        				+"(for Node v0.11.14..0.12.2, see  joyent/node#25266 joyent/node#25358)", getFieldEditorParent());
	    treatCompileErrorAsAfterCompile.setEnabled(false, parent);
        addField(treatCompileErrorAsAfterCompile);
	    

        colorComment = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_COMMENT, "Comment color:", parent);
        addField(colorComment);

        colorDoc = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_DOC, "Doc color:", parent);
        addField(colorDoc);

        colorKeyword = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_KEYWORD, "Keyword color:", parent);
        addField(colorKeyword);

        boldAttributeKeyword = new BooleanFieldEditor(PreferenceConstants.KEY_BOLD_KEYWORD, "Bold keywords", parent);
        addField(boldAttributeKeyword);

        colorString = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_STRING, "String color:", parent);
        addField(colorString);

        colorNumber = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_NUMBER, "Number color:", parent);
        addField(colorNumber);

        colorNormal = new ColorFieldEditor(PreferenceConstants.KEY_COLOR_NORMAL, "Normal text color:", parent);
        addField(colorNormal);
	}


}
