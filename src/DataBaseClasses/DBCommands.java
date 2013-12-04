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
public class DBCommands extends DBconnection {

    // creates DB

    /**
     *
     */
    public synchronized void createDB() {
        String createString
                = "DROP DATABASE IF EXISTS db"
                +" CREATE DATABASE db ";
        

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
    
    // creates table students
        public synchronized void createTableStudents() {
        String createString
                = "create table IF NOT EXISTS "
                + "'students' "
                + "(ID integer NOT NULL, "
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
    //

    /**
     * manual insertion entry to a table "students" 
     */
        public synchronized void insertDataToDB() {

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

    /**
     *
     * @param student
     * @throws SQLException
     */
    public synchronized void insertStudent(Student student) throws SQLException {
        PreparedStatement pstmt = null;
        String insert = "INSERT INTO 'students' ('LAST_NAME', 'FIRST_NAME', 'GROUP_NUMBER', 'GPA' ) VALUES (?, ?, ?, ? )";
          try {
                pstmt = getConn().prepareStatement(insert);
                pstmt.setQueryTimeout(getiTimeout());
                pstmt.setString(1, student.getLastName());
                pstmt.setString(2, student.getFirstName());
                pstmt.setInt(3, student.getGroupNumber());
                pstmt.setDouble(4, student.getGradePointAverage());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(pstmt);
            }
    }
        
    /**
     *another variant of inserting entry to DB with prepareStatement
     * @param students takes data from console(ArrayList, generated in Parser class)
     */
    public synchronized void insertDataToDB(ArrayList<Student> students) {
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

    /**
     *
     * @param student
     * updates student's data
     * @throws SQLException
     */
    public void updateStudent(Student student) throws SQLException {
        PreparedStatement pstmt = null;
        String insert = "INSERT INTO 'students' SET ('LAST_NAME', 'FIRST_NAME', 'GROUP_NUMBER', 'GPA' ) VALUES (?, ?, ?, ? )";
        try {
                pstmt = getConn().prepareStatement(insert);
                pstmt.setQueryTimeout(getiTimeout());
                pstmt.setString(1, student.getLastName());
                pstmt.setString(2, student.getFirstName());
                pstmt.setInt(3, student.getGroupNumber());
                pstmt.setDouble(4, student.getGradePointAverage());
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                close(pstmt);
            }
    }

    /**
     *delete
     * @param student
     * from DB
     * @throws SQLException
     */
    public void deleteStudent(Student student) throws SQLException {
        PreparedStatement pstmt = null;
        String insert = "INSERT INTO 'students' ('LAST_NAME', 'FIRST_NAME', 'GROUP_NUMBER', 'GPA' ) VALUES (?, ?, ?, ? )";
        try {
            pstmt = getConn().prepareStatement(insert);
            pstmt.setInt(1, student.getId());
            pstmt.execute();
        } finally {
            close(pstmt);
        }
    }


    /**
     *
     * @return 
     * returns ArrayList of students from DB after SELECT request
     */
    public ArrayList getDataFromDB() {

        ArrayList<Student> result = new ArrayList<>();
        Statement stmt = null;
        ResultSet rslt = null;
        Student std = new Student();
        try {

            String showBase = "SELECT ID, LAST_NAME, FIRST_NAME,GROUP_NUMBER,GPA FROM students "
                    + "ORDER BY ID";
            stmt = getConn().createStatement();
            rslt = stmt.executeQuery(showBase);
            
            while (rslt.next()) {

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
        close(rslt);
        close(stmt);

        return result;

    }

    
    
    
    
    
    /**
     *drops DB
     */
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

    /**
     *
     * @param stmt
     */
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
     *
     * @param pstmt
     */
    public static synchronized void close(PreparedStatement pstmt) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param rslt
     */
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
