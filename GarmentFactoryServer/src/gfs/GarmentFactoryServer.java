/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfs;

import gfs.ControllerImplementation.RemoteFactoryImple;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gimhani Uthpala
 */
public class GarmentFactoryServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Registry myRegistry = LocateRegistry.createRegistry(344);
            myRegistry.rebind("GarmentFactoryServer", new RemoteFactoryImple());
            JOptionPane.showMessageDialog(null, "server started");
            System.out.println("server started...");
        } catch (ExportException e) {
           JOptionPane.showMessageDialog(null, "server already running");
            System.out.println("Server already running");
        }
    }
    
}
