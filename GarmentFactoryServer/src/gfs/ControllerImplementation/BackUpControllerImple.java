/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs.ControllerImplementation;

import gfc.controller.BackUP;
import gfs.controllers.BackUp;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;


/**
 *
 * @author DinsuG
 */
public class BackUpControllerImple extends UnicastRemoteObject implements BackUP{
    
    private final BackUp backUp;
    public  BackUpControllerImple()throws RemoteException{
        this.backUp=new BackUp();
    }

    @Override
    public int writeBackup() throws IOException, RemoteException, SQLException ,InterruptedException{
        return backUp.writeBackup();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int restoreBackup() throws RemoteException, IOException, InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
