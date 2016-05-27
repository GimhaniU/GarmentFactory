/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.models.Customer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import gfs.controllers.MaterialController;
import gfc.models.Material;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gimhani Uthpala
 */
public class MaterialControllerImple extends UnicastRemoteObject implements gfc.controller.MaterialController{
    private final MaterialController materialController;

    public MaterialControllerImple() throws RemoteException {
        super();
        this.materialController = new MaterialController();
      
    }
    
    @Override
    public String getLastMaterialId() throws RemoteException, SQLException, ClassNotFoundException {
        return materialController.getLastMaterialId();
    }

    @Override
    public int addNewMaterial(Material material) throws RemoteException, SQLException, ClassNotFoundException {
        return materialController.addNewMaterial(material);
    }

    @Override
    public ArrayList<Material> getSimilarMaterials(String item) throws RemoteException, SQLException, ClassNotFoundException {
        return materialController.getSimilarMaterials(item);
    }

    @Override
    public Material searchMaterial(String mat_id) throws RemoteException, SQLException, ClassNotFoundException {
        return materialController.searchMaterial(mat_id);
    }
}
