package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.DocumentType;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * User: todds
 * Date: 11/11/11
 * Time: 11:33 PM
 */
public class DocumentTypeSQLHelper extends SQLHelper<DocumentType> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentTypeSQLHelper.class);

    @Override
    public DocumentType newObject() {
        return new DocumentType();
    }

    public DocumentTypeSQLHelper() throws PenielException {
        sqlTable = "document_type";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("DOCUMENT_TYPE_ID", new FieldHelper(DocumentType.class, "documentTypeId", long.class), true));
            sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID", new FieldHelper(DocumentType.class, "companyId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DOCUMENT_TYPE",  new FieldHelper(DocumentType.class, "documentType", String.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }

    }
}
