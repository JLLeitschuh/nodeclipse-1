package org.nodeclipse.vertx.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.nodeclipse.vertx.Activator;
import org.nodeclipse.vertx.VertxConstants;

public class VertxPreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		String vertxHome = System.getenv("VERTX_HOME");
		if (vertxHome!=null){
			store.setDefault(VertxConstants.VERTX_HOME_TO_USE, vertxHome );
		}
	}

}
