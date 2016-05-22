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


}
