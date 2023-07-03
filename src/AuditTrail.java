

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.UserInformation;
import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.SearchData;
import com.peniel.bus.vo.SessionLog;
import com.peniel.dao.DocumentDataDAO;
import com.peniel.dao.SearchDataDAO;
import com.peniel.dao.SessionLogDAO;

/**
 * Servlet implementation class for Servlet: DisplayPdf
 *
 */
 public class AuditTrail extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(AuditTrail.class);
   
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AuditTrail() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String comid = request.getParameter("comid");
		String sessionid = request.getParameter("sessionid");
		String docId = request.getParameter("docId");
		
		String status = request.getParameter("status");
		Vector sessionLogList = new Vector();
		SearchData searchData = null;
        SessionLogDAO sessionLogDAO = new SessionLogDAO();


		  try{
			  	// Audit Trail
			  	sessionLogList =  sessionLogDAO.getAllSessionLog(docId, comid);
			  	
			  /*
			   * SessionLog sessionLog = SessionLogDAO.getAllSessionLog(docId, comid);
				request.setAttribute("auditTrailDate", (String)sessionLog.getDtm());
				
				HashMap hmap = UserInformation.getUserInformation((int)sessionLog.getUserId()+"");
				String fullName = (String)hmap.get("lastName") +"^"+ (String)hmap.get("firstName");
				
				request.setAttribute("auditUserId", fullName);
				request.setAttribute("fieldModified", (String)sessionLog.getFieldName());
				request.setAttribute("oldValue",(String)sessionLog.getOldValue());
				request.setAttribute("newValue",(String) sessionLog.getNewValue());
				*/
				
			  	request.setAttribute("sessionLogList",sessionLogList);
			  	
				RequestDispatcher rd = request.getRequestDispatcher("/auditTrailList.jsp");
				rd.forward(request, response);
			  
		  } catch ( Exception e) {
				e.printStackTrace();
		  }
		  
	}   	  	    
}