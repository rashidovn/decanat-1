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
        if (getDb() == null) {
            setDb(new DBconnection());
            return getDb();
        } else {
            return getDb();
        }
    }

    public static synchronized void openConnection() {
        try {
            String user = "root";
            String password = "admin";
            String url = "jdbc:sqlite:C:/Documents and Settings/RARomanyuk/Мои документы/NetBeansProjects/decanatdb.db ";
            Class.forName("org.sqlite.JDBC");
            if (getConn() == null) {
                setConn(DriverManager.getConnection(url, user, password));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static synchronized void closeConnection() {
        try {
            if (getConn() != null) {
                getConn().close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the conn
     */
    public static Connection getConn() {
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
