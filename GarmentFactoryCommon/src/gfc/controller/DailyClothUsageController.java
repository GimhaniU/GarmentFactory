/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.DailyClothUsage;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface DailyClothUsageController extends Remote {
    public int addDailyClothUsage(DailyClothUsage dailyClothUsage) throws RemoteException, SQLException,ClassNotFoundException;

    public DailyClothUsage searchDailyClothUsage(String date, String garment_id,String mat_id) throws RemoteException, SQLException,ClassNotFoundException;
    
    public ArrayList<DailyClothUsage> searchDailyClothUsage(int year,int month,int date) throws RemoteException, SQLException,ClassNotFoundException;

    public ArrayList<DailyClothUsage> searchDailyClothUsageOfMonth(int year, int month) throws RemoteException, SQLException,ClassNotFoundException;

}
