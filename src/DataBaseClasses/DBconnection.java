/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

   public static synchronized void createTables() {
        String createTableStudents = "CREATE TABLE IF NOT EXISTS `students` (" +
"`students_id` INTEGER NOT NULL AUTO_INCREMENT," +
"`firstname` VARCHAR(50) NULL DEFAULT NULL," +
"`lastname` VARCHAR(50) NULL DEFAULT NULL," +
"`gpa` REAL NULL DEFAULT NULL, " +
"`group_id` INTEGER(20) NULL DEFAULT NULL," +
"`idx` INT(11) NULL DEFAULT NULL," +
"PRIMARY KEY (`students_id`)," +
"INDEX `FK_GROUP` (`group_id`), " +
"CONSTRAINT `FK_GROUP` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`) ) " +
"COLLATE='latin1_swedish_ci'" +
"ENGINE=InnoDB " +
"ROW_FORMAT=DEFAULT";
                //+ " FOREIGN KEY (GROUP_NUMBER) REFERENCES groups (GROUP_ID))";

        String createTableGroups =
        "CREATE TABLE IF NOT EXISTS `groups` ( `group_id` INTEGER(20) NOT NULL AUTO_INCREMENT, `group_number` VARCHAR(50) NOT NULL DEFAULT '0',  PRIMARY KEY (`group_id`) ) COLLATE='latin1_swedish_ci' ENGINE=InnoDB " +
"ROW_FORMAT=DEFAULT";
               

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.setQueryTimeout(getiTimeout());
            stmt.executeUpdate(createTableGroups);
            stmt.executeUpdate(createTableStudents);


        } catch (SQLException e) {
             System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
        } finally {
            close(stmt);
        }
    }
    
    
      public static synchronized void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
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
