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
    String uName;
    Date date;
    boolean status;

    public Order() {
    }
    
    public Order(int oID, int uID, String uName, Date date, boolean status) {
        this.oID = oID;
        this.uID = uID;
        this.uName = uName;
        this.date = date;
        this.status = status;
    }

    public Order(int oID, int uID, Date date, boolean status) {
        this.oID = oID;
        this.uID = uID;
        this.date = date;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
