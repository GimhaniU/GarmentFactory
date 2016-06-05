/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Gimhani Uthpala
 */
public interface RemoteFactory extends Remote {

    public CustomerController getCustomerController() throws RemoteException, SQLException, ClassNotFoundException;

    public CustomerOrderController getCustomerOrderController() throws RemoteException, SQLException, ClassNotFoundException;

    public DailyClothUsageController getDailyClothUsageController() throws RemoteException, SQLException, ClassNotFoundException;

    public DailyCoverageController getDailyCoverageController() throws RemoteException, SQLException, ClassNotFoundException;

    public DailyMaterialUsageController getDailyMaterialUsageController() throws RemoteException, SQLException, ClassNotFoundException;

    public EmployeeController getEmployeeController() throws RemoteException, SQLException, ClassNotFoundException;
    
    public EmpWageController getEmpWageController() throws RemoteException, SQLException, ClassNotFoundException;
    
    public ExpenseController getExpenseController() throws RemoteException, SQLException, ClassNotFoundException;

    public GarmentController getGarmentController() throws RemoteException, SQLException, ClassNotFoundException;

    public MaterialController getMaterialController() throws RemoteException, SQLException, ClassNotFoundException;

    public StockController getStockController() throws RemoteException, SQLException, ClassNotFoundException;
    
    public UserController getUserController() throws RemoteException, SQLException, ClassNotFoundException;

    public BackUP getBackUP() throws RemoteException,SQLException,InterruptedException,ClassNotFoundException;

    public PieceCoverageController getPieceCoverageController() throws RemoteException,SQLException,ClassNotFoundException;
}
