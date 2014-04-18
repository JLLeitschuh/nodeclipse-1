package org.nodeclipse.enide.editors.jade.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.nodeclipse.enide.editors.jade.Activator;
import org.nodeclipse.enide.editors.jade.JadeEditorConstants;

public class JadePreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
	IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        PreferenceConverter.setDefault(store, JadeEditorConstants.KEY_COLOR_COMMENT, JadeEditorConstants.DEFAULT_COLOR_COMMENT);
        PreferenceConverter.setDefault(store, JadeEditorConstants.KEY_COLOR_DOC, JadeEditorConstants.DEFAULT_COLOR_DOC);
        PreferenceConverter.setDefault(store, JadeEditorConstants.KEY_COLOR_KEYWORD, JadeEditorConstants.DEFAULT_COLOR_KEYWORD);
        PreferenceConverter.setDefault(store, JadeEditorConstants.KEY_COLOR_STRING, JadeEditorConstants.DEFAULT_COLOR_STRING);
        PreferenceConverter.setDefault(store, JadeEditorConstants.KEY_COLOR_NUMBER, JadeEditorConstants.DEFAULT_COLOR_NUMBER);
        PreferenceConverter.setDefault(store, JadeEditorConstants.KEY_COLOR_NORMAL, JadeEditorConstants.DEFAULT_COLOR_NORMAL);
        store.setDefault(JadeEditorConstants.KEY_BOLD_KEYWORD, true);	
	}

}

