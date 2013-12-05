/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import decanat.Groups;
import java.util.List;
import org.hibernate.Session;
import decanat.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import hibernate.HibernateUtil;

/**
 *
 * @author Roma
 */
public class DAOImplementation implements StudentDAO,GroupsDAO {

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
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
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
                Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
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

    @Override
    public void insertGroup(Groups group) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Input/output error");
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateGroup(Groups group) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(group);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Input/output error");
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

  
 
    @Override
    public Groups getGroupById(Integer id) throws SQLException {
         Session session = null;
        Groups group = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            group = (Groups) session.load(Student.class, id);
        } catch (Exception e) {
            System.out.println("Input/output error");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return group;
    }

    @Override
    public List getAllGroups() throws SQLException {
       Session session = null;
       List<Groups> groups = new ArrayList<Groups>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            groups = session.createCriteria(Groups.class).list();
        } catch (Exception e) {
            System.out.println("Input/output error");
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;
    }

    @Override
    public void deleteGroup(Groups group) throws SQLException {
         Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(group);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Input/output error");
            Logger.getLogger(DAOImplementation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
