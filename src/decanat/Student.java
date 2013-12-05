package decanat;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "students")
public class Student implements Serializable {

    private String lastName = "";

    private String firstName = "";
    private static int nextId = 1;
    private Integer id = 0;
    private Integer groupNumber = 0;
    private Double gradePointAverage = 0.0;

    public Student() {
    }

    public Student(Integer id, String lastName, String firstName, Integer groupNumber, double gradePointAverage) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.groupNumber = groupNumber;
        this.gradePointAverage = gradePointAverage;
    }

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "GROUP_NUMBER")
    @ManyToOne(cascade = CascadeType.ALL)
    public Integer getGroupNumber() {
        return groupNumber;
    }

    @Column(name = "GPA")
    public Double getGradePointAverage() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setGradePointAverage(Double gradePointAverage) {
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

    @Override

    public int hashCode() {

        int hash = 0;

        hash += (id != null ? id.hashCode() : 0);

        return hash;

    }

    @Override

    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {

            return false;

        }

        Student other = (Student) object;

        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {

            return false;

        }

        return true;

    }

}
