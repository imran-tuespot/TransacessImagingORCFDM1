package com.peniel.beans;

import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.peniel.dao.AppRolesDAO;
import com.peniel.dao.SessionLogDAO;
import com.peniel.dao.UserLogDAO;
import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.SessionLog;
import com.peniel.bus.vo.UserLog;



public class AuditTrailSessionLog
{
	
	private static Logger logger = LogManager.getLogger(AuditTrailSessionLog.class);
	
	public static String getAuditTrailSessionLog(String comId, String docId)
	{
		
		Vector sessionLogList = new Vector();
		String htmlTableData = "";

		
		  try
		  {
			  	// Audit Trail
			  
//			  	System.out.println(comId);
//			  	System.out.println(docId);
			  	SessionLogDAO sessionLogDAO = new SessionLogDAO();

			  	sessionLogList =  sessionLogDAO.getAllSessionLog(docId, comId);
			  	
			  	//build the html table to display on the page
			  	htmlTableData = htmlTableBuilder(sessionLogList);
			  	
			  	
		  } 
		  catch ( Exception e) 
		  {
			  logger.error("getAuditTrailSessionLog() : Error : "+e.getMessage());
		  }
		 
		  
		  return htmlTableData;
		
	}
	
	public static String getUserAuditLog(String userId)
	{
		
		Vector userLogList = new Vector();
		String htmlTableData = "";		
		  try
		  {
			  	UserLogDAO userLogDAO = new UserLogDAO();

			  	userLogList =  userLogDAO.getUserLog(userId);
			  	//Print userLogList
			  	/*for(int i=0; i<userLogList.size(); i++)
			  	{
			  		UserLog userLog = (UserLog)userLogList.get(i);
			  		System.out.println(i+ "First Name  "+userLog.getFirstName());
			  	}*/
			  	
			  	//build the html table to display on the page
			  	htmlTableData = htmlTableBuilderForUser(userLogList);			  	
			  	
		  } 
		  catch ( Exception e) 
		  {
			  logger.error("getAuditTrailSessionLog() : Error : "+e.getMessage());
		  }
		 		  
		  return htmlTableData;
		
	}
	public static String htmlTableBuilderForUser(Vector userLogList)
	{
		StringBuffer stringBuffer = new StringBuffer();
		StringBuffer rowDataBuffer = new StringBuffer();
		
	
		int auditListIterator =  userLogList.size();
		
		logger.info("result size -->"+auditListIterator);
		//loop through the vector to get the information for each column SessionLog Objects
		UserLog userLog = new UserLog();
		stringBuffer.append(htmlBuilderHeaderAndFirstRow(userLog));

		for(int y = 0; y < auditListIterator; y++)
		{
			//get the object from the vector list
			userLog = (UserLog) userLogList.get(y);
		
			//get the first row and make sure that it is being displayed with the header information
			//	if(y == 0)
			{
				//get the header and first row of data for the first table to display
			}
			//	else
			{
				//build the table that is going to show the remaining rows of data
				rowDataBuffer.append(getBuildDataRow2(userLog));
				
			}

		}
		rowDataBuffer.append("\n </table> ");

		//put all html code together
		//get the first table that has the header and the first row of data
		//and append to that the rest of the rows of data
		stringBuffer.append("\n <div id=\"auditTrail\" style=\"width: 800px; display:none\"> ")
		//stringBuffer.append("\n  ")
					//.append("\n <table align=\"center\" width= \"800\" > ")
					.append(rowDataBuffer.toString())
					//.append("\n </table> ")
					.append("\n </div> ");
					//.append("\n ");
		
		//System.out.println("stringBuffer "+stringBuffer);
		return stringBuffer.toString();
	}
	
	
	public static String htmlTableBuilder(Vector sessionLogList)
	{
		StringBuffer stringBuffer = new StringBuffer();
		StringBuffer rowDataBuffer = new StringBuffer();
		
	
		int auditListIterator =  sessionLogList.size();
		
		logger.info("result size -->"+auditListIterator);
		//loop through the vector to get the information for each column SessionLog Objects
		SessionLog sessionLog = new SessionLog();
		stringBuffer.append(htmlTableBuilderHeaderAndFirstRow(sessionLog));

		for(int y = 0; y < auditListIterator; y++)
		{
			//get the object from the vector list
			sessionLog = (SessionLog) sessionLogList.get(y);
			
			//get the first row and make sure that it is being displayed with the header information
			//if(y == 0)
			{
				//get the header and first row of data for the first table to display
			}
			//else
			{
				//build the table that is going to show the remaining rows of data
				rowDataBuffer.append(getBuildDataRow(sessionLog));
				
			}

		}
		rowDataBuffer.append("\n </table> ");
		//put all html code together
		//get the first table that has the header and the first row of data
		//and append to that the rest of the rows of data
		stringBuffer.append("\n <div id=\"auditTrail\" style=\"width: 800px; display:none\"> ")
		//stringBuffer.append("\n  ")
					.append("\n <table align=\"center\" width= \"800\" > ")
					.append(rowDataBuffer.toString())
					.append("\n </table> ")
					.append("\n </div> ");
					//.append("\n ");
		
		//System.out.println("stringBuffer "+stringBuffer);
		return stringBuffer.toString();
	}
	
