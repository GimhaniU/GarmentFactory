/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Employee;
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
public class EmployeeControllerTest {
    
    public EmployeeControllerTest() {
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
        Employee employee = new Employee("E010","Kumara","Matara","0412234567","986545687V","Cutting");
        EmployeeController instance = new EmployeeController();
        int expResult = 1;
        int result = instance.addNewEmployee(employee);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getLastEmpId method, of class EmployeeController.
     */
    @Test
    public void testGetLastEmpId() throws Exception {
        System.out.println("getLastEmpId");
        EmployeeController instance = new EmployeeController();
        String expResult = "E002";
        String result = instance.getLastEmpId();
        assertEquals(expResult, result);
        
    }
    
}
