/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decanat;

import java.sql.SQLException;
import java.util.Collection;

/**
 *
 * @author roman.romanyuk
 */
public interface StudentActions {
    public void insertStudent(Student student) throws SQLException;  
    public void updateStudent(Student student) throws SQLException;
    public Collection getAllStudents() throws SQLException;              
    public void deleteStudent(Student student) throws SQLException;
    
}
