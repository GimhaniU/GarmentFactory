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
public class DailyMaterialUsage implements Serializable{
    protected String mat_id ;
    protected String dateOfUse;
    protected double amount;

    public DailyMaterialUsage() {
    }
    
    public DailyMaterialUsage(String mat_id, String dateOfUse, double amount) {
        this.mat_id = mat_id;
        this.dateOfUse = dateOfUse;
        this.amount = amount;
    }

    public String getMat_id() {
        return mat_id;
    }

    public void setMat_id(String mat_id) {
        this.mat_id = mat_id;
    }

    public String getDateOfUse() {
        return dateOfUse;
    }

    public void setDateOfUse(String dateOfUse) {
        this.dateOfUse = dateOfUse;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
