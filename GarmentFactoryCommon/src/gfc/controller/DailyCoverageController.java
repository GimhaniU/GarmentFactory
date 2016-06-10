/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.DailyCoverage;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface DailyCoverageController extends Remote {

    public int addDailyCoverage(DailyCoverage dailyCoverage) throws RemoteException, SQLException,ClassNotFoundException;

    public int updateDailyCoverage(DailyCoverage dailyCoverage) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int updateDailyCoverageCut(DailyCoverage dailyCoverage) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int updateDailyCoverageSewn(DailyCoverage dailyCoverage) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int updateDailyCoverageDyed(DailyCoverage dailyCoverage) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int updateDailyCoverageWashDry(DailyCoverage dailyCoverage) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int updateDailyCoverageSewfinish(DailyCoverage dailyCoverage) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int updateDailyCoverageFinish(DailyCoverage dailyCoverage) throws RemoteException, SQLException,ClassNotFoundException;
    

    public DailyCoverage searchDailyCoverage(String date, String garment_id) throws RemoteException, SQLException,ClassNotFoundException;
    
    public ArrayList<DailyCoverage> searchDailyCoverageForDate(int year,int month,int date) throws RemoteException, SQLException,ClassNotFoundException;

    public int addDailyCoverageSet(ArrayList<DailyCoverage> dailyCoverages) throws RemoteException,ClassNotFoundException, SQLException ;

    public ArrayList<DailyCoverage> searchDailyCoverageForMonth(int year, int month) throws RemoteException,ClassNotFoundException, SQLException ;

}
