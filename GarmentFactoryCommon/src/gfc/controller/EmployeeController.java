/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.Employee;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;


/**
 *
 * @author Gimhani Uthpala
 */
public interface EmployeeController extends Remote {
    
    public int addNewEmployee(Employee employee) throws RemoteException, SQLException,ClassNotFoundException;
    
    public String getLastEmpId() throws RemoteException, SQLException,ClassNotFoundException;
}
