/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfc.controller.DailyMaterialUsageController;

/**
 *
 * @author Gimhani Uthpala
 */
public class DailyMaterialUsageControllerImple extends UnicastRemoteObject implements DailyMaterialUsageController{
    private final DailyMaterialUsageController dailyMaterialUsageController;

    public DailyMaterialUsageControllerImple() throws RemoteException {
        super();
        this.dailyMaterialUsageController = new DailyMaterialUsageController() {} ;
    }
}
