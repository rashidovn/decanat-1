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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.AnnotationConfiguration;  
  
public class HibernateUtil {  
  
 private static final SessionFactory sessionFactory = buildSessionFactory();  
 public static final Log logger = LogFactory.getLog(HibernateUtil.class
      .getName());
  
 private static SessionFactory buildSessionFactory() {  
  try {  
   File file = new File("src/hibernate/hibernate.cfg.xml");
      // Create the SessionFactory from hibernate.cfg.xml  
   return new AnnotationConfiguration().configure(file)  
     .buildSessionFactory();  
  
  } catch (Throwable ex) {  
   logger.error("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
  }  
 }  
  
 public static SessionFactory getSessionFactory() {  
  return sessionFactory;  
 }  
}  
 