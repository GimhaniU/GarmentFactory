/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Gimhani Uthpala
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gfs.controllers.ExpenseControllerIT.class, gfs.controllers.GarmentControllerIT.class, gfs.controllers.BackUpIT.class, gfs.controllers.EmployeeControllerIT.class, gfs.controllers.UserControllerIT.class, gfs.controllers.CustomerControllerIT.class, gfs.controllers.EmpWageControllerIT.class, gfs.controllers.DailyCoverageControllerIT.class, gfs.controllers.DailyMaterialUsageControllerIT.class, gfs.controllers.StockControllerIT.class, gfs.controllers.CustomerOrderControllerIT.class, gfs.controllers.PieceCoverageControllerIT.class, gfs.controllers.DailyClothUsageControllerIT.class, gfs.controllers.MaterialControllerIT.class})
public class ControllersITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
