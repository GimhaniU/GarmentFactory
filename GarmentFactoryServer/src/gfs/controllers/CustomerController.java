/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Customer;
import gfs.db_utilities.DBConnection;
import gfs.db_utilities.DBHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Gimhani Uthpala
 */
public class CustomerController {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int addNewCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Insert into Customer Values('" + customer.getCust_id() + "','" + customer.getName() + "','" + customer.getAddress() + "','" + customer.getTelephone() + "','" + customer.getNic() + "')";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String getLastCustId() throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select cust_id From Customer order by cust_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("cust_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<Customer> getSimilarCustomerNames(String name) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From customer where c_name like '" + name + "%'  order by c_name limit 10";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Customer> c_List = new ArrayList<>();
            while (rst.next()) {
                Customer customer = new Customer(rst.getString("cust_id"), rst.getString("C_Name"),  rst.getString("c_address"), rst.getString("c_telephone"), rst.getString("c_nic"));
                c_List.add(customer);
            }
            return c_List;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
