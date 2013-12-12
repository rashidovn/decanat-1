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
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 

 public class HibernateUtil {
     private static SessionFactory sessionFactory = null;
     private static ServiceRegistry serviceRegistry;  
      
     static {
         try {
             File file = new File("src/hibernate/hibernate.cfg.xml");
             Configuration configuration = new Configuration();
             configuration = new Configuration().configure(file);

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException he)
        {
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    } 
}