/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfc.controller.GarmentController;

/**
 *
 * @author Gimhani Uthpala
 */
public class GarmentControllerImple extends UnicastRemoteObject implements GarmentController{
    private final GarmentController garmentController;

    public GarmentControllerImple() throws RemoteException {
        super();
        this.garmentController = new GarmentController() {} ;
    }
}
