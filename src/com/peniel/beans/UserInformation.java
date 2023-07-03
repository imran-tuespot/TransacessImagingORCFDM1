package com.peniel.beans;



import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.AppUserRoles;
import com.peniel.dao.AppUserDAO;
import com.peniel.dao.AppUserRolesDAO;



public class UserInformation 
{
	public static HashMap getUserInformation(HttpServletRequest request)
	{
		HashMap hashMap = new HashMap();
		
		Vector appUserList = new Vector();
		AppUserDAO appUserDao = new AppUserDAO();
		
		//Get the user's information from the database
		 appUserList = appUserDao.findByUserId(Long.toString((Long)request.getSession().getAttribute("userid")));		

        
		
		return getInformation(appUserList);
	}
	
	public static HashMap getUserInformation(String userid)
	{
		HashMap hashMap = new HashMap();
		
		Vector appUserList = new Vector();
		AppUserDAO appUserDao = new AppUserDAO();

		//Get the user's information from the database
        appUserList = appUserDao.findByUserId(userid);
		
		
		return getInformation(appUserList);
	}
	
	
	public static HashMap supervisorGetUserProfile(HttpServletRequest request)
	{
		HashMap hashMap = new HashMap();
		
		Vector appUserList = new Vector();
		AppUserDAO appUserDao = new AppUserDAO();

		//Get the user's information from the database
		appUserList = appUserDao.findByUserId(request.getParameter("guestUserId"),request.getParameter("userRoleValue"));
		
		
		return getInformation(appUserList);
	}
	
