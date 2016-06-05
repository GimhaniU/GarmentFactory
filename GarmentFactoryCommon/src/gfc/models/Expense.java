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
public class Expense implements Serializable {

    private String expense_id;
    private String expense;
    private String dateOfExp;
    private double amount;

    public Expense(String expense_id, String expense, String dateOfExp, double amount) {
        this.expense_id = expense_id;
        this.expense = expense;
        this.dateOfExp = dateOfExp;
        this.amount = amount;
    }

    public Expense() {
    }

    public String getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(String expense_id) {
        this.expense_id = expense_id;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getDateOfExp() {
        return dateOfExp;
    }

    public void setDateOfExp(String dateOfExp) {
        this.dateOfExp = dateOfExp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
