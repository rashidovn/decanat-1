/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import java.util.List;
import org.hibernate.Session;
import decanat.HibernateUtil;
import decanat.Student;
import static DataBaseClasses.DBconnection.getConn;
import static DataBaseClasses.DBconnection.getiTimeout;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class DBCommands extends DBconnection implements ActionMethods {

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
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBCommands.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // creates table students
        public synchronized void createTableStudents() {
        String createString
                = "create table IF NOT EXISTS "
                + "'students' "
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
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBCommands.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //

    /**
     * manual insertion entry to a table "students" 
     */
    

    /**
     *
     * @param student
     * @throws SQLException
     */
    @Override
    public synchronized void insertStudent(Student student) throws SQLException {
     Session session = null;
             try {
                 session = HibernateUtil.getSessionFactory().openSession();
                 session.beginTransaction();
                 session.save(student);
                 session.getTransaction().commit();
             } catch (Exception e) {
                 System.out.println("Input/output error");
             } finally {
                 if (session != null && session.isOpen()) {
                     session.close();
                 }
             } 
    }
        
   

    /**
     *
     * @param student
     * updates student's data
     * @throws SQLException
     */
    @Override
    public synchronized void updateStudent(Student student) throws SQLException {
             Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(student);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Input/output error");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
     

    }

    /**
     *delete
     * @param student
     * from DB
     * @throws SQLException
     */
    @Override
    public void deleteStudent(Student student) throws SQLException {
        Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(student);
                session.getTransaction().commit();
            } catch (Exception e) {
               System.out.println("Input/output error");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }  

    
    @Override
    public List getAllStudents() {

       Session session = null;
            List<Student> students = new ArrayList<Student>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                students = session.createCriteria(Student.class).list();
            } catch (Exception e) {
                System.out.println("Input/output error");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
           
        return students;

    }

    @Override
    public Student getStudentById(Integer id) throws SQLException {
        Session session = null;
            Student student = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                student = (Student) session.load(Student.class, id);
            } catch (Exception e) {
                System.out.println("Input/output error");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return student;

    }
    
    
}
