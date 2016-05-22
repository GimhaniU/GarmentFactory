/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

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
public class MaterialController {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    public int addNewMaterial(Material material) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Insert into Material Values('" + material.getMat_id() + "','" + material.getMat_name() + "','" + material.getMat_type() + "')";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String getLastMaterialId() throws ClassNotFoundException, SQLException {

        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select mat_id From Material order by mat_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("mat_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
