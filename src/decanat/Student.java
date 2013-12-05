package decanat;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "JoinTableStudent")
@Table(name ="STUDENT")
public class Student implements Serializable {
    private static final long serialVersionUID = -6790693372846798580L;
    private String lastName = "";
    private String firstName = "";
    private Integer id = 0;
    private Double gradePointAverage = 0.0;
    private Groups groupNumber=null;

    public Student(Integer id, String lastName, String firstName, Double gradePointAverage, Groups groupNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gradePointAverage = gradePointAverage;
        this.groupNumber=groupNumber;
    }
   
    public Student() {
    }
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
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
         
     
      @ManyToOne
    @JoinColumn(name="GROUP_NUMBER")
    public Groups getgroupNumber() {
        return groupNumber;
    }
     
     
     @Column(name = "GPA")
    public Double getGradePointAverage() {
        return gradePointAverage;
    }

     
     
     
     
    @Override
    public String toString() {
        return " ID: " + getId() + ", LastName: " + getLastName() + ", first name: " + getFirstName() + ", Group: " + ", GPA= " + String.format("%4.2f", getGradePointAverage());
    }

   public void setId(Integer id) {
        this.id = id;
    }
    public void setId() {
        this.id = id;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGradePointAverage(Double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
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
