package ComparatorClasses;

import decanat.Student;
import java.util.Comparator;

public class SortedByLastNameComparator implements Comparator<Student> {

    private Student s1;
    private Student s2;

    public SortedByLastNameComparator(Student s1, Student s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public SortedByLastNameComparator() {
    }

    @Override
    public int compare(Student p1, Student p2) {
        String str1 = p1.getLastName();
        String str2 = p2.getLastName();
        return str1.compareTo(str2);
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
