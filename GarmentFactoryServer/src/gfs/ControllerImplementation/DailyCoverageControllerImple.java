/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfs.controllers.DailyCoverageController;
import gfc.models.DailyCoverage;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public class DailyCoverageControllerImple extends UnicastRemoteObject implements gfc.controller.DailyCoverageController{
    private final DailyCoverageController dailyCoverageController;

    public DailyCoverageControllerImple() throws RemoteException {
        super();
        this.dailyCoverageController = new DailyCoverageController() {} ;
    }

    @Override
    public int addDailyCoverage(DailyCoverage dailyCoverage) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.addDailyCoverage(dailyCoverage);
    }

    @Override
    public int updateDailyCoverage(DailyCoverage dailyCoverage) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.updateDailyCoverage(dailyCoverage);
    }
    
    @Override
    public int addDailyCoverageSet(ArrayList<DailyCoverage> dailyCoverages) throws ClassNotFoundException, SQLException {
        return dailyCoverageController.addDailyCoverageSet(dailyCoverages);
    }

    @Override
    public DailyCoverage searchDailyCoverage(String date, String garment_id) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.searchDailyCoverage( date,garment_id);
    }

    @Override
    public int updateDailyCoverageCut(DailyCoverage dailyCoverage) throws RemoteException, SQLException, ClassNotFoundException {
       return dailyCoverageController.updateDailyCoverageCut( dailyCoverage);
    }

    @Override
    public int updateDailyCoverageSewn(DailyCoverage dailyCoverage) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.updateDailyCoverageSewn( dailyCoverage);
    }

    @Override
    public int updateDailyCoverageDyed(DailyCoverage dailyCoverage) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.updateDailyCoverageDyed( dailyCoverage);
    }

    @Override
    public int updateDailyCoverageWashDry(DailyCoverage dailyCoverage) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.updateDailyCoverageWashDry( dailyCoverage);
    }

    @Override
    public int updateDailyCoverageSewfinish(DailyCoverage dailyCoverage) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.updateDailyCoverageSewfinish( dailyCoverage);
    }

    @Override
    public int updateDailyCoverageFinish(DailyCoverage dailyCoverage) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.updateDailyCoverageFinish( dailyCoverage);
    }

    @Override
    public ArrayList<DailyCoverage> searchDailyCoverageForDate(int year, int month, int date) throws RemoteException, SQLException, ClassNotFoundException {
        return dailyCoverageController.searchDailyCoverageForDate(year, month,date);
    }

    @Override
    public ArrayList<DailyCoverage> searchDailyCoverageForMonth(int year, int month) throws RemoteException, SQLException, ClassNotFoundException{
        return dailyCoverageController.searchDailyCoverageForMonth(year, month);
    }
}
