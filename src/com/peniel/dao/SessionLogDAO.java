package com.peniel.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

import com.peniel.bus.vo.Company;
import com.peniel.bus.vo.SessionLogExtended;
import com.peniel.common.DAOHelper;
import com.peniel.common.ProcessRecordSetList;
import com.peniel.common.dbobject;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.SessionLog;

public class SessionLogDAO extends DAOHelper<SessionLog>
{
	private static Logger logger = LogManager.getLogger(SessionLogDAO.class);

    public static final int UPDATE_RECORDS = 1;
    public static final int NEW_RECORDS = 2;

    public SessionLogDAO() {
        super("SessionLogDAO", SessionLog.getSessionLogSQLHelper());
    }

    public void insertIntoSessionLog(String sessionId, long userId, long compid, String action, Long docId, Long version, String description )
	{
        Vector<SessionLog> sessionLogList = new Vector<SessionLog>();
        SessionLog sessionLog = new SessionLog();

		try
		{
			String sqlstatement = "insert into session_log (session_id, user_id, company_id, dtm, action, doc_id, version, description) values ('" 
				+ sessionId + "', '" + userId+ "', '" + compid + "', sysdate(), '" + action + "', '" + docId + "', '" + version + "', '" + description + "')";
			
			logger.info("query : "+sqlstatement);

            long retval = executeInsert(sqlstatement);
//			DatabaseConnection dbConnection = new DatabaseConnection();
//			dbConnection.executeUpdate(sqlstatement);
//            if(sessionLogList.size()>0)
//                sessionLog = sessionLogList.get(0);
		}
        catch (Exception e)
        {
            e.printStackTrace();
            logger.info("Error :"+e.getMessage());
        }
	}
    public void insertIntoSessionLog(String sessionId, long userId, long compid, String action, Long docId,String fieldName, String oldValue, String newValue, String description )
	{
        Vector<SessionLog> sessionLogList = new Vector<SessionLog>();
        SessionLog sessionLog = new SessionLog();

		try
		{
			String sqlstatement = "insert into session_log (session_id, user_id, company_id, dtm, action,doc_id, field_name,old_value,new_value, description) values ('" 
				+ sessionId + "', '" + userId+ "', '" + compid + "', sysdate(), '" + action+ "', '" + docId  + "', '" + fieldName + "', '" + oldValue + "', '"+ newValue +"','" + description + "')";
			
			logger.info("query : "+sqlstatement);

            long retval = executeInsert(sqlstatement);

		}
        catch (Exception e)
        {
            e.printStackTrace();
            logger.info("Error :"+e.getMessage());
        }
	}

