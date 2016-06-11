/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfs.controllers.CustomerController;
import gfc.models.Customer;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public class CustomerControllerImple extends UnicastRemoteObject implements gfc.controller.CustomerController{
    private final CustomerController customerController;

    public CustomerControllerImple() throws RemoteException {
        super();
        this.customerController = new CustomerController() ;
    }

    @Override
    public int addNewCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException {
        return customerController.addNewCustomer(customer);
    }

    @Override
    public String getLastCustId() throws RemoteException, SQLException, ClassNotFoundException {
        return customerController.getLastCustId();
    }

    @Override
    public ArrayList<Customer> getSimilarCustomerNames(String name) throws RemoteException, SQLException, ClassNotFoundException {
        return customerController.getSimilarCustomerNames(name);
    }

    @Override
    public int updateCustomer(Customer customer) throws RemoteException, SQLException, ClassNotFoundException {
        return customerController.updateCustomer(customer);
    }

    @Override
    public Customer searchCustomer(String cust_id) throws RemoteException, SQLException, ClassNotFoundException {
        return customerController.searchCustomer(cust_id);
    }
}
