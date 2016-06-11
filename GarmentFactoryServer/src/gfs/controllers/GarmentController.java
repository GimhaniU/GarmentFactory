/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Employee;
import gfc.models.Garment;
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
public class GarmentController {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public ArrayList<Garment> getSimilarGarmentNames(String item) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From garment where garment_name like '" + item + "%'  order by garment_name limit 10";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Garment> list = new ArrayList<>();
            while (rst.next()) {
                Garment garment=new Garment(rst.getString("garment_id"),rst.getString("garment_name"), rst.getInt("in_stock"));                
                list.add(garment);
            }
            return list;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
    
    public static int getStockInHand(String garment_id) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select in_stock From Garment where garment_id='"+garment_id+"';";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getInt("in_stock");
            } else {
                return 0;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public Garment searchGarment(String garment_id) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From garment where garment_id='" + garment_id + "'";
            ResultSet rst = DBHandler.getData(conn, sql);
            Garment garment=null;
            if (rst.next()) {
                garment=new Garment(garment_id,rst.getString("garment_name"),rst.getInt("in_stock") , rst.getDouble("sewing_stipend"), rst.getDouble("waxing_stipend"));
            }
            return garment;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
