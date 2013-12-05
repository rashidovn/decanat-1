package ComparatorClasses;

import decanat.Student;
import java.util.Comparator;

public class SortedByGroupComparator implements Comparator<Student> {

    private Student s1;
    private Student s2;

    public SortedByGroupComparator() {
    }

    public SortedByGroupComparator(Student s1, Student s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public int compare(Student s1, Student s2) {
        int grp1 = s1.getGroupNumber();
        int grp2 = s2.getGroupNumber();
        if (grp1 > grp2) {
            return 1;
        } else if (grp2 < grp1) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @return the s1
     */
    public Student getStudent1() {
        return s1;
    }

    /**
     * @param s1 the s1 to set
     */
    public void setStudent1(Student s1) {
        this.s1 = s1;
    }

    /**
     * @return the s2
     */
    public Student getStudent2() {
        return s2;
    }

    /**
     * @param s2 the s2 to set
     */
    public void setStudent2(Student s2) {
        this.s2 = s2;
    }
}
