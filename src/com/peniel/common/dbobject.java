package com.peniel.common;

import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class dbobject {

    private String table_;
    private dbrow datarow_;
    private Vector<dbrow> rows_ = new Vector<dbrow>(25, 5);
    private Connection connection_;
    private HashMap<String, dbcol> columns_ = new HashMap<String, dbcol>();
    private String selectsql_ = "";
    private String insertsql_ = "";
    private String updatesql_ = "";
    private String deletesql_ = "";
    private HashMap<String, String> colidx_ = new HashMap<String, String>();

    public dbobject(Connection conn) {
        datarow_ = new dbrow();
        connection_ = conn;
        //System.out.println("New Object initialized");
    }

    public dbobject(Connection conn, String sqlstmt) throws Exception {

        if (sqlstmt == null || conn == null) {
            throw (new PenielException("DB Object initialization error !!! Found NULL values"));
        }
        connection_ = conn;
        Statement stmt = conn.createStatement();
        //System.out.println("SQLSTMT="+sqlstmt);
        ResultSet rs = stmt.executeQuery(sqlstmt);
        ResultSetMetaData md = rs.getMetaData();
        for (int i = 1; i <= md.getColumnCount(); i++) {
            colidx_.put(md.getColumnName(i).toUpperCase(), "" + (i + 1));
            dbcol dbc = new dbcol(md.getColumnName(i).toUpperCase(), md.getColumnTypeName(i), 0);
            System.out.println(dbc);
            columns_.put(md.getColumnName(i).toUpperCase(), dbc);
        }
        selectsql_ = sqlstmt;


    }

    public dbobject(String t, Connection conn) throws Exception {
        if (t == null || conn == null) {
            throw (new PenielException("DB Object initialization error !!! Found NULL values"));
        }
        datarow_ = new dbrow();
        connection_ = conn;
        setTable(t);

    }

    public dbobject(Connection conn, String sqlstmt, String tempStr) throws Exception {
        if (sqlstmt == null || conn == null) {
            throw (new PenielException("DB Object initialization error !!! Found NULL values"));
        }
        connection_ = conn;
        Statement stmt = conn.createStatement();
        //System.out.println("SQLSTMT="+sqlstmt);
        stmt.executeUpdate(sqlstmt);

        stmt.close();

    }

    public dbobject.dbrow getrow() {
        return datarow_;
    }

    public void setTable(String t) throws Exception {
        //System.out.println("*** In setTable ****");
        table_ = t;
        int i = 0;
        String inssql = "";
        String name = "";
        String type = "";
        int size = 0;


        selectsql_ = "select rowidtochar(rowid) as row_id, ";
        insertsql_ = "insert into " + table_ + " (";
        updatesql_ = "update " + table_ + " set ";
        deletesql_ = "delete " + table_ + " where rowid=chartorowid(?)";
        DatabaseMetaData metadata = connection_.getMetaData();
        ResultSet resultSet = metadata.getColumns(null, DBManager.getInstance().getDbUserId().toUpperCase(), table_, null); //databse, schema, table, column
        while (resultSet.next()) {
            name = resultSet.getString("COLUMN_NAME");
            type = resultSet.getString("TYPE_NAME");
            size = resultSet.getInt("COLUMN_SIZE");
            colidx_.put(name, "" + (i + 1));
            //System.out.println("col = "+name+" type="+type+" size="+size);
            dbcol dbc = new dbcol(name, type, size);
            //System.out.println(dbc);
            columns_.put(name, dbc);
            if (i == 0) {
                selectsql_ += name;
                insertsql_ += name;
                updatesql_ += dbc.getWhereString("=");
                inssql += dbc.getInsString();
            } else {
                selectsql_ += "," + name;
                insertsql_ += "," + name;
                updatesql_ += "," + dbc.getWhereString("=");
                inssql += "," + dbc.getInsString();
            }
            i++;
        }
        selectsql_ += " from " + table_ + " where ";
        //selectsql_+=" from "+table_;   // Modified by Huzefa
        insertsql_ += ") values(" + inssql + ")";
        updatesql_ += " where rowid=chartorowid(?)";

        //System.out.println("*** in settable -->"+selectsql_);
        //System.out.println(insertsql_);
        //System.out.println(updatesql_);
        //System.out.println(deletesql_);
        //System.out.println(inssql);

        resultSet.close();

    }

    public String getTable() {
        return table_;
    }


    public Vector<String> getListofColumns() {
        Vector<String> v = new Vector<String>(25, 5);
        for (String s : columns_.keySet()) {
            v.add(s);
        }
        return v;
    }

    public void initializeRow() {
        datarow_ = new dbrow();
    }

    public void addElement(String e, Object v) throws Exception {

        if (columns_.containsKey(e.toUpperCase())) {
            datarow_.setcolumn(e, v);
        } else {
            //System.out.println("Invalid Column "+e+" in table "+table_);
        }

    }

    public void addRow() {
        rows_.add(datarow_);

    }

    public dbrow getRowbyrowid(String r) throws Exception {
        dbrow dbr = null;
        for (dbrow aRows_ : rows_) {
            dbr = aRows_;
            if (dbr.getrowid().equals(r))
                return dbr;
        }
        if (dbr == null) {
            throw new PenielException("ROWID NOT FOUND = " + r);
        }
        datarow_ = dbr;
        return dbr;

    }

    public dbrow getRowbycolumnvalue(String col, Object value) throws Exception {
        dbrow ndbr = null;

        for (dbrow aRows_ : rows_) {
            dbcol temp = aRows_.getColumn(col.toUpperCase());
            //dbcol temp=(dbcol)columns_.get(col.toUpperCase());
            //System.out.println("Comparing >"+temp.getValueString()+"< with >"+(String)value+"<");

            if (temp.getType().equals("DOUBLE")) {
                if (Double.parseDouble(temp.getValueString()) == (Double) value) {
                    datarow_ = aRows_;
                    ndbr = aRows_;
                    return ndbr;
                }
            } else if (temp.getType().equals("VARCHAR")) {
                if (temp.getValueString().equals((String) value)) {
                    datarow_ = aRows_;
                    ndbr = aRows_;
                    return ndbr;
                }
            }
        }
        if (ndbr == null) {
            throw new PenielException(col + " does not have a value of " + value);
        }
        datarow_ = ndbr;

        return ndbr;

    }

    public dbrow getRowbycolumnvalue(Vector<dbcol> v) throws Exception {
        dbrow dbr = null;
        dbrow ndbr = null;


        for (dbrow aRows_ : rows_) {
            dbr = aRows_;
            int i = 0;
            for (dbcol qcol : v) {
                dbcol temp = columns_.get(qcol.getName());

                if (!temp.equals(qcol.getValue())) {
                    i = 1;
                    break;
                }

            }
            if (i == 0) {
                datarow_ = dbr;
                ndbr = dbr;
                return ndbr;

            }
        }
        if (ndbr == null) {
            throw new PenielException("Result set does not have a value");
        }
        datarow_ = ndbr;
        return ndbr;

    }

    public void syncrowset() throws Exception {

        for (dbrow aRows_ : rows_) {
            (aRows_).syncrow();
        }


    }

    public Vector<dbobject.dbrow> selectrowset(Connection conn, String sqlstmt) throws Exception {
        selectsql_ = sqlstmt;
        String s = "";
        String selectsql1_ = "";
        if (table_ != null) {
            selectsql1_ = selectsql_ + datarow_.getwhereclause();
        } else {
            selectsql1_ = selectsql_;
        }
        //System.out.println("Selecting "+selectsql1_);
        PreparedStatement pstmt = connection_.prepareStatement(selectsql1_);
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData md = rs.getMetaData();
       
        for (int i = 1; i <= md.getColumnCount(); i++) {
        	// System.out.println("Selecting "+md.getColumnName(i));
            colidx_.put(md.getColumnName(i).toUpperCase(), "" + (i + 1));
            dbcol dbc = new dbcol(md.getColumnName(i).toUpperCase(), md.getColumnTypeName(i), 0);
          //  System.out.println("dbc-->"+dbc);
            columns_.put(md.getColumnName(i).toUpperCase(), dbc);
        }

        String[] cols = null;
        String coltyp = "";
        String colsize = "";
        dbcol dbc = null;
        while (rs.next()) {
            //System.out.println("Processing a select row");
            datarow_ = new dbrow();
            for (String s1 : columns_.keySet()) {
                s = s1;
                //System.out.println("Processing col = "+s);
                dbc = datarow_.getColumn(s);

                coltyp = dbc.getType();
                //System.out.println("Type = "+coltyp);
                if (coltyp.equals("VARCHAR")) {
                    datarow_.setcolumn(s, rs.getString(s));
                }
                if (coltyp.equals("DOUBLE")) {
                    datarow_.setcolumn(s, rs.getDouble(s));
                }
                if (coltyp.equals("DATETIME")) {
                    datarow_.setcolumn(s, rs.getDate(s));
                }


            }
            if (table_ != null)
                datarow_.setrowid(rs.getString("row_id"));

            rows_.add(datarow_);

        }
        rs.close();
        pstmt.close();
        if(conn!=null) {
        conn.close(); //added to check pooling issue
        }
        return rows_;
    }

    public long getNextId(Connection conn, String tableId) throws SQLException {
        String selectsql1_ = "select  " + tableId + ".nextval from dual";
        long id = 0;

        PreparedStatement pstmt = connection_.prepareStatement(selectsql1_);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            id = rs.getLong(0);
        }
        rs.close();
        pstmt.close();

        return id;
    }

    public long getNextId(String selectsql1_) throws SQLException {
        long id = 0;

        PreparedStatement pstmt = connection_.prepareStatement(selectsql1_);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            id = rs.getLong(1);
        }
        rs.close();
        pstmt.close();

        return id;
    }

    public long doUpdate(String selectsql1_) throws SQLException {
        long id = 0;

        PreparedStatement pstmt = connection_.prepareStatement(selectsql1_);
        id = pstmt.executeUpdate();

        pstmt.close();

        return id;
    }

    public long doInsert(String selectsql1_) throws SQLException {
        long id = 0;

        PreparedStatement pstmt = connection_.prepareStatement(selectsql1_);
        id = pstmt.executeUpdate();

        pstmt.close();

        return id;
    }

    public Vector selectrowset(String whereClause) throws Exception {

        String s = "";
        String selectsql1_ = "";
        if (table_ != null) {
            //selectsql1_=selectsql_+datarow_.getwhereclause();
            selectsql1_ = selectsql_ + whereClause;
        } else {
            selectsql1_ = selectsql_;
        }
        //System.out.println("Selecting "+selectsql1_);
        PreparedStatement pstmt = connection_.prepareStatement(selectsql1_);
        ResultSet rs = pstmt.executeQuery();
        String[] cols = null;
        String coltyp = "";
        String colsize = "";
        dbcol dbc = null;
        while (rs.next()) {
            //System.out.println("Processing a select row");
            datarow_ = new dbrow();
            for (String s1 : columns_.keySet()) {
                s = s1;
                //System.out.println("Processing col = "+s);
                dbc = datarow_.getColumn(s);

                coltyp = dbc.getType();
                //System.out.println("Type = "+coltyp);
                if (coltyp.equals("VARCHAR")) {
                    datarow_.setcolumn(s, rs.getString(s));
                }
                if (coltyp.equals("DOUBLE")) {
                    datarow_.setcolumn(s, rs.getDouble(s));
                }
                if (coltyp.equals("DATETIME")) {
                    datarow_.setcolumn(s, rs.getDate(s));
                }


            }
            if (table_ != null) {
                datarow_.setrowid(rs.getString("row_id"));
                //System.out.println("********* row_id in selectrowset -->"+rs.getString("row_id"));
            }
            rows_.add(datarow_);

        }
        rs.close();
        pstmt.close();

        return rows_;
    }

    public String toString() {
        String s = "";
        s = "Table Name = " + table_ + "\n";
        Iterator itr = rows_.iterator();
        while (itr.hasNext()) {
            s = s + "\t" + itr.next().toString() + ", \n";
        }
        return s;
    }


    public Vector<HashMap<String, String>> selectResultSet(Connection conn, String sql) throws Exception {

        selectsql_ = sql;
        String s = "";
        String selectsql1_ = "";
        if (table_ != null) {
            selectsql1_ = selectsql_ + datarow_.getwhereclause();
        } else {
            selectsql1_ = selectsql_;
        }
        //System.out.println("Selecting "+selectsql1_);

        Vector<HashMap<String, String>> hashMapList = new Vector<HashMap<String, String>>();


        PreparedStatement pstmt = connection_.prepareStatement(selectsql1_);
        ResultSet resultSet = pstmt.executeQuery();
        //get the number of columns and get their names
        List<String> columnNames = new ArrayList<String>();

        for (int y = 0; y < resultSet.getMetaData().getColumnCount(); y++) {
            columnNames.add(resultSet.getMetaData().getColumnName(y + 1).toUpperCase());
        }

        while (resultSet.next()) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            //now put the values in a hashmap column name/value
            for (int z = 0; z < columnNames.size(); z++) {

                hashMap.put(columnNames.get(z), resultSet.getString(z + 1));

            }

            hashMapList.addElement(hashMap);

        }
        resultSet.close();
        pstmt.close();


        return hashMapList;

    }

    public class dbrow {
        private long status = 0;
        private String row_id = "";
        private HashMap<String, dbcol> fields;
        private HashMap<String, Object> changed;

        public dbrow() {
            status = 0;
            row_id = "";
            fields = new HashMap<String, dbcol>();
            changed = new HashMap<String, Object>();
            fields.clear();
            changed.clear();
            for (String s : columns_.keySet()) {
                dbcol v = new dbcol(s, ((columns_.get(s))).getType(), ((columns_.get(s))).getSize());
                /*v=(columns_.get(s)).clone();*/
                fields.put(s, v);
                changed.put(s, new Integer(0));
            }

        }


        public dbrow(HashMap<String,dbcol> hm) {
            status = 1;
            row_id = "";
            fields = hm;
            for (String s : fields.keySet()) {
                changed.put(s, new Integer(0));
            }

        }

        public dbrow(String rid, HashMap<String,dbcol> hm) {
            status = 2;
            row_id = rid;
            row_id = "";
            fields = hm;
            for (String s : fields.keySet()) {
                changed.put(s, new Integer(0));
            }
        }

        public long getstatus() {
            return status;
        }

        public dbcol getColumn(String col) {
            if (fields.containsKey(col)) {
                return fields.get(col);
            } else {
                return null;
            }
        }

        public void setcolumn(String col, Object val) throws Exception {
            //System.out.println("Setting Value of "+col+" to "+val);
            dbcol dbc = (dbcol) fields.get(col);
            dbc.setValue(val);
            fields.put(col, dbc);
            changed.put(col, new Integer(1));

        }

        public void setstatus(long l) {
            status = l;
        }

        public String getrowid() {
            return row_id;
        }

        public void setrowid(String s) {
            row_id = s;
        }

        public void syncrow() throws Exception {
            int i = 0;
            String col = "";
            dbcol val = null;
            String[] cols = null;
            String coltyp = "";
            String colsize = "";
            String dtstr = "";
            int idx = 0;
            int updflag = 0;

            PreparedStatement pstmt = null;
            Iterator itr = null;
            switch ((int) status) {
                case 0:
                    //System.out.println("No change");
                    break;
                case 1:
                    //System.out.println("New Row");
                    PreparedStatement cstmt = connection_.prepareStatement(insertsql_);
                    String selectsql1_ = "select rowidtochar(rowid) from " + table_ + " where ";
                    itr = fields.keySet().iterator();
                    while (itr.hasNext()) {
                        col = (String) itr.next();
                        val = (dbcol) fields.get(col);
                        changed.put(col, new Integer(0));
                        //selectsql1_+=val.getWhereString("=")+" and ";
                        selectsql1_ += val.getWhereString("=");
                        idx = Integer.parseInt((String) colidx_.get(col.toUpperCase()));

                        //System.out.print("Column "+col+"--->");
                        //                      System.out.println(val.getValueString()+"<----");

                        cstmt.setString(idx, val.getValueString());
                    }
                    selectsql1_ += " 1=1";
                    //	((OraclePreparedStatement)cstmt).setExecuteBatch(20);

                    cstmt.executeUpdate();
                    cstmt.close();
                    pstmt = connection_.prepareStatement(selectsql1_);
                    //System.out.println("SELECT = "+selectsql1_);
                    ResultSet rs = pstmt.executeQuery();
                    rs.next();
                    row_id = rs.getString(1);
                    rs.close();
                    pstmt.close();
                    status = 0;
                    break;
                case 2:
                    //System.out.println("Update Row");
                    updatesql_ = "update " + table_ + " set ";
                    itr = fields.keySet().iterator();
                    i = 0;
                    while (itr.hasNext()) {
                        col = (String) itr.next();
                        val = (dbcol) fields.get(col);
                        updflag = ((Integer) changed.get(col)).intValue();
                        if (updflag != 0) {

                            updatesql_ += val.getUpdateString();
                            i++;
                        }

                        updatesql_ += ","; //Added by Huzefa.

                    }

                    updatesql_ = updatesql_.substring(0, updatesql_.lastIndexOf(",")); //Added by Huzefa.

                    updatesql_ += " where rowid=chartorowid(?) ";
                    //System.out.println(updatesql_);
                    //System.out.println("++++++++++++++++++++");
                    pstmt = connection_.prepareStatement(updatesql_);
                    itr = fields.keySet().iterator();
                    i = 0;
                    while (itr.hasNext()) {
                        col = (String) itr.next();
                        val = fields.get(col);
                        updflag = (Integer) changed.get(col);
                        if (updflag != 0) {
                            coltyp = ((dbcol) columns_.get(col.toUpperCase())).getType();
                            idx = Integer.parseInt((String) colidx_.get(col.toUpperCase()));
                            i++;
                            pstmt.setString(i, val.getValueString());
                        }
                    }
                    if (row_id != null) {
                        if (i > 0) {
                            i++;
                            //System.out.println("row_id--->"+row_id+"<---");
                            //System.out.println(pstmt);
                            pstmt.setString(i, row_id);
                            pstmt.executeUpdate();
                            pstmt.close();
                        } else {
                            pstmt.close();
                            //System.out.println("Nothing changed on the row");
                        }
                    } else {
                        pstmt.close();
                        throw (new PenielException("rowid missing for row"));
                    }
                    status = 0;
                    break;
                case 3:
                    //System.out.println("Delete Row");
                    pstmt = connection_.prepareStatement(deletesql_);
                    if (row_id != null) {
                        pstmt.setString(1, row_id);
                        pstmt.executeUpdate();
                        pstmt.close();
                        row_id = null;
                    } else {
                        pstmt.close();
                        throw (new PenielException("rowid missing for row"));
                    }
                    status = 0;
                    break;
                default:
                    throw (new Exception());
            }


        }

        public String getwhereclause() {
            ////System.out.println("********* in getwhereclause *********");
            String col_ = "";
            String clause = "  ";
            dbcol val_ = null;
            String[] cols = null;
            String coltyp = "";
            String colsize = "";
            int idx = 0;
            int i = 0;
            int k = 0;
            String dtstr = "";
            Iterator itr = fields.keySet().iterator();
            while (itr.hasNext()) {
                col_ = (String) itr.next();
                //System.out.println("col_ = "+col_);
                //System.out.println("val = "+fields.get(col_));
                if ((val_ = (dbcol) fields.get(col_)) != null) {

                    coltyp = ((dbcol) columns_.get(col_.toUpperCase())).getType();
                    //System.out.println("Type = "+coltyp+"  size = "+colsize);
                    idx = Integer.parseInt((String) colidx_.get(col_.toUpperCase()));
                    if (k == 0) {
                        if (((val_.getWhereString("=")).trim()).length() > 0) {
                            clause += val_.getWhereString("=");
                            k++;
                        }
                    } else {
                        if (((val_.getWhereString("=")).trim()).length() > 0) {
                            clause += " and " + val_.getWhereString("=");
                        }
                    }
                    i++;
                }
            }
            if ((clause.trim()).endsWith("and"))
                clause += " 1=1";
            if ((clause.trim()).length() == 0)
                clause += " 1=1";
            return clause;

        }

        public HashMap<String, dbcol> getrow() {
            return fields;
        }

        public String toString() {

            String s = "Row " + row_id + "\n\t Status=" + status + "\n";
            Iterator itr = fields.values().iterator();
            while (itr.hasNext()) {
                s = s + ((dbcol) itr.next()) + "\t\t, \n";
            }
            return s;
        }
    }


    public class dbcol {
        private long status = 0;
        private String colName = "";
        private String colType = "";
        private int colSize = 0;
        private int precision = 0;
        private Object defaultValue = null;
        private Object value = null;
        private Object evalue = null;
        private String pattern = null;


        public dbcol(String nam, String typ, int siz) {
            colName = nam;
            colType = typ;
            colSize = siz;
            if (typ.equals("DATETIME")) {
                value = null;
            }
            if (typ.equals("DOUBLE")) {
                value = null;
            }
            if (typ.equals("VARCHAR")) {
                value = null;
            }
        }

        public dbcol(String nam, String typ, int siz, int prec) {
            colName = nam;
            colType = typ;
            colSize = siz;
            if (typ.equals("DATETIME")) {
                value = new java.util.Date();
            }
            if (typ.equals("DOUBLE")) {
                value = 0.0D;
            }
            if (typ.equals("VARCHAR")) {
                value = "";
            }
            precision = prec;
        }

        public dbcol(String nam, String typ, int siz, Object dv) {
            colName = nam;
            colType = typ;
            colSize = siz;
            value = dv;
            defaultValue = dv;
        }

        public dbcol(String nam, String typ, int siz, int prec, Object dv) {
            colName = nam;
            colType = typ;
            colSize = siz;
            value = dv;
            precision = prec;
            defaultValue = dv;
        }

        public void setPattern(String s) {
            pattern = s;
        }

        public void setRange(Object beg, Object end) {
            value = beg;
            evalue = end;
        }

        public void setValue(Object beg) {
            //System.out.println("In col set value");
            value = beg;

            evalue = null;
        }

        public String toString() {
            String s = "";
            Format formatter = null;

            if (colType.equals("DOUBLE")) {
                if (value == null) {
                    s += colName + "[" + colType + "]=NULL";
                } else {
                    String output = "";
                    if (pattern != null) {
                        DecimalFormat myFormatter = new DecimalFormat(pattern);
                        double vl = ((Double) value).doubleValue();
                        output = myFormatter.format(vl);
                    } else {
                        output = "" + ((Double) value).toString();
                    }
                    s += colName + " [" + colType + " " + colSize + "," + precision + "] " + " = " + output;
                }
            }
            if (colType.equals("VARCHAR")) {
                if (value != null) {
                    s += colName + " [" + colType + " " + colSize + "] " + " = " + (String) value;
                } else {
                    s += colName + " [" + colType + " " + colSize + "] " + " = " + "NULL";
                }
            }
            if (colType.equals("DATETIME")) {
                if (value == null) {
                    s += colName + " [" + colType + "] " + "=NULL ";
                } else {
                    java.util.Date dt = (java.util.Date) value;
                    if (pattern != null) {
                        formatter = new SimpleDateFormat(pattern);
                    } else {
                        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    }
                    s += colName + " [" + colType + " " + colSize + "] " + " = " + formatter.format(dt);
                }
            }

            return s;

        }

        public String getName() {
            return colName;
        }

        public Object getValue() {
            return value;
        }

        public String getType() {
            return colType;
        }

        public boolean equals(Object cv) {
            if (cv == null)
                return false;
            if (value == null)
                return false;
            if (colType.equals("DOUBLE")) {
                int i = ((Double) cv).compareTo(((Double) value));
                if (i == 0) return true;
                else return false;
            }
            if (colType.equals("VARCHAR")) {
                int i = ((String) cv).compareTo(((String) value));
                //System.out.println("i="+i+"  cv="+(String)cv+" value="+(String)value);
                if (i == 0) return true;
                else return false;
            }
            if (colType.equals("DATETIME")) {
                int i = ((java.util.Date) cv).compareTo(((java.util.Date) value));
                if (i == 0) return true;
                else return false;
            }
            return false;
        }

        public int compareTo(Object cv) {
            if (cv == null) return -1;
            if (value == null) return -1;
            if (colType.equals("DOUBLE")) {
                int i = ((Double) cv).compareTo(((Double) value));
                return i;
            }
            if (colType.equals("VARCHAR")) {
                int i = ((String) cv).compareTo(((String) value));
                return i;
            }
            if (colType.equals("DATETIME")) {
                int i = ((java.util.Date) cv).compareTo(((java.util.Date) value));
                return i;
            }
            return -1;
        }


        public String getWhereString(String operator) {
            String s = "";
            Format formatter = null;
            if (value == null) return "";
            if (colType.equals("DOUBLE")) {
                if (evalue != null) {

                    String pt = "";
                    if (pattern != null) {
                        pt = pattern;
                    } else {
                        pt = "#0";
                    }
                    DecimalFormat myFormatter = new DecimalFormat(pt);
                    double vl = ((Double) value).doubleValue();
                    double v2 = ((Double) evalue).doubleValue();
                    String bv = myFormatter.format(vl);
                    String ev = myFormatter.format(v2);
                    s += colName + " between " + bv + " and " + ev;
                } else {
                    if (value == null) {
                        s += "";
                    } else {
                        String pt = "";
                        if (pattern != null) {
                            pt = pattern;
                        } else {
                            pt = "#0.00";
                        }
                        DecimalFormat myFormatter = new DecimalFormat(pt);
                        double vl = ((Double) value).doubleValue();
                        //String ebv = myFormatter.format(vl);
                        String ebv = myFormatter.format(vl);
                        s += colName + " " + operator + " " + ebv;
                    }


                }
            }
            if (colType.equals("VARCHAR")) {
                if (((String) value).length() > 0) {
                    s += colName + " " + operator + " \'" + (String) value + "\'";
                } else {
                    s += "";
                    /*
                     if (operator.equals("="))
                     {
                         s+=colName+" is null ";
                     }
                     else
                     {
                         s+=colName+" is not null ";
                     }*/
                }
            }
            if (colType.equals("DATETIME")) {
                java.util.Date dt = (java.util.Date) value;
                if (evalue != null) {
                    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    s += colName + " between to_date('" + formatter.format(dt) + "','YYYY-MM-DD HH24:MI:SS') and to_date('";
                    dt = (java.util.Date) evalue;
                    s += formatter.format(dt) + "','YYYY-MM-DD HH24:MI:SS')";
                } else {
                    if (value == null) {
                        s += "";
                    } else {
                        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        s += colName + " " + operator + "  to_date('" + formatter.format(dt) + "','YYYY-MM-DD HH24:MI:SS') ";

                    }
                    /*
                     formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                     //System.out.println("Formatter = "+formatter.format(dt));
                     s+=colName+" "+operator+" "+"to_date('"+formatter.format(dt)+"','YYYY-MM-DD HH24:MI:SS')";*/
                }
            }

            if (s.length() > 0) s += " and ";

            return s;
        }

        public String getUpdateString() {
            String s = "";
            if (colType.equals("DOUBLE")) {
                s += colName + "=?";
            }
            if (colType.equals("VARCHAR")) {
                s += colName + "=?";
            }
            if (colType.equals("DATETIME")) {
                s += colName + "=to_date(?,'YYYY-MM-DD HH24:MI:SS')";
            }
            return s;
        }

        public String getInsString() {
            String s = "";
            if (colType.equals("DOUBLE")) {
                s += "?";
            }
            if (colType.equals("VARCHAR")) {
                s += "?";
            }
            if (colType.equals("DATETIME")) {
                s += "to_date(?,'YYYY-MM-DD HH24:MI:SS')";
            }
            return s;
        }

        public String getValueString() {
            String s = "";
            Format formatter = null;

            if (colType.equals("DOUBLE")) {
                String output = "";
                if (pattern != null) {
                    DecimalFormat myFormatter = new DecimalFormat(pattern);
                    double vl = ((Double) value).doubleValue();
                    output = myFormatter.format(vl);
                } else {
                    DecimalFormat myFormatter = new DecimalFormat("#0");
                    double vl = ((Double) value).doubleValue();
                    output = myFormatter.format(vl);
                    output = "" + ((Double) value).toString();
                }
                s += output;
            }
            if (colType.equals("VARCHAR")) {
                if (value != null) {
                    s += (String) value;
                } else {
                    s += "";
                }
            }
            if (colType.equals("DATETIME")) {
            	if(value!= null)
            	{
	                java.util.Date dt = (java.util.Date) value;
	                if (pattern != null) {
	                    formatter = new SimpleDateFormat(pattern);
	                } else {
	                    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                }
	                s += formatter.format(dt);
            	}
            }
            return s;
        }


        public Date getValueDate() {
            Date result = null;

            if (colType.equals("DATETIME")) {
                result = (java.util.Date) value;
            }
            return result;
        }

        public Integer getValueInt() {
            Integer result = null;

            if (colType.equals("DOUBLE")) {
                DecimalFormat myFormatter = new DecimalFormat("#0");
                String output = myFormatter.format(value);
                result = Integer.parseInt(output);
            }
            return result;
        }


        public Double getValueDouble() {
            Double s = null;

            if (colType.equals("DOUBLE")) {
                s = ((Double) value).doubleValue();
            }

            return s;
        }


        public int getSize()

        {

            return colSize;

        }


    }


}

