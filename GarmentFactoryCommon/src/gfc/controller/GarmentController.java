/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.Garment;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface GarmentController extends Remote {

    public ArrayList<Garment> getSimilarGarmentNames(String item) throws RemoteException, SQLException,ClassNotFoundException;
    
    public int getStockInHand(String garment_id)  throws RemoteException, SQLException,ClassNotFoundException;
}
