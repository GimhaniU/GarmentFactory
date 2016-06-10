/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Stock;
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
public class StockControllerIT {
    
    public StockControllerIT() {
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
     * Test of updateStock method, of class StockController.
     */
    @Test
    public void testUpdateStock() throws Exception {
        System.out.println("updateStock");
        Stock stock = null;
        StockController instance = new StockController();
        boolean expResult = false;
        boolean result = instance.updateStock(stock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastStockId method, of class StockController.
     */
    @Test
    public void testGetLastStockId() throws Exception {
        System.out.println("getLastStockId");
        StockController instance = new StockController();
        String expResult = "";
        String result = instance.getLastStockId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
