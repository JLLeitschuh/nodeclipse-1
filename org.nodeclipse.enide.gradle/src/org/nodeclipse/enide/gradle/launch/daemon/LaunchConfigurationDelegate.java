package org.nodeclipse.enide.gradle.launch.daemon;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * `build.gradle` Run As gradle installDebug Gradle Android start<br>
 * see #130
 *  
 * @since 0.12
 * @author Paul Verest
 */
public class LaunchConfigurationDelegate 
	extends org.nodeclipse.enide.gradle.launch.LaunchConfigurationDelegate
	implements ILaunchConfigurationDelegate {
	
	@Override
	protected void specialOptions(ILaunchConfiguration configuration,
			IPreferenceStore preferenceStore, List<String> cmdLine) throws CoreException {
		cmdLine.add("--foreground"); //[incubating] 
		//TODO configurable
	}
}
