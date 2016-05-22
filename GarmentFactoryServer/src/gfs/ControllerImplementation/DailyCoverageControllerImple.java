/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfc.controller.DailyCoverageController;

/**
 *
 * @author Gimhani Uthpala
 */
public class DailyCoverageControllerImple extends UnicastRemoteObject implements DailyCoverageController{
    private final DailyCoverageController dailyCoverageController;

    public DailyCoverageControllerImple() throws RemoteException {
        super();
        this.dailyCoverageController = new DailyCoverageController() {} ;
    }
}
