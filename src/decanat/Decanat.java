package decanat;


import DataBaseClasses.DBconnection;
import DataBaseClasses.Factory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Decanat {

    public Decanat() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
    
        
            //    DBconnection.openConnection();
              //  DBconnection.createTables();
                
              //  DBconnection.closeConnection();
                //DBconnection.dropDB();
        
                
                Groups group = new Groups();
        group.setGroupNumber(104);
        
        
    Student s1 = new Student("Roman","Romaniuk",4.89);
    Student s2 = new Student("Ivan","Ivanov",4.89);
    s1.setGroupNumber(group);
    s2.setGroupNumber(group);
        
        
        
        
 
    
    System.out.println(group);
        try {
            Factory.getInstance().getStudentDAO().insertStudent(s1);
        } catch (SQLException ex) {
            Logger.getLogger(Decanat.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            Factory.getInstance().getStudentDAO().insertStudent(s2);
        } catch (SQLException ex) {
            Logger.getLogger(Decanat.class.getName()).log(Level.SEVERE, null, ex);
        }
    
           List<Student> studs = Factory.getInstance().getStudentDAO().getAllStudents();
         System.out.println("all students");
         for(int i = 0; i < studs.size(); ++i) {
                 System.out.println(",  id : " +studs.get(i).getId()+"Name : " + studs.get(i).getFirstName() +"LastName  : "+studs.get(i).getLastName()+ ", Group : " + studs.get(i).getgroupNumber()+", GPA : "+studs.get(i).getGradePointAverage());
                              
         }      
    
    
    
    
      
   
    
    
    
    }
     
    
}
