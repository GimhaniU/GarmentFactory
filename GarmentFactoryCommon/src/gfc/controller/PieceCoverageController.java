/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.Customer;
import gfc.models.PieceCoverage;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface PieceCoverageController extends Remote{
    public int addPieceCoverage(ArrayList<PieceCoverage> pc) throws RemoteException, SQLException,ClassNotFoundException;
}
