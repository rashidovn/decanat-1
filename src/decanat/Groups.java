/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decanat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author roman.romanyuk
 */
@Table(name = "students")
public class Groups {
    private Integer id=0;
    private Integer groupNumber=0;
    public Groups (Integer id, Integer groupNumber){
        this.id=id;
        groupNumber=groupNumber;
    }
    public Groups(){
    }
    @Id
    @Column(name = "ID")
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



}
