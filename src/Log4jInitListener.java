import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

//import org.apache.log4j.xml.DOMConfigurator;

@WebListener
public final class Log4jInitListener implements ServletContextListener {

    public Log4jInitListener() {
    }

    public void contextDestroyed(ServletContextEvent paramServletContextEvent)  { 
    }

    public void contextInitialized(ServletContextEvent servletContext) {
    	String webAppPath = servletContext.getServletContext().getRealPath("/");
    	String log4jFilePath = webAppPath + "log4j2.properties";
    	System.out.println("Log4jInit.init(): Log properties path : " + log4jFilePath);
    	LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
    	File file1 = new File(log4jFilePath);



    	// this will force a reconfiguration
    	context.setConfigLocation(file1.toURI());




    	// DOMConfigurator.configure(log4jFilePath);
    	System.out.println("initialized log4j configuration from file:"+log4jFilePath);

    	}
	
}