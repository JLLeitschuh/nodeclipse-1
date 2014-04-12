package org.nodeclipse.enide.gradle.preferences;

public class GradleConstants {
	
	public static final String PLUGIN_ID = "org.nodeclipse.enide.gradle";
	public static final String LAUNCH_CONFIGURATION_TYPE_ID = "org.nodeclipse.enide.gradle.launch.LaunchConfigurationType";
	public static final String LAUNCH_ANDROID_INSTALLDEBUG_CONFIGURATION_TYPE_ID = "org.nodeclipse.enide.gradle.launch.android.LaunchConfigurationType";
	public static final String LAUNCH_DAEMON_CONFIGURATION_TYPE_ID = "org.nodeclipse.enide.gradle.launch.daemon.LaunchConfigurationType";
	public static final String LAUNCH_JETTY_CONFIGURATION_TYPE_ID = "org.nodeclipse.enide.gradle.launch.jetty.LaunchConfigurationType";
	public static final String LAUNCH_JETTYECLIPSE_CONFIGURATION_TYPE_ID = "org.nodeclipse.enide.gradle.launch.jettyeclipse.LaunchConfigurationType";
	public static final String LAUNCHGUI_CONFIGURATION_TYPE_ID = "org.nodeclipse.enide.gradle.launchgui.LaunchConfigurationType";
	
	public static final String PROCESS_MESSAGE = "Gradle Process";
	
	public static final String KEY_FILE_PATH = "KEY_FILE_PATH";

	//+
    public static final String ATTR_PROGRAM_ARGUMENTS = "attr_program_arguments";
    public static final String ATTR_MAVEN_ARGUMENTS = "attr_maven_arguments";
    public static final String ATTR_WORKING_DIRECTORY = "attr_working_directory"; 

	public static final String ATTR_ENVIRONMENT_VARIABLES = "attr_environment_variables";	
	public static final String ATTR_APPEND_ENVIRONMENT_VARIABLES = "attr_append_environment_variables";	

	public static final String GRADLE_HOME = "gradle_home";
	public static final String GRADLE_HOME_TO_USE = "gradle_home_to_use";
	public static final String GRADLE_USE_WRAPPER = "gradle_use_wrapper";
	public static final String GRADLE_JAVA_HOME_TO_USE = "java_home_to_use";
	public static final String GRADLE_OPTS = "gradle_opts";
	public static final String GRADLE_PATH = "gradle_path";	
	public static final String GRADLE_OPTIONS = "gradle_options";	
	public static final String GRADLE_OPTION_DEBUG = "gradle_option_debug";
	public static final String GRADLE_OPTION_INFO = "gradle_option_info";
	public static final String GRADLE_OPTION_QUIET = "gradle_option_quiet";
	public static final String GRADLE_OPTION_OFFLINE = "gradle_option_offline";
	public static final String GRADLE_OPTION_DAEMON = "gradle_option_daemon";
	public static final String GRADLE_ENVVAR_ALTERNATIVE_ANDROID_HOME = "gradle_envvar_alternative_android_home";
	/* http://stackoverflow.com/questions/18328730/how-to-create-a-release-signed-apk-file-using-gradle
	android{
		signingConfigs {
		    release {
		        storeFile file(System.getenv("KEYSTORE"))
		        storePassword System.getenv("KEYSTORE_PASSWORD")
		        keyAlias System.getenv("KEY_ALIAS")
		        keyPassword System.getenv("KEY_PASSWORD")
		    }
		}
	}
	*/
	public static final String PASS_ANDROID_SIGNING_ENVIRONMENT_VARIABLES = "pass_android_signing_environment_variables";
	public static final String GRADLE_ENVVAR_ALTERNATIVE_ANDROID_KEYSTORE_FILE = "gradle_envvar_alternative_android_keystore_file";
	public static final String GRADLE_ENVVAR_ALTERNATIVE_ANDROID_KEYSTORE_PASSWORD = "gradle_envvar_alternative_android_keystore_password";
	public static final String GRADLE_ENVVAR_ALTERNATIVE_ANDROID_KEY_ALIAS = "gradle_envvar_alternative_android_key_alias";
	public static final String GRADLE_ENVVAR_ALTERNATIVE_ANDROID_KEY_PASSWORD = "gradle_envvar_alternative_android_key_password";
	
	public static final String PASS_ALL_ENVIRONMENT_VARIABLES = "pass_all_environment_variables";

	public static final String PREFERENCES_PAGE = "org.nodeclipse.enide.gradle.preferences.GradlePreferencePage";
	public static final String PREFERENCE_PAGE_NAME ="Gradle(Enide)"; // the same as in plugin.xml	
}
