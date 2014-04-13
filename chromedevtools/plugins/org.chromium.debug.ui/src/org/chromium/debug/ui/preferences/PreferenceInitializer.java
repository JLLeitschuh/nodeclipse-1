package org.chromium.debug.ui.preferences;

import org.chromium.debug.ui.ChromiumDebugUIPlugin;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;

/*
 * @author Benjamin gurok
 * @author Paul Verest
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = ChromiumDebugUIPlugin.getDefault().getPreferenceStore();
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_COMMENT, PreferenceConstants.DEFAULT_COLOR_COMMENT);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_DOC, PreferenceConstants.DEFAULT_COLOR_DOC);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_KEYWORD, PreferenceConstants.DEFAULT_COLOR_KEYWORD);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_STRING, PreferenceConstants.DEFAULT_COLOR_STRING);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_NUMBER, PreferenceConstants.DEFAULT_COLOR_NUMBER);
        PreferenceConverter.setDefault(store, PreferenceConstants.KEY_COLOR_NORMAL, PreferenceConstants.DEFAULT_COLOR_NORMAL);
        store.setDefault(PreferenceConstants.KEY_BOLD_KEYWORD, true);	}

}

