/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.CustomerOrder;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfs.controllers.CustomerOrderController;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public class CustomerOrderControllerImple extends UnicastRemoteObject implements gfc.controller.CustomerOrderController{
    private final CustomerOrderController customerOrderController;

    public CustomerOrderControllerImple() throws RemoteException {
        super();
        this.customerOrderController = new CustomerOrderController() {} ;
    }

    @Override
    public boolean addSale(ArrayList<CustomerOrder> sale_order) throws RemoteException, SQLException, ClassNotFoundException {
        return customerOrderController.addSale(sale_order);
    }

    @Override
    public String getLastOrderId() throws RemoteException, SQLException, ClassNotFoundException {
        return customerOrderController.getLastOrderId();
    }
}
