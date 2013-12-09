
package ComparatorClasses;

import decanat.Student;
import java.util.Comparator;


public class SortedByGradePointAverageComparator implements Comparator <Student> {
    private Student s1;
    private Student s2;
    public SortedByGradePointAverageComparator(){
        
    }
    public SortedByGradePointAverageComparator(Student as1, Student as2){
        this.s1=as1;
        this.s2=as2;
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

    /**
     * @return the s1
     */
    public Student getS1() {
        return s1;
    }

    /**
     * @param s1 the s1 to set
     */
    public void setS1(Student s1) {
        this.s1 = s1;
    }

    /**
     * @return the s2
     */
    public Student getS2() {
        return s2;
    }

    /**
     * @param s2 the s2 to set
     */
    public void setS2(Student s2) {
        this.s2 = s2;
    }
   
}
