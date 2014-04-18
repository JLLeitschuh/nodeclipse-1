package org.nodeclipse.java.avatarjs.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.nodeclipse.java.avatarjs.Activator;

public class GradlePreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(AvatarjsConstants.JAVA_OPTIONS_TO_RUN_WITH_AVATARJS, "-Djava.library.path=lib -jar lib/avatar-js.jar");
	}

}

