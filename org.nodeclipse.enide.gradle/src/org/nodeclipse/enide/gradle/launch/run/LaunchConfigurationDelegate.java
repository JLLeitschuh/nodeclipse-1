package org.nodeclipse.enide.gradle.launch.run;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.preference.IPreferenceStore;
import org.nodeclipse.enide.gradle.preferences.GradleConstants;

/**
 * `build.gradle` Run As gradle run
 *  
 * @since 0.15
 * @author Paul Verest
 */
public class LaunchConfigurationDelegate 
	extends org.nodeclipse.enide.gradle.launch.LaunchConfigurationDelegate
	implements ILaunchConfigurationDelegate {
	
	@Override
	protected void specialOptions(ILaunchConfiguration configuration,
			IPreferenceStore preferenceStore, List<String> cmdLine) throws CoreException {
		cmdLine.add("run");
	}
}
