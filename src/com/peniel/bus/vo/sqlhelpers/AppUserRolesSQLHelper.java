package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.AppUserRoles;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 11:22 PM
 */
public class AppUserRolesSQLHelper extends SQLHelper<AppUserRoles> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserRolesSQLHelper.class);

    @Override
    public AppUserRoles newObject() {
        return new AppUserRoles();
    }

    public AppUserRolesSQLHelper() throws PenielException {
        sqlTable = "APP_USER_ROLES";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("ROLE_ID", new FieldHelper(AppUserRoles.class, "roleId", long.class), true));
            sqlFieldHelpers.add(new SqlFieldHelper("USER_ID", new FieldHelper(AppUserRoles.class, "userId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("EFFECTIVE_DATE",  new FieldHelper(AppUserRoles.class, "effectiveDate", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }

}
