/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.PieceCoverage;
import gfs.controllers.PieceCoverageController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public class PieceCoverageControllerImple extends UnicastRemoteObject implements gfc.controller.PieceCoverageController{
    private final PieceCoverageController pieceCoverageController;
    
    public PieceCoverageControllerImple() throws RemoteException {
        super();
        this.pieceCoverageController = new PieceCoverageController() ;
    }
    @Override
    public int addPieceCoverage(ArrayList<PieceCoverage> pc) throws RemoteException, SQLException, ClassNotFoundException {
        System.out.println("ENTER");
        return pieceCoverageController.addPieceCoverage(pc);
    }

    @Override
    public ArrayList<PieceCoverage> getPieceCoverage(String emp_id, int month, int year) throws RemoteException, SQLException, ClassNotFoundException {
        return pieceCoverageController.getPieceCoverage(emp_id, month, year);
    }
    
}
