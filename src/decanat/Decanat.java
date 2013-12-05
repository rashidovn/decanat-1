package decanat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Decanat {

    public Decanat() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserChoiceMenu menu = new UserChoiceMenu();
        menu.MenuSelect();
   
    
    
    
    
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
