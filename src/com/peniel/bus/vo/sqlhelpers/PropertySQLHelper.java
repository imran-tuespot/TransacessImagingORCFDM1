package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.Property;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class PropertySQLHelper extends SQLHelper<Property> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertySQLHelper.class);

    @Override
    public Property newObject() {
        return new Property();
    }

    public PropertySQLHelper() throws PenielException {
        sqlTable = "property";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID", new FieldHelper(Property.class, "companyId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("PROPERTY_ID",  new FieldHelper(Property.class, "propertyId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ID",  new FieldHelper(Property.class, "id", long.class)));

            sqlFieldHelpers.add(new SqlFieldHelper("FHA_NUM",  new FieldHelper(Property.class, "fhaNum", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ACCOUNT_EXEC",  new FieldHelper(Property.class, "accountExec", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("WORKLOAD_MGR",  new FieldHelper(Property.class, "workloadMgr", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("LENDER_NUM",  new FieldHelper(Property.class, "lenderNum", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("LENDER_NAME",  new FieldHelper(Property.class, "lenderName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("SERVICER_NAME",  new FieldHelper(Property.class, "servicerName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("SERVICER_NUM",  new FieldHelper(Property.class, "servicerNum", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("PROPERTY_NAME",  new FieldHelper(Property.class, "propertyName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("CITY",  new FieldHelper(Property.class, "city", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("STATE",  new FieldHelper(Property.class, "state", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ZIP",  new FieldHelper(Property.class, "zip", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("CONGRESSIONAL_AREA",  new FieldHelper(Property.class, "congressionalArea", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("TROUBLE_CODE",  new FieldHelper(Property.class, "troubleCode", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("REAC_SCRORE",  new FieldHelper(Property.class, "reacScore", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ACTIVE_DEAC_ASSIGNEMENT",  new FieldHelper(Property.class, "activeDeacAssignment", String.class)));


           
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}
