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
public class Recipe_ingredient {
    int riID;
    int rID;
    int inID;

    public Recipe_ingredient() {
    }

    public Recipe_ingredient(int riID, int rID, int inID) {
        this.riID = riID;
        this.rID = rID;
        this.inID = inID;
    }

    public int getRiID() {
        return riID;
    }

    public void setRiID(int riID) {
        this.riID = riID;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public int getInID() {
        return inID;
    }

    public void setInID(int inID) {
        this.inID = inID;
    }
    
}
