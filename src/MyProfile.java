
import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jmesa.facade.TableFacade;
import org.jmesa.facade.TableFacadeFactory;
import org.jmesa.limit.Limit;
import org.jmesa.view.editor.CellEditor;
import org.jmesa.view.html.HtmlBuilder;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;

import com.peniel.beans.SessionBean;
import com.peniel.beans.SessionLog;
import com.peniel.bus.vo.SearchDataObj;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.AppUserRolesDAO;
import com.peniel.dao.SearchDataDAO;

/**
 * Servlet implementation class for Servlet: GetFiles
 *
 */
 public class MyProfile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(MyProfile.class);
   
   private String userName = "";

      
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public MyProfile() {
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
		
		AppUserDAO appUserDao = new AppUserDAO();
		AppUserRolesDAO appUserRolesDao = new AppUserRolesDAO();
		String status = (String)request.getParameter("status");
		//String oldEmail = request.getParameter("oldEmail").toString();
		String newEmail = request.getParameter("email").toString();
		//String oldFirstName = request.getParameter("oldFirstName").toString();
		//String newFirstName = request.getParameter("first_name").toString();
		//String oldLastName = request.getParameter("oldLastName").toString();
		//String newLastName = request.getParameter("last_name").toString();
		String otp=request.getParameter("OTP").toString();
		String sessionid = request.getParameter("sessionid");
		String userid = request.getParameter("userid");
		String comId = request.getParameter("comId");
		String cellPhone=(String)request.getParameter("cellPhone");
		String  verification =null;
		 boolean moblecheck=false;
   	 if(null!=cellPhone&&!"".equals(cellPhone)) {
   		 moblecheck =appUserDao.mobileExist(userid,cellPhone);
   	 }
 	if(!moblecheck) {
		//System.out.println("status = "+status);
		if (status.equalsIgnoreCase("Active")) {
			status = "A";
		} else if (status.equalsIgnoreCase("Disabled")) { 
			status = "D";
		}
		
		String acceptMails = (String)request.getParameter("acceptMails");
		
		if (acceptMails != null) 
		{
			acceptMails = "Y";
		} else
		{ 
			acceptMails = "N";
		}
		System.out.println("............"+(String)request.getParameter("cellPhone"));
			
		 verification = appUserDao.updateAppUserById(request.getParameter("userid"), (String)request.getParameter("first_name"), 
				(String)request.getParameter("last_name"), (String)request.getParameter("address1"), (String)request.getParameter("address2"), (String)request.getParameter("city"), 
				(String)request.getParameter("state"), (String)request.getParameter("zip"), (String)request.getParameter("email").trim(), (String)request.getParameter("phone_no"),
				(String)request.getParameter("cellPhone"), status, acceptMails,
				(String)request.getParameter("sessionid"),otp,(String)request.getParameter("AUTH_ID"));
		
		//update the user's role
		if(request.getParameter("userRole") != null)
			appUserRolesDao.updateAppUserRoles(Long.parseLong(request.getParameter("userRole")), Long.parseLong(request.getParameter("userid")),
												(String)request.getParameter("sessionid"));
				
		/*if(verification.equalsIgnoreCase("Profile is successfully updated."))
		{			
			if( !oldEmail.isEmpty() && !oldEmail.equalsIgnoreCase(newEmail))
			{
				System.out.println("User Email changed. Enter in SessionLog");				
				SessionLog.insertIntoSessionLog(sessionid,Long.parseLong(userid), Long.parseLong(comId), "Email Changed",0L,"Email", oldEmail,newEmail, "Email Changed");
				
			}					
			if( !oldFirstName.isEmpty() && !oldFirstName.equalsIgnoreCase(newFirstName))
			{
				System.out.println("User First Name changed. Enter in SessionLog");				
				SessionLog.insertIntoSessionLog(sessionid,Long.parseLong(userid), Long.parseLong(comId), "First Name Changed",0L,"First Name", oldFirstName,newFirstName, "First Name Changed");
				
			}					
			if( !oldLastName.isEmpty() && !oldLastName.equalsIgnoreCase(newLastName))
			{
				System.out.println("User Last Name changed. Enter in SessionLog");				
				SessionLog.insertIntoSessionLog(sessionid,Long.parseLong(userid), Long.parseLong(comId), "Last Name Changed",0L,"Last Name", oldLastName,newLastName, "Last Name Changed");
				
			}					
		}*/
	}else {
		verification="Mobile Number is already associated with another registered user. Please enter a different mobile number.";
	}
		try{
			
			request.setAttribute("sessionid", request.getParameter("sessionid"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp?sessionid="+(String)request.getParameter("sessionid")+"&successMsg="+verification);
			dispatcher.forward(request, response);
		} catch(Exception e){
			System.out.println("Exception -->"+e.getMessage());
		
		}
	}   	
	
}
