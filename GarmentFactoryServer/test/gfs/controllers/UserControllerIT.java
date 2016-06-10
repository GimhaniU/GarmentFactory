/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.User;
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
public class UserControllerIT {
    
    public UserControllerIT() {
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
     * Test of addNewUser method, of class UserController.
     */
    @Test
    public void testAddNewUser() throws Exception {
        System.out.println("addNewUser");
        User user = null;
        int expResult = 0;
        int result = UserController.addNewUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class UserController.
     */
    @Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        User user = null;
        int expResult = 0;
        int result = UserController.updateUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePassword method, of class UserController.
     */
    @Test
    public void testUpdatePassword() throws Exception {
        System.out.println("updatePassword");
        User user = null;
        int expResult = 0;
        int result = UserController.updatePassword(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class UserController.
     */
    @Test
    public void testGetAllUsers() throws Exception {
        System.out.println("getAllUsers");
        ArrayList<User> expResult = null;
        ArrayList<User> result = UserController.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchUser method, of class UserController.
     */
    @Test
    public void testSearchUser() throws Exception {
        System.out.println("searchUser");
        String name = "";
        User expResult = null;
        User result = UserController.searchUser(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matchPassword method, of class UserController.
     */
    @Test
    public void testMatchPassword() throws Exception {
        System.out.println("matchPassword");
        String name = "";
        String entertext = "";
        boolean expResult = false;
        boolean result = UserController.matchPassword(name, entertext);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSimilarUsers method, of class UserController.
     */
    @Test
    public void testGetAllSimilarUsers() throws Exception {
        System.out.println("getAllSimilarUsers");
        String typed = "";
        ArrayList<User> expResult = null;
        ArrayList<User> result = UserController.getAllSimilarUsers(typed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
