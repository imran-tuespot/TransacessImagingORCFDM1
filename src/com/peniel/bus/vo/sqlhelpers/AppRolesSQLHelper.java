package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 3:56 PM
 */
public class AppRolesSQLHelper extends SQLHelper<AppRoles> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppRolesSQLHelper.class);

    @Override
    public AppRoles newObject() {
        return new AppRoles();
    }

    public AppRolesSQLHelper() throws PenielException {
        sqlTable = "APP_ROLES";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("ROLE_ID", new FieldHelper(AppRoles.class, "roleId", long.class), true));
            sqlFieldHelpers.add(new SqlFieldHelper("ROLE_NAME",  new FieldHelper(AppRoles.class, "roleName", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}
