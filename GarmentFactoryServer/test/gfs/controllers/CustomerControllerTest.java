/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Customer;
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
public class CustomerControllerTest {
    
    public CustomerControllerTest() {
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
        Customer customer = new Customer("C003", "acv","weligama", "1234567", "123444");
        CustomerController instance = new CustomerController();
        int expResult = 1;
        int result = instance.addNewCustomer(customer);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getLastCustId method, of class CustomerController.
     */
    @Test
    public void testGetLastCustId() throws Exception {
        System.out.println("getLastCustId");
        CustomerController instance = new CustomerController();
        String expResult = "C003";
        String result = instance.getLastCustId();
        assertEquals(expResult, result);
        
    }
    
}
