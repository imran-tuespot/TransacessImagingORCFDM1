package com.peniel.bus.vo.sqlhelpers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.peniel.bus.vo.BatchUpload;
import com.peniel.bus.vo.DocumentData;
import com.peniel.bus.vo.DocumentType;
import com.peniel.common.PenielException;
import com.peniel.dao.helper.FieldHelper;
import com.peniel.dao.helper.SqlFieldHelper;

public class BatchUploadSQLHelper extends SQLHelper<BatchUpload>{
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchUploadSQLHelper.class);

    @Override
    public BatchUpload newObject() {
        return new BatchUpload();
    }

    public BatchUploadSQLHelper() throws PenielException {
        sqlTable = "BatchUpload";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
        	 sqlFieldHelpers.add(new SqlFieldHelper("USER_ID", new FieldHelper(BatchUpload.class, "userId", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("BATCH_FILENAME", new FieldHelper(BatchUpload.class, "batchFilename", String.class), true));
            sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID", new FieldHelper(BatchUpload.class, "companyId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("UPLOAD_DATE",  new FieldHelper(BatchUpload.class, "uploadDate", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("PROCESS_DATE",  new FieldHelper(BatchUpload.class, "processDate", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("STATUS",  new FieldHelper(BatchUpload.class, "status", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("DESCRIPTION",  new FieldHelper(BatchUpload.class, "description", String.class)));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new PenielException("No Such method");
        }

    }

}