	public String  getUserAuditTrail(HttpServletRequest request)
	{
			
        AuditTrailSessionLog auditTrailSessionLog = new AuditTrailSessionLog();
		String htmlTableAuditTrail = auditTrailSessionLog.getUserAuditLog(request.getParameter("guestUserId"));
		
		return htmlTableAuditTrail;
	}
	public String  getUserAuditTrail(String userId)
	{
			
        AuditTrailSessionLog auditTrailSessionLog = new AuditTrailSessionLog();
		String htmlTableAuditTrail = auditTrailSessionLog.getUserAuditLog(userId);
		
		return htmlTableAuditTrail;
	}
	
	
	public static String getUserStatusChange(String username, String sessionId)
	{
		AppUserDAO appUserDao = new AppUserDAO();
		AppUser appUser = new AppUser();
		Vector appUserList = new Vector();
		String status = "";
		
		appUserList = appUserDao.findByUserame(username.toUpperCase());
		
		appUser = (AppUser) appUserList.get(0);
		
		if(appUser.getStatus().equals("A"))
		{
			status = "D";
		}
		else if(appUser.getStatus().equals("D"))
		{
			status = "A";
		}
		
		appUserDao.updateStatusById(appUser.getUserId(), status);
		
		
		//insertIntoSessionLog(sessionId, appUser.getUserId(), appUser.getCompanyId(), "Admin Status Change");
		SessionLog sessionLog = new SessionLog();
		sessionLog.insertIntoSessionLog(sessionId, appUser.getUserId(), appUser.getCompanyId(), "Admin Status Change", 0L, 0L, "Admin Status Change Successful");
		
		return status;
	}
	
	
	public static HashMap getInformation(Vector appUserList)
	{
		HashMap hashMap = new HashMap();
		
		try 
		{
			
	        //There should only be one record for this userid
	        AppUser appUser = new AppUser();
	        
	        appUser = (AppUser) appUserList.get(0);
	        
	             
	        hashMap.put("userId", appUser.getUserId());
	        hashMap.put("comId", appUser.getCompanyId());
	        hashMap.put("username", appUser.getUsername());
	        hashMap.put("password", appUser.getPassword());
	        hashMap.put("firstName", appUser.getFirstName());
	        hashMap.put("lastName", appUser.getLastName());
	        hashMap.put("address1", appUser.getAddress1());
	        hashMap.put("address2", appUser.getAddress2());
	        hashMap.put("city", appUser.getCity());
	        hashMap.put("state", appUser.getState());
	        hashMap.put("zip", appUser.getZip());
	        hashMap.put("email", appUser.getEmail());
	       // hashMap.put("phoneNum", appUser.getPhoneNo());
	        hashMap.put("status", appUser.getStatus());
	        hashMap.put("cellPhone", appUser.getCellPhone());
	        //hashMap.put("secondEmail", appUser.getSecondEmail());
	        //hashMap.put("jobTitle", appUser.getJobTitle());
	        hashMap.put("role", appUser.role);
	        hashMap.put("password_status", appUser.getPasswordStatus());
	        hashMap.put("accept_mails", appUser.getAcceptMails());
	        hashMap.put("AUTH_ID", appUser.getAuthId());
	        hashMap.put("OTP", appUser.getOtp());
	        //get the app user's role
	        FormInformation formInformation = new FormInformation();
	        AppUserRolesDAO appUserRolesDao = new AppUserRolesDAO();
	        AppUserRoles appUserRoles = new AppUserRoles();
	        Vector appUserRolesList = new Vector();
	        
	        /*appUserRolesList = appUserRolesDao.findByUserId(Long.toString(appUser.getUserId()));
	        appUserRoles = (AppUserRoles) appUserRolesList.get(0);
	        
	        String userRole = formInformation.getAppRolesInformation(appUserRoles.getRoleId());*/
	        List<AppRoles> mapList=appUserRolesDao.findByRoleNames(Long.toString(appUser.getUserId()));
			
			String ano =" ";
			for(int i=0;i<mapList.size();i++){
			System.out.println("Get All Roles:"+mapList.get(i).getRoleName());
			ano =ano+mapList.get(i).getRoleName()+" ,"; 
			}
			if(ano.endsWith(" ,")){
				ano = ano.substring(0, ano.length() - 1);
			}
			String htmlCode ="<p>"+ano+"</p>";
			System.out.println("htmlCode:"+htmlCode);
	        
	        int roleSelected=Double.valueOf(appUser.getRoleId()).intValue();
	        String userRole = formInformation.getAppRolesInformationSelect(roleSelected,appUser.getCompanyId());
	        
	        System.out.println("userROLE:"+userRole);
	        
	        //get the state list and select the one that is accurate
	        String stateList = formInformation.getStatesInformation(appUser.getState());
	        
	     //   hashMap.put("userSelectedRole",rolesDemoo);
	        hashMap.put("userSelectedRole",roleSelected);
	        hashMap.put("userRole", userRole);
	        hashMap.put("stateList", stateList);
	        hashMap.put("selectedRolesNames", htmlCode);
			
			
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		
		return hashMap;
	}
	


	
	public static String processProfileUpdate(HttpServletRequest request)
	{
		AppUserDAO appUserDao = new AppUserDAO();
		AppUserRolesDAO appUserRolesDao = new AppUserRolesDAO();
		String status = (String)request.getParameter("status");
		System.out.println("status = "+status);
		if (status.equalsIgnoreCase("Active")) {
			status = "A";
		} else if (status.equalsIgnoreCase("Disabled")) { 
			status = "D";
		}
		String acceptEmails = request.getParameter("acceptEmails");
		if (acceptEmails.equalsIgnoreCase("true")) 
		{
			acceptEmails = "Y";
		} else if (acceptEmails.equalsIgnoreCase("false")) 
		{ 
			acceptEmails = "N";
		}
		String verification = appUserDao.updateAppUserById(request.getParameter("userid"), (String)request.getParameter("first_name"), 
				(String)request.getParameter("last_name"), (String)request.getParameter("address1"), (String)request.getParameter("address2"), (String)request.getParameter("city"), 
				(String)request.getParameter("state"), (String)request.getParameter("zip"), (String)request.getParameter("email"), (String)request.getParameter("phone_no"),
				(String)request.getParameter("cellPhone"), status, acceptEmails,
				(String)request.getParameter("sessionid"),(String)request.getParameter("OTP"),(String)request.getParameter("AUTH_ID"));
		
		//update the user's role
		if(request.getParameter("userRole") != null)
			appUserRolesDao.updateAppUserRoles(Long.parseLong(request.getParameter("userRole")), Long.parseLong(request.getParameter("userid")), (String)request.getParameter("sessionid"));
		
		// to be added
		//getUserStatusChange(request.getParameter("username"), request.getParameter("sessionId"));

		return verification;
	}
	
	
}
