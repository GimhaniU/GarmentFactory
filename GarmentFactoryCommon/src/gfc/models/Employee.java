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
public class Employee implements Serializable {

    private String emp_id;
    private String name;
    private String address;
    private String telephone;
    private String nic;
    private String duty;

    private int month;
    private int year;
    private int no_of_days;
    private int ot_hours;
    private double salary;

    
    public Employee() {
    }

    public Employee(String emp_id, String name, String address, String telephone, String nic, String duty) {
        this.emp_id = emp_id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.nic = nic;
        this.duty = duty;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    
}
