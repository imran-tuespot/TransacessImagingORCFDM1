package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.SearchDataObj;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 11:36 PM
 */
public class SearchDataObjSQLHelper extends SQLHelper<SearchDataObj> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchDataObjSQLHelper.class);

    @Override
    public SearchDataObj newObject() {
        return new SearchDataObj();
    }
    private int srNo;
    private String fileName;
    private String folderName;
    private String indexTypeId;
    private String indexType;
    private String indexValue;
    private String documentType;
    private int version;
    private int docId;
    private int docTypeId;

    //ToDo: Fix this
    public SearchDataObjSQLHelper() throws PenielException {
        sqlTable = "APP_USER_ROLES";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("SR_NO", new FieldHelper(SearchDataObj.class, "srNo", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("VERSION", new FieldHelper(SearchDataObj.class, "version", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DOC_ID", new FieldHelper(SearchDataObj.class, "docId", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DOC_TYPE_ID", new FieldHelper(SearchDataObj.class, "docTypeId", int.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("FILENAME",  new FieldHelper(SearchDataObj.class, "fileName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DOCUMENT_TYPE",  new FieldHelper(SearchDataObj.class, "documentType", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("FOLDERNAME",  new FieldHelper(SearchDataObj.class, "folderName", String.class)));

            sqlFieldHelpers.add(new SqlFieldHelper("INDEX_TYPE",  new FieldHelper(SearchDataObj.class, "indexType", String.class)));
/* unknown */
            sqlFieldHelpers.add(new SqlFieldHelper("INDEX_TYPE_ID",  new FieldHelper(SearchDataObj.class, "indexTypeId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("INDEX_VALUE",  new FieldHelper(SearchDataObj.class, "indexValue", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}
