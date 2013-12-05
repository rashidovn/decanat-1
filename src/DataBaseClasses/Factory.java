    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

/**
 *
 * @author Roma
 */
public class Factory {
    private static StudentDAO studentDAO = null;
       private static Factory instance = null;

       public static synchronized Factory getInstance(){
             if (instance == null){
               instance = new Factory();
             }
             return instance;
       }

       public StudentDAO getStudentDAO(){
             if (studentDAO == null){
               studentDAO = new DAOImplementation();
             }
             return studentDAO;
       }  
}
