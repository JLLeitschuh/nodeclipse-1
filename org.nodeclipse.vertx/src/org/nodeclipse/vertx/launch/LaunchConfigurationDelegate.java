package org.nodeclipse.vertx.launch;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.debug.core.model.RuntimeProcess;
import org.eclipse.jface.preference.IPreferenceStore;
import org.nodeclipse.common.preferences.CommonDialogs;
import org.nodeclipse.debug.util.Constants;
import org.nodeclipse.debug.util.VariablesUtil;
//import org.nodeclipse.ui.Activator;
//import org.nodeclipse.ui.preferences.PreferenceConstants;
import org.nodeclipse.ui.util.NodeclipseConsole;
import org.nodeclipse.vertx.Activator;
import org.nodeclipse.vertx.VertxConstants;

/**
 * Launching `jjs` from Java 8.<br>
 * see LaunchConfigurationDelegate in .debug and .phantomjs module for comparison.
 * 
 * @since 0.7
 * @author Paul Verest
 */
public class LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		boolean isDebugMode = mode.equals(ILaunchManager.DEBUG_MODE);
		
		// Using configuration to build command line	
		List<String> cmdLine = new ArrayList<String>();

		String executablePath= preferenceStore.getString(VertxConstants.VERTX_PATH);
		// Check if the node location is correctly configured
		File executableFile = new File(executablePath);
		if(!executableFile.exists()){
			// If the location is not valid than show a dialog which prompts the user to goto the preferences page
//			Dialogs.showPreferencesDialog("path to jjs util from Java 8 runtime is not correctly configured.\n\n"
//					+ "Please goto Window -> Prefrences -> Nodeclipse and configure the correct location under 'JJS path:'");
			CommonDialogs.showPreferencesDialog(VertxConstants.PREFERENCES_PAGE,
					"Vert.x `vertx` location is not correctly configured.\n\n"
					+ "Please goto Window -> Preferences -> "+VertxConstants.PREFERENCE_PAGE_NAME
					+" and configure the correct location");
			return;
		}			
		cmdLine.add(executablePath);
		
		if (isDebugMode) {
			//TODO research how to debug
		}

		String file = configuration.getAttribute(VertxConstants.KEY_FILE_PATH,	"");
		String filePath = ResourcesPlugin.getWorkspace().getRoot().findMember(file).getLocation().toOSString();
		// path is relative, so cannot find it, unless get absolute path
		cmdLine.add(filePath);
		
		String workingDirectory = configuration.getAttribute(Constants.ATTR_WORKING_DIRECTORY, "");
		File workingPath = null;
		if(workingDirectory.length() == 0) {
			workingPath = (new File(filePath)).getParentFile();
		} else {
			workingDirectory = VariablesUtil.resolveValue(workingDirectory);
			if(workingDirectory == null) {
				workingPath = (new File(filePath)).getParentFile();
			} else {
				workingPath = new File(workingDirectory);
			}
		}
		
		Map<String, String> envm = new HashMap<String, String>();
		envm = configuration.getAttribute(Constants.ATTR_ENVIRONMENT_VARIABLES, envm);
		String[] envp = new String[envm.size()];
		int idx = 0;
		for(String key : envm.keySet()) {
			String value = envm.get(key);
			envp[idx++] = key + "=" + value;
		}
		
		
		for(String s : cmdLine) NodeclipseConsole.write(s+" ");
		NodeclipseConsole.write("\n");
		
		String[] cmds = {};
		cmds = cmdLine.toArray(cmds);
		// Launch a process to debug.eg,
		Process p = DebugPlugin.exec(cmds, workingPath, envp);
		RuntimeProcess process = (RuntimeProcess)DebugPlugin.newProcess(launch, p, VertxConstants.PROCESS_MESSAGE);
		if (isDebugMode) {
			//TODO research how to debug
		}
		
	}

}