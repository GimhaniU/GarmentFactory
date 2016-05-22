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
public class Garment implements Serializable{
    private String garment_id;
    private String garment_name;
    private int	in_stock;
    private double sewing_stipend;
    private double cutting_stipend;

    public Garment() {
    }

    public Garment(String garment_id, String garment_name, int in_stock) {
        this.garment_id = garment_id;
        this.garment_name = garment_name;
        this.in_stock = in_stock;
    }

    
    
    public Garment(String garment_id, String garment_name, int in_stock, double sewing_stipend, double cutting_stipend) {
        this.garment_id = garment_id;
        this.garment_name = garment_name;
        this.in_stock = in_stock;
        this.sewing_stipend = sewing_stipend;
        this.cutting_stipend = cutting_stipend;
    }

    
    
    public String getGarment_id() {
        return garment_id;
    }

    public void setGarment_id(String garment_id) {
        this.garment_id = garment_id;
    }

    public String getGarment_name() {
        return garment_name;
    }

    public void setGarment_name(String garment_name) {
        this.garment_name = garment_name;
    }

    public int getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(int in_stock) {
        this.in_stock = in_stock;
    }

    public double getSewing_stipend() {
        return sewing_stipend;
    }

    public void setSewing_stipend(double sewing_stipend) {
        this.sewing_stipend = sewing_stipend;
    }

    public double getCutting_stipend() {
        return cutting_stipend;
    }

    public void setCutting_stipend(double cutting_stipend) {
        this.cutting_stipend = cutting_stipend;
    }
    
    
}
