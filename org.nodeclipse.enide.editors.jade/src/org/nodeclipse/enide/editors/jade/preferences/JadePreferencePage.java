package org.nodeclipse.enide.editors.jade.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nodeclipse.enide.editors.jade.Activator;
import org.nodeclipse.enide.editors.jade.JadeEditorConstants;

/**
 * @author Paul Verest
 * @since 0.11 moved from NodePreferencePage
 */
public class JadePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private ColorFieldEditor colorComment;
    private ColorFieldEditor colorDoc;
    private ColorFieldEditor colorKeyword;
    private ColorFieldEditor colorString;
    private ColorFieldEditor colorNumber;
    private ColorFieldEditor colorNormal;
    private BooleanFieldEditor boldAttributeKeyword;
    
    public JadePreferencePage() {
        super(GRID);
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        setPreferenceStore(store);
        setDescription("Jade Editor Settings");
    }
@Override
public void init(IWorkbench workbench) {
}

@Override
protected void createFieldEditors() {

Composite parent = getFieldEditorParent();

        colorComment = new ColorFieldEditor(JadeEditorConstants.KEY_COLOR_COMMENT, "Comment color:", parent);
        addField(colorComment);

        colorDoc = new ColorFieldEditor(JadeEditorConstants.KEY_COLOR_DOC, "Doc color:", parent);
        addField(colorDoc);

        colorKeyword = new ColorFieldEditor(JadeEditorConstants.KEY_COLOR_KEYWORD, "Keyword color:", parent);
        addField(colorKeyword);

        boldAttributeKeyword = new BooleanFieldEditor(JadeEditorConstants.KEY_BOLD_KEYWORD, "Bold keywords", parent);
        addField(boldAttributeKeyword);

        colorString = new ColorFieldEditor(JadeEditorConstants.KEY_COLOR_STRING, "String color:", parent);
        addField(colorString);

        colorNumber = new ColorFieldEditor(JadeEditorConstants.KEY_COLOR_NUMBER, "Number color:", parent);
        addField(colorNumber);

        colorNormal = new ColorFieldEditor(JadeEditorConstants.KEY_COLOR_NORMAL, "Normal text color:", parent);
        addField(colorNormal);
}
}
