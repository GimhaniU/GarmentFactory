/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfc.controller.CustomerController;
import gfc.controller.CustomerOrderController;

/**
 *
 * @author Gimhani Uthpala
 */
public class CustomerOrderControllerImple extends UnicastRemoteObject implements CustomerOrderController{
    private final CustomerOrderController customerOrderController;

    public CustomerOrderControllerImple() throws RemoteException {
        super();
        this.customerOrderController = new CustomerOrderController() {} ;
    }
}
