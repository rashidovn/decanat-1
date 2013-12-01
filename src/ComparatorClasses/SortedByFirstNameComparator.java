
package ComparatorClasses;

import decanat.Student;
import java.util.Comparator;


public class SortedByFirstNameComparator implements Comparator<Student>{
    
    private Student s1;
    private Student s2;
    public SortedByFirstNameComparator(){
        
    }
    public SortedByFirstNameComparator(Student s1, Student s2){
        this.s1=s1;
        this.s2=s2;
    }
    
    @Override
    public int compare(Student s1, Student s2) {
        String str1 = s1.getFirstName();
        String str2 = s2.getFirstName();
        return str1.compareTo(str2);
    }
    public Student getPerson1(){
        return s1;
    }
    public Student getPerson2(){
        return s2;
    }
    public void setPerson1(Student s1){
        this.s1=s1;
    }
    public void setPerson2(Student s2){
        this.s2=s2;
    }
    
}

