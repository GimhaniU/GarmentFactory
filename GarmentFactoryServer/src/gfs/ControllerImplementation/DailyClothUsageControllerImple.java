/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.DailyClothUsage;
import gfc.models.DailyCoverage;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfs.controllers.DailyClothUsageController;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public class DailyClothUsageControllerImple extends UnicastRemoteObject implements gfc.controller.DailyClothUsageController{
    private final DailyClothUsageController dailyClothUsageController;

    public DailyClothUsageControllerImple() throws RemoteException {
        super();
        this.dailyClothUsageController = new DailyClothUsageController() {} ;
    }

    @Override
    public int addDailyClothUsage(DailyClothUsage dailyClothUsage) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyClothUsageController.addDailyClothUsage(dailyClothUsage);
    }

    @Override
    public DailyClothUsage searchDailyClothUsage(String date, String garment_id, String mat_id) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyClothUsageController.searchDailyClothUsage(date,garment_id, mat_id);
    }

    @Override
    public ArrayList<DailyClothUsage> searchDailyClothUsage(int year,int month,int date) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyClothUsageController.searchDailyClothUsage(year,month,date);
    }

    @Override
    public ArrayList<DailyClothUsage> searchDailyClothUsageOfMonth(int year, int month) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyClothUsageController.searchDailyClothUsageOfMonth(year,month);
    }

    
    
}
