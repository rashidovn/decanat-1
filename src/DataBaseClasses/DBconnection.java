/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class DBconnection {

    private static Connection conn = null;
    private static int iTimeout = 20;
    private static DBconnection db = null;
    //public static String url = "C:/Users/Roma/Documents/NetBeansProjects/db.db";

    public static synchronized DBconnection getUniqueInstance() {
        if (db == null) {
            db = new DBconnection();
            return db;
        } else {
            return db;
        }
    }

    public static synchronized void openConnection() {
        try {
            String user = "root";
            String password = "admin";
            String url = "jdbc:mysql://localhost:3306/decanat?zeroDateTimeBehavior=convertToNull";
            Class.forName("com.mysql.jdbc.Driver");
            if (conn == null) {
                conn= DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static synchronized void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the conn
     */
    public static Connection conn() {
        return conn;
    }

    /**
     * @param aConn the conn to set
     */
    public static void setConn(Connection aConn) {
        conn = aConn;
    }

    /**
     * @return the iTimeout
     */
    public static int getiTimeout() {
        return iTimeout;
    }

    /**
     * @param aiTimeout the iTimeout to set
     */
    public static void setiTimeout(int aiTimeout) {
        iTimeout = aiTimeout;
    }

    /**
     * @return the db
     */
    public static DBconnection getDb() {
        return db;
    }

    /**
     * @param aDb the db to set
     */
    public static void setDb(DBconnection aDb) {
        db = aDb;
    }
}
