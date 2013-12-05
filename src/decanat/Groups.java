/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decanat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author roman.romanyuk
 */
@Entity(name = "JoinTableGroups")
@Table(name = "GROUPS", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID"),
@UniqueConstraint(columnNames = "GROUP_NUMBER")})
public class Groups implements Serializable {
    private static final long serialVersionUID = -1798070786993154676L;
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id=0;
    
    @Column(name = "GROUP_NUMBER")
    private Integer groupNumber=0;
    
    @OneToMany(mappedBy="groupNumber")
    private List<Student> students;
    
    public Groups (Integer id, Integer groupNumber){
        this.id=id;
        this.groupNumber=groupNumber;
    }
    public Groups(){
    }
        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    


}
