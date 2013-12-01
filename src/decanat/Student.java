package decanat;

import java.io.Serializable;

public class Student implements Serializable {

    private String lastName = "";
    private String firstName = "";
    private static int nextId = 1;
    private int id = 0;
    private int groupNumber = 0;
    private double gradePointAverage = 0;

    public Student(int id, String lastName, String firstName, int groupNumber, double gradePointAverage) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.groupNumber = groupNumber;
        this.gradePointAverage = gradePointAverage;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    @Override
    public String toString() {
        return " ID: " + getId() + ", LastName: " + getLastName() + ", first name: " + getFirstName() + ", Group: " + getGroupNumber() + ", GPA= " + String.format("%4.2f", getGradePointAverage());
    }

    public void setId() {
        setId(getNextId());
        setNextId(getNextId() + 1);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    /**
     * @return the nextId
     */
    public static int getNextId() {
        return nextId;
    }

    /**
     * @param aNextId the nextId to set
     */
    public static void setNextId(int aNextId) {
        nextId = aNextId;
    }
}
