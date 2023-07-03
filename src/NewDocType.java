import com.peniel.beans.SessionBean;
import com.peniel.bus.vo.DocumentType;
import com.peniel.bus.vo.UserSession;
import com.peniel.common.PenielException;
import com.peniel.dao.DocumentTypeDAO;
import com.peniel.dao.SessionLogDAO;
import com.peniel.dao.UserSessionDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

/**
 * User: todds
 * Date: 11/30/11
 * Time: 10:26 PM
 */
public class NewDocType extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;

    private static Logger logger = LogManager.getLogger(NewDocType.class);

    /* (non-Java-doc)
    * @see javax.servlet.http.HttpServlet#HttpServlet()
    */
    public NewDocType() {
        super();
    }

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
        String sessionId = request.getParameter("sessionid");
        String submit = request.getParameter("submitButton");
    	
        SessionBean s = new SessionBean();

        int id = s.checkSession(sessionId);
        if ( id <= -1) {
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            response.setContentType("text/html");
            (response.getWriter()).write("<table align='center'><tr><td><font size=8 color=red>Session Expired. Please Login again.</font></td></tr></table>");
            logger.info("Session expired");
        }  else {
        	
            UserSessionDAO userSessionDAO = new UserSessionDAO();
            Vector<UserSession> sessions =  userSessionDAO.findById(sessionId);
            UserSession session = sessions == null ? null : sessions.get(0);

            if (session != null) {
                String compId = ""+session.getCompanyId();
                String userId = ""+session.getUserId();
                DocumentTypeDAO documentTypeDAO = new DocumentTypeDAO();

                if (submit != null) {
                    // add the new value
                    String newDocTypeName = request.getParameter("newDocTypeTxt");
                    try {
                    	if(newDocTypeName !=null )// For page reload 
                    	{
                    		if(newDocTypeName != "")
                    		{
		                        DocumentType documentType = documentTypeDAO.findByDocumentNameAndCompany(newDocTypeName, compId);
		                        if (documentType != null) 
		                        {
		                            request.setAttribute("errorMessage",  "Document Type must be unique");
		                        } else 
		                        {	   
		                        	newDocTypeName = newDocTypeName.replace("'", "\\\\"); 
		                        	System.out.println("Inserting new document type-----> "+newDocTypeName);
		                        	
		                            documentTypeDAO.insertNewDocType(compId, newDocTypeName);
		                            request.setAttribute("successMessage",  "Document Type "+newDocTypeName+ " Added Successfully!");
		                        }
                    		}
                    		else
                        	{
                        		request.setAttribute("errorMessage",  "Please Enter Document Type");
                        	}
                    	}
                    	
                    } catch (PenielException e) {
                        request.setAttribute("errorMessage",  "Failed to insert new Document type - "+ newDocTypeName);
                    }
                }

                Vector<DocumentType> listValues = documentTypeDAO.findByCompanyId1(compId);
                
                request.setAttribute("listvalue", listValues);

                request.setAttribute("userid", userId);
                request.setAttribute("compid", compId);
                request.setAttribute("sessionid", sessionId);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/newDocType.jsp?sessionid=" + sessionId);
            dispatcher.forward(request, response);
        }
    }

}
