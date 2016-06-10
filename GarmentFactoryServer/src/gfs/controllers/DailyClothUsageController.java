/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.DailyClothUsage;
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
                dailyClothUsage=new DailyClothUsage(mat_id, garment_id, date,rst.getDouble("amount"),rst.getInt("no_of_pieces") );
            }
            return dailyClothUsage;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<DailyClothUsage> searchDailyClothUsage(int year,int month,int date) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From dailyclothusage  left join garment  using(garment_id) left join material  using(mat_id) where  dateofuse='"+year+"-"+month+"-" + date + "' or dateofuse='"+year+"-0"+month+"-" + date + "' or dateofuse='"+year+"-"+month+"-0" + date + "' or dateofuse='"+year+"-0"+month+"-0" + date + "';";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<DailyClothUsage> clothUsages=new ArrayList<>();
            
            while(rst.next()) {
                DailyClothUsage dailyClothUsage=new DailyClothUsage(rst.getString("mat_id"),rst.getString("mat_name"),rst.getString("garment_id"),rst.getString("garment_name") ,rst.getString("dateofuse"),rst.getDouble("amount"),rst.getInt("no_of_pieces"));
                clothUsages.add(dailyClothUsage);
            }
            return clothUsages;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<DailyClothUsage> searchDailyClothUsageOfMonth(int year, int month) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select mat_id,mat_name,garment_id,garment_name,sum(amount) as s_amount,sum(no_of_pieces) as s_pieces From dailyclothusage  left join garment  using(garment_id) left join material  using(mat_id) where  dateofuse='"+year+"-"+month+"-%' or dateofuse='"+year+"-0"+month+"-%' group by garment_id;";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<DailyClothUsage> clothUsages=new ArrayList<>();
            
            while(rst.next()) {
                DailyClothUsage dailyClothUsage=new DailyClothUsage(rst.getString("mat_id"),rst.getString("mat_name"),rst.getString("garment_id"),rst.getString("garment_name") ,year,month,rst.getDouble("s_amount"),rst.getInt("s_pieces"));
                clothUsages.add(dailyClothUsage);
            }
            return clothUsages;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
