/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.EmpWage;
import gfs.controllers.EmpWageController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/**
 *
 * @author Gimhani Uthpala
 */
public class EmpWageControllerImple extends UnicastRemoteObject implements gfc.controller.EmpWageController{
    private final EmpWageController empWageController;

    public EmpWageControllerImple() throws RemoteException {
        super();
        this.empWageController = new EmpWageController() ;
    }

    @Override
    public int addEmployeeAttendance(EmpWage new_employee) throws RemoteException, SQLException, ClassNotFoundException {
        return empWageController.addEmployeeAttendance(new_employee);
    }

    @Override
    public int addEmployeeSalary(EmpWage employee) throws RemoteException, SQLException, ClassNotFoundException {
        return empWageController.addEmployeeSalary(employee);
    }

    @Override
    public EmpWage getEmployeeAttendance(String emp_id, int month, int year) throws RemoteException, SQLException, ClassNotFoundException {
        return empWageController.getEmployeeAttendance( emp_id, month, year);
    }

    @Override
    public int addEmployeePieceSalary(EmpWage employee) throws RemoteException, SQLException, ClassNotFoundException {
        return empWageController.addEmployeePieceSalary(employee);
    }

    @Override
    public EmpWage getEmployeePieceSalary(String emp_id, int month, int year) throws RemoteException, SQLException, ClassNotFoundException {
        return empWageController.getEmployeePieceSalary( emp_id, month, year);
    }

    @Override
    public EmpWage getEmployeeWage(String emp_id, int month, int year) throws RemoteException, SQLException, ClassNotFoundException {
        return empWageController.getEmployeeWage( emp_id, month, year);
    }
}
