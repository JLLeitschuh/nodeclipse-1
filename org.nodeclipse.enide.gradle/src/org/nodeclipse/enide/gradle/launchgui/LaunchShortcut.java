package org.nodeclipse.enide.gradle.launchgui;

import org.eclipse.debug.ui.ILaunchShortcut;
import org.nodeclipse.enide.gradle.preferences.GradleConstants;
//import org.nodeclipse.ui.util.NodeclipseConsole;

/**
 * Using "Run As" --> "Gradle GUI" will lead here
 **/
public class LaunchShortcut  
	extends org.nodeclipse.enide.gradle.launch.LaunchShortcut
	implements ILaunchShortcut
{

	@Override
	protected String getLaunchConfigurationTypeConstant() {
		return GradleConstants.LAUNCHGUI_CONFIGURATION_TYPE_ID;
	}

}
