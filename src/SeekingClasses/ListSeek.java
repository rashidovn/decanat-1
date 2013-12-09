/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SeekingClasses;

import decanat.Student;
import java.util.ArrayList;

/**
 *
 * @author Roma
 */
public class ListSeek {
     private ArrayList<Student> seekedList = new ArrayList<>();
      
     
    public ListSeek(){
        
    }
      
      public ArrayList<Student> seekByLastName(ArrayList<Student>seekingList, String field ){
         
        for (Student st: seekingList){
            if (st.getLastName().equals(field))
                seekedList.add(st);
        }
         return seekedList;
       }
      
      public ArrayList<Student> seekFirstName(ArrayList<Student>seekingList, String field ){
          for (Student st: seekingList){
            if (st.getFirstName().equals(field))
                seekedList.add(st);
        }
         return seekedList;
      }
      public ArrayList<Student> seekGroupNumber(ArrayList<Student>seekingList, int iField ){
          for (Student st: seekingList){
          if (st.getGroupNumber()==(iField))
                seekedList.add(st);
        }
         return seekedList;
      }
      
    
 public ArrayList<Student> getSeekedList() {
        return  seekedList;
    }
 
  public void setSeekedList(ArrayList<Student> seekedList) {
        this.seekedList=seekedList;
    }


    public void showSeekedList() {
            for (Student p : seekedList) {
            System.out.println(p);
        }

    }

@Override
    public String toString() {
        Student p = new Student();
        return " ID: " + p.getId() + ", LastName: " + p.getLastName() + ", first name: " + p.getFirstName() + ", Group: " + p.getGroupNumber() + ", GPA= " + String.format("%4.2f", p.getGradePointAverage());
    }


}
    

