package org.nodeclipse.enide.maven.launch.goal2;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.preference.IPreferenceStore;
import org.nodeclipse.enide.maven.preferences.MavenConstants;

/**
 * mvn goal2</br>
 * 
 * @since 0.15
 * @author Paul Verest
 */
public class LaunchConfigurationDelegate  
	extends org.nodeclipse.enide.maven.launch.LaunchConfigurationDelegate
	implements ILaunchConfigurationDelegate {

	@Override
	protected void specialOptions(ILaunchConfiguration configuration,
			IPreferenceStore preferenceStore, List<String> cmdLine) throws CoreException {
		
		String mavenOptions= preferenceStore.getString(MavenConstants.MAVEN_OPTIONS);
		if(!mavenOptions.equals("")) {
			String[] sa = mavenOptions.split(" ");
			for(String s : sa) {
				cmdLine.add(s);
			}			
		}
		
		String file = configuration.getAttribute(MavenConstants.KEY_FILE_PATH,	"");
		String filePath = ResourcesPlugin.getWorkspace().getRoot().findMember(file).getLocation().toOSString();
		// path is relative, so cannot find it, unless get absolute path
		cmdLine.add("-f");  //  -f,--file <arg>                        Force the use of an alternate POM
		cmdLine.add(filePath);
		
		String mavenGoal1= preferenceStore.getString(MavenConstants.MAVEN_GOAL2);
		cmdLine.add(mavenGoal1); //TODO only this changed

		//workingPath = (new File(filePath)).getParentFile();
		//setWorkingDirectoryDefault(filePath);
		workingDirectoryDefault = (new File(filePath)).getParentFile();
	}
}
