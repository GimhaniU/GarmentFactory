/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Material;
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
public class MaterialControllerIT {
    
    public MaterialControllerIT() {
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
     * Test of addNewMaterial method, of class MaterialController.
     */
    @Test
    public void testAddNewMaterial() throws Exception {
        System.out.println("addNewMaterial");
        Material material = null;
        MaterialController instance = new MaterialController();
        int expResult = 0;
        int result = instance.addNewMaterial(material);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastMaterialId method, of class MaterialController.
     */
    @Test
    public void testGetLastMaterialId() throws Exception {
        System.out.println("getLastMaterialId");
        MaterialController instance = new MaterialController();
        String expResult = "";
        String result = instance.getLastMaterialId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimilarMaterials method, of class MaterialController.
     */
    @Test
    public void testGetSimilarMaterials() throws Exception {
        System.out.println("getSimilarMaterials");
        String item = "";
        MaterialController instance = new MaterialController();
        ArrayList<Material> expResult = null;
        ArrayList<Material> result = instance.getSimilarMaterials(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchMaterial method, of class MaterialController.
     */
    @Test
    public void testSearchMaterial() throws Exception {
        System.out.println("searchMaterial");
        String mat_id = "";
        Material expResult = null;
        Material result = MaterialController.searchMaterial(mat_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimilarCloths method, of class MaterialController.
     */
    @Test
    public void testGetSimilarCloths() throws Exception {
        System.out.println("getSimilarCloths");
        String item = "";
        MaterialController instance = new MaterialController();
        ArrayList<Material> expResult = null;
        ArrayList<Material> result = instance.getSimilarCloths(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSimilarOtherMaterials method, of class MaterialController.
     */
    @Test
    public void testGetSimilarOtherMaterials() throws Exception {
        System.out.println("getSimilarOtherMaterials");
        String item = "";
        MaterialController instance = new MaterialController();
        ArrayList<Material> expResult = null;
        ArrayList<Material> result = instance.getSimilarOtherMaterials(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
