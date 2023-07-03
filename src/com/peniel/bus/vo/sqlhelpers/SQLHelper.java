package com.peniel.bus.vo.sqlhelpers;

import com.peniel.common.dbobject;
import com.peniel.dao.helper.SqlFieldHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * This class is the root class that a deals with processing of rows of data.<BR />
 * Implementations must Supply a newObject that returns the Generic type. <BR/>
 * There are several functions that can help with creating the "select" part of the SQL
 *
 * User: todd sieland-peterson
 * Date: 11/4/11
 * Time: 5:47 PM
 */
public abstract class SQLHelper<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SQLHelper.class);

    protected List<SqlFieldHelper> sqlFieldHelpers;
    protected String sqlTable;
    protected String sequenceName;
    protected String batchsequenceName;

    public abstract T newObject();

    public List<SqlFieldHelper> getSqlFieldHelpers() {
        return sqlFieldHelpers;
    }

    public String getSqlTable() {
        return sqlTable;
    }

    public String getSequenceName() {
        return sequenceName;
    }
    public String getBatchSequenceName() {
        return batchsequenceName;
    }

    /**
     * SQL Build functions. Alias is the name that will be prepended to the column name (alias.columnname)
     * If the alias is set (non-zero) then it will be prepended to the field name.<BR/>
     * //TODO: a new function for chaining the select.
     * @param alias
     * @return the Select string part of the sql
     */
    public String buildSelect(String alias) {
        StringBuilder sb = new StringBuilder("SELECT ");
        boolean first = true;

        for (SqlFieldHelper fieldHelper : sqlFieldHelpers) {
            if (!first) {
                sb.append(", ");
            }
            first = false;
            if (alias != null) {
                sb.append(alias).append(".");
            }
            sb.append(fieldHelper.getSqlFieldName());
        }

        return sb.toString();
    }

    // not working yet
    public String buildFrom(String joined, String alias) {
        StringBuilder sb = new StringBuilder();

        sb.append(sqlTable);

        if (alias != null) {
            sb.append(" ").append(alias);
        }

        return sb.toString();
    }

    public String buildWhere(String alias, String field, String condition, Object value) {
        StringBuilder sb = new StringBuilder();

        sb.append(" WHERE ");

        if (alias != null) {
            sb.append(alias).append(".");
        }

        sb.append(field).append(" ").append(condition).append(" ");

        SqlFieldHelper helper = findFieldHelperForFieldName(field);
        if (helper.isFieldThisType(String.class)) {
            sb.append("'").append(value).append("'");
        } else {
            sb.append(value);
        }

        return sb.toString();
    }

    public String buildFrom(String alias) {
        StringBuilder sb = new StringBuilder();

        sb.append(" FROM ").append(sqlTable);

        if (alias != null) {
            sb.append(" ").append(alias);
        }

        return sb.toString();
    }

    public String buildSet(String alias, T object) {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public T builderFromSql(HashMap hashMap) {
        T appUser = newObject();
        return builderFromSql(hashMap, appUser);
    }

    public T builderFromSql(HashMap hashMap, T appUser) {
        for (SqlFieldHelper fieldHelper : sqlFieldHelpers) {
            fieldHelper.builderFromSql(null, hashMap, appUser);
        }

        return appUser;
    }

    public Vector<T> buildFromDbRows(Vector<dbobject.dbrow> rows) {
        Vector<T> appUserList = new Vector<T>();
        for (dbobject.dbrow dbrow : rows) {
            HashMap<String, dbobject.dbcol> hashMap = dbrow.getrow();

            if (hashMap.size() > 0) {
                appUserList.add(buildFromDbRow(dbrow));
            }
        }
        return appUserList;
    }

    public T buildFromDbRow(dbobject.dbrow row) {
        HashMap<String, dbobject.dbcol> hashMap = row.getrow();
        T object = newObject();

        for (SqlFieldHelper sqlFieldHelper : sqlFieldHelpers) {
            sqlFieldHelper.builderFromSql(null, hashMap, object);
        }

        return object;
    }

    /**
     * Given the database row, this will pull the values back out of the record set.
     * @param alias
     * @param row
     * @return The single db row as the Generic object.
     */
    public T buildFromDbRow(String alias, dbobject.dbrow row) {
        HashMap<String, dbobject.dbcol> hashMap = row.getrow();
        T object = newObject();

        for (SqlFieldHelper sqlFieldHelper : sqlFieldHelpers) {
            sqlFieldHelper.builderFromSql(alias, hashMap, object);
        }

        return object;
    }

    /**
     * Finds the fieldHelper in the hash table where the name passed in is the same.
     * @param field Name of the field to find
     * @return FieldHelper object or null
     */
    public SqlFieldHelper findFieldHelperForFieldName(String field) {
        for (SqlFieldHelper fieldHelper : sqlFieldHelpers) {
            if (fieldHelper.getSqlFieldName().equalsIgnoreCase(field)) {
                return fieldHelper;
            }
        }
        return null;
    }
}
