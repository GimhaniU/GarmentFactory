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
public class DailyCoverage implements Serializable {
    private String garment_id;
    private String dateOfCover;
    private int	no_of_cut;
    private int	no_of_sewn;
    private int	no_of_dyed;
    private int	no_of_washdry;
    private int	no_of_sewfinish;
    private int	no_of_finish;
    private int no_spec; //to be used in 3 tuples
    
    public DailyCoverage() {
    }

    
    
    public DailyCoverage(String garment_id, String dateOfCover, int no_of_cut, int no_of_sewn, int no_of_dyed, int no_of_washdry, int no_of_sewfinish, int no_of_finish) {
        this.garment_id = garment_id;
        this.dateOfCover = dateOfCover;
        this.no_of_cut = no_of_cut;
        this.no_of_sewn = no_of_sewn;
        this.no_of_dyed = no_of_dyed;
        this.no_of_washdry = no_of_washdry;
        this.no_of_sewfinish = no_of_sewfinish;
        this.no_of_finish = no_of_finish;
    }

    public DailyCoverage(String garment_id, String dateOfCover, int no_spec) {
        this.garment_id = garment_id;
        this.dateOfCover = dateOfCover;
        this.no_spec=no_spec;
    }

    public int getNo_spec() {
        return no_spec;
    }

    public void setNo_spec(int no_spec) {
        this.no_spec = no_spec;
    }
    
    

    public String getGarment_id() {
        return garment_id;
    }

    public void setGarment_id(String garment_id) {
        this.garment_id = garment_id;
    }

    public String getDateOfCover() {
        return dateOfCover;
    }

    public void setDateOfCover(String dateOfCover) {
        this.dateOfCover = dateOfCover;
    }

    public int getNo_of_cut() {
        return no_of_cut;
    }

    public void setNo_of_cut(int no_of_cut) {
        this.no_of_cut = no_of_cut;
    }

    public int getNo_of_sewn() {
        return no_of_sewn;
    }

    public void setNo_of_sewn(int no_of_sewn) {
        this.no_of_sewn = no_of_sewn;
    }

    public int getNo_of_dyed() {
        return no_of_dyed;
    }

    public void setNo_of_dyed(int no_of_dyed) {
        this.no_of_dyed = no_of_dyed;
    }

    public int getNo_of_washdry() {
        return no_of_washdry;
    }

    public void setNo_of_washdry(int no_of_washdry) {
        this.no_of_washdry = no_of_washdry;
    }

    public int getNo_of_sewfinish() {
        return no_of_sewfinish;
    }

    public void setNo_of_sewfinish(int no_of_sewfinish) {
        this.no_of_sewfinish = no_of_sewfinish;
    }

    public int getNo_of_finish() {
        return no_of_finish;
    }

    public void setNo_of_finish(int no_of_finish) {
        this.no_of_finish = no_of_finish;
    }
    
    
    
}
