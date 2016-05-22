/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfcl;

import gfcl.views.StartSplash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author Gimhani Uthpala
 */
public class GarmentFactoryClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());   
            
            new StartSplash().setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GarmentFactoryClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
