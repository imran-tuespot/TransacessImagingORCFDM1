
/*
* ****************************************************************************
*
* File Name      :   DBManager.java
*
* Created by     :   Nitin Singh
* Created Date   :   01/24/2010
* --------------------------------------------------------------------------
*                          Modification History
* ---------------------------------------------------------------------------
* Date         Programmer     CR/WR       Changes
* ---------------------------------------------------------------------------
* 01/24/2010   Nitin Singh    Rel 1.0     Initial Creation
* 03/23/2010   Nitin Singh    Rel 1.0     Added Pooling Logic
* ****************************************************************************
*/


package com.peniel.common;


import java.sql.*;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;

import com.peniel.utilities.GeneratePassword;

import java.util.Stack;

import oracle.sql.BLOB;


/**
 */
public class DBManager {
    //Harvest keywords
    private static byte[] id_ =
            (new String("@(#) [viewpath]/[item];[version];[state];[author];[crtime]")).getBytes();

    private static DBManager dbmgr_ = null;
    private static int BLOB_POOL_SIZE = 1;
    private static int POOL_SIZE = 10;
    private String url_ = null;
    private boolean initialized_ = false;

    private HashMap<String, Stack<Connection>> dbConnPool_ = null;
    //  private HashMap dbConnPoolUsed_ = null;
    private HashMap<String, Vector<BLOB>> blobPool_ = null;

    private String userId_ = null;
    private String passwd_ = null;
    private Connection blobConnection_ = null;
    private String dbInstanceName_ = null;
    private String sourceName_ = null;
    private Stack<Connection> stk_ = null;


    public void initialize(String source, String url, String userid, String passwd) throws PenielException {

        if (!initialized_) {

            url_ = url + "," + userid + "," + passwd;
            userId_ = userid;
            passwd_ = passwd;
            sourceName_ = source;
            dbConnPool_ = new HashMap<String, Stack<Connection>>();

            // dbConnPoolUsed_=new HashMap();
            initialized_ = true;
        }
    }

    public void
    initialize() throws PenielException {
        try {

            if (!initialized_) {
                javax.naming.Context ctx = new javax.naming.InitialContext();
                String url = (String) ctx.lookup("java:comp/env/connection");
                String userid = (String) ctx.lookup("java:comp/env/dbusername");
                String passwd = (String) ctx.lookup("java:comp/env/dbpassword");
                String source = (String) ctx.lookup("java:comp/env/dbsource");
                String appProperty = (String) ctx.lookup("java:comp/env/appProperty");

                // System.out.println("Original Pass Phrase:============== " + passwd);
                 try{
 					GeneratePassword generatePassphrase = new GeneratePassword(appProperty);
 					passwd = generatePassphrase.decrypt(passwd);
 					//System.out.println("Decrypted Pass Phrase:==================== " + passwd);
 	                initialize(source, url, userid, passwd);
                 }catch(Exception e)
                 {
                 	System.out.println("Wrong DB password or Error while decrypting DB password"+e.getMessage());
                 }
            }
        } catch (Exception e) {
            throw (new PenielException("DBManager : DB Parameters has not been initialized"));
        }
    }

    public static DBManager getInstance() throws PenielException {
        if (dbmgr_ == null) {
            dbmgr_ = new DBManager();
            dbmgr_.initialize();
        }

        return dbmgr_;
    }

    // used for testing purposes
    public static DBManager getInstance(String source, String url, String userid, String passwd) throws PenielException {
        if (dbmgr_ == null) {
            dbmgr_ = new DBManager();
            dbmgr_.initialize(source, url, userid, passwd);
        }

        return dbmgr_;
    }

    /**
     * @throws PenielException
     */
    private DBManager() throws PenielException {
    }

    public String getDbUserId() {
        return userId_;
    }

    public String getDbPasswd() {
        return passwd_;
    }

    public String getDbUrl() {
        return url_;
    }

    public Connection getBlobConnection() {
        return blobConnection_;
    }

    public Connection getPDBConnection() throws PenielException {
        Stack<Connection> stk = null;
        if (!initialized_) {
            throw (new PenielException("DBManager for " + sourceName_ + " has not been initialized"));
        }

        Connection conn = null;
        if (dbConnPool_.containsKey(sourceName_)) {
            stk = dbConnPool_.get(sourceName_);
            if (stk.size() == 0) {
                while (stk.size() == 0) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("Interrupted in wait");
                    }
                    System.out.println(stk.size() + " <==================  Here are the number of connections in the stack");

                    stk = dbConnPool_.get(sourceName_);

                    System.out.println(stk.size() + " <==================  Here are the number of connections after the stack was filled");
                }
            }
            conn = (Connection) stk.pop();
            //System.out.println("Connection popped balance="+stk.size());

