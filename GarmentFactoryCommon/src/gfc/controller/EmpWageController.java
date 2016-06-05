/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.EmpWage;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Gimhani Uthpala
 */
public interface EmpWageController extends Remote{
    public EmpWage getEmployeeAttendance(String emp_id, int month, int year) throws RemoteException, SQLException,ClassNotFoundException;
    
    public EmpWage getEmployeePieceSalary(String emp_id, int month, int year) throws RemoteException, SQLException,ClassNotFoundException;
    
    public EmpWage getEmployeeWage(String emp_id, int month, int year) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int addEmployeeAttendance(EmpWage new_employee) throws RemoteException, SQLException,ClassNotFoundException;;

    public int addEmployeeSalary(EmpWage employee) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int addEmployeePieceSalary(EmpWage employee) throws RemoteException, SQLException,ClassNotFoundException;
}
