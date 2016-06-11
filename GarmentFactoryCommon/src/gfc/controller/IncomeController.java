/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.Income;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface IncomeController extends Remote{
    public String getLastIncomeId() throws RemoteException, SQLException,ClassNotFoundException;
    
    public ArrayList<Income> getSimilarIncomeNames(String item) throws RemoteException, SQLException,ClassNotFoundException; 

    public int addNewIncome(Income income) throws RemoteException, SQLException,ClassNotFoundException;

    public ArrayList<Income> getMonthlyIncomeList(int year,int month) throws RemoteException, SQLException,ClassNotFoundException; 
    
    public ArrayList<Income> getYearlyIncomeList(int year) throws RemoteException, SQLException,ClassNotFoundException; 
}
