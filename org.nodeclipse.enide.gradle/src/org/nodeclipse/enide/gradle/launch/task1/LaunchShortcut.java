package org.nodeclipse.enide.gradle.launch.task1;

import org.eclipse.debug.ui.ILaunchShortcut;
import org.nodeclipse.enide.gradle.preferences.GradleConstants;

//import org.nodeclipse.ui.util.NodeclipseConsole;

/**
 * Using "Run As" --> gradle task1
 **/
public class LaunchShortcut  
	extends org.nodeclipse.enide.gradle.launch.LaunchShortcut
	implements ILaunchShortcut
{

	@Override
	protected String getLaunchConfigurationTypeConstant() {
		return GradleConstants.LAUNCH_TASK1_CONFIGURATION_TYPE_ID;
	}

}
