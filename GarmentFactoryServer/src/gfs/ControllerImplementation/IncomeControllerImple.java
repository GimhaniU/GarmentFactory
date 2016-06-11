/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.Income;
import gfs.controllers.IncomeController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
class IncomeControllerImple extends UnicastRemoteObject implements gfc.controller.IncomeController{
    private final IncomeController incomeController;

    public IncomeControllerImple() throws RemoteException {
        super();
        this.incomeController = new IncomeController() ;
    }

    @Override
    public String getLastIncomeId() throws RemoteException, SQLException, ClassNotFoundException {
        return incomeController.getLastIncomeId();
    }

    @Override
    public ArrayList<Income> getSimilarIncomeNames(String item) throws RemoteException, SQLException, ClassNotFoundException {
        return incomeController.getSimilarIncomeNames(item);
    }

    @Override
    public int addNewIncome(Income income) throws RemoteException, SQLException, ClassNotFoundException {
        return incomeController.addNewIncome(income);
    }

    @Override
    public ArrayList<Income> getMonthlyIncomeList(int year, int month) throws RemoteException, SQLException, ClassNotFoundException {
        return incomeController.getMonthlyIncomeList(year,month);
    }

    @Override
    public ArrayList<Income> getYearlyIncomeList(int year) throws RemoteException, SQLException, ClassNotFoundException {
        return incomeController.getYearlyIncomeList(year);
    }
}
