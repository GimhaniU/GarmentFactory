/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.Customer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface CustomerController extends Remote {
    public int addNewCustomer(Customer customer) throws RemoteException, SQLException,ClassNotFoundException;

    public String getLastCustId()  throws RemoteException, SQLException,ClassNotFoundException;
    
    public ArrayList<Customer> getSilimarCustomerNames(String name)  throws RemoteException, SQLException,ClassNotFoundException;

}
