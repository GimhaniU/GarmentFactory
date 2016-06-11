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
public class Income implements Serializable {

    private String income_id;
    private String income;
    private String dateOfInc;
    private double amount;

    public Income(String income_id, String income, String dateOfInc, double amount) {
        this.income_id = income_id;
        this.income = income;
        this.dateOfInc = dateOfInc;
        this.amount = amount;
    }

    public Income() {
    }

    public String getIncome_id() {
        return income_id;
    }

    public void setIncome_id(String income_id) {
        this.income_id = income_id;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getDateOfInc() {
        return dateOfInc;
    }

    public void setDateOfInc(String dateOfInc) {
        this.dateOfInc = dateOfInc;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }   

}
