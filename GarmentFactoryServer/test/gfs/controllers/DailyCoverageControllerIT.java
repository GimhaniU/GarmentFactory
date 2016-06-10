/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.DailyCoverage;
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
public class DailyCoverageControllerIT {
    
    public DailyCoverageControllerIT() {
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
     * Test of addDailyCoverage method, of class DailyCoverageController.
     */
    @Test
    public void testAddDailyCoverage() throws Exception {
        System.out.println("addDailyCoverage");
        DailyCoverage dailyCoverage = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.addDailyCoverage(dailyCoverage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDailyCoverageSet method, of class DailyCoverageController.
     */
    @Test
    public void testAddDailyCoverageSet() throws Exception {
        System.out.println("addDailyCoverageSet");
        ArrayList<DailyCoverage> dailyCoverages = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.addDailyCoverageSet(dailyCoverages);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchDailyCoverage method, of class DailyCoverageController.
     */
    @Test
    public void testSearchDailyCoverage() throws Exception {
        System.out.println("searchDailyCoverage");
        String date = "";
        String garment_id = "";
        DailyCoverageController instance = new DailyCoverageController();
        DailyCoverage expResult = null;
        DailyCoverage result = instance.searchDailyCoverage(date, garment_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyCoverage method, of class DailyCoverageController.
     */
    @Test
    public void testUpdateDailyCoverage() throws Exception {
        System.out.println("updateDailyCoverage");
        DailyCoverage dailyCoverage = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.updateDailyCoverage(dailyCoverage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyCoverageCut method, of class DailyCoverageController.
     */
    @Test
    public void testUpdateDailyCoverageCut() throws Exception {
        System.out.println("updateDailyCoverageCut");
        DailyCoverage dailyCoverage = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.updateDailyCoverageCut(dailyCoverage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyCoverageSewn method, of class DailyCoverageController.
     */
    @Test
    public void testUpdateDailyCoverageSewn() throws Exception {
        System.out.println("updateDailyCoverageSewn");
        DailyCoverage dailyCoverage = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.updateDailyCoverageSewn(dailyCoverage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyCoverageDyed method, of class DailyCoverageController.
     */
    @Test
    public void testUpdateDailyCoverageDyed() throws Exception {
        System.out.println("updateDailyCoverageDyed");
        DailyCoverage dailyCoverage = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.updateDailyCoverageDyed(dailyCoverage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyCoverageWashDry method, of class DailyCoverageController.
     */
    @Test
    public void testUpdateDailyCoverageWashDry() throws Exception {
        System.out.println("updateDailyCoverageWashDry");
        DailyCoverage dailyCoverage = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.updateDailyCoverageWashDry(dailyCoverage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyCoverageSewfinish method, of class DailyCoverageController.
     */
    @Test
    public void testUpdateDailyCoverageSewfinish() throws Exception {
        System.out.println("updateDailyCoverageSewfinish");
        DailyCoverage dailyCoverage = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.updateDailyCoverageSewfinish(dailyCoverage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDailyCoverageFinish method, of class DailyCoverageController.
     */
    @Test
    public void testUpdateDailyCoverageFinish() throws Exception {
        System.out.println("updateDailyCoverageFinish");
        DailyCoverage dailyCoverage = null;
        DailyCoverageController instance = new DailyCoverageController();
        int expResult = 0;
        int result = instance.updateDailyCoverageFinish(dailyCoverage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
