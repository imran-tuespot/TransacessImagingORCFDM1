package com.peniel.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import com.peniel.bus.vo.sqlhelpers.AppUserSQLHelper;
import com.peniel.bus.vo.sqlhelpers.SQLHelper;
import com.peniel.common.*;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.AppUser;
import com.peniel.database.DatabaseConnection;


public class AppUserDAO extends DAOHelper<AppUser> {
    public static final String activeStatus = "A";
    public static final String disableStatus = "D";

    private static Logger logger = LogManager.getLogger(AppUserDAO.class);

    public AppUserDAO() {
        super("AppUserDAO", AppUser.getAppUserSQLHelper());
    }

    public Vector<AppUser> findByAdvancedSearch(String companyId, String firstName, String lastName, String sOrder) {
        Vector<AppUser> appUserList = new Vector<AppUser>();

        try {
            //String sqlStatement="select cell_phone, second_email, job_title, user_id, user_type_id, username, company_id, password, first_name, last_name, address1, address2, city, state, zip, email, phone_no, status from app_user where ";

            String sqlStatement = "select /*+result_cache */ APP_ROLES.ROLE_ID role_id,APP_USER_ROLES.USER_ROLE_ID user_role_id,APP_ROLES.role_name role_name,cell_phone, second_email, job_title, app_user.user_id user_id, user_type_id, username, app_user.company_id, password, first_name, last_name, address1, address2, city, state, zip, email, phone_no, (case when status = 'A' then 'Active' else 'Disabled' end) status, password_status from app_user,app_user_roles, APP_ROLES where app_user_roles.user_id = app_user.user_id and APP_ROLES.ROLE_ID = app_user_roles.ROLE_ID and ";

            sqlStatement = sqlStatement + " app_user.company_id = " + companyId;

            if (!StringUtils.isBlank(firstName)) {
                sqlStatement = sqlStatement + "  and upper(first_name) like upper('" + firstName + "%') ";
            }

            if (!StringUtils.isBlank(lastName)) {
                sqlStatement = sqlStatement + "  and upper(last_name) like upper('" + lastName + "%') ";
            }

            if (!StringUtils.isBlank(sOrder))
                sqlStatement = sqlStatement + "  order by " + sOrder;
            else
                sqlStatement = sqlStatement + "order by status,last_name asc";

            logger.info("query22 : " + sqlStatement);
            //appUserList = getAppUserList(DatabaseConnection.getResultSet(sqlStatement));
            appUserList = processSelectMulti(sqlStatement);

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error in findByAdvancedSearch() : " + e.getMessage());
        }

        return appUserList;
    }
    
    public Vector<AppUser> findByUserId(String userId,String personROleId) {
        return findByProperty("USER_ID", userId,personROleId);
    }
public Vector<AppUser> findByProperty(String propertyName, String value,String personRoleID) {
        Vector<AppUser> appUserList = new Vector<AppUser>();

        try {
            if (propertyName.compareToIgnoreCase("USER_ID") == 0) {
                propertyName = "upper(APP_USER." + propertyName + ")";
            }
            else
            {
            	  propertyName = "APP_USER." + propertyName;
            }

            String sqlStatement = "select APP_ROLES.ROLE_ID role_id, APP_USER_ROLES.USER_ROLE_ID user_role_id,APP_ROLES.role_name role_name,nvl(cell_phone,'') CELL_PHONE," +
            		" nvl(second_email,'') SECOND_EMAIL, nvl(job_title,'') JOB_TITLE, app_user.user_id user_id,OTP, " +
            		" user_type_id, username, app_user.company_id, password, first_name, last_name, address1, address2, city," +
            		" state, zip, email, phone_no, (case when status = 'A' then 'Active' else 'Disabled' end) STATUS,AUTH_ID," +
            		" password_status, accept_mails from app_user,app_user_roles, APP_ROLES " +
            		" where app_user_roles.user_id = app_user.user_id and APP_ROLES.ROLE_ID = app_user_roles.ROLE_ID and " 
            		+ propertyName + " = '" + value + "' and APP_USER_ROLES.USER_ROLE_ID ='"+personRoleID+"'";
            sqlStatement = sqlStatement + " order by status,last_name asc";
            logger.info("AppUser query 2222222: " + sqlStatement);
            System.out.println("******************UI**************************");

            //appUserList = getAppUserList(getAppUserList(DatabaseConnection.getResultSet(sqlStatement));
            appUserList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error in findByProperty(): " + e.getMessage());
        }

        return appUserList;
    }

