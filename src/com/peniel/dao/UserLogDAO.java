package com.peniel.dao;


import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.UserLog;
import com.peniel.common.DAOHelper;
import com.peniel.common.ProcessRecordSetList;
import com.peniel.common.dbobject;


public class UserLogDAO extends DAOHelper<UserLog>{
	private static Logger logger = LogManager.getLogger(UserLogDAO.class);

    public static final int UPDATE_RECORDS = 1;
    public static final int NEW_RECORDS = 2;

    public UserLogDAO() {
        super("UserLogDAO", UserLog.getUserLogSQLHelper());
    }
  
	
	public Vector<UserLog> getUserLog(String userId)
	{

		Vector<UserLog> userLogList = new Vector<UserLog>();
		 
        GetUserLogList getUserLogList = new GetUserLogList();

		try
		{
			
			/*String sqlStatement=" "+
			"SELECT   a.user_session_id USER_SESSION_ID, b.first_name, b.last_name, a.userid USER_ID,a.date_of_chg DATE_OF_CHG, "  +
					 "a.field_changed FIELD_CHANGED, NVL (a.old_value, ' ') OLD_VALUE, NVL (a.new_value, ' ') NEW_VALUE "  +
			"FROM   user_log a, app_user b "  +
			"WHERE   a.userid =" +userId + " AND b.user_session_id = a.user_session_id " +
			"ORDER BY   date_of_chg DESC  ";*/	
			String sqlStatement=" "+
					" select  distinct ul.user_session_id USER_SESSION_ID, (select first_name from app_user where username like concat(substring_index( ul.user_session_id,'20',1),'%') limit 1) FIRST_NAME, (select last_name from app_user where username like concat(substring_index( ul.user_session_id,'20',1),'%') limit 1) LAST_NAME, " +
					" ul.userid USERID, ul.field_changed FIELD_CHANGED,  ul.old_value OLD_VALUE, "+
					"DATE_FORMAT(ul.date_of_chg ,'%m-%d%-%Y') as DATE_OF_CHG, "+
					" ul.new_value NEW_VALUE " +
					" from  app_user d, user_log ul  " +
					" where ul.userid ="+userId + " AND d.user_id = ul.userid and ul.USER_SESSION_ID not like 'BATCH_%' "+
//					" AND c.session_id IN (  "+
//					" SELECT    a.user_session_id USER_SESSION_ID  FROM   user_log a, app_user b  WHERE   a.userid = " +
//					 userId + " AND b.user_id = a.userid ) "+
					 " ORDER BY   date_of_chg DESC  ";			
			/*String sqlStatement=" "+
			"select  d.first_name FIRST_NAME, d.last_name LAST_NAME,ul.user_session_id USER_SESSION_ID," +
			" ul.userid USER_ID, ul.date_of_chg DATE_OF_CHG, ul.field_changed FIELD_CHANGED, " +
			" ul.old_value OLD_VALUE, ul.new_value NEW_VALUE "+
			"from session_log c, app_user d, user_log ul "+
			" where c.session_id IN ( " +
			" SELECT   a.user_session_id USER_SESSION_ID "+
			" FROM   user_log a, app_user b "+
			" WHERE   a.userid =" +userId + " AND b.user_id = a.userid ) " +
			" AND d.user_id = c.user_id AND ul.userid = " +userId;*/
			
			System.out.println("*** UserLogDAO getUserAuditSessionLog *** : "+sqlStatement);

            userLogList = processSelectMulti(sqlStatement, getUserLogList);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.info("Error :"+e.getMessage());
		}
		
		return userLogList;
	}

   

   
    public void copyUserLogRow(UserLog userLog, dbobject.dbrow row) {
    	userLog.setUserSessionId(valToString(row.getColumn("USER_SESSION_ID").getValue()));
    	 userLog.setFirstName(valToString(row.getColumn("FIRST_NAME").getValue()));
         userLog.setLastName(valToString(row.getColumn("LAST_NAME").getValue()));
    	userLog.setUserId(toInteger(row.getColumn("USERID").getValue()));    	
    	userLog.setDateOfChg(valToString(row.getColumn("DATE_OF_CHG").getValue()));

        String fieldName = (String)row.getColumn("FIELD_CHANGED").getValue();
        if(fieldName == null || "".equals(fieldName)) fieldName = " ";
        userLog.setFieldChanged(fieldName);

        String oldVal = (String)row.getColumn("OLD_VALUE").getValue();
        if(oldVal == null || "".equals(oldVal)) oldVal = " ";
        userLog.setOldValue(oldVal);

        String newVal = (String)row.getColumn("NEW_VALUE").getValue();
        if(newVal == null || "".equals(newVal)) newVal = " ";
        userLog.setNewValue(newVal);
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
    class GetUserLogList implements ProcessRecordSetList<UserLog> {
        public Vector<UserLog> processRecords(Vector hashMapList) {
            Vector<UserLog> userLogList = new Vector<UserLog>();

            try
            {
                int y;
                for (y = 0; y < hashMapList.size(); y++)
                {
                    dbobject.dbrow row = (dbobject.dbrow)hashMapList.get(y);
                    UserLog userLog = new UserLog();

                    copyUserLogRow(userLog, row);

                    userLogList.add(userLog);
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
                logger.info("Error :"+e.getMessage());
            }

            return userLogList;
        }
    }

    
}
