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
public class Material implements Serializable{
    private String mat_id;
    private String mat_name;
    private String mat_type;
    private double in_stock;

    public Material() {
    }
    
    public Material(String mat_id, String mat_name, String mat_type, double in_stock) {
        this.mat_id = mat_id;
        this.mat_name = mat_name;
        this.mat_type = mat_type;
        this.in_stock = in_stock;
    }

    
    public String getMat_id() {
        return mat_id;
    }

    public void setMat_id(String mat_id) {
        this.mat_id = mat_id;
    }

    public String getMat_name() {
        return mat_name;
    }

    public void setMat_name(String mat_name) {
        this.mat_name = mat_name;
    }

    public String getMat_type() {
        return mat_type;
    }

    public void setMat_type(String mat_type) {
        this.mat_type = mat_type;
    }

    public double getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(double in_stock) {
        this.in_stock = in_stock;
    }
    
    
}
