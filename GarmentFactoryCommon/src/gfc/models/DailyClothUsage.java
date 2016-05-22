/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.models;

import java.io.Serializable;

/**
 *
 * @author Gimhani Uthpala
 */
public class DailyClothUsage extends DailyMaterialUsage implements Serializable{
    private String garment_id;
    private int no_of_pieces;

    public DailyClothUsage() {
    }
    
    public DailyClothUsage(String mat_id,String garment_id, String dateOfUse, double amount, int no_of_pieces) {
        this.garment_id = garment_id;
        this.no_of_pieces = no_of_pieces;
        this.mat_id = mat_id;
        this.dateOfUse = dateOfUse;
        this.amount = amount;
    }

    public String getGarment_id() {
        return garment_id;
    }

    public void setGarment_id(String garment_id) {
        this.garment_id = garment_id;
    }

    public int getNo_of_pieces() {
        return no_of_pieces;
    }

    public void setNo_of_pieces(int no_of_pieces) {
        this.no_of_pieces = no_of_pieces;
    }
    
    
    
    
}
