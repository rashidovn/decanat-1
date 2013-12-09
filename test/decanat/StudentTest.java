/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package decanat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roman.romanyuk
 */
public class StudentTest {
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Student.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Student std = new Student();
        int bef=std.getId();
        std.setId();
        assertTrue(std.getId()-1== bef);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getLastName method, of class Student.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Student std = new Student();
        std.setLastName("Roman");
        assertTrue("Roman".equals(std.getLastName()));
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getFirstName method, of class Student.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Student std = new Student();
        std.setFirstName("Roman");
        assertTrue("Roman".equals(std.getFirstName()));
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getGroupNumber method, of class Student.
     */
    @Test
    public void testGetGroupNumber() {
        System.out.println("getGroupNumber");
        Student std = new Student();
        std.setGroupNumber(2);
        assertTrue(2== std.getGroupNumber());
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getGradePointAverage method, of class Student.
     */
    @Test
    public void testGetGradePointAverage() {
        System.out.println("getGradePointAverage");
        Student std = new Student();
        std.setGradePointAverage(1.1);
        assertTrue(std.getGradePointAverage()== 1.1);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Student instance = new Student();
        String expResult = "";
        String result = instance.toString();
        assertNotNull(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setId method, of class Student.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        
        Student std = new Student();
        std.setId();
        Student std2 = new Student();
        assertTrue (std2.getId()-1 == std.getId());
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setLastName method, of class Student.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
       Student instance = new Student();
        instance.setLastName("Roman");
        assertTrue("Roman".equals(instance.getLastName()));
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of setFirstName method, of class Student.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        Student instance = new Student();
        instance.setFirstName("Roman");
        assertTrue("Roman".equals(instance.getFirstName()));
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of setGroupNumber method, of class Student.
     */
    @Test
    public void testSetGroupNumber() {
        System.out.println("setGroupNumber");
        int groupNumber = 1;
        Student instance = new Student();
        instance.setGroupNumber(groupNumber);
       assertTrue(instance.getGroupNumber()==1);
      
    }

    /**
     * Test of setGradePointAverage method, of class Student.
     */
    @Test
    public void testSetGradePointAverage() {
        System.out.println("setGradePointAverage");
        double gradePointAverage = 0.0;
        Student instance = new Student();
        instance.setGradePointAverage(gradePointAverage);
        assertTrue(instance.getGradePointAverage()==0.0);
        // TODO review the generated test code and remove the default call to fail.
   
    }
    
}
