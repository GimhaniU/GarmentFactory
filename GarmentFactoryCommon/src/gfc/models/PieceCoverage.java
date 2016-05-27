/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gfc.models;

/**
 *
 * @author Gimhani Uthpala
 */
public class PieceCoverage {
    private String emp_id;
    private String garment_id;
    private String dateOfWork;
    private int no_of_pieces;

    public PieceCoverage(String emp_id, String garment_id, String dateOfWork, int no_of_pieces) {
        this.emp_id = emp_id;
        this.garment_id = garment_id;
        this.dateOfWork = dateOfWork;
        this.no_of_pieces = no_of_pieces;
    }

    public PieceCoverage() {
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
    
    
    
}
