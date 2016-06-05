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
public class PieceCoverage implements Serializable{

    private String emp_id;
    private String garment_id;
    private String dateOfWork;
    private int no_of_pieces;
    private double waxing_stipend;
    private double sewing_stipend;

    public PieceCoverage(String emp_id, String garment_id, String dateOfWork, int no_of_pieces) {
        this.emp_id = emp_id;
        this.garment_id = garment_id;
        this.dateOfWork = dateOfWork;
        this.no_of_pieces = no_of_pieces;
    }

    public PieceCoverage() {
    }

    public PieceCoverage(String emp_id, String garment_id, String dateOfWork, int no_of_pieces, double sewing_stipend, double waxing_stipend) {
        this.emp_id = emp_id;
        this.garment_id = garment_id;
        this.dateOfWork = dateOfWork;
        this.no_of_pieces = no_of_pieces;
        this.waxing_stipend = waxing_stipend;
        this.sewing_stipend = sewing_stipend;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getGarment_id() {
        return garment_id;
    }

    public void setGarment_id(String garment_id) {
        this.garment_id = garment_id;
    }

    public String getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(String dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public int getNo_of_pieces() {
        return no_of_pieces;
    }

    public void setNo_of_pieces(int no_of_pieces) {
        this.no_of_pieces = no_of_pieces;
    }

    public double getWaxing_stipend() {
        return waxing_stipend;
    }

    public void setWaxing_stipend(double waxing_stipend) {
        this.waxing_stipend = waxing_stipend;
    }

    public double getSewing_stipend() {
        return sewing_stipend;
    }

    public void setSewing_stipend(double sewing_stipend) {
        this.sewing_stipend = sewing_stipend;
    }

}
