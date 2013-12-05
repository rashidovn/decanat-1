/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import decanat.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roma
 */
public interface StudentDAO {
    
     public void insertStudent(Student student) throws SQLException;
     public void insertStudent(ArrayList<Student> student) throws SQLException;
     public void updateStudent(Student student) throws SQLException;
     public Student getStudentById(Integer id) throws SQLException;    
     public List getAllStudents() throws SQLException;              
     public void deleteStudent(Student student) throws SQLException;

    
}
