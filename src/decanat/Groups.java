/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decanat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author roman.romanyuk
 */
@Entity
@Table(name = "groups")
public class Groups implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;
    
    private Integer id = 0;
    private Integer groupNumber = 0;
   
    
    
    private Set<Student> students;

    public Groups(Integer id, Integer groupNumber) {
        this.id = id;
        this.groupNumber = groupNumber;
    }

    public Groups() {
    }
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "GROUP_NUMBER")
    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }
     
     @OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="group_id")
	@IndexColumn(name="idx")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
