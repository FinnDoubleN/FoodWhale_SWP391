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
public class Category {
    
    int categoryID;
    String cname;
    String status;

    public Category() {
    }

    public Category(int categoryID, String cname) {
        this.categoryID = categoryID;
        this.cname = cname;
    }

    public Category(int categoryID, String cname, String status) {
        this.categoryID = categoryID;
        this.cname = cname;
        this.status = status;
    }
    
    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
