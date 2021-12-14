/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Order {
    int oID;
    int uID;
    String uEmail;
    String uName;
    String uAddress;
    Date date;
    Double total;
    String status;

    public Order() {
    }

    public Order(int oID, String status) {
        this.oID = oID;
        this.status = status;
    }
    
    public Order(int oID, int uID, String uName, Date date, String status) {
        this.oID = oID;
        this.uID = uID;
        this.uName = uName;
        this.date = date;
        this.status = status;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public Order(int oID, int uID, Date date, String status) {
        this.oID = oID;
        this.uID = uID;
        this.date = date;
        this.status = status;
    }

    public Order(int oID, String uName, String uAddress, Date date, Double total, String status) {
        this.oID = oID;
        this.uName = uName;
        this.uAddress = uAddress;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
