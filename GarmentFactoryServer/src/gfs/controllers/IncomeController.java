/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Expense;
import gfc.models.Income;
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
public class IncomeController {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public ArrayList<Income> getMonthlyIncomeList(int year, int month) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From income where  dateofinc like '" + year + "-" + month + "-%' or dateofinc like '" + year + "-0" + month + "-%'";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Income> list = new ArrayList<>();
            while (rst.next()) {
                Income income = new Income(rst.getString("income_id"), rst.getString("income"), rst.getString("dateOfInc"), rst.getDouble("Amount"));
                list.add(income);
            }
            return list;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int addNewIncome(Income income) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Insert into Income Values('" + income.getIncome_id() + "','" + income.getIncome() + "','" + income.getDateOfInc() + "','" + income.getAmount() + "');";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public ArrayList<Income> getSimilarIncomeNames(String item) throws SQLException, ClassNotFoundException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From income where income like '" + item + "%'  order by income limit 10";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Income> list = new ArrayList<>();
            while (rst.next()) {
                Income income = new Income(rst.getString("income_id"), rst.getString("income"), rst.getString("dateOfInc"), rst.getDouble("Amount"));
                list.add(income);
            }
            return list;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<Income> getYearlyIncomeList(int year) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From income where  dateofinc like '" + year + "%' ";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Income> list = new ArrayList<>();
            while (rst.next()) {
                Income income = new Income(rst.getString("income_id"), rst.getString("income"), rst.getString("dateOfInc"), rst.getDouble("Amount"));
                list.add(income);
            }
            return list;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public String getLastIncomeId() throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select income_id From income order by incom_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("income_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
