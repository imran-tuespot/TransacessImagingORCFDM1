package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.IndexType;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 11:35 PM
 */
public class IndexTypeSQLHelper extends SQLHelper<IndexType> {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexTypeSQLHelper.class);

    @Override
    public IndexType newObject() {
        return new IndexType();
    }

    public IndexTypeSQLHelper() throws PenielException {
        sqlTable = "index_type";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("INDEX_TYPE_ID", new FieldHelper(IndexType.class, "indexTypeId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("INDEX_TYPE", new FieldHelper(IndexType.class, "indexType", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID",  new FieldHelper(IndexType.class, "companyId", long.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }
    }
}
