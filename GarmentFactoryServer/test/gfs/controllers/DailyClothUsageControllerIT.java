/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.DailyClothUsage;
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
public class DailyClothUsageControllerIT {
    
    public DailyClothUsageControllerIT() {
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
     * Test of addDailyClothUsage method, of class DailyClothUsageController.
     */
    @Test
    public void testAddDailyClothUsage() throws Exception {
        System.out.println("addDailyClothUsage");
        DailyClothUsage dailyClothUsage = null;
        DailyClothUsageController instance = new DailyClothUsageController();
        int expResult = 0;
        int result = instance.addDailyClothUsage(dailyClothUsage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchDailyClothUsage method, of class DailyClothUsageController.
     */
    @Test
    public void testSearchDailyClothUsage() throws Exception {
        System.out.println("searchDailyClothUsage");
        String date = "";
        String garment_id = "";
        String mat_id = "";
        DailyClothUsageController instance = new DailyClothUsageController();
        DailyClothUsage expResult = null;
        DailyClothUsage result = instance.searchDailyClothUsage(date, garment_id, mat_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
