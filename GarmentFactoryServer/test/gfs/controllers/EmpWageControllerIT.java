/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.EmpWage;
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
public class EmpWageControllerIT {
    
    public EmpWageControllerIT() {
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
     * Test of getEmployeeAttendance method, of class EmpWageController.
     */
    @Test
    public void testGetEmployeeAttendance() throws Exception {
        System.out.println("getEmployeeAttendance");
        String emp_id = "";
        int month = 0;
        int year = 0;
        EmpWage expResult = null;
        EmpWage result = EmpWageController.getEmployeeAttendance(emp_id, month, year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployeeAttendance method, of class EmpWageController.
     */
    @Test
    public void testAddEmployeeAttendance() throws Exception {
        System.out.println("addEmployeeAttendance");
        EmpWage new_employee = null;
        EmpWageController instance = new EmpWageController();
        int expResult = 0;
        int result = instance.addEmployeeAttendance(new_employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployeeSalary method, of class EmpWageController.
     */
    @Test
    public void testAddEmployeeSalary() throws Exception {
        System.out.println("addEmployeeSalary");
        EmpWage employee = null;
        EmpWageController instance = new EmpWageController();
        int expResult = 0;
        int result = instance.addEmployeeSalary(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployeePieceSalary method, of class EmpWageController.
     */
    @Test
    public void testAddEmployeePieceSalary() throws Exception {
        System.out.println("addEmployeePieceSalary");
        EmpWage employee = null;
        EmpWageController instance = new EmpWageController();
        int expResult = 0;
        int result = instance.addEmployeePieceSalary(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeePieceSalary method, of class EmpWageController.
     */
    @Test
    public void testGetEmployeePieceSalary() throws Exception {
        System.out.println("getEmployeePieceSalary");
        String emp_id = "";
        int month = 0;
        int year = 0;
        EmpWageController instance = new EmpWageController();
        EmpWage expResult = null;
        EmpWage result = instance.getEmployeePieceSalary(emp_id, month, year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeWage method, of class EmpWageController.
     */
    @Test
    public void testGetEmployeeWage() throws Exception {
        System.out.println("getEmployeeWage");
        String emp_id = "";
        int month = 0;
        int year = 0;
        EmpWageController instance = new EmpWageController();
        EmpWage expResult = null;
        EmpWage result = instance.getEmployeeWage(emp_id, month, year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
