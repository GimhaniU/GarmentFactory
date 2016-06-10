/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.PieceCoverage;
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
public class PieceCoverageControllerIT {
    
    public PieceCoverageControllerIT() {
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
     * Test of addPieceCoverage method, of class PieceCoverageController.
     */
    @Test
    public void testAddPieceCoverage() throws Exception {
        System.out.println("addPieceCoverage");
        ArrayList<PieceCoverage> pcs = null;
        PieceCoverageController instance = new PieceCoverageController();
        int expResult = 0;
        int result = instance.addPieceCoverage(pcs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPieceCoverage method, of class PieceCoverageController.
     */
    @Test
    public void testGetPieceCoverage() throws Exception {
        System.out.println("getPieceCoverage");
        String emp_id = "";
        int month = 0;
        int year = 0;
        PieceCoverageController instance = new PieceCoverageController();
        ArrayList<PieceCoverage> expResult = null;
        ArrayList<PieceCoverage> result = instance.getPieceCoverage(emp_id, month, year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
