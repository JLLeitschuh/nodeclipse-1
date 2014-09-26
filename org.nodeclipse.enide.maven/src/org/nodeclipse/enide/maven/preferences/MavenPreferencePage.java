package org.nodeclipse.enide.maven.preferences;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.nodeclipse.enide.maven.Activator;

/**
 * @author Paul Verest
 */
public class MavenPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	
	boolean isWindows = Platform.getOS().startsWith("win");

	private DirectoryFieldEditor mavenHome;
	private DirectoryFieldEditor mavenHomeToUse;
	private DirectoryFieldEditor javaHomeToUse;
	private StringFieldEditor mavenJvmOpts;
    //private FileFieldEditor mavenPath;

    private StringFieldEditor mavenOptions;
    private StringFieldEditor mavenGoal1;
    private StringFieldEditor mavenGoal2;
    private BooleanFieldEditor mavenOptionShowVersion;
    private BooleanFieldEditor mavenOptionDebug;
    private BooleanFieldEditor mavenOptionQuiet;
    private BooleanFieldEditor mavenOptionOffline;
    private BooleanFieldEditor mavenOptionForcedDependenciesUpdate;
    private BooleanFieldEditor mavenOptionTestSkip;
    private FileFieldEditor mavenOptionAlternativeSettings;
    private StringFieldEditor mavenOptionJettyPort;
    private BooleanFieldEditor passAllEnvVars;

    public MavenPreferencePage() {
        super(GRID);
        setPreferenceStore(Activator.getDefault().getPreferenceStore());
        setImageDescriptor(Activator.getImageDescriptor("icons/feather-ma16.png"));
        setDescription(
//        	VersionUtil.getLongString()+  //TODO make plugin to collect Eclipse utils
//        	"\n"+
    		"Maven requires to set JAVA_HOME (that Eclipse does not use) and MAVEN_HOME environment variable to use from shell.\n"
    		+"MAVEN_HOME is to be folder where you extracted downloaded Maven distribution,"
    		+" e.g. D:\\Progs\\Maven\\apache-maven-3.2.1\n"
    		+"Then it is easy to add mvn to Path like following string \"%JAVA_HOME%\\bin;%MAVEN_HOME%\\bin;\"."
        		);
    }
	@Override
	public void init(IWorkbench workbench) {
	}

    private void addLinkWidget(String text, String urlString){
       	// http://stackoverflow.com/questions/22424993/eclipse-plugin-dev-how-to-add-hyperlink-on-fieldeditorpreferencepage
        Link link = new Link(getFieldEditorParent(), SWT.NONE);
        link.setText(text);
        link.addSelectionListener(new SelectionAdapter() {
        	public void widgetSelected(final SelectionEvent event) {
				try {
					URL url = new URL(urlString);
					try {
						PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser().openURL(url );
					} catch (PartInitException e) {
					}
				} catch (MalformedURLException e) {
				}
        	}
        });
    }
	
	@Override
	protected void createFieldEditors() {
    	addLinkWidget("Visit <A>Nodeclipse maven project page</A>", "http://www.nodeclipse.org/projects/maven/");
    	addLinkWidget(" and <A>maven.apache.org</A> for news and docs.", "http://maven.apache.org/");
    	addLinkWidget("<A>GitHub</A>", "https://github.com/Nodeclipse/nodeclipse-1/tree/master/org.nodeclipse.enide.maven");

		mavenHome = new DirectoryFieldEditor(MavenConstants.MAVEN_HOME, "Maven home directory:", getFieldEditorParent());
		mavenHome.setEnabled(false, getFieldEditorParent());
		addField(mavenHome);
		//TODO show maven version in this Preference Page
		mavenHomeToUse = new DirectoryFieldEditor(MavenConstants.MAVEN_HOME_TO_USE, "Maven home to use:", getFieldEditorParent());
		addField(mavenHomeToUse);
		javaHomeToUse = new DirectoryFieldEditor(MavenConstants.MAVEN_JAVA_HOME_TO_USE, "alternative JAVA_HOME to use:", getFieldEditorParent());
		addField(javaHomeToUse);
		mavenJvmOpts = new StringFieldEditor(MavenConstants.MAVEN_OPTS, "JVM options MAVEN_OPTS:", getFieldEditorParent());
		addField(mavenJvmOpts);
		
		mavenOptions = new StringFieldEditor(MavenConstants.MAVEN_OPTIONS, "Maven options (mvn -h):", getFieldEditorParent());
		addField(mavenOptions);
		/*
		mavenGoal1 = new StringFieldEditor(MavenConstants.MAVEN_GOAL1, "Maven goal1:", getFieldEditorParent());
		addField(mavenGoal1);
		mavenGoal2 = new StringFieldEditor(MavenConstants.MAVEN_GOAL2, "Maven goal2:", getFieldEditorParent());
		addField(mavenGoal2);
		*/
		mavenOptionShowVersion = new BooleanFieldEditor(MavenConstants.MAVEN_OPTION_SHOW_VERSION,"-V, --show-version Display version information without stopping build", getFieldEditorParent());
        addField(mavenOptionShowVersion);
        mavenOptionDebug = new BooleanFieldEditor(MavenConstants.MAVEN_OPTION_DEBUG,"-X Debug	(Produce execution debug output)", getFieldEditorParent());
        addField(mavenOptionDebug);
        mavenOptionQuiet = new BooleanFieldEditor(MavenConstants.MAVEN_OPTION_QUIET,"-q Quiet	(Quiet output - only show errors)", getFieldEditorParent());
        addField(mavenOptionQuiet);
        mavenOptionForcedDependenciesUpdate = new BooleanFieldEditor(MavenConstants.MAVEN_OPTION_FORCED_DEPENDENCIES_UPDATE, "-U Forces a check for updated releases and snapshots on remote repositories", getFieldEditorParent());
        addField(mavenOptionForcedDependenciesUpdate);
		mavenOptionOffline = new BooleanFieldEditor(MavenConstants.MAVEN_OPTION_OFFLINE, "-o Offline	(Work offline)", getFieldEditorParent());
        addField(mavenOptionOffline);
        mavenOptionTestSkip = new BooleanFieldEditor(MavenConstants.MAVEN_OPTION_TEST_SKIP,"-Dmaven.test.skip=true	(skip unit testing)", getFieldEditorParent());
        if (isWindows) mavenOptionTestSkip.setEnabled(false, getFieldEditorParent());
        addField(mavenOptionTestSkip);

        mavenOptionAlternativeSettings = new FileFieldEditor(MavenConstants.MAVEN_OPTION_ALTERNATIVE_SETTINGS, "-s Alternative settings.xml:", getFieldEditorParent());
		addField(mavenOptionAlternativeSettings);

		mavenOptionJettyPort = new StringFieldEditor(MavenConstants.MAVEN_OPTION_JETTY_PORT, "-Djetty.port=", getFieldEditorParent());
		addField(mavenOptionJettyPort);

        passAllEnvVars = new BooleanFieldEditor(MavenConstants.PASS_ALL_ENVIRONMENT_VARIABLES, 
        		"pass all environment variables of Eclipse to launched app", getFieldEditorParent());
        addField(passAllEnvVars);
	}


}
