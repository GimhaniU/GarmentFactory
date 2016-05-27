/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.DailyMaterialUsage;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfs.controllers.DailyMaterialUsageController;
import java.sql.SQLException;

/**
 *
 * @author Gimhani Uthpala
 */
public class DailyMaterialUsageControllerImple extends UnicastRemoteObject implements gfc.controller.DailyMaterialUsageController{
    private final DailyMaterialUsageController dailyMaterialUsageController;

    public DailyMaterialUsageControllerImple() throws RemoteException {
        super();
        this.dailyMaterialUsageController = new DailyMaterialUsageController() {} ;
    }

    @Override
    public boolean addDailyUsage(DailyMaterialUsage dmu) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyMaterialUsageController.addDailyUsage(dmu);
    }

    @Override
    public boolean isDateAdded(String mat_id, String date) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyMaterialUsageController.isDateAdded(mat_id, date);
    }
}
