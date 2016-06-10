/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Expense;
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
public class ExpenseControllerIT {
    
    public ExpenseControllerIT() {
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
     * Test of getSimilarExpenseNames method, of class ExpenseController.
     */
    @Test
    public void testGetSimilarExpenseNames() throws Exception {
        System.out.println("getSimilarExpenseNames");
        String item = "";
        ExpenseController instance = new ExpenseController();
        ArrayList<Expense> expResult = null;
        ArrayList<Expense> result = instance.getSimilarExpenseNames(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastExpId method, of class ExpenseController.
     */
    @Test
    public void testGetLastExpId() throws Exception {
        System.out.println("getLastExpId");
        ExpenseController instance = new ExpenseController();
        String expResult = "";
        String result = instance.getLastExpId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewExpense method, of class ExpenseController.
     */
    @Test
    public void testAddNewExpense() throws Exception {
        System.out.println("addNewExpense");
        Expense expense = null;
        ExpenseController instance = new ExpenseController();
        int expResult = 0;
        int result = instance.addNewExpense(expense);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
