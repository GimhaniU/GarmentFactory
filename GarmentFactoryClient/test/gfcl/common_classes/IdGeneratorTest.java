/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.common_classes;

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
public class IdGeneratorTest {
    
    public IdGeneratorTest() {
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
     * Test of generateNextCustomerID method, of class IdGenerator.
     */
    @Test
    public void testGenerateNextCustomerID() {
        System.out.println("generateNextCustomerID");
        String lastCustID = "C010";
        String expResult = "C011";
        String result = IdGenerator.generateNextCustomerID(lastCustID);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of generateNextMaterialID method, of class IdGenerator.
     */
    @Test
    public void testGenerateNextMaterialID() {
        System.out.println("generateNextMaterialID");
        String lastMatID = "M021";
        String expResult = "M022";
        String result = IdGenerator.generateNextMaterialID(lastMatID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of generateNextEmployeeID method, of class IdGenerator.
     */
    @Test
    public void testGenerateNextEmployeeID() {
        System.out.println("generateNextEmployeeID");
        String lastEmpID = "E031";
        String expResult = "E032";
        String result = IdGenerator.generateNextEmployeeID(lastEmpID);
        assertEquals(expResult, result);
        
    }
    
}
