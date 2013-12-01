
package decanat;

import java.util.Comparator;
import java.util.Objects;


public class SortedByLastNameComparator implements Comparator <Student>{
    private Student p1;
    private Student p2;
    public SortedByLastNameComparator(Student p1, Student p2){
        this.p1=p1;
        this.p2=p2;
    }
    public SortedByLastNameComparator(){
        
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
    @Override
    public int compare(Student p1, Student p2){
        String str1 = p1.getLastName();
        String str2 = p2.getLastName();
        return str1.compareTo(str2);
    }

}
