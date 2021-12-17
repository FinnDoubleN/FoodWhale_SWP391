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
    String Recipientname;
    String Address;
    String Phone;
    Date date;
    Double total;
    String Note;
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

    public Order(int oID, String Recipientname, String Address, String Phone, Date date, Double total, String note, String status) {
        this.oID = oID;
        this.Recipientname = Recipientname;
        this.Address = Address;
        this.Phone = Phone;
        this.date = date;
        this.total = total;
        this.Note = note;
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

    public String getRecipientname() {
        return Recipientname;
    }

    public void setRecipientname(String Recipientname) {
        this.Recipientname = Recipientname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    
}
