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

    int inID;
    String inName;
    String image;
    String type;
    double money;
    int categoryID;
    String description;
    String guideline;
    String cName;
    String status;

    public Ingredient() {
    }

    public Ingredient(int inID, String status) {
        this.inID = inID;
        this.status = status;
    }
    
    public Ingredient(int inID, String inName, String type, double money, String cName, String status) {
        this.inID = inID;
        this.inName = inName;
        this.type = type;
        this.money = money;
        this.cName = cName;
        this.status = status;
    }

    public Ingredient(int inID, String inName, double money, String description, String image) {
        this.inID = inID;
        this.inName = inName;
        this.money = money;
        this.description = description;
        this.image = image;
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

    public Ingredient(int inID, String inName, String image, String type, double money, String cName, String description, String guideline) {
        this.inID = inID;
        this.inName = inName;
        this.image = image;
        this.type = type;
        this.money = money;
        this.cName = cName;
        this.description = description;
        this.guideline = guideline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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
