import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.UserSession;
import com.peniel.dao.UserSessionDAO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * User: todds
 * Date: 11/29/11
 * Time: 9:54 PM
 */
public class DocDownloadBuiltFile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 3929891273L;
    private static final Logger logger = LoggerFactory.getLogger(DocDownloadBuiltFile.class);

    private static final int BUFSIZE = 10240;

    /* (non-Java-doc)
    * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /* (non-Java-doc)
    * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String userId = request.getParameter("userid");
        String compId = request.getParameter("compid");
        String sessionId = request.getParameter("session");

        SessionBean s = new SessionBean();
        UserSessionDAO userSessionDAO = new UserSessionDAO();

        Vector<UserSession> userSessionVector = userSessionDAO.findById(sessionId) ;

        if (userSessionVector != null && userSessionVector.size() > 0){
            UserSession us = userSessionVector.firstElement();
            if (StringUtils.equals(sessionId, us.getSessionId())) {
                try {
                    Date date = (new SimpleDateFormat("yyyy-M-d")).parse(us.getLastUpdated());
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(date);
                    
                    gregorianCalendar.add(Calendar.HOUR_OF_DAY, 24);
                    
                    if (gregorianCalendar.getTime().getTime() >= new Date().getTime()) {
                        String fileName = getDestinationBaseDirectory() + getFinalDownloadDir() + File.separator + sessionId + ".zip";
                        File file = new File(fileName);
                        if(!file.exists()) {
                            errorPage(response, "Your requeted file does not exist");
                        } else {
                            logger.info("File name for download is " + fileName);
                            try {
                                doDownload(request, response, fileName, "DownloadFile.zip");
                            } catch (Exception e) {
                                errorPage(response, "An error has occurred please try again. " + fileName);
                            }
                        }
                    } else {
                        // timeout
                        errorPage(response, "Your download link has expired. ");
                    }
                } catch (ParseException e) {
                    logger.error("", e);
                    errorPage(response, "Your download link has expired. ");
                }
            }
        } else {
            // timeout
            errorPage(response, "Your download link has expired. ");
            logger.info("Session expired");
        }
    }

    public void errorPage(HttpServletResponse response, String errorMessage) throws IOException {
        response.setHeader("Expires", "5000");
        response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "public");
        response.setContentType("text/html");
        (response.getWriter()).write("<table align='center'><tr><td><font size=8 color=red>" + errorMessage +
                "</font></td></tr></table>");
    }

    /**
       *  Sends a file to the ServletResponse output stream.  Typically
       *  you want the browser to receive a different name than the
       *  name the file has been saved in your local database, since
       *  your local names need to be unique.
       *
       *  @param req The request
       *  @param resp The response
       *  @param filename The name of the file you want to download.
       *  @param original_filename The name the browser should receive.
       */
      private void doDownload( HttpServletRequest req, HttpServletResponse resp,
                               String filename, String original_filename )
          throws IOException
      {
          File f        = new File(filename);
          int                 length   = 0;
          ServletOutputStream op       = resp.getOutputStream();
          ServletContext context  = getServletConfig().getServletContext();
          String              mimetype = context.getMimeType( filename );

          //
          //  Set the response and go!
          //
          //
          resp.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
          resp.setContentLength( (int)f.length() );
          resp.setHeader( "Content-Disposition", "attachment; filename=\"" + original_filename + "\"" );

          //
          //  Stream to the requester.
          //
          byte[] bbuf = new byte[BUFSIZE];
          DataInputStream in = new DataInputStream(new FileInputStream(f));

          while ((in != null) && ((length = in.read(bbuf)) != -1)) {
              op.write(bbuf, 0, length);
          }

          in.close();
          op.flush();
          op.close();
      }

    public String getDestinationBaseDirectory() {
        return  this.getServletContext().getRealPath("scaimages");
    }

    public String getFinalDownloadDir() {
        try {
            return getFromEnv("finalDownloadDir");
        } catch (NamingException e) {
            return null;
        }
    }

    public String getFromEnv(String val) throws NamingException {
        javax.naming.Context ctx = new javax.naming.InitialContext();
        return (String) ctx.lookup("java:comp/env/" + val);
    }
}
