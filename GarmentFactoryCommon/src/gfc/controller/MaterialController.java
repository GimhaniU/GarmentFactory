/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.controller;

import gfc.models.Customer;
import gfc.models.Material;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public interface MaterialController extends Remote {

    public int addNewMaterial(Material material) throws RemoteException, SQLException,ClassNotFoundException;
    
    
    
    public String getLastMaterialId() throws RemoteException, SQLException,ClassNotFoundException;

    public ArrayList<Material> getSimilarMaterials(String item) throws RemoteException, SQLException,ClassNotFoundException;

    public Material searchMaterial(String mat_id) throws RemoteException, SQLException,ClassNotFoundException;

    
}
