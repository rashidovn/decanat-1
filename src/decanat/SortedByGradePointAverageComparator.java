
package decanat;

import java.util.Comparator;


public class SortedByGradePointAverageComparator implements Comparator <Student> {
    private Student p1;
    private Student p2;
    public SortedByGradePointAverageComparator(){
        
    }
    public SortedByGradePointAverageComparator(Student p1, Student p2){
        this.p1=p1;
        this.p2=p2;
    }
        
    @Override
    public int compare(Student o1, Student o2) {
        double gpa1 = o1.getGradePointAverage();
        double gpa2 = o2.getGradePointAverage();
        if (gpa1<gpa2)
            return 1;
        else if (gpa2>gpa1)
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
