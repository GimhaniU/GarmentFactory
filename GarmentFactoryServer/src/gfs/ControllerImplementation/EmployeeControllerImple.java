/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import gfc.models.Employee;
import gfs.controllers.EmployeeController;

/**
 *
 * @author Gimhani Uthpala
 */
public class EmployeeControllerImple extends UnicastRemoteObject implements gfc.controller.EmployeeController{
    private final EmployeeController employeeController;

    public EmployeeControllerImple() throws RemoteException {
        super();
        this.employeeController = new EmployeeController() ;
    }

    @Override
    public int addNewEmployee(Employee employee) throws RemoteException, SQLException, ClassNotFoundException {
        return employeeController.addNewEmployee(employee);
    }

    @Override
    public String getLastEmpId() throws RemoteException, SQLException, ClassNotFoundException {
        return employeeController.getLastEmpId();
    }
    
}
