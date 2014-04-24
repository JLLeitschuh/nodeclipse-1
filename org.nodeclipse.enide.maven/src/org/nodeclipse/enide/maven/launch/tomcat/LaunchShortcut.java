package org.nodeclipse.enide.maven.launch.tomcat;

import org.eclipse.debug.ui.ILaunchShortcut;
import org.nodeclipse.enide.maven.preferences.MavenConstants;

/**
 * Using "Run As" --> "mvn tomcat6:start Maven start" will lead here</br>
 * http://tomcat.apache.org/maven-plugin-2.2/context-goals.html
 **/
public class LaunchShortcut extends org.nodeclipse.enide.maven.launchexec.LaunchShortcut implements ILaunchShortcut {
	
	@Override
    protected String getLaunchConfigurationTypeConstant() {
		return MavenConstants.LAUNCH_TOMCAT_CONFIGURATION_TYPE_ID;
	}

}
