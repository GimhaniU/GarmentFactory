/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfs.controllers.ExpenseController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Gimhani Uthpala
 */
public class ExpenseControllerImple extends UnicastRemoteObject implements gfc.controller.ExpenseController{
    private final ExpenseController expenseController;

    public ExpenseControllerImple() throws RemoteException {
        super();
        this.expenseController = new ExpenseController() ;
    }
}
