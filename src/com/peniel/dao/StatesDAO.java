package com.peniel.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.peniel.bus.vo.sqlhelpers.SQLHelper;
import com.peniel.common.DAOHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.peniel.bus.vo.States;
import com.peniel.database.*;


public class StatesDAO extends DAOHelper<States> {
    private static Logger logger = LogManager.getLogger(StatesDAO.class);

    public StatesDAO() {
        super("StatesDAO", States.getStatesSQLHelper());
    }

    public Vector<States> findAll() {
        Vector<States> statesList = new Vector<States>();
        String alias = null;

        try {
            /*StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sqlHelper.buildSelect(alias))
                    .append(sqlHelper.buildFrom(alias))
                    .append(sqlHelper.buildWhere(alias, "COUNTRY", "=", "USA"))
                    .append(" order by name asc");*/
            String sqlStatement = "select /*+ result_cache */ country, state, name  from tblstates where country = 'USA' order by name asc ";

            logger.info("query : " + sqlStatement);

            statesList = processSelectMulti(sqlStatement);

        } catch (Exception e) {
            logger.info("Error :" + e.getMessage());
        }

        return statesList;

    }


   //    public Vector<States> findByProperty(String propertyName, String value) {
//
//        Vector statesList = new Vector();
//
//
//        try {
//            String sqlStatement = "select country, state, name  from tblstates where " + propertyName + " = '" + value + "'";
//
//            logger.info("query : " + sqlStatement);
//
//            statesList = getStatesList(DatabaseConnection.getResultSet(sqlStatement));
//
//
//        } catch (Exception e) {
//            logger.info("Error :" + e.getMessage());
//        }
//
//        return statesList;
//    }
//

//    public Vector getStatesList(Vector hashMapList) {
//        Vector statesList = null;
//
//
//        statesList = new Vector();
//        try {
//            for (int y = 0; y < hashMapList.size(); y++) {
//                HashMap hashMap = new HashMap();
//                hashMap = (HashMap) hashMapList.get(y);
//
//                States states = new States();
//                states.setCountry((String) hashMap.get("COUNTRY"));
//                states.setState((String) hashMap.get("STATE"));
//                states.setName((String) hashMap.get("NAME"));
//
//
//                statesList.add(states);
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            logger.info("Error :" + e.getMessage());
//        }
//
//
//        return statesList;
//    }

}












