/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.DailyCoverage;
import gfc.models.Employee;
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
public class DailyCoverageController {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int addDailyCoverage(DailyCoverage dailyCoverage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Insert into daily_coverage Values('" + dailyCoverage.getGarment_id() + "','" + dailyCoverage.getDateOfCover() + "','" + dailyCoverage.getNo_of_cut() + "','" + dailyCoverage.getNo_of_sewn() + "','" + dailyCoverage.getNo_of_dyed() + "','" + dailyCoverage.getNo_of_washdry() + "','" + dailyCoverage.getNo_of_sewfinish() + "','" + dailyCoverage.getNo_of_finish() + "')";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int addDailyCoverageSet(ArrayList<DailyCoverage> dailyCoverages) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            conn.setAutoCommit(false);
            int ret = 1;
            try {
                for (DailyCoverage dailyCoverage : dailyCoverages) {
                    String sql = "Insert into daily_coverage Values('" + dailyCoverage.getGarment_id() + "','" + dailyCoverage.getDateOfCover() + "','" + dailyCoverage.getNo_of_cut() + "','" + dailyCoverage.getNo_of_sewn() + "','" + dailyCoverage.getNo_of_dyed() + "','" + dailyCoverage.getNo_of_washdry() + "','" + dailyCoverage.getNo_of_sewfinish() + "','" + dailyCoverage.getNo_of_finish() + "')";
                    int res = DBHandler.setData(conn, sql);
                    if (res <= 0) {
                        conn.rollback();
                        ret = 0;
                        break;
                    }

                }
                if (ret > 0) {
                    conn.commit();
                }
            } catch (SQLException e) {
                conn.rollback();
                ret = 0;
            } finally {
                conn.setAutoCommit(true);
            }
            return ret;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public DailyCoverage searchDailyCoverage(String date, String garment_id) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From daily_coverage where garment_id='" + garment_id + "' and dateofcover='" + date + "';";
            ResultSet rst = DBHandler.getData(conn, sql);
            DailyCoverage dailyCoverage = null;
            if (rst.next()) {
                dailyCoverage = new DailyCoverage(rst.getString("garment_id"), rst.getString("dateofcover"), rst.getInt("no_of_cut"), rst.getInt("no_of_sewn"), rst.getInt("no_of_dyed"), rst.getInt("no_of_washdry"), rst.getInt("no_of_sewfinish"), rst.getInt("no_of_finish"));
            }
            return dailyCoverage;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int updateDailyCoverage(DailyCoverage dailyCoverage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Update daily_coverage set no_of_cut='" + dailyCoverage.getNo_of_cut() + "',no_of_sewn='" + dailyCoverage.getNo_of_sewn() + "',no_of_dyed='" + dailyCoverage.getNo_of_dyed() + "',no_of_washdry='" + dailyCoverage.getNo_of_washdry() + "',no_of_sewfinish='" + dailyCoverage.getNo_of_sewfinish() + "',no_of_finish='" + dailyCoverage.getNo_of_finish() + "' where dateofcover='" + dailyCoverage.getDateOfCover() + "' and garment_id='" + dailyCoverage.getGarment_id() + "';";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int updateDailyCoverageCut(DailyCoverage dailyCoverage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();

            String sql;
            if (searchDailyCoverage(dailyCoverage.getDateOfCover(), dailyCoverage.getGarment_id()) != null) {
                sql = "Update daily_coverage set no_of_cut='" + dailyCoverage.getNo_spec() + "' where dateofcover='" + dailyCoverage.getDateOfCover() + "' and garment_id='" + dailyCoverage.getGarment_id() + "';";
            } else {
                sql = "Insert into daily_coverage Values('" + dailyCoverage.getGarment_id() + "','" + dailyCoverage.getDateOfCover() + "','" + dailyCoverage.getNo_spec()+ "','0','0','0','0','0')";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int updateDailyCoverageSewn(DailyCoverage dailyCoverage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();

            String sql;
            if (searchDailyCoverage(dailyCoverage.getDateOfCover(), dailyCoverage.getGarment_id()) != null) {
                sql = "Update daily_coverage set no_of_sewn='" + dailyCoverage.getNo_spec() + "' where dateofcover='" + dailyCoverage.getDateOfCover() + "' and garment_id='" + dailyCoverage.getGarment_id() + "';";
            } else {
                sql = "Insert into daily_coverage Values('" + dailyCoverage.getGarment_id() + "','" + dailyCoverage.getDateOfCover() + "','0','"+dailyCoverage.getNo_spec()+"','0','0','0','0')";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int updateDailyCoverageDyed(DailyCoverage dailyCoverage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();

            String sql;
            if (searchDailyCoverage(dailyCoverage.getDateOfCover(), dailyCoverage.getGarment_id()) != null) {
                sql = "Update daily_coverage set no_of_dyed='" + dailyCoverage.getNo_spec() + "' where dateofcover='" + dailyCoverage.getDateOfCover() + "' and garment_id='" + dailyCoverage.getGarment_id() + "';";
            } else {
                sql = "Insert into daily_coverage Values('" + dailyCoverage.getGarment_id() + "','" + dailyCoverage.getDateOfCover() + "','0','0','"+dailyCoverage.getNo_spec()+"','0','0','0')";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int updateDailyCoverageWashDry(DailyCoverage dailyCoverage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();

            String sql;
            if (searchDailyCoverage(dailyCoverage.getDateOfCover(), dailyCoverage.getGarment_id()) != null) {
                sql = "Update daily_coverage set no_of_washdry='" + dailyCoverage.getNo_spec() + "' where dateofcover='" + dailyCoverage.getDateOfCover() + "' and garment_id='" + dailyCoverage.getGarment_id() + "';";
            } else {
                sql = "Insert into daily_coverage Values('" + dailyCoverage.getGarment_id() + "','" + dailyCoverage.getDateOfCover() + "','0','0','0','"+dailyCoverage.getNo_spec()+"','0','0')";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int updateDailyCoverageSewfinish(DailyCoverage dailyCoverage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();

            String sql;
            if (searchDailyCoverage(dailyCoverage.getDateOfCover(), dailyCoverage.getGarment_id()) != null) {
                sql = "Update daily_coverage set no_of_sewfinish='" + dailyCoverage.getNo_spec() + "' where dateofcover='" + dailyCoverage.getDateOfCover() + "' and garment_id='" + dailyCoverage.getGarment_id() + "';";
            } else {
                sql = "Insert into daily_coverage Values('" + dailyCoverage.getGarment_id() + "','" + dailyCoverage.getDateOfCover() + "','0','0','0','0','"+dailyCoverage.getNo_spec()+"','0')";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int updateDailyCoverageFinish(DailyCoverage dailyCoverage) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();

            String sql;
            if (searchDailyCoverage(dailyCoverage.getDateOfCover(), dailyCoverage.getGarment_id()) != null) {
                sql = "Update daily_coverage set no_of_finish='" + dailyCoverage.getNo_spec() + "' where dateofcover='" + dailyCoverage.getDateOfCover() + "' and garment_id='" + dailyCoverage.getGarment_id() + "';";
            } else {
                sql = "Insert into daily_coverage Values('" + dailyCoverage.getGarment_id() + "','" + dailyCoverage.getDateOfCover() + "','0','0','0','0','0','"+dailyCoverage.getNo_spec()+"')";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public ArrayList<DailyCoverage> searchDailyCoverageForDate(int year, int month, int date) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From daily_coverage  left join garment  using(garment_id) where  dateofcover='"+year+"-"+month+"-" + date + "' or dateofcover='"+year+"-0"+month+"-" + date + "' or dateofcover='"+year+"-"+month+"-0" + date + "' or dateofcover='"+year+"-0"+month+"-0" + date + "';";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<DailyCoverage> dailyCoverages=new ArrayList<>();
            
            while(rst.next()) {
                DailyCoverage dailyCoverage=new DailyCoverage(rst.getString("garment_id"), rst.getString("garment_name"),rst.getString("dateofcover"), rst.getInt("no_of_cut"), rst.getInt("no_of_sewn"), rst.getInt("no_of_dyed"), rst.getInt("no_of_washdry"), rst.getInt("no_of_sewfinish"), rst.getInt("no_of_finish"));
                dailyCoverages.add(dailyCoverage);
            }
            return dailyCoverages;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<DailyCoverage> searchDailyCoverageForMonth(int year, int month) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select garment_id,garment_name,sum(no_of_cut) as s_cut,sum(no_of_sewn) as s_sewn,sum(no_of_dyed) as s_dyed,sum(no_of_washdry) as s_washdry,sum(no_of_sewfinish) as s_sewfinish,sum(no_of_finish) as s_finish From daily_coverage  left join garment  using(garment_id) where  dateofcover like '"+year+"-"+month+"-%' or dateofcover like '"+year+"-0"+month+"-%' group by garment_id;";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<DailyCoverage> dailyCoverages=new ArrayList<>();
            
            while(rst.next()) {
                DailyCoverage dailyCoverage=new DailyCoverage(rst.getString("garment_id"), rst.getString("garment_name"),year,month, rst.getInt("s_cut"), rst.getInt("s_sewn"), rst.getInt("s_dyed"), rst.getInt("s_washdry"), rst.getInt("s_sewfinish"), rst.getInt("s_finish"));
                dailyCoverages.add(dailyCoverage);
            }
            return dailyCoverages;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
