package com.peniel.bus.vo.sqlhelpers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peniel.bus.vo.SessionLog;
import com.peniel.bus.vo.UserLog;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;

public class UserLogSQLHelper extends SQLHelper<UserLog> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLogSQLHelper.class);

	    @Override
	    public UserLog newObject() {
	        return new UserLog();
	    }

	    public UserLogSQLHelper() throws PenielException {
	        sqlTable = "user_log";

	        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
	        try {
	            sqlFieldHelpers.add(new SqlFieldHelper("USERID", new FieldHelper(UserLog.class, "userId", int.class)));	           
	            sqlFieldHelpers.add(new SqlFieldHelper("USER_SESSION_ID",  new FieldHelper(UserLog.class, "userSessionId", String.class)));
	            sqlFieldHelpers.add(new SqlFieldHelper("DATE_OF_CHG",  new FieldHelper(UserLog.class, "dateOfChg", String.class)));	           
	            sqlFieldHelpers.add(new SqlFieldHelper("FIELD_CHANGED",  new FieldHelper(UserLog.class, "fieldChanged", String.class)));
	            sqlFieldHelpers.add(new SqlFieldHelper("OLD_VALUE",  new FieldHelper(UserLog.class, "oldValue", String.class)));
	            sqlFieldHelpers.add(new SqlFieldHelper("NEW_VALUE",  new FieldHelper(UserLog.class, "newValue", String.class)));
	            sqlFieldHelpers.add(new SqlFieldHelper("FIRST_NAME",  new FieldHelper(UserLog.class, "firstName", String.class)));
	            sqlFieldHelpers.add(new SqlFieldHelper("LAST_NAME",  new FieldHelper(UserLog.class, "lastName", String.class)));
	            
	        } catch (NoSuchMethodException e) {
	            LOGGER.error(e.getMessage());
	            throw new PenielException("No Such method");
	        }
	    }
}
