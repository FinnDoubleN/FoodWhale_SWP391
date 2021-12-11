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
    String image;
    String inName;
    String type;
    int Price;

    public Order_Detail(int oID, int inID, int Quantity, String inName, String image, String type, int Price) {
        this.oID = oID;
        this.inID = inID;
        this.Quantity = Quantity;
        this.inName = inName;
        this.image = image;
        this.type = type;
        this.Price = Price;
    }

    public Order_Detail(String image, String inName, String type, int Price, int Quantity) {
        this.image = image;
        this.inName = inName;
        this.type = type;
        this.Price = Price;
        this.Quantity = Quantity;
    }

    public Order_Detail(int odID, int oID, int inID, int Quantity) {
        this.odID = odID;
        this.oID = oID;
        this.inID = inID;
        this.Quantity = Quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
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
