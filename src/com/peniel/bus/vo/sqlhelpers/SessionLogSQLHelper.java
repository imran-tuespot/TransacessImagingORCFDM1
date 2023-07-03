package com.peniel.bus.vo.sqlhelpers;


import com.peniel.bus.vo.SessionLog;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 11:36 PM
 */
public class SessionLogSQLHelper extends SQLHelper<SessionLog> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionLogSQLHelper.class);

    @Override
    public SessionLog newObject() {
        return new SessionLog();
    }

    public SessionLogSQLHelper() throws PenielException {
        sqlTable = "session_log";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("USER_ID", new FieldHelper(SessionLog.class, "userId", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID", new FieldHelper(SessionLog.class, "companyId", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DOC_ID", new FieldHelper(SessionLog.class, "docId", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("VERSION", new FieldHelper(SessionLog.class, "version", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("SESSION_ID",  new FieldHelper(SessionLog.class, "sessionId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DTM",  new FieldHelper(SessionLog.class, "dtm", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ACTION",  new FieldHelper(SessionLog.class, "action", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DESCRIPTION",  new FieldHelper(SessionLog.class, "description", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("FIELD_NAME",  new FieldHelper(SessionLog.class, "fieldName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("OLD_VALUE",  new FieldHelper(SessionLog.class, "oldValue", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("NEW_VALUE",  new FieldHelper(SessionLog.class, "newValue", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("FIRST_NAME",  new FieldHelper(SessionLog.class, "firstName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("LAST_NAME",  new FieldHelper(SessionLog.class, "lastName", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }
    }
}
