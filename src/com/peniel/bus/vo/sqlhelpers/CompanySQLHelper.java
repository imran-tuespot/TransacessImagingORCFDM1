package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.Company;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 11:27 PM
 */
public class CompanySQLHelper extends SQLHelper<Company> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanySQLHelper.class);

    @Override
    public Company newObject() {
        return new Company();
    }

    public CompanySQLHelper() throws PenielException {
        sqlTable = "company";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID", new FieldHelper(Company.class, "companyId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("company_name",  new FieldHelper(Company.class, "companyName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("address1",  new FieldHelper(Company.class, "address1", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("address2",  new FieldHelper(Company.class, "address2", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("city",  new FieldHelper(Company.class, "city", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("state",  new FieldHelper(Company.class, "state", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("zip",  new FieldHelper(Company.class, "zip", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("default_Index",  new FieldHelper(Company.class, "defaultIndex", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("company_fullname",  new FieldHelper(Company.class, "companyFullname", String.class)));

        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}
