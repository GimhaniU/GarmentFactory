/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import gfc.controller.*;

/**
 *
 * @author DinsuG
 */
public class RemoteFactoryImple extends UnicastRemoteObject implements RemoteFactory {

    public RemoteFactoryImple() throws RemoteException {
        super();
    }
    
    @Override
    public CustomerController getCustomerController() throws RemoteException, SQLException, ClassNotFoundException{
        return new CustomerControllerImple();
    }

    @Override
    public CustomerOrderController getCustomerOrderController() throws RemoteException, SQLException, ClassNotFoundException{
        return new CustomerOrderControllerImple();
    }

    @Override
    public DailyClothUsageController getDailyClothUsageController() throws RemoteException, SQLException, ClassNotFoundException{
        return new DailyClothUsageControllerImple();
    }

    @Override
    public DailyCoverageController getDailyCoverageController() throws RemoteException, SQLException, ClassNotFoundException{
        return new DailyCoverageControllerImple();
    }
    @Override
    public DailyMaterialUsageController getDailyMaterialUsageController() throws RemoteException, SQLException, ClassNotFoundException{
        return new DailyMaterialUsageControllerImple();
    }

    @Override
    public EmployeeController getEmployeeController() throws RemoteException, SQLException, ClassNotFoundException{
        return new EmployeeControllerImple();
    }
    @Override
    public GarmentController getGarmentController() throws RemoteException, SQLException, ClassNotFoundException{
        return new GarmentControllerImple();
    }

    @Override
    public MaterialController getMaterialController() throws RemoteException, SQLException, ClassNotFoundException{
        return new MaterialControllerImple();
    }

    @Override
    public StockController getStockController() throws RemoteException, SQLException, ClassNotFoundException{
        return new StockControllerImple();
    }
    
    @Override
    public UserController getUserController() throws RemoteException, SQLException, ClassNotFoundException{
        return new UserControllerImple();
    }

    @Override
    public BackUP getBackUP() throws RemoteException,SQLException,InterruptedException,ClassNotFoundException{
        return new BackUpControllerImple();
    }

    @Override
    public PieceCoverageController getPieceCoverageController() throws RemoteException, SQLException, ClassNotFoundException {
        return new PieceCoverageControllerImple();
    }

}
