package hibernate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Roma
 */
import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {

   
 private static final SessionFactory sessionFactory = buildSessionFactory();
 
    private static SessionFactory buildSessionFactory() {
        try {
             File file = new File("src/hibernate/hibernate.cfg.xml");
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure(file).buildSessionFactory();
 
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }
 
}