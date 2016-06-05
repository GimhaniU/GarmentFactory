/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import gfc.models.EmpWage;
import gfc.models.Employee;
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
public class EmpWageController {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static EmpWage getEmployeeAttendance(String emp_id, int month, int year) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From empwage where emp_id='" + emp_id + "' and month='" + month + "' and year='" + year + "'";
            ResultSet rst = DBHandler.getData(conn, sql);
            EmpWage employee = null;
            if (rst.next()) {
                employee = new EmpWage(rst.getString("emp_id"), rst.getInt("month"), rst.getInt("year"), rst.getInt("no_of_days"), rst.getInt("ot_hours"));
            }
            return employee;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int addEmployeeAttendance(EmpWage new_employee) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql;
            if (getEmployeeAttendance(new_employee.getEmp_id(), new_employee.getMonth(), new_employee.getYear()) != null) {
                sql = "Update empwage set  no_of_days='" + new_employee.getNo_of_days() + "',ot_hours='" + new_employee.getOt_hours() + "' where emp_id='" + new_employee.getEmp_id() + "' and month='" + new_employee.getMonth() + "' and year='" + new_employee.getYear() + "';";
            } else {
                sql = "Insert into empwage values('" + new_employee.getEmp_id() + "','" + new_employee.getMonth() + "','" + new_employee.getYear() + "','" + new_employee.getNo_of_days() + "','" + new_employee.getOt_hours() + "','0') ;";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int addEmployeeSalary(EmpWage employee) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();

            if (getEmployeeAttendance(employee.getEmp_id(), employee.getMonth(), employee.getYear()) != null) {
                String sql = "Update empwage set  no_of_days='" + employee.getNo_of_days() + "',ot_hours='" + employee.getOt_hours() + "',dailywage='" + employee.getDailywage() + "',ot_rate='" + employee.getOt_rate() + "',additions='" + employee.getAdditions() + "',deductions='" + employee.getDeductions() + "' where emp_id='" + employee.getEmp_id() + "' and month='" + employee.getMonth() + "' and year='" + employee.getYear() + "';";
                int res = DBHandler.setData(conn, sql);
                return res;
            } else {
                String sql = "Insert into empwage values('" + employee.getEmp_id() + "','" + employee.getMonth() + "','" + employee.getYear() + "','" + employee.getNo_of_days() + "','" + employee.getOt_hours() + "','" + employee.getDailywage() + "','" + employee.getOt_rate() + "','" + employee.getAdditions() + "','" + employee.getDeductions() + "') ;";
                int res = DBHandler.setData(conn, sql);
                return res;
            }

        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public int addEmployeePieceSalary(EmpWage employee) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql;
            if (getEmployeeAttendance(employee.getEmp_id(), employee.getMonth(), employee.getYear()) != null) {
                sql = "Update empsalary set  total_stipend='" + employee.getTotal_stipend() + "',deductions='" + employee.getDeductions() + "',additions='" + employee.getAdditions() + "' where emp_id='" + employee.getEmp_id() + "' and month='" + employee.getMonth() + "' and year='" + employee.getYear() + "';";
            } else {
                sql = "Insert into empsalary values('" + employee.getEmp_id() + "','" + employee.getMonth() + "','" + employee.getYear() + "','" + employee.getTotal_stipend() + "','" + employee.getAdditions() + "','" + employee.getDeductions() + "') ;";
            }
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public EmpWage getEmployeePieceSalary(String emp_id, int month, int year) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From empsalary where emp_id='" + emp_id + "' and month='" + month + "' and year='" + year + "'";
            ResultSet rst = DBHandler.getData(conn, sql);
            EmpWage employee = null;
            if (rst.next()) {
                employee = new EmpWage(rst.getString("emp_id"), rst.getInt("month"), rst.getInt("year"), rst.getDouble("total_stipend"), rst.getDouble("additions"), rst.getDouble("deductions"));
            }
            return employee;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public EmpWage getEmployeeWage(String emp_id, int month, int year) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From empwage where emp_id='" + emp_id + "' and month='" + month + "' and year='" + year + "'";
            ResultSet rst = DBHandler.getData(conn, sql);
            EmpWage employee = null;
            if (rst.next()) {
                employee = new EmpWage(rst.getString("emp_id"), rst.getInt("month"), rst.getInt("year"), rst.getInt("no_of_days"), rst.getInt("ot_hours"), rst.getDouble("dailywage"), rst.getDouble("ot_rate"), rst.getDouble("additions"), rst.getDouble("deductions"));
            }
            return employee;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
