package au.com.ozblog.server;

import org.eclipse.jetty.webapp.WebAppContext;

public class AppContextBuilder {

	public static WebAppContext buildWebAppContext() {
		WebAppContext webAppContext;
		webAppContext = new WebAppContext();
		webAppContext.setDescriptor(webAppContext + "/WEB-INF/web.xml");
		webAppContext.setResourceBase(".");
		webAppContext.setContextPath("/");
		return webAppContext;
	}
}