    public Vector<AppUser> findByProperty(String propertyName, String value) {
        Vector<AppUser> appUserList = new Vector<AppUser>();

        try {
            if (propertyName.compareToIgnoreCase("USER_ID") == 0) {
                propertyName = "upper(APP_USER." + propertyName + ")";
            }
            else
            {
            	  propertyName = "APP_USER." + propertyName;
            }

            String sqlStatement = "select   APP_USER_ROLES.USER_ROLE_ID user_role_id,APP_ROLES.ROLE_ID role_id,APP_ROLES.role_name role_name,nvl(CELL_PHONE,'') CELL_PHONE," +
            		" nvl(second_email,'') SECOND_EMAIL, nvl(job_title,'') JOB_TITLE,AUTH_ID,MFA_STATUS,OTP, app_user.user_id user_id, " +
            		" user_type_id, username, app_user.company_id, password, first_name, last_name, address1, address2, city," +
            		" state, zip, email, phone_no, (case when status = 'A' then 'Active' else 'Disabled' end) STATUS," +
            		" password_status, accept_mails from app_user,app_user_roles, APP_ROLES " +
            		" where app_user_roles.user_id = app_user.user_id and APP_ROLES.ROLE_ID = app_user_roles.ROLE_ID and APP_USER_ROLES.USER_ID =APP_USER.USER_ID and " 
            		+ propertyName + " = '" + value + "'";
            sqlStatement = sqlStatement + " order by status,last_name asc";
            logger.info("AppUser query 1111111111111111: " + sqlStatement);

            System.out.println("**************down");
            //appUserList = getAppUserList(getAppUserList(DatabaseConnection.getResultSet(sqlStatement));
            appUserList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error in findByProperty(): " + e.getMessage());
        }

        return appUserList;
    }
    
    public static HashMap getAppUserEmails(String companyId) 
	{
		Vector emailList = new Vector();	 
		StringBuilder strEmails =new StringBuilder(300);
		HashMap<String,String> hashMap = new HashMap<String,String>();
		try 
		{
			String sqlStmt = "select email from app_user where company_id ="+companyId+ 
			" and status = 'A' and password_status = 'A'";
			logger.info("query in AppUserDao : "+sqlStmt);

			emailList = DatabaseConnection.getResultSet(sqlStmt);		
				   
			for(int y = 0; y < emailList.size(); y++)
    		{
				HashMap hashMapEmails = new HashMap();
				hashMapEmails =(HashMap)emailList.get(y);
				
				strEmails.append((String)hashMapEmails.get("EMAIL"));
				
				strEmails.append(";");			
    		}
			hashMap.put("EmailList", strEmails.toString());

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error in getAppUserEmails(): "+e.getMessage());
		}
		
		return hashMap;
	}
    
