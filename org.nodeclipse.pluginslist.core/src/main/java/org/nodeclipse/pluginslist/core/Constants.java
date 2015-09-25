package org.nodeclipse.pluginslist.core;

import java.net.MalformedURLException;
import java.net.URL;

public class Constants {

	public static final String LIST_BROWSER_ID = "NodeclipsePluginsListID";
	public static final String GITHUB_BROWSER_ID = "NodeclipseGithubID";
	public static final String STACKOVERFLOW_BROWSER_ID = "NodeclipseStackoverflowID";

	public static final String LIST_BROWSER_NAME = "GitHub Nodeclipse organization";
	public static final String LIST_BROWSER_TOOLTIP = "Install plugins via drag-n-drop on main toolbar";
	public static final String GITHUB_BROWSER_NAME = "Nodeclipse Plugins List";
	public static final String GITHUB_BROWSER_TOOLTIP = "https://github.com/nodeclipse/";
	public static final String STACKOVERFLOW_BROWSER_NAME = "Stackoverflow.com nodeclipse questions";
	public static final String STACKOVERFLOW_BROWSER_TOOLTIP = "http://stackoverflow.com/tags/nodeclipse";

	public static final String ERROR1_MESSAGE = "Error creating browser component";

	public static URL listUrl;
	public static URL githubUrl;
	public static URL stackoverflowUrl;

	static{
		try {
			listUrl = new URL("http://www.nodeclipse.org/updates/list");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			githubUrl = new URL("https://github.com/nodeclipse/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			stackoverflowUrl = new URL("http://stackoverflow.com/tags/nodeclipse");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
