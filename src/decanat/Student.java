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

@Entity
@Table(name ="students")
public class Student implements Serializable {
    private static final long serialVersionUID = -6790693372846798580L;
    private String lastName = "";
    private String firstName = "";
    private Integer id = 0;
    private Double gradePointAverage = 0.0;
    private Groups groupNumber=null;

    public Student(String firstName, String lastName,  Double gradePointAverage ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gradePointAverage = gradePointAverage;
        
    }
   
    public Student() {
    }
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    public Integer getId() {
        return id;
    }
     @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }
     
    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }
    
      @ManyToOne
	@JoinColumn(name="group_id",insertable=false, updatable=false,nullable=false)
    public Groups getgroupNumber() {
        return groupNumber;
    }
     
     
     @Column(name = "gpa")
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
   
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGradePointAverage(Double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

     public void setGroupNumber(Groups groupNumber) {
        this.groupNumber= groupNumber;
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
