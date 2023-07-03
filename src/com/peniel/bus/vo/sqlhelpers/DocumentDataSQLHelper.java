package com.peniel.bus.vo.sqlhelpers;


import com.peniel.bus.vo.DocumentData;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 4:31 PM
 */
public class DocumentDataSQLHelper extends SQLHelper<DocumentData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentDataSQLHelper.class);

    public DocumentDataSQLHelper() throws PenielException {
        sqlTable = "DOCUMENT_DATA";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper> ();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("DOCUMENT_ID", new FieldHelper(DocumentData.class, "documentId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("PROPERTY_ID", new FieldHelper(DocumentData.class, "propertyId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DOCUMENT_TYPE_ID",  new FieldHelper(DocumentData.class, "documentTypeId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("COMPNAY_ID",  new FieldHelper(DocumentData.class, "companyId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("FILENAME",  new FieldHelper(DocumentData.class, "filename", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("FOLDER_ID",  new FieldHelper(DocumentData.class, "folderId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("VERSION",  new FieldHelper(DocumentData.class, "version", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("CREATE_DATE",  new FieldHelper(DocumentData.class, "createDate", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("TRANSACTION_TYPE_ID",  new FieldHelper(DocumentData.class, "transactionTypeId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("TRANSACTION_DATE",  new FieldHelper(DocumentData.class, "transactionDate", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("TRANSACTION_STATUS",  new FieldHelper(DocumentData.class, "transactionStatus", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("ACTUALFILENAME",  new FieldHelper(DocumentData.class, "actualfilename", String.class)));

        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }
    }

    public DocumentData newObject() {
        return new DocumentData();
    }


}
