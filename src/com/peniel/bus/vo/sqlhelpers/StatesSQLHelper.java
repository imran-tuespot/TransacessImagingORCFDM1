package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.SessionLog;
import com.peniel.bus.vo.States;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 11:37 PM
 */
public class StatesSQLHelper extends SQLHelper<States> {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatesSQLHelper.class);

    @Override
    public States newObject() {
        return new States();
    }

    public StatesSQLHelper() throws PenielException {
        sqlTable = "tblstates";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("COUNTRY",  new FieldHelper(States.class, "country", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("STATE",  new FieldHelper(States.class, "state", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("NAME",  new FieldHelper(States.class, "name", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}
