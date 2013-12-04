package decanat;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ID")
    private Integer id = 0;

    @Column(name = "LAST_NAME")
    private String lastName = "";

    @Column(name = "FIRST_NAME")
    private String firstName = "";

    @Column(name = "GROUP_NUMBER")
    private Integer groupNumber = 0;

    @Column(name = "GPA")
    private Double gradePointAverage = 0.0;

    private static Integer nextId = 1;

    public Student(Integer id, String lastName, String firstName, Integer groupNumber, Double gradePointAverage) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.groupNumber = groupNumber;
        this.gradePointAverage = gradePointAverage;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

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
    public static Integer getNextId() {
        return nextId;
    }

    /**
     * @param aNextId the nextId to set
     */
    public static void setNextId(Integer aNextId) {
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
