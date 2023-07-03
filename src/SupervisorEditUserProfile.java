
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.AppRoles;
import com.peniel.common.PenielException;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.AppUserRolesDAO;

/**
 * Servlet implementation class for Servlet: GetFiles
 *
 */
 public class SupervisorEditUserProfile extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(SupervisorEditUserProfile.class);
   
   private String userName = "";

      
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SupervisorEditUserProfile() {
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
		//String oldRole = request.getParameter("oldRole").toString();
		//String oldEmail = request.getParameter("oldEmail").toString();
		//String newEmail = request.getParameter("email").toString();
		//String oldSecondEmail = request.getParameter("oldSecondEmail").toString();
		//String newRole = request.getParameter("newRole").toString();
		String sessionid = request.getParameter("sessionid");
		String userid = request.getParameter("userid");
		String comId = request.getParameter("comId");
		String[] userRoleValue= request.getParameterValues("userRoleValue");
		String  userRoleID= request.getParameter("userRoleID");
		String userSelectedRoleId = request.getParameter("userSelectRole");
		String otp=request.getParameter("OTP");

		
		AppUserDAO appUserDao = new AppUserDAO();
		String verification =null;
		String cellPhone=(String)request.getParameter("cellPhone");
		
		 boolean moblecheck=false;
    	 if(null!=cellPhone&&!"".equals(cellPhone)) {
    		 moblecheck =appUserDao.mobileExist(userid,cellPhone);
    	 }
		if(!moblecheck) {
		AppUserRolesDAO appUserRolesDao = new AppUserRolesDAO();
		String status = (String)request.getParameter("status");
		//System.out.println("status = "+status);
		if (status.equalsIgnoreCase("Active")) {
			status = "A";
		} else if (status.equalsIgnoreCase("Disabled")) { 
			status = "D";
		}
		
		
		String acceptMails = (String)request.getParameter("acceptMails");
		//System.out.println("acceptEmails--> = "+acceptEmails[0]);
		if (acceptMails != null) 
		{
			acceptMails = "Y";
		} else
		{ 
			acceptMails = "N";
		}
		
		 verification = appUserDao.updateAppUserById(request.getParameter("userid"), (String)request.getParameter("first_name"), 
				(String)request.getParameter("last_name"), (String)request.getParameter("address1"), (String)request.getParameter("address2"), (String)request.getParameter("city"), 
				(String)request.getParameter("state"), (String)request.getParameter("zip"), (String)request.getParameter("email"), (String)request.getParameter("phone_no"),
				(String)request.getParameter("cellPhone"),  status, acceptMails,
				(String)request.getParameter("sessionid"),otp,(String)request.getParameter("AUTH_ID"));
		
		//update the user's role
		/*if(userRoleValue.length!=0){
			Vector<AppUserRoles> rolesP=appUserRolesDao.findAll(Long.parseLong(request.getParameter("userid")),Long.parseLong(request.getParameter("userRoleID")));
			
			System.out.println("WEEEELCOME"+Long.toString(rolesP.get(0).getRoleId()));
			for(int i=0;i<userRoleValue.length;i++){
		
				if(userRoleValue[i].equals(Long.toString(rolesP.get(0).getRoleId()))){
					appUserRolesDao.updateAppUserRoles(Long.parseLong(userRoleValue[i]), Long.parseLong(request.getParameter("userid")),
											  (String)request.getParameter("sessionid"),Long.parseLong(request.getParameter("userRoleID")));
		
				}
				else{
					
					try {
						long userRoleId = appUserDao.getNextId1();
					
					appUserRolesDao.insertIntoAppUserRoles(Long.parseLong(userRoleValue[i]),Long.parseLong(request.getParameter("userid")),userRoleId);
					} catch (PenielException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
	}
			}
		}*/
		System.out.println("============userRoleValue========"+userRoleValue);
		
		System.out.println("============userRoleValue========"+userRoleValue.length);
		int userRoleLength = userRoleValue.length;
        if(userRoleValue.length!=0){
				 int countRecords=0;
				
				 boolean countValue=false;
		         List<AppRoles> existedUserRoles = appUserRolesDao.findByRoleNames(request.getParameter("userid"));
				 for(int i=0;i<userRoleLength;i++){
						boolean countOfRolescheck = false;
						if(userSelectedRoleId.equals(userRoleValue[i])){
						if(countValue){
							System.out.println("inserted condition");
							 long userRoleId;
							try {
								userRoleId = appUserDao.getNextId1();
								 appUserRolesDao.insertIntoAppUserRoles(Long.parseLong(userRoleValue[i]),Long.parseLong(request.getParameter("userid")),userRoleId);
								countOfRolescheck = true;
							} catch (PenielException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						
						}
						else{
							
								appUserRolesDao.updateAppUserRoles(Double.parseDouble(userRoleValue[i]), Double.parseDouble(request.getParameter("userid")),
								(String)request.getParameter("sessionid"),Double.parseDouble(request.getParameter("userRoleID")));
								countOfRolescheck = true;
								countRecords++;
							}
				
						}else {
							for(int j=0;j< existedUserRoles.size();j++){
									 if(userRoleValue[i].equals(Long.toString(existedUserRoles.get(j).getRoleId()))){									 
									 if(i!=0){
										/*appUserRolesDao.updateAppUserRoles(Long.parseLong(userRoleValue[i]), Long.parseLong(request.getParameter("userid")),
										  (String)request.getParameter("sessionid"),Long.parseLong(request.getParameter("userRoleID")));*/
										System.out.println("updated condition break");
										countOfRolescheck = true;
										countRecords ++;
										break;
									 }
									 else{
										 countOfRolescheck = true;
										 countRecords ++;
										 break;
									 }
									 
								    }else{
								    	
								   }
							}							
						}
						if(!countOfRolescheck){
							if(countRecords==0){
								appUserRolesDao.updateAppUserRoles(Long.parseLong(userRoleValue[i]), Long.parseLong(request.getParameter("userid")),
								(String)request.getParameter("sessionid"),Long.parseLong(request.getParameter("userRoleID")));
								 countRecords++;
								 countValue = true;
								 
							}
							else {
							 System.out.println("inserted condition");
							 long userRoleId;
							try {
								userRoleId = appUserDao.getNextId1();
								 appUserRolesDao.insertIntoAppUserRoles(Long.parseLong(userRoleValue[i]),Long.parseLong(request.getParameter("userid")),userRoleId);

							} catch (PenielException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							}
						}
						else{
											 
						}							 
				 }							
				 
			 } 		
		/*if(verification.equalsIgnoreCase("Profile is successfully updated."))
		{
			if(!oldRole.isEmpty()  && !oldRole.equalsIgnoreCase(newRole))
			{
				System.out.println("User role changed. Enter in SessionLog");				
				SessionLog.insertIntoSessionLog(sessionid,Long.parseLong(userid), Long.parseLong(comId), "Role Changed",0L,"User Role", oldRole,newRole, "Role Changed");
				
			}
			if( !oldEmail.isEmpty() && !oldEmail.equalsIgnoreCase(newEmail))
			{
				System.out.println("User Email changed. Enter in SessionLog");				
				SessionLog.insertIntoSessionLog(sessionid,Long.parseLong(userid), Long.parseLong(comId), "Email Changed",0L,"Email", oldEmail,newEmail, "Email Changed");
				
			}
					
		}*/
	}else {
		verification="Mobile Number is already associated with another registered user. Please enter a different mobile number.";
	}
		//return verification;
		try{			
			request.setAttribute("sessionid", request.getParameter("sessionid"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("supervisorGrid.jsp?sessionid="+(String)request.getParameter("sessionid")+"&successMsg="+verification);
			dispatcher.forward(request, response);
		} catch(Exception e){
			System.out.println("Exception -->"+e.getMessage());
		
		}
	}   	
	
}
