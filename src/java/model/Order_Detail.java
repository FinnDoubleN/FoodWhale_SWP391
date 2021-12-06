/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Order_Detail {
    int odID;
    int oID;
    int inID;
    int Quantity;
    double Total;
    String Note;

    public Order_Detail() {
    }

    public Order_Detail(int odID, int oID, int inID, int Quantity, double Total, String Note) {
        this.odID = odID;
        this.oID = oID;
        this.inID = inID;
        this.Quantity = Quantity;
        this.Total = Total;
        this.Note = Note;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    
    

    public Order_Detail(int odID, int oID, int inID, int Quantity) {
        this.odID = odID;
        this.oID = oID;
        this.inID = inID;
        this.Quantity = Quantity;
    }

    public int getOdID() {
        return odID;
    }

    public void setOdID(int odID) {
        this.odID = odID;
    }

    public int getoID() {
        return oID;
    }

    public void setoID(int oID) {
        this.oID = oID;
    }

    public int getInID() {
        return inID;
    }

    public void setInID(int inID) {
        this.inID = inID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
}
