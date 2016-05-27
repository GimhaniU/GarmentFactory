/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.DailyMaterialUsage;
import gfc.models.Material;
import gfs.db_utilities.DBConnection;
import gfs.db_utilities.DBHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Gimhani Uthpala
 */
public class DailyMaterialUsageController {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public boolean addDailyUsage(DailyMaterialUsage dmu) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            boolean ret = true;
            conn.setAutoCommit(false);
            try {
                Material searchMaterial = MaterialController.searchMaterial(dmu.getMat_id());
                Double new_stock = searchMaterial.getIn_stock() - dmu.getAmount();
                
                String sql ="Insert into dailymaterialusage values('"+dmu.getMat_id()+"','" +dmu.getDateOfUse() + "','" + dmu.getAmount() + "');"; 
                int res = DBHandler.setData(conn, sql);
                if (res > 0) {
                    String sql1 = "Update Material set  in_stock='" + new_stock + "' where mat_id='" + dmu.getMat_id() + "';";
                    int res1 = DBHandler.setData(conn, sql1);
                    if (res1 <= 0) {
                        ret = false;
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

    public boolean isDateAdded(String mat_id, String date) throws ClassNotFoundException, SQLException {
            try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From dailymaterialusage where mat_id='"+mat_id+"' and dateofuse='"+date+"'";
            ResultSet rst = DBHandler.getData(conn, sql);
            return rst.next();
        } finally {
            readWriteLock.readLock().unlock();
        }
      
    }
    
}
