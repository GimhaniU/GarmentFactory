/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.Stock;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Gimhani Uthpala
 */
public interface StockController extends Remote {
 
    public String getLastStockId() throws RemoteException, SQLException,ClassNotFoundException;
    
    public boolean updateStock(Stock stock ) throws RemoteException, SQLException,ClassNotFoundException;

    public double getMonthlyCostForMaterial(int year,int month) throws RemoteException, SQLException,ClassNotFoundException;

    public double getYearlyCostForMaterial(int year) throws RemoteException, SQLException,ClassNotFoundException;;
}
