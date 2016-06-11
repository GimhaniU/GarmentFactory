/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.Employee;
import gfc.models.Expense;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface ExpenseController extends Remote{
    public String getLastExpId() throws RemoteException, SQLException,ClassNotFoundException;
    
    public ArrayList<Expense> getSimilarExpenseNames(String item) throws RemoteException, SQLException,ClassNotFoundException; 

    public int addNewExpense(Expense expense) throws RemoteException, SQLException,ClassNotFoundException;

    public ArrayList<Expense> getMonthlyExpenses(int year,int month) throws RemoteException, SQLException,ClassNotFoundException; 
    
    public ArrayList<Expense> getYearlyExpenses(int year) throws RemoteException, SQLException,ClassNotFoundException; 
}
