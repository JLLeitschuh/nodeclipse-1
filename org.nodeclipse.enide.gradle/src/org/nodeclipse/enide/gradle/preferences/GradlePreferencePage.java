package org.nodeclipse.enide.gradle.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.nodeclipse.enide.gradle.Activator;

/**
 * @author Paul Verest
 */
public class GradlePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private DirectoryFieldEditor gradleHome;
	private DirectoryFieldEditor gradleHomeToUse;
	private StringFieldEditor gradleJvmOpts;
    
    private StringFieldEditor gradleOptions;
    private BooleanFieldEditor gradleOptionDebug;
    private BooleanFieldEditor gradleOptionInfo;
    private BooleanFieldEditor gradleOptionQuiet;
    private BooleanFieldEditor gradleOptionOffline;
    private DirectoryFieldEditor gradleEnvVarAlternativeAndroidHome;
    private BooleanFieldEditor passAndroidSigningEnvVars;
	private FileFieldEditor gradleEnvVarAlternativeKeystoreFile;
	private StringFieldEditor gradleEnvVarAlternativeKeystorePassword;
	private StringFieldEditor gradleEnvVarAlternativeKeyAlias;
	private StringFieldEditor gradleEnvVarAlternativeKeyPassword;
	private BooleanFieldEditor passAllEnvVars;

    public GradlePreferencePage() {
        super(GRID);
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
        setDescription(
//        	VersionUtil.getLongString()+  //TODO make plugin to collect Eclipse utils
//        	"\n"+
        	"From getting-started.html:\n"
        	+"For running Gradle, create GRADLE_HOME environment variable pointing to folder with unpacked Gradle distribution"
        	+ "and add GRADLE_HOME/bin to your PATH environment variable. Usually, this is sufficient to run Gradle.\n"
        	+"Gradle uses whichever JDK it finds in your path (to check, use java -version)."
        	+" Alternatively, you can set the JAVA_HOME environment variable to point to the install directory of the desired JDK.\n"	
    		+"\nFor this plugin specifying Gradle home to use will be enough."
        	+" (This lets you easily experiment with different versions.)");
    }
	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected void createFieldEditors() {
		

	    gradleHome = new DirectoryFieldEditor(GradleConstants.GRADLE_HOME, "Gradle home directory:", getFieldEditorParent());
		gradleHome.setEnabled(false, getFieldEditorParent());
		addField(gradleHome);
		//TODO show version in this Preference Page
		gradleHomeToUse = new DirectoryFieldEditor(GradleConstants.GRADLE_HOME_TO_USE, "Gradle home to use:", getFieldEditorParent());
		addField(gradleHomeToUse);
		gradleJvmOpts = new StringFieldEditor(GradleConstants.GRADLE_OPTS, "JVM options GRADLE_OPTS:", getFieldEditorParent());
		addField(gradleJvmOpts);
		
      gradleOptions = new StringFieldEditor(GradleConstants.GRADLE_OPTIONS, "Gradle options (gradle -h):", getFieldEditorParent());
        addField(gradleOptions);
      gradleOptionDebug = new BooleanFieldEditor(GradleConstants.GRADLE_OPTION_DEBUG,"-d, --debug Log in debug mode (includes normal stacktrace).", getFieldEditorParent());
        addField(gradleOptionDebug);
      gradleOptionInfo = new BooleanFieldEditor(GradleConstants.GRADLE_OPTION_INFO,"-i, --info Set log level to info.", getFieldEditorParent());
        addField(gradleOptionInfo);
      gradleOptionQuiet = new BooleanFieldEditor(GradleConstants.GRADLE_OPTION_QUIET,"-q, --quiet Log errors only.", getFieldEditorParent());
        addField(gradleOptionQuiet);
      gradleOptionOffline = new BooleanFieldEditor(GradleConstants.GRADLE_OPTION_OFFLINE,"--offline The build should operate without accessing network resources.", getFieldEditorParent());
        addField(gradleOptionOffline);

        gradleEnvVarAlternativeAndroidHome = new DirectoryFieldEditor(GradleConstants.GRADLE_ENVVAR_ALTERNATIVE_ANDROID_HOME, "alternative ANDROID_HOME:", getFieldEditorParent());
		addField(gradleEnvVarAlternativeAndroidHome);
        
        passAndroidSigningEnvVars = new BooleanFieldEditor(GradleConstants.PASS_ANDROID_SIGNING_ENVIRONMENT_VARIABLES, 
        		"pass Android signing environment variables (4) // experimental, see #129", getFieldEditorParent());
        addField(passAndroidSigningEnvVars);
        gradleEnvVarAlternativeKeystoreFile = new FileFieldEditor(GradleConstants.GRADLE_ENVVAR_ALTERNATIVE_ANDROID_KEYSTORE_FILE, "alternative KEYSTORE file:", getFieldEditorParent());
		addField(gradleEnvVarAlternativeKeystoreFile);
        gradleEnvVarAlternativeKeystorePassword = new StringFieldEditor(GradleConstants.GRADLE_ENVVAR_ALTERNATIVE_ANDROID_KEYSTORE_PASSWORD, "alternative KEYSTORE_PASSWORD:", getFieldEditorParent());
		addField(gradleEnvVarAlternativeKeystorePassword);
        gradleEnvVarAlternativeKeyAlias = new StringFieldEditor(GradleConstants.GRADLE_ENVVAR_ALTERNATIVE_ANDROID_KEY_ALIAS, "alternative KEY_ALIAS:", getFieldEditorParent());
		addField(gradleEnvVarAlternativeKeyAlias);
        gradleEnvVarAlternativeKeyPassword = new StringFieldEditor(GradleConstants.GRADLE_ENVVAR_ALTERNATIVE_ANDROID_KEY_PASSWORD, "alternative KEY_PASSWORD:", getFieldEditorParent());
		addField(gradleEnvVarAlternativeKeyPassword);
		
        passAllEnvVars = new BooleanFieldEditor(GradleConstants.PASS_ALL_ENVIRONMENT_VARIABLES, 
        		"pass all environment variables of Eclipse to launched app", getFieldEditorParent());
        addField(passAllEnvVars);
	}


}
