
package decanat;

import java.util.Comparator;


public class SortedByGroupComparator implements Comparator<Student>{
    
    private Student p1;
    private Student p2;
    public SortedByGroupComparator(){
        
    }
    public SortedByGroupComparator(Student p1, Student p2){
        this.p1=p1;
        this.p2=p2;
    }
   @Override
    public int compare(Student p1, Student p2) {
    int grp1 = p1.getGroupNumber();
        int grp2 = p2.getGroupNumber();
        if (grp1>grp2)
            return 1;
        else if (grp2<grp1)
            return -1;
        else
        return 0;
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
    
   

