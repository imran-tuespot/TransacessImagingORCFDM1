package com.peniel.bus.vo.sqlhelpers;

import com.peniel.bus.vo.AppRoles;
import com.peniel.bus.vo.AppUser;
import com.peniel.bus.vo.Folder;
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
public class FolderSQLHelper extends SQLHelper<Folder> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FolderSQLHelper.class);

    @Override
    public Folder newObject() {
        return new Folder();
    }

    public FolderSQLHelper() throws PenielException {
        sqlTable = "Folders";

        sqlFieldHelpers = new ArrayList<SqlFieldHelper>();
        try {
            sqlFieldHelpers.add(new SqlFieldHelper("FOLDER_ID", new FieldHelper(Folder.class, "folderId", long.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("FOLDER_NAME", new FieldHelper(Folder.class, "folderName", String.class)));
            sqlFieldHelpers.add(new SqlFieldHelper("COMPANY_ID",  new FieldHelper(Folder.class, "companyId", long.class)));
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage());
            throw new PenielException("No Such method");
        }
    }
}
