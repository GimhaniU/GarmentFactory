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
public class PatternCheckerTest {
    
    public PatternCheckerTest() {
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
     * Test of checkNIC method, of class PatternChecker.
     */
    @Test
    public void testCheckNIC() {
        System.out.println("checkNIC");
        String nicText = "9394e";
        String expResult = "9394";
        String result = PatternChecker.checkNIC(nicText);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheckNIC1() {
        System.out.println("checkNIC");
        String nicText = "9394";
        String expResult = "9394";
        String result = PatternChecker.checkNIC(nicText);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkNICdirect method, of class PatternChecker.
     */
    @Test
    public void testCheckNICdirect() {
        System.out.println("checkNICdirect");
        String nicText = "939456789V";
        boolean expResult = true;
        boolean result = PatternChecker.checkNICdirect(nicText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckNICdirect1() {
        System.out.println("checkNICdirect");
        String nicText = "93945679V"; //1 number missing
        boolean expResult = false;
        boolean result = PatternChecker.checkNICdirect(nicText);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkTelNum method, of class PatternChecker.
     */
    @Test
    public void testCheckTelNum() {
        System.out.println("checkTelNum");
        String telText = "07156s";
        String expResult = "07156";
        String result = PatternChecker.checkTelNum(telText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckTelNum1() {
        System.out.println("checkTelNum");
        String telText = "07156";
        String expResult = "07156";
        String result = PatternChecker.checkTelNum(telText);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkTelNumdirect method, of class PatternChecker.
     */
    @Test
    public void testCheckTelNumdirect() {
        System.out.println("checkTelNumdirect");
        String telText = "0712760876";
        boolean expResult = true;
        boolean result = PatternChecker.checkTelNumdirect(telText);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheckTelNumdirect1() {
        System.out.println("checkTelNumdirect");
        String telText = "071276876s"; 
        boolean expResult = false;
        boolean result = PatternChecker.checkTelNumdirect(telText);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of dateFormatChecker method, of class PatternChecker.
     */
    @Test
    public void testDateFormatChecker() {
        System.out.println("dateFormatChecker");
        String birthday = "2015-06-12";
        boolean expResult = true;
        boolean result = PatternChecker.dateFormatChecker(birthday);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkDecimal method, of class PatternChecker.
     */
    @Test
    public void testCheckDecimal() {
        System.out.println("checkDecimal");
        String text = "20.12w";
        String expResult = "20.12";
        String result = PatternChecker.checkDecimal(text);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkDecimaldirect method, of class PatternChecker.
     */
    @Test
    public void testCheckDecimaldirect() {
        System.out.println("checkDecimaldirect");
        String text = "20.1s1";
        boolean expResult = false;
        boolean result = PatternChecker.checkDecimaldirect(text);
        assertEquals(expResult, result); 
    }

    /**
     * Test of checkIntegerdirect method, of class PatternChecker.
     */
    @Test
    public void testCheckIntegerdirect() {
        System.out.println("checkIntegerdirect");
        String text = "12";
        boolean expResult = true;
        boolean result = PatternChecker.checkIntegerdirect(text);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkStringdirect method, of class PatternChecker.
     */
    @Test
    public void testCheckStringdirect() {
        System.out.println("checkStringdirect");
        String text = "sasss";
        boolean expResult = true;
        boolean result = PatternChecker.checkStringdirect(text);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkstring method, of class PatternChecker.
     */
    @Test
    public void testCheckstring() {
        System.out.println("checkstring");
        String text = "ssaas1";
        String expResult = "ssaas";
        String result = PatternChecker.checkstring(text);
        assertEquals(expResult, result);
    }

    /**
     * Test of addDecimalPointsForPrice method, of class PatternChecker.
     */
    @Test
    public void testCheckPrice() {
        System.out.println("checkPrice");
        String text = "12";
        String expResult = "12.00";
        String result = PatternChecker.addDecimalPointsForPrice(text);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkInteger method, of class PatternChecker.
     */
    @Test
    public void testCheckInteger() {
        System.out.println("checkInteger");
        String text = "12.";
        String expResult = "12";
        String result = PatternChecker.checkInteger(text);
        assertEquals(expResult, result);
        
    }

    

    /**
     * Test of getMonthNumber method, of class PatternChecker.
     */
    @Test
    public void testGetMonthNumber() {
        System.out.println("getMonthNumber");
        String month = "March";
        int expResult = 3;
        int result = PatternChecker.getMonthNumber(month);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getMonthName method, of class PatternChecker.
     */
    @Test
    public void testGetMonthName() {
        System.out.println("getMonthName");
        int month = 10;
        String expResult = "October";
        String result = PatternChecker.getMonthName(month);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of round method, of class PatternChecker.
     */
    @Test
    public void testRound() {
        System.out.println("round");
        double value = 0.123;
        int places = 2;
        double expResult = 0.12;
        double result = PatternChecker.round(value, places);
        assertEquals(expResult, result, 0.0);
        
    }
    /**
     * Test of isDateValid method, of class PatternChecker.
     */
    @Test
    public void testIsDateValid() {
        System.out.println("isDateValid");
        String date = "2015-08-04";
        boolean expResult = true;
        boolean result = PatternChecker.isDateValid(date);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testIsDateValid1() {
        System.out.println("isDateValid");
        String date = "2016-08-04";
        boolean expResult = false;
        boolean result = PatternChecker.isDateValid(date);
        assertEquals(expResult, result);
        
    }
    
}
