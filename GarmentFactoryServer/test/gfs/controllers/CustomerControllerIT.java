/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Customer;
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
public class CustomerControllerIT {
    
    public CustomerControllerIT() {
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
     * Test of addNewCustomer method, of class CustomerController.
     */
    @Test
    public void testAddNewCustomer() throws Exception {
        System.out.println("addNewCustomer");
        Customer customer = null;
        CustomerController instance = new CustomerController();
        int expResult = 0;
        int result = instance.addNewCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastCustId method, of class CustomerController.
     */
    @Test
    public void testGetLastCustId() throws Exception {
        System.out.println("getLastCustId");
        CustomerController instance = new CustomerController();
        String expResult = "";
        String result = instance.getLastCustId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimilarCustomerNames method, of class CustomerController.
     */
    @Test
    public void testGetSimilarCustomerNames() throws Exception {
        System.out.println("getSimilarCustomerNames");
        String name = "";
        CustomerController instance = new CustomerController();
        ArrayList<Customer> expResult = null;
        ArrayList<Customer> result = instance.getSimilarCustomerNames(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCustomer method, of class CustomerController.
     */
    @Test
    public void testUpdateCustomer() throws Exception {
        System.out.println("updateCustomer");
        Customer customer = null;
        CustomerController instance = new CustomerController();
        int expResult = 0;
        int result = instance.updateCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
