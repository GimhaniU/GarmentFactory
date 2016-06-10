/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.CustomerOrder;
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
public class CustomerOrderControllerIT {
    
    public CustomerOrderControllerIT() {
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
     * Test of addSale method, of class CustomerOrderController.
     */
    @Test
    public void testAddSale() throws Exception {
        System.out.println("addSale");
        ArrayList<CustomerOrder> sale_order = null;
        CustomerOrderController instance = new CustomerOrderController();
        boolean expResult = false;
        boolean result = instance.addSale(sale_order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastOrderId method, of class CustomerOrderController.
     */
    @Test
    public void testGetLastOrderId() throws Exception {
        System.out.println("getLastOrderId");
        CustomerOrderController instance = new CustomerOrderController();
        String expResult = "";
        String result = instance.getLastOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
