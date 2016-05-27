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
public class CustomerOrder implements Serializable{
    private String order_id;
    private String cust_id;
    private String garment_id;
    private String dateOfOrder;
    private int	amount ;
    private double unit_price;

    public CustomerOrder(String order_id,String cust_id, String garment_id, String dateOfOrder, int amount, double unit_price) {
        this.order_id=order_id;
        this.cust_id = cust_id;
        this.garment_id = garment_id;
        this.dateOfOrder = dateOfOrder;
        this.amount = amount;
        this.unit_price = unit_price;
    }

    public CustomerOrder() {
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    
    
    
    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getGarment_id() {
        return garment_id;
    }

    public void setGarment_id(String garment_id) {
        this.garment_id = garment_id;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
    
    
}
