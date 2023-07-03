package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppUser;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * User: todds
 * Date: 11/4/11
 * Time: 5:01 PM
 */
public class AppUserSQLHelper extends SQLHelper<AppUser> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserSQLHelper.class);

    public AppUserSQLHelper() throws PenielException {
        sqlTable = "APP_USER";
        sequenceName = "APP_USER_SEQ";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("USER_ID", new FieldHelper(AppUser.class, "userId", long.class), true));
            sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID",  new FieldHelper(AppUser.class, "companyId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("USER_TYPE_ID",  new FieldHelper(AppUser.class, "userTypeId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("USERNAME",  new FieldHelper(AppUser.class, "username", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("PASSWORD",  new FieldHelper(AppUser.class, "password", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("FIRST_NAME",  new FieldHelper(AppUser.class, "firstName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("LAST_NAME",  new FieldHelper(AppUser.class, "lastName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ADDRESS1",  new FieldHelper(AppUser.class, "address1", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ADDRESS2",  new FieldHelper(AppUser.class, "address2", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("CITY",  new FieldHelper(AppUser.class, "city", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("STATE",  new FieldHelper(AppUser.class, "state", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ZIP",  new FieldHelper(AppUser.class, "zip", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("EMAIL",  new FieldHelper(AppUser.class, "email", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("PHONE_NO",  new FieldHelper(AppUser.class, "phoneNo", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("STATUS",  new FieldHelper(AppUser.class, "status", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("CELL_PHONE",  new FieldHelper(AppUser.class, "cellPhone", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("SECOND_EMAIL",  new FieldHelper(AppUser.class, "secondEmail", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("JOB_TITLE",  new FieldHelper(AppUser.class, "jobTitle", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("PASSWORD_STATUS",  new FieldHelper(AppUser.class, "PasswordStatus", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ACCEPT_MAILS",  new FieldHelper(AppUser.class, "AcceptMails", String.class)));
            //sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID",  new FieldHelper(AppUser.class, "PasswordStatus", String.class)));
            //sqlFieldHelpers.add(new SqlFieldHelper("PASSWORD_STATUS",  new FieldHelper(AppUser.class, "PasswordStatus", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ROLE_NAME",  new FieldHelper(AppUser.class, "role", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ROLE_ID",  new FieldHelper(AppUser.class, "roleId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("USER_ROLE_ID",  new FieldHelper(AppUser.class, "userRoleId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("AUTH_ID",  new FieldHelper(AppUser.class, "authId", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("MFA_STATUS",  new FieldHelper(AppUser.class, "mfaStatus", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("OTP",  new FieldHelper(AppUser.class, "otp", String.class)));
//            appUser.setUsername((String)hashMap.get("USERNAME"));
//            appUser.setPassword((String)hashMap.get("PASSWORD"));
//            appUser.setRole((String)hashMap.get("ROLE_NAME"));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }
    }

    public AppUser newObject() {
        return new AppUser();
    }

}
