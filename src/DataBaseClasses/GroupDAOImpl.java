/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import decanat.Groups;
import decanat.Student;
import hibernate.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Roma
 */
public class GroupDAOImpl implements GroupDAO {
    
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
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
