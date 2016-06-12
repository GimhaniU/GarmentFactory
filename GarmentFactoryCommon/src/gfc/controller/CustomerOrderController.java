/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.CustomerOrder;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface CustomerOrderController extends Remote {

    public boolean addSale(ArrayList<CustomerOrder> sale_order) throws RemoteException, SQLException,ClassNotFoundException;
    
    public String getLastOrderId() throws RemoteException, SQLException,ClassNotFoundException;
    
    public ArrayList<CustomerOrder> getOrdersOfCustomer(String cust_id) throws RemoteException, SQLException,ClassNotFoundException;
    
    public ArrayList<CustomerOrder> searchOrder(String order_id) throws RemoteException, SQLException,ClassNotFoundException;

    public ArrayList<CustomerOrder> getSimilarOrderIDs(String customer,String order_id_part) throws RemoteException, SQLException,ClassNotFoundException;

    public double getMonthlySalesIncome(int year,int month) throws RemoteException, SQLException,ClassNotFoundException;

    public double getYearlySalesIncome(int year) throws RemoteException, SQLException,ClassNotFoundException;
}
