/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.DailyClothUsage;
import gfc.models.DailyCoverage;
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
public class DailyClothUsageController {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int addDailyClothUsage(DailyClothUsage dailyClothUsage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();

            String sql;
            if (searchDailyClothUsage(dailyClothUsage.getDateOfUse(),dailyClothUsage.getGarment_id(), dailyClothUsage.getMat_id()) != null) {
                sql = "Update dailyclothusage set no_of_pieces='" + dailyClothUsage.getNo_of_pieces() + "',amount='"+dailyClothUsage.getAmount()+"' where dateofuse='" + dailyClothUsage.getDateOfUse()+ "' and garment_id='" + dailyClothUsage.getGarment_id() + "' and mat_id='"+dailyClothUsage.getMat_id()+"';";
            } else {
                sql = "Insert into dailyclothusage Values('" + dailyClothUsage.getMat_id()+ "','" + dailyClothUsage.getGarment_id() + "','"+dailyClothUsage.getDateOfUse()+"','"+dailyClothUsage.getAmount()+"','"+dailyClothUsage.getNo_of_pieces()+"')";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public DailyClothUsage searchDailyClothUsage(String date, String garment_id, String mat_id) throws ClassNotFoundException, SQLException {
       try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From dailyclothusage where garment_id='" + garment_id + "' and dateofuse='" + date + "' and mat_id='"+mat_id+"';";
            ResultSet rst = DBHandler.getData(conn, sql);
            DailyClothUsage dailyClothUsage=null;
            if (rst.next()) {
                dailyClothUsage=new DailyClothUsage(mat_id, garment_id, date, dailyClothUsage.getAmount(), dailyClothUsage.getNo_of_pieces());
            }
            return dailyClothUsage;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
