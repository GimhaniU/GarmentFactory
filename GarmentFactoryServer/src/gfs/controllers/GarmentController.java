/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

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

    public static Garment searchGarment(String garment_id) throws ClassNotFoundException, SQLException {
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

    public String getLastGarmentId() throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select garment_id From Garment order by garment_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("garment_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int addNewGarment(Garment garment) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Insert into Garment Values('" + garment.getGarment_id() + "','" + garment.getGarment_name() + "','" + garment.getIn_stock() + "','" +garment.getSewing_stipend()+ "','" + garment.getWaxing_stipend() + "')";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int updateGarmentStipends(Garment garment) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Update Garment set sewing_stipend= '" +garment.getSewing_stipend()+ "',waxing_stipend='" + garment.getWaxing_stipend() + "' where garment_id='"+garment.getGarment_id()+"';";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int updateGarmentStock(Garment garment) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            Garment searchGarment = searchGarment(garment.getGarment_id());
            int new_in_stock=searchGarment.getIn_stock()+garment.getIn_stock();
            String sql = "Update Garment set in_stock= '" +new_in_stock+ "'  where garment_id='"+garment.getGarment_id()+"';";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    
}
