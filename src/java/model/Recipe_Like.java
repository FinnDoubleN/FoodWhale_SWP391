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
public class Recipe_Like {
    int rlID;
    int rID;
    int uID;
    boolean Fav;

    public Recipe_Like() {
    }

    public Recipe_Like(int rlID, int rID, int uID, boolean Fav) {
        this.rlID = rlID;
        this.rID = rID;
        this.uID = uID;
        this.Fav = Fav;
    }

    public int getRlID() {
        return rlID;
    }

    public void setRlID(int rlID) {
        this.rlID = rlID;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public boolean isFav() {
        return Fav;
    }

    public void setFav(boolean Fav) {
        this.Fav = Fav;
    }
    
}