	public SessionLog getSessionLog(String docId, String compId)
	{
		Vector<SessionLog> sessionLogList = new Vector<SessionLog>();
		SessionLog sessionLog = new SessionLog();
		GetSessionLogList getSessionLogList = new GetSessionLogList();

		try 
		{
			/*String sqlStatement="SELECT   * " +
			"FROM   (  SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, " +
	           "a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, nvl(c.old_value,' ') OLD_VALUE, nvl(a.new_value,' ') NEW_VALUE  " +
	           "FROM   session_log a, app_user b, session_log c " +
	           "WHERE  a.doc_id  = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND a.action NOT LIKE 'UPDATE%' and a.action like 'NEW%' and c.action like 'DEL%' " +
	           	     "and c.dtm-a.dtm <0.00001 and c.dtm-a.dtm>-0.00001 and c.session_id=a.session_id and c.field_name=a.field_name and nvl(c.old_value,'X')<>nvl(a.new_value,'Y') " +
	          "UNION ALL " +
	         	"SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, " +
	         		"a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, ' ' OLD_VALUE, nvl(a.new_value,' ') NEW_VALUE  " +
	         	"FROM   session_log a, app_user b " +
	         	"WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND a.action NOT LIKE 'UPDATE%' and a.action like 'NEW%' and " + 
	         	   "not exists (select 'x' from session_log c where c.action like 'DEL%' " +
	         	   "and c.dtm-a.dtm <0.00001 and c.dtm-a.dtm>-0.00001  " +
	         	   "and c.session_id=a.session_id  " +
	         	   "and c.field_name=a.field_name) " +
	          "UNION ALL " +
	          	  "SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, " +
	          	           "a.version VERSION, a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE " +
	          	  "FROM   session_log a, app_user b " +
	          	  "WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND action LIKE 'UPDATE%' " + 
	          "UNION ALL  " +
	          	  "SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, " +
	          	  		  "a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE " +
	          	  "FROM   session_log a, app_user b  " +
	          	  "WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND action LIKE 'View%' " + 
	          	      "ORDER BY   dtm DESC) " +
	          	    "WHERE   ROWNUM = 1 ";	      
				*/
			
			String sqlStatement="SELECT   * FROM "+
			"(SELECT   a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, "  +
					 " a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (c.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE "  +
			"FROM   session_log a, app_user b, session_log c "  +
			"WHERE       a.doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND a.action NOT LIKE 'UPDATE%' AND a.action LIKE 'NEW%' "  +
					"AND c.action LIKE 'DEL%' AND c.dtm - a.dtm < 0.00001 AND c.dtm - a.dtm > -0.00001 AND c.session_id = a.session_id AND c.field_name = a.field_name "  +
					"AND NVL (c.old_value, 'X') <> NVL (a.new_value, 'Y') "  + 
			"UNION ALL "  +
			"SELECT   a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, "  +
					"a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, ' ' OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE  "  +
			"FROM   session_log a, app_user b  "  +
			"WHERE       doc_id = "+docId+" "  +
					"AND b.user_id = a.user_id AND b.company_id = a.company_id AND a.action NOT LIKE 'UPDATE%' AND a.action LIKE 'NEW%' AND NOT EXISTS "  +
	               "(SELECT   'x' FROM   session_log c WHERE       c.action LIKE 'DEL%' AND c.dtm - a.dtm < 0.00001 AND c.dtm - a.dtm > -0.00001 "  +
	            		   "AND c.session_id = a.session_id AND c.field_name = a.field_name) "  +
			"UNION ALL  "  +
			"SELECT   a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, "  +
					"a.version VERSION, a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE "  +
			"FROM   session_log a, app_user b "  +
			"WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND action LIKE 'UPDATE%' AND upper(a.field_name) not like '%STATUS%' "  +
			"UNION ALL ( "  +
			"SELECT   a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, max(a.version) VERSION, "  +
					" 'UPDATE DOC STATUS' DESCRIPTION, max(a.action) ACTION, a. field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE "  +
			"FROM   session_log a, app_user b  "  +
			"WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND action LIKE 'UPDATE%' AND upper(a.field_name)  like '%STATUS%' "  +
			"group by a.session_id, b.first_name, b.last_name, a.user_id , a.company_id , a.dtm , a.doc_id , a.field_name , a.old_value, a.new_value ) "  +
			"ORDER BY   dtm DESC  "  +
			"LIMIT 1 ) as tq ";		

			logger.info("query : "+sqlStatement);

			sessionLogList = processSelectMulti(sqlStatement, getSessionLogList);
                    //getSessionLogList(DatabaseConnection.getResultSet(sqlStatement));
			if(sessionLogList.size()>0)
                sessionLog = sessionLogList.get(0);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return sessionLog;
	}
	
    public String valToString(Object o) {
        if (o instanceof Integer) {
            return o.toString();
        }
        if (o instanceof Double) {
            return o.toString();
        }
        if (o instanceof String) {
            return (String)o;
        }
        if (o instanceof java.sql.Date) {
            return o.toString();
        }
        return "";
    }

    public int toInteger(Object o) {
        if (o instanceof Integer) {
            return (Integer)o;
        }
        if (o instanceof Double) {
            return ((Double)o).intValue();
        }
        if (o instanceof String) {
            try {
                if (StringUtils.contains((String)o, '.'))  {
                    return (int)Double.parseDouble((String)o);
                } else {
                    return Integer.parseInt((String)o);
                }
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return 0;
    }

    public double toDouble(Object o) {
        if (o instanceof Integer) {
            return ((Integer)o).doubleValue();
        }
        if (o instanceof Double) {
            return (Double)o;
        }
        if (o instanceof String) {
            return Double.parseDouble((String) o);
        }
        return 0;
    }

	public Vector<SessionLog> getAllSessionLog(String docId, String compId)
	{
//		ResultSet resultSet = null;
		Vector<SessionLog> sessionLogList = new Vector<SessionLog>();
//		SessionLog sessionLog = new SessionLog();
		 
        GetSessionLogList getSessionLogList = new GetSessionLogList();

		try
		{
			/*		
			String sqlStatement="  SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, " +
	           "a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, nvl(c.old_value,' ') OLD_VALUE, nvl(a.new_value,' ') NEW_VALUE  " +
	           "FROM   session_log a, app_user b, session_log c " +
	           "WHERE  a.doc_id  = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND a.action NOT LIKE 'UPDATE%' and a.action like 'NEW%' and c.action like 'DEL%' " +
	           	     "and c.dtm-a.dtm <0.00001 and c.dtm-a.dtm>-0.00001 and c.session_id=a.session_id and c.field_name=a.field_name and nvl(c.old_value,'X')<>nvl(a.new_value,'Y') " +
	          "UNION ALL " +
	         	"SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, " +
	         		"a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, ' ' OLD_VALUE, nvl(a.new_value,' ') NEW_VALUE  " +
	         	"FROM   session_log a, app_user b " +
	         	"WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND a.action NOT LIKE 'UPDATE%' and a.action like 'NEW%' and " + 
	         	   "not exists (select 'x' from session_log c where c.action like 'DEL%' " +
	         	   "and c.dtm-a.dtm <0.00001 and c.dtm-a.dtm>-0.00001  " +
	         	   "and c.session_id=a.session_id  " +
	         	   "and c.field_name=a.field_name) " +
	          "UNION ALL " +
	          	  "SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, " +
	          	           "a.version VERSION, a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE " +
	          	  "FROM   session_log a, app_user b " +
	          	  "WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND action LIKE 'UPDATE%' " + 
	          "UNION ALL  " +
	          	  "SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, " +
	          	  		  "a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE " +
	          	  "FROM   session_log a, app_user b  " +
	          	  "WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND action LIKE 'View%' " + 
	          	      "ORDER BY   dtm DESC ";
		    */
			
			String sqlStatement="SELECT DISTINCT "+
					  " a.session_id SESSION_ID, "+
					  " b.first_name FIRST_NAME, "+
					  " b.last_name LAST_NAME, "+
					  " a.user_id USER_ID, "+
					  " a.company_id COMPANY_ID, "+
					  " DATE_FORMAT(a.dtm, '%m-%d-%Y') DTM, "+
					  " a.dtm datedtm, "+
					  " a.doc_id DOC_ID,                    "+
					  " a.version VERSION,                  "+
					  " a.description DESCRIPTION,          "+
					  " a.action ACTION,                    "+
					  " a.field_name FIELD_NAME,            "+
					  " NVL(a.old_value, ' ') OLD_VALUE,    "+
					  " NVL(a.new_value, ' ') NEW_VALUE,    "+
					  " a.version version1                  "+
					" FROM                                  "+
					 "   session_log a,                     "+
					 "   app_user b                         "+
					" WHERE                                 "+
					  "  doc_id =                     "+ docId+
					   "    AND b.user_id = a.user_id       "+
					   "    AND b.company_id = a.company_id "+
						"	order by datedtm desc,version1 desc ";
					
					/*" "+
			"SELECT distinct  a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, date_format(a.dtm ,'%m-%d-%Y') DTM, a.doc_id DOC_ID, a.version VERSION, "  +
					 " a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (c.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE "  +
			",a.version version1  FROM   session_log a, app_user b, session_log c "  +
			"WHERE       a.doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND a.action NOT LIKE 'UPDATE%' AND a.action LIKE 'NEW%' "  +
					"AND c.action LIKE 'DEL%' AND c.dtm - a.dtm < 0.00001 AND c.dtm - a.dtm > -0.00001 AND c.session_id = a.session_id AND c.field_name = a.field_name "  +
					"AND NVL (c.old_value, 'X') <> NVL (a.new_value, 'Y') "  + 
			"UNION ALL "  +
			"SELECT distinct  a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, date_format(a.dtm ,'%m-%d-%Y') DTM, a.doc_id DOC_ID, a.version VERSION, "  +
					"a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, ' ' OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE  "  +
			",a.version version1  FROM   session_log a, app_user b  "  +
			"WHERE       doc_id = "+docId+" "  +
					"AND b.user_id = a.user_id AND b.company_id = a.company_id AND a.action NOT LIKE 'UPDATE%' AND a.action LIKE 'NEW%' AND NOT EXISTS "  +
	               "(SELECT   'x' FROM   session_log c WHERE       c.action LIKE 'DEL%' AND c.dtm - a.dtm < 0.00001 AND c.dtm - a.dtm > -0.00001 "  +
	            		   "AND c.session_id = a.session_id AND c.field_name = a.field_name) "  +
			"UNION ALL  "  +
			"SELECT distinct  a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, date_format(a.dtm ,'%m-%d-%Y') DTM, a.doc_id DOC_ID, "  +
					"a.version VERSION, a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE "  +
			",a.version version1  FROM   session_log a, app_user b "  +
			"WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND action LIKE 'UPDATE%' AND upper(a.field_name) not like '%STATUS%' "  +
			"UNION ALL "  +
			"SELECT distinct  a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, date_format(a.dtm ,'%m-%d-%Y') DTM, a.doc_id DOC_ID, max(a.version) VERSION, "  +
					" 'UPDATE DOC STATUS' DESCRIPTION, max(a.action) ACTION, a.field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE "  +
			",a.version version1  FROM   session_log a, app_user b  "  +
			"WHERE       doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id AND action LIKE 'UPDATE%' AND upper(a.field_name)  like '%STATUS%' "  +
			"group by a.session_id, b.first_name, b.last_name, a.user_id , a.company_id , date_format(a.dtm ,'%m-%d-%Y') , a.doc_id , a.field_name , a.old_value, a.new_value  "  +
			
			"  UNION ALL" + 
			"  (SELECT distinct  a.session_id SESSION_ID, b.first_name FIRST_NAME, b.last_name LAST_NAME, a.user_id USER_ID, a.company_id COMPANY_ID, date_format(a.dtm ,'%m-%d-%Y') DTM, a.doc_id DOC_ID, "+ 
			"max(a.version) VERSION,  a.description DESCRIPTION, max(a.action) ACTION, a.field_name FIELD_NAME, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE ,a.version version1  FROM "+
			"  session_log a, app_user b  WHERE doc_id = "+docId+" AND b.user_id = a.user_id AND b.company_id = a.company_id "+// AND action in ('View Document','Download Document') "+
			"AND a.description  in ('View Document','Download Document','Document Shared') group by a.session_id, b.first_name, b.last_name, a.user_id , a.company_id , a.dtm , a.doc_id , a.field_name , "+
			"a.old_value, a.new_value) "+
			"ORDER BY   dtm,version1 DESC  ";	*/
			

			// 5009044
			
			logger.info("query : "+sqlStatement);

            sessionLogList = processSelectMulti(sqlStatement, getSessionLogList);
//			sessionLogList = getAllSessionLogList(DatabaseConnection.getResultSet(sqlStatement));
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return sessionLogList;
	}
	public Vector<SessionLog> getUserAuditSessionLog(String userId)
	{

		Vector<SessionLog> sessionLogList = new Vector<SessionLog>();
		 
        GetSessionLogList getSessionLogList = new GetSessionLogList();

		try
		{
			
			String sqlStatement=" "+
			"SELECT   a.session_id SESSION_ID, b.first_name, b.last_name, a.user_id USER_ID, a.company_id COMPANY_ID, a.dtm DTM, a.doc_id DOC_ID, a.version VERSION, "  +
					 " a.description DESCRIPTION, a.action ACTION, a.field_name FIELD_NAME, NVL (c.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE "  +
			"FROM   session_log a, app_user b, session_log c "  +
			"WHERE   a.user_id =" +userId + " AND b.user_id = a.user_id AND b.company_id = a.company_id AND( a.action  LIKE 'Role%' OR  a.action  LIKE 'Email%'" +
					"OR  a.action  LIKE 'First%' OR  a.action  LIKE 'Last%') AND c.dtm - a.dtm < 0.00001 AND c.dtm - a.dtm > -0.00001 AND c.session_id = a.session_id AND c.field_name = a.field_name "  +
					"AND NVL (c.old_value, 'X') <> NVL (a.new_value, 'Y')" +
			"ORDER BY   dtm DESC  ";	

			
			System.out.println("*** SessionLogDAO getUserAuditSessionLog *** : "+sqlStatement);

            sessionLogList = processSelectMulti(sqlStatement, getSessionLogList);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return sessionLogList;
	}

    /**
     * returns list of sessionLogExtended for a range of dates.
     * @param type
     * @param startDate
     * @param endDate
     * @param compId
     * @return
     */
	public Vector<SessionLogExtended> getTimedSessionLog(int type, Date startDate, Date endDate, String compId)
	{
		Vector<SessionLog> sessionLogList = new Vector<SessionLog>();
        GetSessionLogExtendedList getSessionLogList = new GetSessionLogExtendedList();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String recordType;
        long primaryIndex = 0;

        CompanyDAO companyDAO = new CompanyDAO();
        
        Vector<Company> companyList = companyDAO.findById(compId);
        Company company = null;
        if (companyList != null) {
            company = companyList.get(0);
            primaryIndex = company.getDefaultIndex();
        }
        
        if (startDate == null) {
            gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.add(GregorianCalendar.DAY_OF_MONTH, -7);
            startDate = gregorianCalendar.getTime();
        }
        if (endDate == null) {
            gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
            endDate = gregorianCalendar.getTime();
        }
        switch (type) {
            case NEW_RECORDS:
                recordType = "NEW%";
                break;
            case UPDATE_RECORDS:
            default:
                recordType = "UPDATE%";
        }

		try
		{
			String sqlStatement =  "SELECT  sl.SESSION_ID as SESSION_ID, sl.USER_ID as USER_ID, au.FIRST_NAME as FIRST_NAME, " +
                    "au.LAST_NAME as LAST_NAME, sl.COMPANY_ID as COMPANY_ID, sl.DTM as DTM, sl.DOC_ID as DOC_ID, " +
                    "sl.ACTION as ACTION, sl.VERSION as VERSION, sl.DESCRIPTION as DESCRIPTION, " +
                    "sl.FIELD_NAME as FIELD_NAME, sl.OLD_VALUE as OLD_VALUE, sl.NEW_VALUE as NEW_VALUE, " +
                    "dt.Document_type as DOCUMENT_TYPE , sd.index_data as INDEX_DATA " +
                    "from Session_log sl  " +
                    "INNER JOIN  app_user au on sl.user_id=au.user_id " +
                    "INNER JOIN DOCUMENT_DATA dd ON (sl.doc_id=dd.DOCUMENT_ID  and sl.version=dd.version)" +
                    "INNER JOIN SEARCH_DATA sd ON sd.Document_id=dd.DOCUMENT_ID " +
                    "INNER JOIN DOCUMENT_TYPE dt ON dt.document_type_id=dd.document_type_id " +
                    "WHERE sl.action like '" + recordType + "' AND sl.doc_id > 0 AND sl.company_id = " + compId +
                    " AND sl.DTM >= '" + df.format(startDate) + "'  AND sl.DTM <= '" + df.format(endDate) + "'  " +
                    " AND sd.company_id=" + compId + " AND sd.index_type_id=" + primaryIndex +
                    "  ORDER BY sl.doc_id, sl.dtm";

			logger.info("query : "+sqlStatement);
            Vector<SessionLogExtended> sessionLogExtendedList = new Vector<SessionLogExtended>();

            sessionLogList = processSelectMulti(sqlStatement, getSessionLogList);
            for (SessionLog sessionLog : sessionLogList) {
                if (sessionLog instanceof SessionLogExtended) {
                    sessionLogExtendedList.add((SessionLogExtended)sessionLog);
                }
            }

            return sessionLogExtendedList;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
            return null;
		}
	}

    class GetSessionLogList implements ProcessRecordSetList<SessionLog> {
        public Vector<SessionLog> processRecords(Vector hashMapList) {
            Vector<SessionLog> sessionLogList = new Vector<SessionLog>();

            try
            {
                int y;
                for (y = 0; y < hashMapList.size(); y++)
                {
                    //dbobject object = (dbobject)hashMapList.get(y);
                    dbobject.dbrow row = (dbobject.dbrow)hashMapList.get(y);
                    SessionLog sessionLog = new SessionLog();

                    copySessionLogRow(sessionLog, row);

                    sessionLogList.add(sessionLog);
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                logger.info("Error :"+e.getMessage());
            }

            return sessionLogList;
        }
    }

    class GetSessionLogExtendedList implements ProcessRecordSetList<SessionLog> {
        public Vector<SessionLog> processRecords(Vector hashMapList) {
            Vector<SessionLog> sessionLogList = new Vector<SessionLog>();

            try
            {
                int y;
                for (y = 0; y < hashMapList.size(); y++)
                {
                    //dbobject object = (dbobject)hashMapList.get(y);
                    dbobject.dbrow row = (dbobject.dbrow)hashMapList.get(y);
                    SessionLogExtended sessionLog = new SessionLogExtended();

                    copySessionLogRow(sessionLog, row);
                    sessionLog.setDocumentType(valToString(row.getColumn("DOCUMENT_TYPE").getValue()));
                    sessionLog.setDocumentNumber(valToString(row.getColumn("INDEX_DATA").getValue()));

                    sessionLogList.add(sessionLog);
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                logger.info("Error :"+e.getMessage());
            }

            return sessionLogList;
        }
    }

    public void copySessionLogRow(SessionLog sessionLog, dbobject.dbrow row) {
        sessionLog.setSessionId(valToString(row.getColumn("SESSION_ID").getValue()));
        sessionLog.setUserId(toInteger(row.getColumn("USER_ID").getValue()));
        sessionLog.setFirstName(valToString(row.getColumn("FIRST_NAME").getValue()));
        sessionLog.setLastName(valToString(row.getColumn("LAST_NAME").getValue()));
        sessionLog.setCompanyId(toInteger(row.getColumn("COMPANY_ID").getValue()));
        sessionLog.setDtm(valToString(row.getColumn("DTM").getValue()));
        sessionLog.setDocId(toInteger(row.getColumn("DOC_ID").getValue()));
        sessionLog.setAction(valToString(row.getColumn("ACTION").getValue()));
        String version = valToString(row.getColumn("VERSION").getValue());
        sessionLog.setDescription(valToString(row.getColumn("DESCRIPTION").getValue()));

        if(version == null || "".equals(version)) version = "0";
        sessionLog.setVersion(toInteger(version));

        String fieldName = (String)row.getColumn("FIELD_NAME").getValue();
        if(fieldName == null || "".equals(fieldName)) fieldName = " ";
        sessionLog.setFieldName(fieldName);

        String oldVal = (String)row.getColumn("OLD_VALUE").getValue();
        if(oldVal == null || "".equals(oldVal)) oldVal = " ";
        sessionLog.setOldValue(oldVal);

        String newVal = (String)row.getColumn("NEW_VALUE").getValue();
        if(newVal == null || "".equals(newVal)) newVal = " ";
        sessionLog.setNewValue(newVal);
    }


}



