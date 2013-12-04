/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import java.util.List;
import org.hibernate.Session;
import decanat.HibernateUtil;
import decanat.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class DBCommands implements ActionMethods {

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
            Logger.getLogger(DBCommands.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

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
            Logger.getLogger(DBCommands.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

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
            Logger.getLogger(DBCommands.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public synchronized void insertStudent(ArrayList<Student> students) {
        for (Student s : students) {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(s);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Input/output error");
                Logger.getLogger(DBCommands.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }

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
            Logger.getLogger(DBCommands.class.getName()).log(Level.SEVERE, null, e);
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
