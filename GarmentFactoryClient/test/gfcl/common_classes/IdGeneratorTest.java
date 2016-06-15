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
    //to test the usual behaviour of methods
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

    /**
     * Test of generateNextExpenseID method, of class IdGenerator.
     */
    @Test
    public void testGenerateNextExpenseID() {
        System.out.println("generateNextExpenseID");
        String lastExpenseID = "P021";
        String expResult = "P022";
        String result = IdGenerator.generateNextExpenseID(lastExpenseID);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of generateNextIncomeID method, of class IdGenerator.
     */
    @Test
    public void testGenerateNextIncomeID() {
        System.out.println("generateNextIncomeID");
        String lastIncomeID = "I001";
        String expResult = "I002";
        String result = IdGenerator.generateNextIncomeID(lastIncomeID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of generateNextStockID method, of class IdGenerator.
     */
    @Test
    public void testGenerateNextStockID() {
        System.out.println("generateNextStockID");
        String lastStockID = "S001";
        String expResult = "S002";
        String result = IdGenerator.generateNextStockID(lastStockID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of generateNextOrderID method, of class IdGenerator.
     */
    @Test
    public void testGenerateNextOrderID() {
        System.out.println("generateNextOrderID");
        String lastOrderID = "Q001";
        String expResult = "Q002";
        String result = IdGenerator.generateNextOrderID(lastOrderID);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of generateNextGarmentID method, of class IdGenerator.
     */
    @Test
    public void testGenerateNextGarmentID() {
        System.out.println("generateNextGarmentID");
        String lastGarmentID = "G032";
        String expResult = "G033";
        String result = IdGenerator.generateNextGarmentID(lastGarmentID);
        assertEquals(expResult, result);
        
    }
    
    //to test whether the system can hold incorrect inputs
    
    @Test
    public void testGenerateNextExpenseID1() {
        System.out.println("generateNextExpenseID");
        String lastExpenseID = null;
        String expResult = "P001";
        String result = IdGenerator.generateNextExpenseID(lastExpenseID);
        assertEquals(expResult, result);  
    }
    
    public void testGenerateNextGarmentID1() {
        System.out.println("generateNextGarmentID");
        String lastGarmentID = null;
        String expResult = "G033";
        String result = IdGenerator.generateNextGarmentID(lastGarmentID);
        assertEquals(expResult, result);
        
    }
    
}
