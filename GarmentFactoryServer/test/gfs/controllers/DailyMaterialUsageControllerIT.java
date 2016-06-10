/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.DailyMaterialUsage;
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
public class DailyMaterialUsageControllerIT {
    
    public DailyMaterialUsageControllerIT() {
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
     * Test of addDailyUsage method, of class DailyMaterialUsageController.
     */
    @Test
    public void testAddDailyUsage() throws Exception {
        System.out.println("addDailyUsage");
        DailyMaterialUsage dmu = null;
        DailyMaterialUsageController instance = new DailyMaterialUsageController();
        boolean expResult = false;
        boolean result = instance.addDailyUsage(dmu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDateAdded method, of class DailyMaterialUsageController.
     */
    @Test
    public void testIsDateAdded() throws Exception {
        System.out.println("isDateAdded");
        String mat_id = "";
        String date = "";
        DailyMaterialUsageController instance = new DailyMaterialUsageController();
        boolean expResult = false;
        boolean result = instance.isDateAdded(mat_id, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