    public Vector<AppUser> findByUserameUpper(String username) {
        
    	Vector<AppUser> appUserList = new Vector<AppUser>();

        try {
           
            String propertyName = "UPPER(APP_USER.USERNAME) = UPPER('"+username+"')";
            

            String sqlStatement = "select APP_ROLES.ROLE_ID,APP_ROLES.role_name role_name,nvl(cell_phone,'') cell_phone," +
            		" nvl(second_email,'') second_email, nvl(job_title,'') job_title, app_user.user_id user_id, " +
            		" user_type_id, username, app_user.company_id, password, first_name, last_name, address1, address2, city," +
            		//" state, zip, email, phone_no, (case when status = 'A' then 'Active' else 'Disabled' end) status," +
            		" state, zip, email, phone_no, status," +
            		" password_status, accept_mails from app_user,app_user_roles, APP_ROLES " +
            		" where app_user_roles.user_id = app_user.user_id and APP_ROLES.ROLE_ID = app_user_roles.ROLE_ID and " 
            		+ propertyName ;
            
            sqlStatement = sqlStatement + " order by status,last_name asc";
            logger.info("AppUser query : " + sqlStatement);

            //appUserList = getAppUserList(getAppUserList(DatabaseConnection.getResultSet(sqlStatement));
            appUserList = processSelectMulti(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error in findByProperty(): " + e.getMessage());
        }

        return appUserList;
    }


    public Vector<AppUser> findByUserame(String username) {
        return findByProperty("USERNAME", username);
    }

    public Vector<AppUser> findByUserId(String userId) {
        return findByProperty("USER_ID", userId);
    }

    public Vector<AppUser> findByCompanyId(String companyId) {
        try {
            Integer.parseInt(companyId);
            return findByProperty("COMPANY_ID", companyId);
        } catch (NumberFormatException e) {
            logger.error("Company id is " + companyId + " Should be 0");
        }
        return null;
    }
	
	public static Vector getAppUserList(Vector hashMapList)
	{
		Vector appUserList = null;
		AppUser appUser;
		
		appUserList = new Vector();

        try 
        {
        	for(int y = 0; y < hashMapList.size(); y++)
    		{
    			HashMap hashMap = new HashMap();
    			hashMap = (HashMap)hashMapList.get(y);
    			
    			appUser = new AppUser();
    		    appUser.setUserId(Long.parseLong((String)hashMap.get("USER_ID")));
    		    appUser.setUserTypeId(Long.parseLong((String)hashMap.get("USER_TYPE_ID")));
    		    appUser.setUsername((String)hashMap.get("USERNAME"));
    		    appUser.setCompanyId(Long.parseLong((String)hashMap.get("COMPANY_ID")));
    		    appUser.setPassword((String)hashMap.get("PASSWORD"));
    		    appUser.setFirstName((String)hashMap.get("FIRST_NAME"));
    		    appUser.setLastName((String)hashMap.get("LAST_NAME"));
    		    appUser.setAddress1((String)hashMap.get("ADDRESS1"));
    		    appUser.setAddress2((String)hashMap.get("ADDRESS2"));
    		    appUser.setCity((String)hashMap.get("CITY"));
    		    appUser.setState((String)hashMap.get("STATE"));
    		    appUser.setZip((String)hashMap.get("ZIP"));
    		    appUser.setEmail((String)hashMap.get("EMAIL"));
    		    appUser.setPhoneNo((String)hashMap.get("PHONE_NO"));
    		    appUser.setStatus((String)hashMap.get("STATUS"));
    		    appUser.setCellPhone((String)hashMap.get("CELL_PHONE"));
    		    appUser.setSecondEmail((String)hashMap.get("SECOND_EMAIL"));
    		    appUser.setJobTitle((String)hashMap.get("JOB_TITLE"));
    		    appUser.role = ((String)hashMap.get("ROLE_NAME"));
    		    appUser.setPasswordStatus((String)hashMap.get("PASSWORD_STATUS"));
    		    appUser.setRole((String)hashMap.get("ROLE_NAME"));
    		    appUser.setRoleId((String)hashMap.get("ROLE_ID"));
    		    
    		    appUser.setAcceptMails((String)hashMap.get("accept_mails"));
    		    //cell_phone
    			//second_email
    			//job_title
    			
    		    appUserList.add(appUser);
    		}
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error in getAppUserList(): "+e.getMessage());
		}

		return appUserList;
	}
	
	public static Vector findByComapnyAndRole(String companyId, String roleName)
	{
		 Vector<AppUser> appUserList = new Vector<AppUser>();
		
		 try 
			{				
				String sqlStatement="select * from app_user where company_id ="+companyId +
				" and user_id in ( select user_id from app_user_roles "+
				" where role_id in ( select role_id from app_roles where role_name ='" + roleName + "'))";
								
				logger.info("query select all Admins : "+sqlStatement);
				appUserList = getAppUserList(DatabaseConnection.getResultSet(sqlStatement));

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				logger.info("Error in findByComapnyAndRole(): "+e.getMessage());
			}
		
		 return appUserList;
	}
    public String insertIntoAppUser(long userId, String userTypeId, String username, String companyId,
                                           String firstName, String lastName, String address1, String address2, String city, String state,
                                           String zip, String email, String phoneNo, String cellPhone, String secondEmail, String jobTitle, String acceptMails) {
        try {
            String sqlStatement = "insert into app_user (user_id, user_type_id, username, company_id, first_name, last_name, address1, address2, city, state, zip, email, phone_no, cell_phone, second_email, job_title,password_status, accept_mails) values (" + userId + ", " + userTypeId + ", '" + username + "', " + companyId
                    + ", '" + firstName + "', '" + lastName + "', '" + address1 + "', '" + address2 + "', '" + city
                    + "', '" + state + "', '" + zip + "', '" + email + "', '" + phoneNo + "', '" + cellPhone + "', '" + secondEmail + "', '" + jobTitle + "','D', '"+acceptMails+ "')";
            logger.info("insert query : " + sqlStatement);
            executeInsert(sqlStatement);

        } catch (PenielException e) {
            e.printStackTrace();
            logger.info("Error in insertIntoAppUser(): "+e.getMessage());
        }

        return "New user successfully registered.  An email is sent with login credentials. ";
    }


    public String updatePasswordByUsername(String username, String password) {
        try {
            StringBuffer sqlStatement = new StringBuffer();
            sqlStatement.append("update app_user set  ")
                    .append(" password = '" + password + "', status = 'A'  ")
                    .append(" where upper(username) = upper('" + username + "') ");

            logger.info("query : " + sqlStatement);

            executeUpdate(sqlStatement.toString());
        } catch (PenielException e) {
            e.printStackTrace();
            logger.info("Error in updatePasswordByUsername(): "+e.getMessage());
        }

        return "You have successfully updated your password.  Please take the time to go to the login screen and log into the application.";

    }

    public String updatePasswordStatusById(long userId, String status) {
        try {
            StringBuffer sqlStatement = new StringBuffer();
            sqlStatement.append("update app_user set  ")
                    .append(" password_status = '" + status + "' ")
                    .append(" where user_id = '" + userId + "' ");
            logger.info("query : " + sqlStatement);

            executeUpdate(sqlStatement.toString());
        } catch (PenielException e) {
            e.printStackTrace();
            logger.info("Error in updatePasswordStatusById(): "+e.getMessage());
        }
        return "";
    }
    
   

    public String updateStatusById(long userId, String status) {
        try {
            StringBuffer sqlStatement = new StringBuffer();

            sqlStatement.append("update app_user set  ")
                    .append(" status = '" + status + "' ")
                    .append(" where user_id = '" + userId + "' ");


            logger.info("query : " + sqlStatement);

            executeUpdate(sqlStatement.toString());

        } catch (PenielException e) {
            e.printStackTrace();
            logger.info("Error in updateStatusById(): "+e.getMessage());
        }

        return "You have successfully updated your password.  Please take the time to go to the login screen and log into the application.";
    }


    public String updateAppUserById(String userId, String firstName, String lastName, String address1,
    								String address2, String city, String state, String zip, String email,
    								String phoneNo, String cellPhone, 
    								String status, String acceptEmails, String sessionId, String otp, String AUTH_ID) {
        try {
            //update the user by the user Id
            StringBuffer sqlStatement = new StringBuffer();
            sqlStatement.append("update app_user set  ");


            sqlStatement.append("first_name = '" + firstName + "', ");
            sqlStatement.append("last_name = '" + lastName + "', ");
            sqlStatement.append("address1 = '" + address1 + "', ");
            sqlStatement.append("address2 = '" + address2 + "', ");
            sqlStatement.append("city = '" + city + "', ");
            sqlStatement.append("state = '" + state + "', ");
            sqlStatement.append("zip = '" + zip + "', ");
            sqlStatement.append("email = '" + email + "', ");
            sqlStatement.append("phone_no = '" + phoneNo + "', ");
            sqlStatement.append("cell_phone = '" + cellPhone + "', ");
            
            sqlStatement.append("status = '" + status + "', ");
            sqlStatement.append("accept_mails = '" + acceptEmails + "', ");
            sqlStatement.append("user_session_id = '" + sessionId + "', ");
            sqlStatement.append("AUTH_ID = " + AUTH_ID + ",");
            sqlStatement.append("OTP = '" + otp + "' ");

            sqlStatement.append("where user_id = " + userId);

            logger.info("query1 : " + sqlStatement);

            executeUpdate(sqlStatement.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error in updateAppUserById(): "+e.getMessage());
        }
        return "Profile is successfully updated.";
    }

//    public Vector<AppUser> getAppUserList(String sqlStatement) throws PenielException {
//        Vector<AppUser> appUserList = null;
//        DBManager db = DBManager.getInstance();
//        Connection conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);
//
//        System.out.println("sql: " + sqlStatement);
//        try {
//            dbobject rdo = new dbobject(conn);
//            Vector<dbobject.dbrow> vRows = rdo.selectrowset(conn, sqlStatement);
//
//            appUserList = processDbLinesToObjects(vRows);
//        } catch (PenielException e) {
//            throw (new PenielException("Exception in " + MODULE_NAME + " : getAppUserList() " + e.getExceptionMessage()));
//        } catch (Exception ex) {
//            throw (new PenielException(ex, "Exception in " + MODULE_NAME + " : getAppUserList() " + ex.getMessage()));
//        } finally {
//            db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
//        }
//
//        return appUserList;
//    }

//    public AppUser processDbLineToObject(dbobject.dbrow row) {
//        return sqlHelper.buildFromDbRow(row);
//
//        AppUser appUser = new AppUser();
//        Iterator itr;
//
//        HashMap<String, dbobject.dbcol> hashMap = row.getrow();
//        itr = hashMap.keySet().iterator();
//        while (itr.hasNext()) {
//            String str = (String) itr.next();
//            dbobject.dbcol dbcol = hashMap.get(str);
//
//            String dbcolName = dbcol.getName();
//
//            if (dbcolName.equalsIgnoreCase("USER_ID")) {
//                appUser.setUserId(Double.valueOf(dbcol.getValueString()).longValue());
//            }
//            if (dbcolName.equalsIgnoreCase("USER_TYPE_ID")) {
//                appUser.setUserTypeId(Double.valueOf(dbcol.getValueString()).longValue());
//            }
//            if (dbcolName.equalsIgnoreCase("USERNAME")) {
//                appUser.setUsername(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("COMPANY_ID")) {
//                Long compId = Double.valueOf(dbcol.getValueString()).longValue();
//
//                appUser.setCompanyId(compId);
//            }
//            if (dbcolName.equalsIgnoreCase("PASSWORD")) {
//                appUser.setPassword(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("FIRST_NAME")) {
//                appUser.setFirstName(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("LAST_NAME")) {
//                appUser.setLastName(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("ADDRESS1")) {
//                appUser.setAddress1(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("ADDRESS2")) {
//                appUser.setAddress2(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("CITY")) {
//                appUser.setCity(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("STATE")) {
//                appUser.setState(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("ZIP")) {
//                appUser.setZip(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("EMAIL")) {
//                appUser.setEmail(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("PHONE_NO")) {
//                appUser.setPhoneNo(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("STATUS")) {
//                appUser.setStatus(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("CELL_PHONE")) {
//                appUser.setCellPhone(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("SECOND_EMAIL")) {
//                appUser.setSecondEmail(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("JOB_TITLE")) {
//                appUser.setJobTitle(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("PASSWORD_STATUS")) {
//                appUser.setPasswordStatus(dbcol.getValueString());
//            }
//            if (dbcolName.equalsIgnoreCase("ROLE_NAME")) {
//                appUser.setRole(dbcol.getValueString());
//                appUser.role = dbcol.getValueString();
//            }
//
//        }
//
//        return appUser;
//    }

//    public Vector<AppUser> extractAppUserList(Vector<dbobject.dbrow> vrows) {
//        Vector<AppUser> appUserList = new Vector<AppUser>();
//
//        for (dbobject.dbrow dbrow : vrows) {
//            HashMap<String, dbobject.dbcol> hashMap = dbrow.getrow();
//
//            if (hashMap.size() > 0) {
//                appUserList.add(processDbLineToObject(dbrow));
//            }
//        }
//        return appUserList;
//    }
//
    public static String getLinkString(long nCnt, String sLetter) {
        String strLink = "&nbsp;";
        if (nCnt > 0)
            strLink += "<b><a href=\"javascript:getAlphabetSearchUsers('" + sLetter + "')\">" + sLetter + "</a></b>";
        else
            strLink += "<a>" + sLetter + "</a>";

        return strLink;

    }

    public static String findByAllLinks() {

        // to be done
        String strLink = "<a href=\"javascript:getAlphabetSearchUsers('')\">All</a> &nbsp;";

        try {
            String sqlStatement = "select * from v_app_user_links";
            logger.info("query findByAllLinks: " + sqlStatement);
            Vector hashMapList = DatabaseConnection.getResultSet(sqlStatement);
            char ch = ' ';
            if (hashMapList.size() > 0) {
                HashMap hashMap = new HashMap();
                hashMap = (HashMap) hashMapList.get(0);

                strLink += getLinkString(Long.parseLong((String) hashMap.get("A_COUNT")), "A");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("B_COUNT")), "B");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("C_COUNT")), "C");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("D_COUNT")), "D");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("E_COUNT")), "E");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("F_COUNT")), "F");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("G_COUNT")), "G");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("H_COUNT")), "H");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("I_COUNT")), "I");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("J_COUNT")), "J");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("K_COUNT")), "K");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("L_COUNT")), "L");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("M_COUNT")), "M");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("N_COUNT")), "N");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("O_COUNT")), "O");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("P_COUNT")), "P");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("Q_COUNT")), "Q");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("R_COUNT")), "R");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("S_COUNT")), "S");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("T_COUNT")), "T");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("U_COUNT")), "U");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("V_COUNT")), "V");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("W_COUNT")), "W");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("X_COUNT")), "X");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("Y_COUNT")), "Y");
                strLink += getLinkString(Long.parseLong((String) hashMap.get("Z_COUNT")), "Z");


            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error in findByAllLinks() :" + e.getMessage());
        }

        return strLink;
    }
    
    public long getMaxUserId() throws PenielException {
		// TODO Auto-generated method stub
    	  Connection conn=null;
          Statement st=null;
  	      ResultSet rs=null;
  	      long userId = 0;
  	    try{
  	    conn=DatabaseConnection.getDatabaseConnection();
		String sqlQuery = "Select MAX(USER_ID)as USER_ID  from APP_USER;"; 
		st=conn.createStatement();
		rs=st.executeQuery(sqlQuery);
    	if(rs.next()) {
    		userId=(long) rs.getDouble("USER_ID");
    	}
  	    }catch(Exception e){
  	    	logger.info("sqlQuery:"+e.getMessage());
 	    }finally{
 	    	try {
 	    		 if(rs!=null){
				rs.close();
 	    		 }
 	    		 if(st !=null){
				st.close();
 	    		 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	    	
 	    	DatabaseConnection.disconnectdb();
 	    }
  	  return userId+1;
  	  }

    public boolean mobileExist(String userid, String cellPhone) {
		
		 Connection conn=null;
       Statement st=null;
	      ResultSet rs=null;
	      boolean mobilesatus = false;
	    try{
	    conn=DatabaseConnection.getDatabaseConnection();
		String sqlQuery = "SELECT CELL_PHONE FROM app_user where CELL_PHONE='"+cellPhone+"' and USER_ID <>"+userid+";"; 
		st=conn.createStatement();
		rs=st.executeQuery(sqlQuery);
 	if(rs.next()) {
 		if(rs.getString("CELL_PHONE").equals(cellPhone)) {
 			mobilesatus=true;
 		}
 	}
	    }catch(Exception e){
	    	logger.info("sqlQuery:"+e.getMessage());
	    }finally{
	    	try {
	    		 if(rs!=null){
				rs.close();
	    		 }
	    		 if(st !=null){
				st.close();
	    		 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	DatabaseConnection.disconnectdb();
	    }
	  return mobilesatus;
	}


}


