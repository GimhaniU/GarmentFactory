/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.CustomerOrder;
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
public class CustomerOrderController {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addSale(ArrayList<CustomerOrder> sale_order) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            boolean ret = true;
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            conn.setAutoCommit(false);
            //to add to customer orders
            try {
                for (CustomerOrder order : sale_order) {
                    String sql = "Insert into CustomerOrder Values('" + order.getOrder_id() + "','" + order.getCust_id() + "','" + order.getGarment_id() + "','" + order.getDateOfOrder() + "','" + order.getAmount() + "','" + order.getUnit_price() + "')";
                    int res = DBHandler.setData(conn, sql);
                    if (res < 0) {
                        ret = false;
                        conn.rollback();
                        break;
                    }
                }
                if (ret) {
                    //to deduct sold items from stock
                    for (CustomerOrder order : sale_order) {
                        int stockinhand = GarmentController.getStockInHand(order.getGarment_id());
                        int new_stock = stockinhand - order.getAmount();
                        String sql = "Update Garment set in_stock='" + new_stock + "' where garment_id='" + order.getGarment_id() + "'";
                        int res = DBHandler.setData(conn, sql);
                        if (res < 0) {
                            ret = false;
                            conn.rollback();
                            break;
                        }
                    }
                }
                if (ret) {
                    conn.commit();
                }
            } catch (SQLException sqle) {
                ret=false;
                conn.rollback();
            } finally {
                conn.setAutoCommit(true);
            }
            return ret;
        } finally {
            readWriteLock.writeLock().unlock();

        }
    }

    public String getLastOrderId() throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select order_id From customerorder order by order_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("order_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
