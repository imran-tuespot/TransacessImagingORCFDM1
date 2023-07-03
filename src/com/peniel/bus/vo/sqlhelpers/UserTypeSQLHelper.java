package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.UserType;
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
public class UserTypeSQLHelper extends SQLHelper<UserType> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserTypeSQLHelper.class);

    @Override
    public UserType newObject() {
        return new UserType();
    }


    public UserTypeSQLHelper() throws PenielException {
        sqlTable = "user_type";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("user_type_id", new FieldHelper(UserType.class, "userTypeId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("user_type",  new FieldHelper(UserType.class, "userType", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}

