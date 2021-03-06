/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import gfc.models.Employee;
import gfs.db_utilities.DBConnection;
import gfs.db_utilities.DBHandler;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public class EmployeeController {

    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int addNewEmployee(Employee employee) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Insert into Employee Values('" + employee.getEmp_id() + "','" + employee.getName() + "','" + employee.getAddress() + "','" + employee.getTelephone() + "','" + employee.getNic() + "','" + employee.getDuty() + "')";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public String getLastEmpId() throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();
            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select emp_id From Employee order by emp_id desc limit 1";
            ResultSet rst = DBHandler.getData(conn, sql);
            if (rst.next()) {
                return rst.getString("emp_id");
            } else {
                return null;
            }
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public ArrayList<Employee> getSimilarEmployeeNames(String name) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From employee where name like '" + name + "%'  order by name limit 10";
            ResultSet rst = DBHandler.getData(conn, sql);
            ArrayList<Employee> list = new ArrayList<>();
            while (rst.next()) {
                Employee employee = new Employee(rst.getString("emp_id"), rst.getString("Name"), rst.getString("address"), rst.getString("telephone"), rst.getString("nic"), rst.getString("duty"));
                list.add(employee);
            }
            return list;

        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public Employee searchEmployee(String id) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.readLock().lock();

            Connection conn = DBConnection.getDBConnection().getConnection();
            String sql = "Select * From employee where emp_id='" + id + "'";
            ResultSet rst = DBHandler.getData(conn, sql);
            Employee employee = null;
            if (rst.next()) {
                employee = new Employee(rst.getString("emp_id"), rst.getString("Name"), rst.getString("address"), rst.getString("telephone"), rst.getString("nic"), rst.getString("duty"));
            }
            return employee;
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
        try {
            readWriteLock.writeLock().lock();
            DBConnection dbconn = DBConnection.getDBConnection();
            Connection conn = dbconn.getConnection();
            String sql = "Update Employee set  name='" + employee.getName() + "',address='" + employee.getAddress() + "',telephone='" + employee.getTelephone() + "',nic='" + employee.getNic() + "',duty='" + employee.getDuty() + "' where emp_id='" + employee.getEmp_id() + "';";
            int res = DBHandler.setData(conn, sql);
            return res;
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    
}
