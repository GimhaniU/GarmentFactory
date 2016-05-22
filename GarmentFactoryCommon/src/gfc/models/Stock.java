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
public class Stock implements Serializable{
    private String mat_id;
    private String dateOfBuy;
    private double amountOfBuy;
    private double unit_price;

    public Stock() {
    }
    
    public Stock(String mat_id, String dateOfBuy, double amountOfBuy, double unit_price) {
        this.mat_id = mat_id;
        this.dateOfBuy = dateOfBuy;
        this.amountOfBuy = amountOfBuy;
        this.unit_price = unit_price;
    }
    
    public String getMat_id() {
        return mat_id;
    }

    public void setMat_id(String mat_id) {
        this.mat_id = mat_id;
    }

    public String getDateOfBuy() {
        return dateOfBuy;
    }

    public void setDateOfBuy(String dateOfBuy) {
        this.dateOfBuy = dateOfBuy;
    }

    public double getAmountOfBuy() {
        return amountOfBuy;
    }

    public void setAmountOfBuy(double amountOfBuy) {
        this.amountOfBuy = amountOfBuy;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    
    
}
