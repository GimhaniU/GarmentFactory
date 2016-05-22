/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfc.controller.DailyClothUsageController;

/**
 *
 * @author Gimhani Uthpala
 */
public class DailyClothUsageControllerImple extends UnicastRemoteObject implements DailyClothUsageController{
    private final DailyClothUsageController dailyClothUsageController;

    public DailyClothUsageControllerImple() throws RemoteException {
        super();
        this.dailyClothUsageController = new DailyClothUsageController() {} ;
    }
    
}
