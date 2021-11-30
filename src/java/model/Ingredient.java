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
public class Ingredient {
    int  inID;
    String inName;
    String image;
    String type;
    double money;
    int categoryID;
    String description;
    String guideline;

    public Ingredient() {
    }

    public Ingredient(int inID, String inName, String image, String type, double money, int categoryID, String description, String guideline) {
        this.inID = inID;
        this.inName = inName;
        this.image = image;
        this.type = type;
        this.money = money;
        this.categoryID = categoryID;
        this.description = description;
        this.guideline = guideline;
    }

    public int getInID() {
        return inID;
    }

    public void setInID(int inID) {
        this.inID = inID;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }
     
}
