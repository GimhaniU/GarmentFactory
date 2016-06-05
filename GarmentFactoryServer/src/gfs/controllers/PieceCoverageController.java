/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.PieceCoverage;
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
public class PieceCoverageController {
    
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    public int addPieceCoverage(ArrayList<PieceCoverage> pcs) throws ClassNotFoundException, SQLException {
        try {
            System.out.println("entered");
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            conn.setAutoCommit(false);
            int res = 1;
            try {
                for (PieceCoverage pc : pcs) {
                    String sql = "Insert into piece_coverage Values('" + pc.getEmp_id() + "','" + pc.getGarment_id() + "','" + pc.getDateOfWork() + "','" + pc.getNo_of_pieces() + "');";
                    res = DBHandler.setData(conn, sql);
                    //System.out.println("done"+pc.getGarment_id());
                    if(res<=0){
                        //System.out.println("failed"+pc.getGarment_id());
                        conn.rollback();
                        break;
                    }
                }
                if(res>0){
                    conn.commit();
                }
            } catch (SQLException e) {
                res=0;
                conn.rollback();
            } finally {
                conn.setAutoCommit(true);
            }
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public ArrayList<PieceCoverage> getPieceCoverage(String emp_id, int month, int year) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From piece_coverage left join garment using(garment_id) where emp_id= '" + emp_id+ "' and dateOfWork like '"+year+"-"+month+"-%' or dateOfWork like '"+year+"-0"+month+"-%' order by dateOfWork";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<PieceCoverage> list = new ArrayList<>();
            while (rst.next()) {
                PieceCoverage pc=new PieceCoverage(emp_id, rst.getString("garment_id"), rst.getString("dateOfWork"), rst.getInt("no_of_pieces"), rst.getDouble("sewing_stipend"),rst.getDouble("waxing_stipend"));
                list.add(pc);
            }
            return list;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
    
}
