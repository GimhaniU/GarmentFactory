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
public class DailyClothUsage extends DailyMaterialUsage implements Serializable {

    private String garment_id;
    private int no_of_pieces;
    //other fields are inherited from DailyMaterialUsage
    private String garment_name;
    private String material_name;
    //for monthly usage
    private int month;
    //for monthly usage
    private int year;

    public DailyClothUsage() {
    }

    public DailyClothUsage(String mat_id, String garment_id, String dateOfUse, double amount, int no_of_pieces) {
        this.garment_id = garment_id;
        this.no_of_pieces = no_of_pieces;
        this.mat_id = mat_id;
        this.dateOfUse = dateOfUse;
        this.amount = amount;
    }

    public DailyClothUsage(String mat_id, String mat_name, String garment_id, String garment_name, String dateOfUse, double amount, int no_of_pieces) {
        this.garment_id = garment_id;
        this.garment_name = garment_name;
        this.material_name = mat_name;
        this.no_of_pieces = no_of_pieces;
        this.mat_id = mat_id;
        this.dateOfUse = dateOfUse;
        this.amount = amount;
    }

    public DailyClothUsage(String mat_id, String mat_name, String garment_id, String garment_name, int year, int month, double amount, int no_of_pieces) {
        this.garment_id = garment_id;
        this.garment_name = garment_name;
        this.material_name = mat_name;
        this.no_of_pieces = no_of_pieces;
        this.mat_id = mat_id;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public String getGarment_name() {
        return garment_name;
    }

    public void setGarment_name(String garment_name) {
        this.garment_name = garment_name;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
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

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
