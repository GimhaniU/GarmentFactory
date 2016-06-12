/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Expense;
import gfc.models.Material;
import gfc.models.Stock;
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
public class StockController {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean updateStock(Stock stock) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            boolean ret = true;
            conn.setAutoCommit(false);
            try {
                Material searchMaterial = MaterialController.searchMaterial(stock.getMat_id());
                Double new_stock = searchMaterial.getIn_stock() + stock.getAmountOfBuy();
                String sql ="Insert into stock values('"+stock.getStock_id()+"','" + stock.getMat_id() + "','" + stock.getDateOfBuy() + "','" + stock.getAmountOfBuy() + "','" + stock.getUnit_price() + "');"; 
                int res = DBHandler.setData(conn, sql);
                if (res > 0) {
                    String sql1 = "Update Material set  in_stock='" + new_stock + "' where mat_id='" + stock.getMat_id() + "';";
                    int res1 = DBHandler.setData(conn, sql1);
                    if (res1 <= 0) {
                        ret = false;
                        System.out.println("error");
                        conn.rollback();
                    }
                } else {
                    ret = false;
                    conn.rollback();
                }
                if(ret){
                    conn.commit();
                }
            } catch (SQLException sqle) {
                ret = false;
                conn.rollback();
            } finally {
                conn.setAutoCommit(true);
            }
            return ret;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String getLastStockId() throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select stock_id From stock order by stock_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("stock_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public double getMonthlyCostForMaterial(int year, int month) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select sum(amountofbuy*unit_price) as total From stock where  dateofbuy like '"+year+"-"+month+"-%' or dateofbuy like '"+year+"-0"+month+"-%'";
            ResultSet rst = DBHandler.getData(conn, sql);
            if(rst.next()){
                return rst.getDouble("total");
            }else{
                return 0;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public double getYearlyCostForMaterial(int year) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select sum(amountofbuy*unit_price) as total From stock where  dateofbuy like '"+year+"%' ";
            ResultSet rst = DBHandler.getData(conn, sql);
            if(rst.next()){
                return rst.getDouble("total");
            }else{
                return 0;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
