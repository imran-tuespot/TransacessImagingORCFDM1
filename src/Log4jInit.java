
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;


public class Log4jInit extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public void init() {

	String prefix=getServletContext().getRealPath("/");
	String file=getInitParameter("log4j-init-file");

	if(file!=null){
	    System.out.println("Log4jInit.init(): Log properties path : " + prefix + file);
	    LoggerContext context = (LoggerContext) LogManager.getContext(false);
	    File file1 = new File(prefix + file);
	    context.setConfigLocation(file1.toURI());
	}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	PrintWriter out=response.getWriter();

	out.println("<h4>This is Log4j-init servlet</h4>");

	Logger logger=LogManager.getRootLogger();

	logger.fatal("Testing FATAL");
	logger.error("Testing ERROR");
	logger.warn("Testing WARN");
	logger.info("Testing INFO");
	logger.debug("Testing DEBUG");

    }

    //The performance of deciding whether to log or not to log when logging is turned on.

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	doGet(request, response);
    }

}
