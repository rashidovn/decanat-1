/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decanat;


import DataBaseClasses.DAOImplementation;
import DataBaseClasses.Factory;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class UserChoiceMenu {

    private Student student = new  Student();
   
    
    

    public UserChoiceMenu() {
    }

    public void MenuSelect() throws IOException, ClassNotFoundException {
        DAOImplementation dao = new DAOImplementation();
            
                Student s1 = new Student();
    s1.setLastName("romaniuk");
    s1.setFirstName("Roman");
    s1.setGradePointAverage(4.89);
    
 
        Student s2 = new Student();
        s1.setLastName("Ivanov");
        s1.setFirstName("Ivan");
        s1.setGradePointAverage(4.5);
        
        
        //Add new Employee object
        Groups gr = new Groups();
        gr.setGroupNumber(104);
        
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
 
        gr.setStudents(students);   
        try {
            Factory.getInstance().getStudentDAO().insertStudent(students);
                       
                       //System.out.println(dao.getAllStudents());
        } catch (SQLException ex) {
            Logger.getLogger(UserChoiceMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            
           
        
   
    
     
    
    
    
    }

    /**
     * @return the listSort
     */
    
    public void showListFromDB() {
        List result = null;
        try {
            result = Factory.getInstance().getStudentDAO().getAllStudents();
        } catch (SQLException ex) {
            Logger.getLogger(UserChoiceMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Object r: result)
            System.out.println(r);
        
    }
    /**
     * @return the dataIO
     */
    
    
    
    
    
}
