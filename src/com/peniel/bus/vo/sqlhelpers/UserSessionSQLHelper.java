package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.UserSession;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 11:38 PM
 */
public class UserSessionSQLHelper extends SQLHelper<UserSession> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSessionSQLHelper.class);

    @Override
    public UserSession newObject() {
        return new UserSession();
    }

    public UserSessionSQLHelper() throws PenielException {
        sqlTable = "user_session";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("USER_ID", new FieldHelper(UserSession.class, "userId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("COMPID", new FieldHelper(UserSession.class, "companyId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("SESSION_ID",  new FieldHelper(UserSession.class, "sessionId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("LAST_UPDATED",  new FieldHelper(UserSession.class, "lastUpdated", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("CLOSED_ON",  new FieldHelper(UserSession.class, "closedOn", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("USERNAME",  new FieldHelper(UserSession.class, "username", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("IPADDRESS",  new FieldHelper(UserSession.class, "ipAddress", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}
