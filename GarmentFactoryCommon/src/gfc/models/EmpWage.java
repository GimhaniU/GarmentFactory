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
public class EmpWage implements Serializable{

    private String emp_id;
    private int month;
    private int year;
    private int no_of_days;
    private int ot_hours;
    private double dailywage;
    private double ot_rate;
    private double additions;
    private double deductions;

    private double total_stipend;

    //for wage based employees
    public EmpWage() {
    }

    public EmpWage(String emp_id, int month, int year, int no_of_days, int ot_hours) {
        this.emp_id = emp_id;
        this.month = month;
        this.year = year;
        this.no_of_days = no_of_days;
        this.ot_hours = ot_hours;
    }

    public EmpWage(String emp_id, int month, int year, int no_of_days, int ot_hours, double dailywage, double ot_rate, double additions, double deductions) {
        this.emp_id = emp_id;
        this.month = month;
        this.year = year;
        this.no_of_days = no_of_days;
        this.ot_hours = ot_hours;
        this.dailywage = dailywage;
        this.ot_rate = ot_rate;
        this.additions = additions;
        this.deductions = deductions;
    }

    //for piece based employees
    public EmpWage(String emp_id, int month, int year, double total_stipend, double additions, double deductions) {
        this.emp_id = emp_id;
        this.month = month;
        this.year = year;
        this.additions = additions;
        this.deductions = deductions;
        this.total_stipend = total_stipend;
    }

    public double getTotal_stipend() {
        return total_stipend;
    }

    public void setTotal_stipend(double total_stipend) {
        this.total_stipend = total_stipend;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
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

    public int getNo_of_days() {
        return no_of_days;
    }

    public void setNo_of_days(int no_of_days) {
        this.no_of_days = no_of_days;
    }

    public int getOt_hours() {
        return ot_hours;
    }

    public void setOt_hours(int ot_hours) {
        this.ot_hours = ot_hours;
    }

    public double getDailywage() {
        return dailywage;
    }

    public void setDailywage(double dailywage) {
        this.dailywage = dailywage;
    }

    public double getOt_rate() {
        return ot_rate;
    }

    public void setOt_rate(double ot_rate) {
        this.ot_rate = ot_rate;
    }

    public double getAdditions() {
        return additions;
    }

    public void setAdditions(double additions) {
        this.additions = additions;
    }

}
