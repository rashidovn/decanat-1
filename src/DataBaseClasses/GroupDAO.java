/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBaseClasses;

import decanat.Groups;
import decanat.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Roma
 */
public interface GroupDAO {
    
     public void insertGroup(Groups group) throws SQLException;
     public void updateGroup(Groups group) throws SQLException;
     public Groups getGroupById(Integer id) throws SQLException;    
     public List getAllGroups() throws SQLException;              
     public void deleteGroup(Groups group) throws SQLException;


}
