/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.DailyCoverage;
import gfc.models.Employee;
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

    public DailyCoverage searchDailyCoverage(String date, String garment_id) throws RemoteException, SQLException,ClassNotFoundException;

    public int addDailyCoverageSet(ArrayList<DailyCoverage> dailyCoverages) throws RemoteException,ClassNotFoundException, SQLException ;
}
