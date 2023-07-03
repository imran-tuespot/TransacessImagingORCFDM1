package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.SearchData;
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
public class SearchDataSQLHelper extends SQLHelper<SearchData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchDataSQLHelper.class);

    @Override
    public SearchData newObject() {
        return new SearchData();
    }

    public SearchDataSQLHelper() throws PenielException {
        sqlTable = "search_data";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("document_id", new FieldHelper(SearchData.class, "documentId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("company_id", new FieldHelper(SearchData.class, "companyId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("index_type_id", new FieldHelper(SearchData.class, "indexTypeId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("index_data",  new FieldHelper(SearchData.class, "indexData", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ROW_ID",  new FieldHelper(SearchData.class, "rowid", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}
