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
        String createString =
                "create table IF NOT EXISTS "
                + "students "
                + "(id integer NOT NULL , "
                + "LAST_NAME varchar(40) NOT NULL, "
                + "FIRST_NAME varchar(40) NOT NULL, "
                + "GROUP_NUMBER integer NOT NULL, "
                + "GPA double NOT NULL, "
                + "PRIMARY KEY (id)) ";

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

    

    public static synchronized void insertDataToStudentsTable() {

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

    public static synchronized void insertDataToStudentsTable(ArrayList<Student> students) {
        for (Student a : students) {
            String sqlString = "";
            PreparedStatement pstmt = null;
            String insert = "INSERT INTO 'students' ('LAST_NAME', 'FIRST_NAME', 'GROUP_NUMBER', 'GPA' ) VALUES (?, ?, ?, ? )";
            try {
                pstmt = getConn().prepareStatement(insert);
                pstmt.setQueryTimeout(getiTimeout());
                pstmt.setString(2, a.getLastName());
                pstmt.setString(3, a.getFirstName());
                pstmt.setInt(4, a.getGroupNumber());
                pstmt.setDouble(5, a.getGradePointAverage());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(pstmt);
            }

        }

    }

    
    public void insertRowData(Object obj) {
        PreparedStatement pstmt = null;
        ResultSet rslt = null;
        Student std = (Student) obj;
        String insert = "INSERT INTO 'students' ('LAST_NAME', 'FIRST_NAME', 'GROUP_NUMBER', 'GPA' ) VALUES (?, ?, ?, ?, ? )";
        try {

            getConn().prepareStatement(insert);
            pstmt.setString(2, std.getLastName());
            pstmt.setString(3, std.getFirstName());
            pstmt.setInt(3, std.getGroupNumber());
            pstmt.setDouble(3, std.getGradePointAverage());
            pstmt.executeUpdate();
            rslt = pstmt.executeQuery();
            while (rslt.next()) {
                //----------Realization------------//
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(pstmt);
            close(rslt);
        }
    }
    
    
    
    
    
    
    
    public static ArrayList<Student> getResultListFromDB() {

        ArrayList<Student> students = new ArrayList<>();

        Statement stmt = null;
        ResultSet rslt = null;

        try {

            String showBase = "select students.group_number from students "
                    + "where students.group_number=101 ";
            stmt = getConn().createStatement();
            rslt = stmt.executeQuery(showBase);

            while (rslt.next()) {

                Student std = new Student();
                std.setId(rslt.getInt("id"));
                std.setLastName(rslt.getString("last_name"));
                std.setFirstName(rslt.getString("first_name"));
                std.setGroupNumber(rslt.getInt("group_number"));
                std.setGradePointAverage(rslt.getDouble("gpa"));

                students.add(std);
                System.out.println(students);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            close(rslt);
            close (stmt);

            return students;

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
