/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import java.io.File;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Roma
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
   
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
             File file = new File("src/DataBaseClasses/hibernate.cfg.xml");
            sessionFactory = new Configuration().configure(file).buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
