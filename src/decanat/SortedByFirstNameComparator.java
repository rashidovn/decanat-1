
package decanat;

import java.util.Comparator;


public class SortedByFirstNameComparator implements Comparator<Student>{
    
    private Student p1;
    private Student p2;
    public SortedByFirstNameComparator(){
        
    }
    public SortedByFirstNameComparator(Student p1, Student p2){
        this.p1=p1;
        this.p2=p2;
    }
    
    @Override
    public int compare(Student p1, Student p2) {
        String str1 = p1.getFirstName();
        String str2 = p2.getFirstName();
        return str1.compareTo(str2);
    }
    public Student getPerson1(){
        return p1;
    }
    public Student getPerson2(){
        return p2;
    }
    public void setPerson1(Student p1){
        this.p1=p1;
    }
    public void setPerson2(Student p2){
        this.p2=p2;
    }
    
}

