

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.beans.Login;
import com.peniel.beans.SessionBean;
import com.peniel.beans.SessionLog;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.Company;
import com.peniel.common.DBManager;
import com.peniel.dao.CompanyDAO;
import com.peniel.utilities.GeneratePassword;

/**
 * Servlet implementation class for Servlet: Getlogin
 *
 */
 public class Getlogin extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
   private static Logger logger = LogManager.getLogger(Getlogin.class);
   
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Getlogin() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		//doPost(request, response);
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager db = null;
		// TODO Auto-generated method stub
		String isLogged = "null";	
		String username = (String)request.getParameter("username").toUpperCase().trim();
		String password = (String)request.getParameter("password");
		String check = (String)request.getSession().getAttribute("check");
		int comid =0;
		String appUserRole = "";
		String roleId="";
		AppModules appModulesData=new AppModules();
		
		int userId = 0;
		try 
		{
            db = DBManager.getInstance();
            db.initialize();
            javax.naming.Context ctx = new javax.naming.InitialContext();
            String appProperty = (String) ctx.lookup("java:comp/env/appProperty");
			Login login = new Login();
			
			//get the correct companyId
			List<AppUser> appUsers =  new ArrayList<AppUser>();
			//username.replaceAll("\\s","")
			//System.out.println("Imaging Getlogin  Original User Pass Phrase:============== " + password);
			GeneratePassword generatePassphrase = new GeneratePassword(appProperty); 
			password = generatePassphrase.encrypt(password);
			//System.out.println("Imaging Getlogin  Encrypted User Pass Phrase:==================== " + generatePassphrase.decrypt("2iFLdnQKx8D3NrOSpLmBZA=="));
			
			appUsers = login.getAuthenticated(username, password);
			
			Map<AppUser,Integer> userMap = new HashMap<AppUser,Integer>();
			Map<AppModules,Integer>  moduleMap= new HashMap<AppModules,Integer>();
			Set<String> folderPatterens= new LinkedHashSet<String>();
			Set<String> rightNames= new LinkedHashSet<String>();
			Set<String> accessPatterenDetails= new LinkedHashSet<String>();
			List<String> patteren =new ArrayList<String>();
			Map<String,String> accessPatteren= new LinkedHashMap<String,String>();
			Map<String,String> moduledata= new HashMap<String,String>();
			
			
						
			AppModules appModules=null;
			
			 AppUser app =null;
			
			if(appUsers != null && !appUsers.get(0).getStatus().equals("Disabled") ){
				
				logger.info(appUsers.toString());
				userId = (int) appUsers.get(0).getUserId();
				comid = (int) appUsers.get(0).getCompanyId();
				appUserRole = (String) appUsers.get(0).getRole();
				
//				for(AppUser appuser: appUsers){
					// appModules=GetModulesDataByRoleId.getModulesByRoleId(appuser.getRoleId());
//					 if(appModules.getModuleDetails()!=null){					 
//					 logger.info(appModules.getModuleDetails().size());
//					 userMap.put(appuser,appModules.getModuleDetails().size());	
//					
//					 moduleMap.put(appModules,appModules.getModuleDetails().size());
//					 }
	//				}
				
				
				/*if(userMap.isEmpty())
				{
					logger.info("Default user adding");
					AppUser	appUser = appUsers.get(0);
					appUser.setRole("USER");
					appUser.setRoleId("2");
					appModules=GetModulesDataByRoleId.getModulesByRoleId(appUser.getRoleId());
					 if(appModules.getModuleDetails()!=null){					 
					 logger.info(appModules.getModuleDetails().size());
					 userMap.put(appUser,appModules.getModuleDetails().size());					
					 moduleMap.put(appModules,appModules.getModuleDetails().size());
					 }
					
				}*/
				System.out.println("kkkk"+userMap.isEmpty());
				if(!userMap.isEmpty()){
				 int maxValueInMap=(Collections.max(userMap.values()));  // This will return max value in the Hashmap
			        for (Entry<AppUser, Integer> entry : userMap.entrySet()) { 
			        	// Itrate through hashmap
			        	  logger.info(maxValueInMap + entry.getValue());   
			            if (entry.getValue()==maxValueInMap) {
			            	
			            	 app = entry.getKey();
			                logger.info("3333333333333"+entry.getKey());
			               
			            }
			            logger.info("3333333333333"+entry.getKey());
			           }
				
			       
				
				//get the user's ROLE
				//appUserRole = (String) app.getRole();
				System.out.println("appUserRole:"+appUserRole);
				logger.info("User Role ---->"+appUserRole);
				
				roleId=(String) app.roleId;
				logger.info(	"User RoleID ---->"+roleId);
			
				Rights rights =GetRightsDataByRoleId.getRightsByRoleId(roleId);
				
				List<AddRightsResponse> roleDetails=rights.getRoleDetails();
								

				for(AddRightsResponse rightData:roleDetails)
				{    
					rightNames.add(rightData.getRightName());
					accessPatterenDetails.add(rightData.getAcessType());
					folderPatterens.add(rightData.getFolderPattern());
					accessPatteren.put(rightData.getFolderPattern(), rightData.getAcessType());

				}
				logger.info(folderPatterens);
				logger.info(accessPatteren);
				
				
            
               
               for (Entry<AppModules, Integer> entry : moduleMap.entrySet()) { 
		        	
		        	  logger.info(maxValueInMap + entry.getValue());   
		            if (entry.getValue()==maxValueInMap) {		            	
		            	appModulesData = entry.getKey();
		                logger.info(entry.getKey());
		               
		            }
		            
		           }
			
               
            	for(ModuleResponse moduleResponse:appModulesData.getModuleDetails())
				{
	
            		//	logger.info("submodule"+moduleResponse.getSubModuleName());
					//logger.info("module"+ moduleResponse.getModuleName());

					moduledata.put(moduleResponse.getSubModuleName(), moduleResponse.getModuleName());
				
				}
				
            	logger.info("moduledata"+moduledata);
               
            	logger.info(appModulesData.getModuleDetails());
				
				}
				
				Vector companyList = new CompanyDAO().findById(comid+"");
				Company company = (Company) companyList.get(0);
				logger.info("Company ****"+company.toString());
				 System.out.println("Company Full Name:::"+company.getCompanyFullname());
				request.getSession().setAttribute("companyName", company.getCompanyName());
				request.getSession().setAttribute("defaultIndex", company.getDefaultIndex());
				if(company.getCompanyFullname()!=null) {
					 request.getSession().setAttribute("companyFullname", company.getCompanyFullname());
				}else {
					 request.getSession().setAttribute("companyFullname", "");
				}
			   
				String sessionid = SessionBean.getNewSessionId(username);
	
				String ipaddress = request.getRemoteHost();
				InetAddress inetAddress = InetAddress.getLocalHost();
				String clientIpAddress = inetAddress.getHostAddress();
				
				if ( ipaddress == null && ( ipaddress.equalsIgnoreCase("null") && ipaddress.trim().length()==0)) {
					clientIpAddress = request.getRemoteAddr();
				}
				
				if ( check == null || check.equalsIgnoreCase("null")) 
				{
					java.util.Date today = new java.util.Date();
				    java.sql.Timestamp timestamp = new java.sql.Timestamp(today.getTime());
					
					SessionBean.insertSessionString(sessionid, timestamp, userId,0, username, comid, clientIpAddress);
				}
				
				HttpSession session = request.getSession();
				
				request.setAttribute("userid", appUsers.get(0).getUserId());
				request.setAttribute("sessionid", sessionid);
				request.setAttribute("comid",comid);
				request.setAttribute("email",appUsers.get(0).getEmail());
				request.setAttribute("otp",appUsers.get(0).getOtp());
				request.setAttribute("cell_phone",appUsers.get(0).getCellPhone());
				request.getSession().setAttribute("userid",appUsers.get(0).getUserId());
				request.getSession().setAttribute("sessionid",sessionid);
				request.getSession().setAttribute("comid",comid);
				request.getSession().setAttribute("username",username);
				request.getSession().setAttribute("appuserrole",appUserRole);
				request.getSession().setAttribute("folderPatterens",folderPatterens);
				request.getSession().setAttribute("accessPatteren",accessPatteren);
				request.getSession().setAttribute("rightNames",rightNames);
				moduledata.put("userManagement","userManagement");
				request.getSession().setAttribute("modules",moduledata);
				request.getSession().setAttribute("accessPatterenDetails",accessPatterenDetails);
System.out.println(appUsers.get(0).getAuthId()+":::::::::::::naveen");
				if(appUsers.get(0).getAuthId()==0) {
					request.setAttribute("authId",0);
				
				}else {
					request.setAttribute("authId",appUsers.get(0).getAuthId());
					
				}
				
				logger.info(appUsers.get(0).getOtp() +" : Login successful. ");
				
				long docid = 0L;
				long version = 0L;
				System.out.println("naveen:"+appUserRole);
				
				logger.info(sessionid +" "+ userId+":::"+appUserRole +" "+ comid +" "+ "Login" +" "+ "Login Successful");
				SessionLog sessionLog = new SessionLog();
				//sessionLog.insertIntoSessionLog(sessionid, userId, comid, "Login", docid, version, "Login Successful");
				
				System.out.println(appUsers.get(0).getMfaStatus()+":::::::::::::getMfaStatus");
								
				request.getSession().setAttribute("openwindow","no");
				//if an admin user, send them to the Admin portal page
				if(appUsers.get(0).getMfaStatus()==0) {
					System.out.println("if");
					request.getSession().setAttribute("openwindow","yes");
					RequestDispatcher rd = request.getRequestDispatcher(getPageRedirect(appUserRole));
					rd.forward(request, response);
				}else {
					System.out.println("else");
					RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				//response.sendRedirect(getPageRedirect(appUserRole)+"?sessionid="+sessionid);
				
			} 
			else 
			{
				if(appUsers != null && appUsers.get(0).getStatus().equals("Disabled")) {
					request.setAttribute("errormsg", "your status is not activated");
					
				}
				isLogged = "no";
			    request.setAttribute("isLogged", isLogged);
			    logger.info(username +" : Login failed. ");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response); 
			}
		} 
		catch ( Exception e) 
		{
			e.printStackTrace();
			isLogged = "no";
		    request.setAttribute("isLogged", isLogged);
		    logger.info(username +" : Login failed. ");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response); 
		}
	} 
	
	
	public static String getPageRedirect(String appUserRole)
	{
		String pageRedirect = "";
		
		/*if(appUserRole.equals("ADMIN") || appUserRole.equals("POWERUSER"))
		{
			pageRedirect = "/dashboard.jsp";
		}*/
	/*	else if(appUserRole.equals("MANAGER"))
		{
			pageRedirect = "docMgmtSearchGrid.jsp";
		}*/
		/*else
		{
			pageRedirect = "/dashboard1.jsp";
		}*/
		
		if(appUserRole!=null)
		{
			pageRedirect = "/indexPage.jsp";
		}
	
		
		return pageRedirect;
	}
	
	/*public String getContextLogin(){
		//String contextLoginId = "";
		try{
			TaraWS3Locator loc = new TaraWS3Locator();
			
			loc.setEndpointAddress("TaraWS3Soap", "http://www.taptrac.com/HUDPleaseReview/services/taraws3.asmx");
			
			logger.info("Endpoint = "+loc.getTaraWS3SoapAddress());
			java.net.URL url= new java.net.URL(loc.getTaraWS3SoapAddress());
			
			String sname=loc.getTaraWS3SoapWSDDServiceName();
			logger.info("Service = "+sname);
			
			TaraWS3Soap_BindingStub bstub = new TaraWS3Soap_BindingStub(url,loc);
			logger.info("*** 1 **  ");
			//contextLoginId = bstub.impersonate(accessKey, "PleaseReview:NativeUser", "mpeters");
			//logger.info("** 2*** "+contextLoginId);
			
			logger.info("Web Service Call ended");
		}catch(Exception e){
			logger.info("exception -->"+e.getMessage());
		}
		return contextLoginId;
	}*/
}