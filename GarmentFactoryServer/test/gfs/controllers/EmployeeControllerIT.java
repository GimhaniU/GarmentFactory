/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Employee;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gimhani Uthpala
 */
public class EmployeeControllerIT {
    
    public EmployeeControllerIT() {
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
     * Test of addNewEmployee method, of class EmployeeController.
     */
    @Test
    public void testAddNewEmployee() throws Exception {
        System.out.println("addNewEmployee");
        Employee employee = null;
        EmployeeController instance = new EmployeeController();
        int expResult = 0;
        int result = instance.addNewEmployee(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastEmpId method, of class EmployeeController.
     */
    @Test
    public void testGetLastEmpId() throws Exception {
        System.out.println("getLastEmpId");
        EmployeeController instance = new EmployeeController();
        String expResult = "";
        String result = instance.getLastEmpId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimilarEmployeeNames method, of class EmployeeController.
     */
    @Test
    public void testGetSimilarEmployeeNames() throws Exception {
        System.out.println("getSimilarEmployeeNames");
        String name = "";
        EmployeeController instance = new EmployeeController();
        ArrayList<Employee> expResult = null;
        ArrayList<Employee> result = instance.getSimilarEmployeeNames(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchEmployee method, of class EmployeeController.
     */
    @Test
    public void testSearchEmployee() throws Exception {
        System.out.println("searchEmployee");
        String id = "";
        EmployeeController instance = new EmployeeController();
        Employee expResult = null;
        Employee result = instance.searchEmployee(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployee method, of class EmployeeController.
     */
    @Test
    public void testUpdateEmployee() throws Exception {
        System.out.println("updateEmployee");
        Employee employee = null;
        EmployeeController instance = new EmployeeController();
        int expResult = 0;
        int result = instance.updateEmployee(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
