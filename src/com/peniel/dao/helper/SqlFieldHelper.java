package com.peniel.dao.helper;

import com.peniel.bus.vo.AppUser;
import com.peniel.common.PenielException;
import com.peniel.common.dbobject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * User: todds
 * Date: 11/4/11
 * Time: 7:54 PM
 */
public class SqlFieldHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(SqlFieldHelper.class);
    private String sqlFieldName;
    private FieldHelper fieldHelper;
    private boolean primaryKey;

    public SqlFieldHelper(String sqlFieldName, FieldHelper fieldHelper, boolean primaryKey) {
        this.fieldHelper = fieldHelper;
        this.sqlFieldName = sqlFieldName.toUpperCase();
        this.primaryKey = primaryKey;
    }

    public SqlFieldHelper(String sqlFieldName, FieldHelper fieldHelper) {
        this.fieldHelper = fieldHelper;
        this.sqlFieldName = sqlFieldName.toUpperCase();
    }

    public String objectToString(Object objectWrapper) {
        return objectWrapper.toString();
    }

    public boolean isFieldThisType(Class clazz) {
        return fieldHelper.isFieldThisType(clazz);
    }

    /**
     * returns a string based on the type of value and the destination type.
     * @param objectWrapper
     * @return
     * @throws PenielException
     */
    public String objectValueToSqlWrapper(Object objectWrapper) throws PenielException {
        if (fieldHelper.getClazz().equals(String.class)) {
            return "\"" + objectToString(objectWrapper) + "\"";
        }
        if (fieldHelper.getClazz().equals(Long.class)) {
            return objectToString(objectWrapper);
        }
        if (fieldHelper.getClazz().equals(Double.class)) {
            return objectToString(objectWrapper);
        }
        if (fieldHelper.getClazz().equals(Integer.class)) {
            return objectToString(objectWrapper);
        }
        if (fieldHelper.getClazz().equals(Float.class)) {
            return objectToString(objectWrapper);
        }
        throw new PenielException("Add type to objectValueToSqlWrapper() Passed value was type " +
                objectWrapper.getClass().getName() + " - Target type was " + fieldHelper.getClazz().getName());
    }

    /**
     * This Generates the sql for the SET xxxxx=yyyy
     * @param x
     * @param setEqual
     * @return
     */
    public String buildSqlUpdateString(Object setEqual, String x) throws PenielException {
        if (x != null) {
            return buildSqlUpdateString(setEqual);
        }
        return " SET " + sqlFieldName + " = " + objectValueToSqlWrapper(setEqual);
    }

    public String buildSqlUpdateString(Object setEqual) throws PenielException {
        return " SET " + sqlFieldName + " = " + objectValueToSqlWrapper(setEqual);
    }

    /**
     * builds the values
     * @param x
     * @return
     */
    public String buildSqlString(String x) {
        if (x != null) {
            return x + ", " + sqlFieldName;
        }
        return sqlFieldName;
    }


    public FieldHelper getFieldHelper() {
        return fieldHelper;
    }

    public void setFieldHelper(FieldHelper fieldHelper) {
        this.fieldHelper = fieldHelper;
    }

    public String getSqlFieldName() {
        return sqlFieldName;
    }

    public void setSqlFieldName(String sqlFieldName) {
        this.sqlFieldName = sqlFieldName;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }
// takes input hash map and puts the one item into the targetObject
//    public void builderFromSql(HashMap hashMap, Object targetObject) {
//        dbobject.dbcol col = hashMap.get(sqlFieldName);
//        Object value = col.getValue();
//
//        if ( value != null ) {
//            try {
//                fieldHelper.setter(targetObject, value);
//            } catch (IllegalAccessException x) {
//                LOGGER.error("Cannot access function ");
//            }
//        } else {
//            LOGGER.error("In buildFromSql() Cannot find map entry for " + fieldHelper.getFieldName());
//        }
//    }

    public void builderFromSql(String alias, HashMap<String, dbobject.dbcol> hashMap, Object targetObject) {
        dbobject.dbcol col;

        if (alias == null ) {
            col = hashMap.get(sqlFieldName.toUpperCase());
        } else {
            col = hashMap.get((alias + ". " + sqlFieldName).toUpperCase());
        }

        if (col == null ) {
           // LOGGER.debug("Could not find field name " + sqlFieldName);
        } else {
            builderFromSql(col, targetObject);
        }
    }

    // takes the column and builds the
    public void builderFromSql(dbobject.dbcol column, Object targetObject) {
        Object value = column.getValue();
        //Object value = hashMap.get(sqlFieldName);

        try {
            fieldHelper.setter(targetObject, value);
        } catch (IllegalAccessException e) {
            LOGGER.error("Exception trying to save value from column(" + column + ") to target object (" +
                    targetObject.getClass().getName() + ") ", e);
        }
    }

}
