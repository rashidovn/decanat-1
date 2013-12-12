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
    private static GroupDAO groupDAO=null;
       private static Factory instance = null;

       public static synchronized Factory getInstance(){
             if (instance == null){
               instance = new Factory();
             }
             return instance;
       }

       public StudentDAO getStudentDAO(){
             if (studentDAO == null){
               studentDAO = new StudentDAOImpl();
             }
             return studentDAO;
       }  
       public GroupDAO getGroupDAO(){
             if (groupDAO == null){
               groupDAO = new GroupDAOImpl();
             }
             return groupDAO;
       }  
}
