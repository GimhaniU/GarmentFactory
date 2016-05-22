/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfc.controller.StockController;

/**
 *
 * @author Gimhani Uthpala
 */
public class StockControllerImple extends UnicastRemoteObject implements StockController{
    private final StockController stockController;

    public StockControllerImple() throws RemoteException {
        super();
        this.stockController = new StockController() {} ;
    }
    
}
