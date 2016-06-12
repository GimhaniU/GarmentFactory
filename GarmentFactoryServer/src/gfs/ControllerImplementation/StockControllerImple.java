/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.Stock;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfs.controllers.StockController;
import java.sql.SQLException;

/**
 *
 * @author Gimhani Uthpala
 */
public class StockControllerImple extends UnicastRemoteObject implements gfc.controller.StockController{
    private final StockController stockController;

    public StockControllerImple() throws RemoteException {
        super();
        this.stockController = new StockController() {} ;
    }

    @Override
    public boolean updateStock(Stock stock) throws RemoteException, SQLException, ClassNotFoundException {
        return stockController.updateStock(stock);
    }

    @Override
    public String getLastStockId() throws RemoteException, SQLException, ClassNotFoundException {
        return stockController.getLastStockId();
    }

    @Override
    public double getMonthlyCostForMaterial(int year, int month) throws RemoteException, SQLException, ClassNotFoundException {
        return stockController.getMonthlyCostForMaterial(year, month);
    }

    @Override
    public double getYearlyCostForMaterial(int year) throws RemoteException, SQLException, ClassNotFoundException {
        return stockController.getYearlyCostForMaterial(year);
    }

    
    
}
