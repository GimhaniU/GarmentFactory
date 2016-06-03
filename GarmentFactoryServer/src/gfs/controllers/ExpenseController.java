/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.Expense;
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
public class ExpenseController {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public ArrayList<Expense> getSimilarExpenseNames(String item) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From expense where expense like '" + item + "%'  order by expense limit 10";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Expense> list = new ArrayList<>();
            while (rst.next()) {
                Expense expense=new Expense(rst.getString("expense_id"),rst.getString("expense"),rst.getString("dateOfExp"),rst.getDouble("Amount"));
                list.add(expense);
            }
            return list;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public String getLastExpId() throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select expense_id From Expense order by expense_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("expense_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int addNewExpense(Expense expense) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Insert into Expense Values('" + expense.getExpense_id() + "','" + expense.getExpense() + "','" + expense.getDateOfExp() + "','" + expense.getAmount() + "')";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
