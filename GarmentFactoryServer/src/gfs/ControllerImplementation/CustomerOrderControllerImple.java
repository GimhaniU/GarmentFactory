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

    @Override
    public ArrayList<CustomerOrder> getSimilarOrderIDs(String customer,String order_id_part) throws RemoteException, SQLException, ClassNotFoundException {
        return customerOrderController.getSimilarOrderIDs(customer,order_id_part);
    }

    @Override
    public ArrayList<CustomerOrder> searchOrder(String order_id) throws RemoteException, SQLException, ClassNotFoundException {
        return customerOrderController.searchOrder(order_id);
    }

    @Override
    public ArrayList<CustomerOrder> getOrdersOfCustomer(String cust_id) throws RemoteException, SQLException, ClassNotFoundException {
        return customerOrderController.getOrdersOfCustomer(cust_id);
    }

    @Override
    public double getMonthlySalesIncome(int year, int month) throws RemoteException, SQLException, ClassNotFoundException {
        return customerOrderController.getMonthlySalesIncome(year, month);
    }

    @Override
    public double getYearlySalesIncome(int year) throws RemoteException, SQLException, ClassNotFoundException {
        return customerOrderController.getYearlySalesIncome(year);
    }
}
