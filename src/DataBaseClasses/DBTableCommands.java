/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import decanat.Student;
import static DataBaseClasses.DBconnection.getConn;
import static DataBaseClasses.DBconnection.getiTimeout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class DBTableCommands extends DBconnection {

    public static synchronized void createTableStudents() {
        String createString
                = "create table IF NOT EXISTS "
                + "students "
                + "(ID integer NOT NULL , "
                + "LAST_NAME varchar(40) NOT NULL, "
                + "FIRST_NAME varchar(40) NOT NULL, "
                + "GROUP_NUMBER integer NOT NULL, "
                + "GPA double NOT NULL, "
                + "PRIMARY KEY (ID)) ";

        Statement stmt = null;
        try {
            stmt = getConn().createStatement();
            stmt.setQueryTimeout(getiTimeout());
            stmt.executeUpdate(createString);
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(stmt);
        }
    }

    public static synchronized void insertDataToDB() {

        Statement stmt = null;
        try {
            stmt = getConn().createStatement();
            stmt.setQueryTimeout(getiTimeout());
            stmt.executeUpdate(
                    "insert into " + "students "
                    + "values("
                    + "'romaniuk', "
                    + "'roman', "
                    + "101, "
                    + "4.89)");

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(stmt);
        }
    }

    public static synchronized void insertDataToDB(ArrayList<Student> students) {
        for (Student a : students) {
            PreparedStatement pstmt = null;
            String insert = "INSERT INTO 'students' ('LAST_NAME', 'FIRST_NAME', 'GROUP_NUMBER', 'GPA' ) VALUES (?, ?, ?, ? )";
            try {
                pstmt = getConn().prepareStatement(insert);
                pstmt.setQueryTimeout(getiTimeout());
                pstmt.setString(1, a.getLastName());
                pstmt.setString(2, a.getFirstName());
                pstmt.setInt(3, a.getGroupNumber());
                pstmt.setDouble(4, a.getGradePointAverage());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(pstmt);
            }

        }

    }

    public static ArrayList<Student> getDataFromDB() {

        ArrayList<Student> result = new ArrayList<>();
        
        Statement stmt = null;
        ResultSet rslt = null;

        try {

            String showBase = "select students.group_number from students "
                    + "where students.GROUP_NUMBER=3 ";
            stmt = getConn().createStatement();
            rslt = stmt.executeQuery(showBase);

            while (rslt.next()) {

                Student std = new Student();
                std.setId(rslt.getInt("ID"));
                std.setLastName(rslt.getString("LAST_NAME"));
                std.setFirstName(rslt.getString("FIRST_NAME"));
                std.setGroupNumber(rslt.getInt("GROUP_NUMBER"));
                std.setGradePointAverage(rslt.getDouble("GPA"));

                result.add(std);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
        close(rslt);
        close(stmt);

        return result;

    }

    public static synchronized void dropDB() {
        Statement stmt = null;
        try {
            stmt = getConn().createStatement();

            String sDropTable = "DROP TABLE 'students'";
            stmt.executeUpdate(sDropTable);

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
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

    public static synchronized void close(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized void close(ResultSet rslt) {
        try {
            if (rslt != null) {
                rslt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
