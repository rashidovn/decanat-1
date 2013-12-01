/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decanat;

import org.sqlite.JDBC;
import java.sql.Connection;
import org.sqlite.SQLite;
 import org.sqlite.JDBC;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roma
 */
public class DBconnection {
    private static Connection conn =null;
    private static int iTimeout = 20;
    private static DBconnection db = null;
    //public static String url = "C:/Users/Roma/Documents/NetBeansProjects/db.db";
     public static synchronized DBconnection getUniqueInstance() {
        if (db == null) {
                db = new DBconnection();
                return db;
        }
        else return db;
    }
    public static synchronized void openConnection () {
            try {
                String user = "root";
                String password = "admin";
                String url = "jdbc:sqlite:C:/Users/Roma/Documents/NetBeansProjects/db.db ";
                Class.forName("org.sqlite.JDBC");
              if (conn == null) {
                conn = DriverManager.getConnection(url,user,password);
                    }
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
               }
           
    }
    
    
    
    
    
 
    
    
     public static ArrayList<Student> getResultList() {
         
        ArrayList<Student> list = new ArrayList<>();
        
        Statement stmt = null;
        ResultSet rslt = null;
        
        try {
            
            String showBase = "select students.group_number from students "
                    + "where students.group_number=101 ";
            stmt = conn.createStatement();
            rslt = stmt.executeQuery(showBase);
            
            while (rslt.next()) {

                Student std = new Student();
                //std.setId(,rslt.getInt("id"));
               // std.setLastName(rslt.getString("last_name"));
               // std.setFirstName(rslt.getString("first_name"));
                std.setGroupNumber(rslt.getInt("group_number"));
              //  std.setGradePointAverage(rslt.getDouble("gpa"));

                list.add(std);
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            close(rslt);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return list;

    }
 
    
     public static synchronized void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static synchronized void createTableStudents() {
    String createString =
        "create table IF NOT EXISTS " + 
        "students " +
        "(id integer NOT NULL, " +
        "last_name varchar(40) NOT NULL, " +
        "first_name varchar(40) NOT NULL, " +
        "group_number integer NOT NULL, " +
        "gpa double NOT NULL, " +
        "PRIMARY KEY (id)) ";

    Statement stmt = null;
    try {
        stmt = conn.createStatement();
        stmt.setQueryTimeout(iTimeout);
        stmt.executeUpdate(createString);
    } catch (SQLException ex) {
        Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
       close(stmt);
    }
}
     
     public void insertRowData( Object obj) {
         ReadEntryFromConsole refc =null;
         PreparedStatement pstmt = null;
         ResultSet rslt = null;
         Student std = (Student)obj;
         String insert = "INSERT INTO 'students'"+
            "  ('id', 'last_name', 'first_name', 'group_number', 'gpa' ) VALUES (?, ?, ?, ?, ? )";
    try {
        
        conn.prepareStatement(insert);
        pstmt.setInt(1, std.getId());
        pstmt.setString(2, std.getLastName());
        pstmt.setString(3, std.getFirstName());
        pstmt.setInt(3, std.getGroupNumber());
        pstmt.setDouble(3, std.getGradePointAverage());
        pstmt.executeUpdate();
        rslt = pstmt.executeQuery();
                  while (rslt.next()) {
                   ;
                  }
            
    } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        close (pstmt);
        close(rslt);
    }
}
    
      
     
     
     public static synchronized void insertDataToStudentsTable() {

    Statement stmt = null;
    try {
        stmt = conn.createStatement();
        stmt.setQueryTimeout(iTimeout);
        stmt.executeUpdate(
            "insert into " +"students " +
            "values(1, " +
            "'romaniuk', " +
            "'roman', " +
            "101, " +
            "4.89)");
        
    } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        close(stmt);
    }
}
     
     public static synchronized void dropDB(){
        Statement stmt = null;
         try {
            stmt=conn.createStatement();
            
            String sDropTable = "DROP TABLE 'students'";
            stmt.executeUpdate(sDropTable);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        close(stmt);
    }
     
     }
    
      
       public static synchronized void close(Statement stmt)
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
        }
        catch  (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     


    public static synchronized void close(PreparedStatement pstmt )
    {
        try
        {
            if (pstmt != null)
            {
                pstmt.close();
            }
        }
        catch  (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized void close(ResultSet rslt)
    {
        try
        {
            if (rslt != null)
            {
                rslt.close();
            }
        }
        catch  (SQLException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    
    
    /*
              
              try {
                  PreparedStatement pstmt = DBconnection.conn.prepareStatement("select * from GROUP WHERE groupNumber = ?");

                  pstmt.setString(1, "104");
                 // pstmt.setString(2, "201");

                  ResultSet resultSet = pstmt.executeQuery();
                  while (resultSet.next()) {
                      System.out.println(resultSet.getString("groupNumber"));
                  }
            
                  resultSet.close();
                  pstmt.close();
              } catch (SQLException ex) {
                  Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
              }
         */
}
