/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl.connector;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import gfc.controller.*;
import gfc.controller.RemoteFactory;

/**
 *
 * @author Gimhani Uthpala
 */
public class Connector {

    private final RemoteFactory remoteFactory;
    private static Connector serverConnector = null;
    private BackUP backUP;
    private CustomerController customerController;
    private CustomerOrderController customerOrderController;
    private DailyClothUsageController dailyClothUsageController;
    private DailyCoverageController dailyCoverageController;
    private DailyMaterialUsageController dailyMaterialUsageController;
    private EmployeeController employeeController;
    private GarmentController garmentController;
    private MaterialController materialController;
    private StockController stockController;
    private UserController userController;
    private PieceCoverageController pieceCoverageController;
    private ExpenseController expenseController;
    private EmpWageController empWageController;

    public Connector() throws NotBoundException, MalformedURLException, RemoteException {
        String lookUpString = "rmi://127.0.0.1:344/GarmentFactoryServer";
        remoteFactory = (RemoteFactory) Naming.lookup(lookUpString);

    }

    public RemoteFactory getRemoteFactory() {
        return remoteFactory;
    }

    public static Connector getSConnector() throws NotBoundException, MalformedURLException, RemoteException {
        if (serverConnector == null) {
            serverConnector = new Connector();
        }
        return serverConnector;
    }

    public CustomerController getCustomerController() throws RemoteException, SQLException, ClassNotFoundException {
        if (customerController == null) {
            customerController = remoteFactory.getCustomerController();
        }
        return customerController;
    }

    public CustomerOrderController getCustomerOrderController() throws RemoteException, SQLException, ClassNotFoundException {
        if (customerOrderController == null) {
            customerOrderController = remoteFactory.getCustomerOrderController();
        }
        return customerOrderController;
    }

    public DailyClothUsageController getDailyClothUsageController() throws RemoteException, SQLException, ClassNotFoundException {
        if (dailyClothUsageController == null) {
            dailyClothUsageController = remoteFactory.getDailyClothUsageController();
        }
        return dailyClothUsageController;
    }

    public DailyCoverageController getDailyCoverageController() throws RemoteException, SQLException, ClassNotFoundException {
        if (dailyCoverageController == null) {
            dailyCoverageController = remoteFactory.getDailyCoverageController();
        }
        return dailyCoverageController;
    }

    public DailyMaterialUsageController getDailyMaterialUsageController() throws RemoteException, SQLException, ClassNotFoundException {
        if (dailyMaterialUsageController == null) {
            dailyMaterialUsageController = remoteFactory.getDailyMaterialUsageController();
        }
        return dailyMaterialUsageController;
    }

    public EmployeeController getEmployeeController() throws RemoteException, SQLException, ClassNotFoundException {
        if (employeeController == null) {
            employeeController = remoteFactory.getEmployeeController();
        }
        return employeeController;
    }
    
    public EmpWageController getEmpWageController() throws RemoteException, SQLException, ClassNotFoundException {
        if (empWageController == null) {
            empWageController = remoteFactory.getEmpWageController();
        }
        return empWageController;
    }
    
    public ExpenseController getExpenseController() throws RemoteException, SQLException, ClassNotFoundException {
        if (expenseController == null) {
            expenseController = remoteFactory.getExpenseController();
        }
        return expenseController;
    }

    public GarmentController getGarmentController() throws RemoteException, SQLException, ClassNotFoundException {
        if (garmentController == null) {
            garmentController = remoteFactory.getGarmentController();
        }
        return garmentController;
    }

    public MaterialController getMaterialController() throws RemoteException, SQLException, ClassNotFoundException {
        if (materialController == null) {
            materialController = remoteFactory.getMaterialController();
        }
        return materialController;
    }
    
    public PieceCoverageController getPieceCoverageController() throws RemoteException, SQLException, ClassNotFoundException {
        if (pieceCoverageController == null) {
            pieceCoverageController = remoteFactory.getPieceCoverageController();
        }
        return pieceCoverageController;
    }

    public StockController getStockController() throws RemoteException, SQLException, ClassNotFoundException {
        if (stockController == null) {
            stockController = remoteFactory.getStockController();
        }
        return stockController;
    }

    public UserController getUserController() throws RemoteException, SQLException, ClassNotFoundException {
        if (userController == null) {
            userController = remoteFactory.getUserController();
        }
        return userController;
    }

    public BackUP getbBackUPController() throws RemoteException, SQLException, ClassNotFoundException, InterruptedException {
        if (backUP == null) {
            backUP = remoteFactory.getBackUP();
        }
        return backUP;
    }

}
