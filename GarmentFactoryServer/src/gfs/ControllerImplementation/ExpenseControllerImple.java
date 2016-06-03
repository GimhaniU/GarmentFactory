/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.Expense;
import gfs.controllers.ExpenseController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

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

    @Override
    public ArrayList<Expense> getSimilarExpenseNames(String item) throws RemoteException, SQLException, ClassNotFoundException {
        return expenseController.getSimilarExpenseNames(item);
    }

    @Override
    public String getLastExpId() throws RemoteException, SQLException, ClassNotFoundException {
        return expenseController.getLastExpId();
    }

    @Override
    public int addNewExpense(Expense expense) throws RemoteException, SQLException, ClassNotFoundException {
        return expenseController.addNewExpense(expense);
    }
}
