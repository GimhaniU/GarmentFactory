/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.DailyMaterialUsage;
import gfc.models.Material;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 *
 * @author Gimhani Uthpala
 */
public interface DailyMaterialUsageController extends Remote {
    public boolean isDateAdded(String mat_id,String date)throws RemoteException, SQLException,ClassNotFoundException;
    
    public boolean addDailyUsage(DailyMaterialUsage dmu) throws RemoteException, SQLException,ClassNotFoundException;
}