	public static String htmlTableBuilderHeaderAndFirstRow(SessionLog sessionLog)
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		
		//header labels for the table of information
		stringBuffer.append("<font size=\"14px\" face=\"roboto\">")
		.append(" <table class=\"audittab\" style=\"border-bottom:1px solid #F90\" align=\"center\" width= \"900\" > ")
					.append("\n  <tr> ")
					.append("\n <td width=\"120\" valign=\"top\"><h5 class=\"header\">Date</h5></td> ")
					.append("\n <td width=\"110\" valign=\"top\"><h5 class=\"header\">Last Name</h5></td> ")
					.append("\n <td width=\"120\" valign=\"top\"><h5 class=\"header\">First Name</h5></td> ")
					.append("\n <td width=\"142\" valign=\"top\"><h5 class=\"header\">Field Modified</h5></td> ")
					.append("\n <td width=\"133\" valign=\"top\"><h5 class=\"header\">Old Value</h5></td> ")
					.append("\n <td width=\"196\" valign=\"top\"><h5 class=\"header\">New Value</h5></td> ")
					.append("\n <td width=\"196\" valign=\"top\"><h5 class=\"header\">Action</h5></td> ")
					.append("\n </tr> ");
					
					//here is the horizontal rule that separate the data from the headers
					
					
					//build the html row with data from the first row
					//.append(getBuildDataRow(sessionLog))
					//.append("\n </table> ");
		return stringBuffer.toString();
	}
	
	public static String getBuildDataRow(SessionLog sessionLog)
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("\n <tr> ")
		.append("\n <td width=\"120\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + (String) sessionLog.getDtm() + "</p></td> ")
		.append("\n <td width=\"110\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + (String)sessionLog.getLastName() + "</p></td> ")
		.append("\n <td width=\"120\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + (String)sessionLog.getFirstName() + "</p></td> ")
		.append("\n <td width=\"142\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + (String)sessionLog.getFieldName().replace("_", " ") + "</p></td> ")
		.append("\n <td width=\"133\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + (String)sessionLog.getOldValue() + "</p></td> ")
		.append("\n <td width=\"196\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + (String)sessionLog.getNewValue() + "</p></td> ")
		.append("\n <td width=\"196\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + (String)sessionLog.getAction() + "</p></td> ")
		.append("\n </tr> ");
		
		
		return stringBuffer.toString();
	}
	public static String getBuildDataRow2(UserLog userLog)
	{
		String dateChg = (String)userLog.getDateOfChg();
		String lastName = (String)userLog.getLastName();
		String firstName = (String)userLog.getFirstName();
		String fieldChanged = (String)userLog.getFieldChanged().replace("_", " ");
		String oldVal = (String)userLog.getOldValue();
		String newVal = (String)userLog.getNewValue();
		AppRoles appRoles;
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println(" userLog.getFieldChanged()"+userLog.getFieldChanged());
		if(userLog.getFieldChanged().equalsIgnoreCase("ROLE_ID"))
		{
			AppRolesDAO appRolesDAO = new AppRolesDAO();
			Vector<AppRoles> oldRole = appRolesDAO.findById(userLog.getOldValue());		      
		    appRoles = oldRole.get(0);
		    System.out.println("appUserRoles "+appRoles.getRoleName());
		    oldVal = appRoles.getRoleName();
		    Vector<AppRoles> newRole = appRolesDAO.findById(userLog.getNewValue());		      
		    appRoles = newRole.get(0);
		    System.out.println("appUserRoles "+appRoles.getRoleName());
		    newVal = appRoles.getRoleName();
			
		}
		if(userLog.getFieldChanged().equalsIgnoreCase("STATUS"))
		{
			if(oldVal.equalsIgnoreCase("A"))
				oldVal = "Active";
			if(oldVal.equalsIgnoreCase("D"))
				oldVal = "Disabled";	
			if(newVal.equalsIgnoreCase("A"))
				newVal = "Active";
			if(newVal.equalsIgnoreCase("D"))
				newVal = "Disabled";	
			
		}
		
		stringBuffer.append("\n <tr> ")
		.append("\n <td width=\"120\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + dateChg + "</p></td> ")
		.append("\n <td width=\"100\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + lastName + "</p></td> ")
		.append("\n <td width=\"120\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + firstName + "</p></td> ")
		.append("\n <td width=\"132\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + fieldChanged + "</p></td> ")
		.append("\n <td width=\"123\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + oldVal + "</p></td> ")
		.append("\n <td width=\"170\" align=\"left\" valign=\"top\"><p class=\"auditclass\">" + newVal + "</p></td> ")
		.append("\n </tr> ");
		
		
		return stringBuffer.toString();
	}
	
	public static String htmlBuilderHeaderAndFirstRow(UserLog userLog)
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append(" <font size=\"14px\" face=\"roboto\"><table class=\"audittab\" style=\"border-bottom:1px solid #F90\"  align=\"center\" width= \"1000\" > ")
					.append("\n  <tr> ")
					.append("\n <td width=\"120\" valign=\"top\"><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date</h5></td> ")
					.append("\n <td width=\"100\" valign=\"top\"><h5>Last Name</h5></td> ")
					.append("\n <td width=\"120\" valign=\"top\"><h5>First Name</h5></td> ")
					.append("\n <td width=\"142\" valign=\"top\"><h5>Field Modified</h5></td> ")
					.append("\n <td width=\"140\" valign=\"top\"><h5>Old Value</h5></td> ")
					.append("\n <td width=\"196\" valign=\"top\"><h5>New Value</h5></td> ")
					.append("\n </tr> ");
					
					
					//build the html row with data from the first row
					//.append(getBuildDataRow2(userLog))
					//.append("\n </table> ");
		return stringBuffer.toString();
	}
	
	
	
		  	    
}