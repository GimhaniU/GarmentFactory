/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Garment;
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
public class GarmentControllerIT {
    
    public GarmentControllerIT() {
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
     * Test of getSimilarGarmentNames method, of class GarmentController.
     */
    @Test
    public void testGetSimilarGarmentNames() throws Exception {
        System.out.println("getSimilarGarmentNames");
        String item = "";
        GarmentController instance = new GarmentController();
        ArrayList<Garment> expResult = null;
        ArrayList<Garment> result = instance.getSimilarGarmentNames(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStockInHand method, of class GarmentController.
     */
    @Test
    public void testGetStockInHand() throws Exception {
        System.out.println("getStockInHand");
        String garment_id = "";
        int expResult = 0;
        int result = GarmentController.getStockInHand(garment_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