            // Check to see it is it stale.
            try {
                Statement stmt = conn.createStatement();
                stmt.execute("select 1 from dual");
                stmt.close();

            } catch (Exception e) {
                try {
                    conn.close();
                } catch (Exception e1) {
                    System.out.println("Error in closing conn");
                }
                try {
                    String dburl = "";
                    StringTokenizer st = new StringTokenizer(url_, ",");
                    if (st != null && st.hasMoreTokens()) {
                        dburl = st.nextToken();
                        userId_ = st.nextToken();
                        passwd_ = st.nextToken();
                    }


                    conn = DriverManager.getConnection(dburl, userId_, passwd_);


                } catch (Exception e2) {
                    e2.printStackTrace();
                }

            }

            // dbConnPoolUsed_.put(sourceName_, conn);

            return conn;
        }

        //System.out.println(" DBMgr:  Before getting the url");
        if (url_ == null) {
            System.out.println("DBManager : URL not set");
            throw new PenielException("DBManager: Url is NULL");
        }
        String dburl = null;
        try {
            StringTokenizer st = new StringTokenizer(url_, ",");
            if (st != null && st.hasMoreTokens()) {
                dburl = st.nextToken();
                userId_ = st.nextToken();
                passwd_ = st.nextToken();
            }

            int atIndex = dburl.indexOf('@') + 1;
            dbInstanceName_ = dburl.substring(atIndex);
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException when trying " + " to parse url " + url_);
            throw (new PenielException(ex, "NoSuchElementException when trying " +
                    " to parse url from " + url_));
        }

        stk = new Stack<Connection>();


        try {
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        	DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection conn1 = DriverManager.getConnection(dburl, userId_, passwd_);
                stk.push(conn1);
            }
            blobConnection_ = DriverManager.getConnection(dburl, userId_, passwd_);
        } catch (Exception ex) {
            System.out.println("Exception trying to get DB connection." + "Details : " + userId_ + " " + passwd_ + " " + url_);

            throw (new PenielException(ex, "Exception trying to get DB connection." +
                    "Details : " + userId_ + " " + passwd_ + " " + url_));
        }

        conn = stk.pop();

        dbConnPool_.put(sourceName_, stk);
        // dbConnPoolUsed_.put(sourceName_, conn);

        //System.out.println(" OBTAINED CONNECTION  bal left = "+stk.size());
        if (conn == null)
            System.out.println(" NULL CONNECTION");

        return conn;
    }

    public Connection getPDBConnection(String source) throws PenielException {
    	
        Stack<Connection> stk = null;
        if (!initialized_) {
            throw (new PenielException("DBManager for  has not been initialized"));
        }

        Connection conn = null;

        if (dbConnPool_.containsKey(source)) {
            stk = dbConnPool_.get(source);

            if (stk.size() == 0) {
                /*while (stk.size() == 0) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("Interrupted in wait");
                    }
                    stk = dbConnPool_.get(source);
                }*/
            } else {


            conn = (Connection) stk.pop();
            System.out.println("Connection Popped Bal left=======ui========>>>>>>>"+stk.size());
           //  System.out.println(conn + "  ********************  This is the connection *********************");
            // Check to see it is it stale.


            try {


                Statement stmt = conn.createStatement();
                stmt.execute("select 1 from dual");
                stmt.close();

//            	 System.out.println("****************** Here is testing the connection ***********************");
            } catch (Exception e) {
                try {
                    //System.out.println(conn);
                    //System.out.println("****************** CLOSING CONNECTION IN CATCH ***********************");
                    conn.close();

                } catch (Exception e1) {
                    System.out.println("Error in closing conn");
                }


                try {
                    String dburl = "";
                    StringTokenizer st = new StringTokenizer(url_, ",");
                    if (st != null && st.hasMoreTokens()) {
                        dburl = st.nextToken();
                        userId_ = st.nextToken();
                        passwd_ = st.nextToken();
                    }

                    conn = DriverManager.getConnection(dburl, userId_, passwd_);
                    stk = new Stack<Connection>();
                    stk.push(conn);
                    


                } catch (Exception e2) {
                    e2.printStackTrace();
                }

            }

            // dbConnPoolUsed_.put(source,conn);
            //System.out.println("EXISTING CONNECTION OBTAINED");
            return conn;
            }
        }

        //System.out.println(" DBMgr:  conn :"+conn); 
        if (url_ == null) {
            System.out.println("DBManager : URL not set");
            throw new PenielException("DBManager: Url is NULL");
        }
        String dburl = null;
        try {
            StringTokenizer st = new StringTokenizer(url_, ",");
            if (st != null && st.hasMoreTokens()) {
                dburl = st.nextToken();
                userId_ = st.nextToken();
                passwd_ = st.nextToken();
            }

            int atIndex = dburl.indexOf('@') + 1;
            dbInstanceName_ = dburl.substring(atIndex);
        } catch (NoSuchElementException ex) {
            System.out.println("NoSuchElementException when trying " + " to parse url " + url_);
            throw (new PenielException(ex, "NoSuchElementException when trying " +
                    " to parse url from " + url_));
        }

        stk = new Stack<Connection>();
        try {
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        	DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection conn1 = DriverManager.getConnection(dburl, userId_, passwd_);
                stk.push(conn1);
            }

            blobConnection_ = DriverManager.getConnection(dburl, userId_, passwd_);
            System.out.println("NEW CONNECTION OBTAINED");
        } catch (Exception ex) {
            System.out.println("Exception trying to get DB connection." + "Details : " + userId_ + " " + passwd_ + " " + url_);

            throw (new PenielException(ex, "Exception trying to get DB connection." +
                    "Details : " + userId_ + " " + passwd_ + " " + url_));
        }


        conn = (Connection) stk.pop();
       // System.out.println("Connection Popped Bal ui in get connection left="+stk.size());
        dbConnPool_.put(source, stk);

        //  dbConnPoolUsed_.put(source, conn);


        if (conn == null)
            System.out.println(" NULL CONNECTION");

        return conn;
    }

    private void createBlobs() throws PenielException {
        if (blobPool_ == null)
            blobPool_ = new HashMap<String, Vector<BLOB>>();

        if (!blobPool_.containsKey(sourceName_))
            blobPool_.put(sourceName_, new Vector<BLOB>());

        Connection conn = getPDBConnection();

        Vector<BLOB> blobList = blobPool_.get(sourceName_);
        for (int i = 0; i < BLOB_POOL_SIZE; i++) {
            try {
                oracle.sql.BLOB blob = oracle.sql.BLOB.createTemporary(conn, true,
                        oracle.sql.BLOB.DURATION_SESSION);
                blobList.add(blob);
            } catch (java.sql.SQLException ex) {
                throw (new PenielException(ex, "Exception creating BLOBs in DBManager"));
            }
        }
    }

    public oracle.sql.BLOB getBlob() throws PenielException {
        oracle.sql.BLOB blob = null;
        try {
            Vector<BLOB> blobList = null;
            if (blobPool_ != null)
                blobList = blobPool_.get(sourceName_);

            if (blobList == null || blobList.size() < 1) {
                createBlobs();
                blobList = blobPool_.get(sourceName_);
            }

            blob = blobList.remove(0);
            //System.out.println("Getting another blob from the pool");
            //blob.open(oracle.sql.BLOB.MODE_READWRITE);
            //System.out.println("Opened the blob obtained from the pool");
        } catch (Exception ex) {
            throw (new PenielException(ex, "Exception obtaining BLOB in DBManager"));
        }

        return blob;
    }

    public void releaseBlob(oracle.sql.BLOB blob) throws PenielException {
        try {
            Vector<BLOB> blobList = blobPool_.get(sourceName_);
            //System.out.println("Closing blob in releaseBlob");
            if (blobList != null)
                blobList.add(blob);
            blob.trim(0);
            //blob.close();
            //System.out.println("Adding the blob back to the Blob Pool.");

        } catch (java.sql.SQLException ex) {
            throw (new PenielException(ex, "Exception releasing BLOB in DBManager"));
        }
    }

    public void releaseConnection(String source, Connection conn) {
        Stack<Connection> stk = null;
        if (dbConnPool_.containsKey(source)) {

            //System.out.println(conn + "  *****************************  This is releasing the connection  *********************");

            try {
                if (conn.isClosed()) {
                    System.out.println("**** releaseConnection:  The connection is closed.  ********");
                }
            } catch (SQLException e3) {
                // TODO Auto-generated catch block
                System.out.println("******  Catch to see if connection isClosed  ********");
                e3.printStackTrace();
            }


            try {


                Statement stmt = conn.createStatement();
                stmt.execute("select 1 from dual");
                stmt.close();


//	            	 System.out.println("****************** Here is testing the connection ***********************");
            } catch (Exception e) {
                try {
                    //System.out.println(conn);
                    //System.out.println("****************** CLOSING CONNECTION IN CATCH ***********************");
                    conn.close();

                } catch (Exception e1) {
                    System.out.println("Error in closing conn");
                }


                try {
                    String dburl = "";
                    StringTokenizer st = new StringTokenizer(url_, ",");
                    if (st != null && st.hasMoreTokens()) {
                        dburl = st.nextToken();
                        userId_ = st.nextToken();
                        passwd_ = st.nextToken();
                    }


                    conn = DriverManager.getConnection(dburl, userId_, passwd_);


                } catch (Exception e2) {
                    e2.printStackTrace();
                }

            }

            stk = (Stack<Connection>) dbConnPool_.get(source);
            System.out.println(source+"==============imaging========= > "+dbConnPool_.get(source) );
            stk.push(conn);
            dbConnPool_.put(source, stk);
            // dbConnPoolUsed_.remove(source);

           System.out.println("Connection Released =====ui release connection================== > " + stk.size());
        }
    }

    public static void main(String[] args) {
        try {
            DBManager rec = new DBManager();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

} 
