package com.peniel.common;

import com.peniel.bus.vo.sqlhelpers.SQLHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Vector;

/**
 * User: todds
 * Date: 11/18/11
 * Time: 1:57 PM
 */
public class DAOManager extends DAOHelper<Object> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DAOManager.class);

    public DAOManager(SQLHelper<Object> objectSQLHelper) {
        super("DAOManager", objectSQLHelper);
    }

    /**
    * Call to process and return a list of Objects of type T.
    *
    * @param sqlStatement
    * @return  Vector< T > the vector of the
    * @throws PenielException
    */
   public Vector<HashMap> processSelectMultiIntoHashMap(String sqlStatement) throws PenielException {
       Vector<HashMap> outputList = null;
       DBManager db = DBManager.getInstance();
       Connection conn = db.getPDBConnection(DbManagerValues.CONN_SOURCE);

       //System.out.println("SQL: " + sqlStatement);
       try {
           dbobject rdo = new dbobject(conn);
           Vector<dbobject.dbrow> vRows = rdo.selectrowset(conn, sqlStatement);

           outputList = new Vector<HashMap>();
           for (dbobject.dbrow row : vRows) {
               HashMap record = new HashMap();

               record.put("USER_ID", row.getColumn("USER_ID").getValue());
               record.put("DIFF", ((Double)row.getColumn("DIFF").getValue()).toString());

               outputList.add(record);
           }

       } catch (PenielException e) {
           throw (new PenielException("Exception in " + MODULE_NAME + " : getAppUserList() " + e.getExceptionMessage()));
       } catch (Exception ex) {
           throw (new PenielException(ex, "Exception in " + MODULE_NAME + " : getAppUserList() " + ex.getMessage()));
       } finally {
           db.releaseConnection(DbManagerValues.CONN_SOURCE, conn);
       }

       return outputList;

   }


}
