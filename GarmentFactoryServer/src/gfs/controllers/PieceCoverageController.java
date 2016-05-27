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
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            conn.setAutoCommit(false);
            int res = 1;
            try {
                for (PieceCoverage pc : pcs) {
                    String sql = "Insert into piece_coverage Values('" + pc.getEmp_id() + "','" + pc.getGarment_id() + "','" + pc.getDateOfWork() + "','" + pc.getNo_of_pieces() + "');";
                    res = DBHandler.setData(conn, sql);
                    if(res<=0){
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
    
}
