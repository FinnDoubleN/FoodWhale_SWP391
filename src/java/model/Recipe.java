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
public class Recipe {

    int rID;
    String rName;
    int cID;    
    String image;
    String difficulty;
    int time;
    int uID;
    String rDescription;
    String guideline1;
    String guideline2;
    String guideline3;

    public Recipe() {
    }

    public Recipe(int rID, String rName, int cID, String image, String difficulty, int time, int uID, String rDescription, String guideline1, String guideline2, String guideline3) {
        this.rID = rID;
        this.rName = rName;
        this.cID = cID;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
        this.guideline1 = guideline1;
        this.guideline2 = guideline2;
        this.guideline3 = guideline3;
    }

    public Recipe(int rID, String rName, int cID, String image, String difficulty, int time, int uID, String rDescription) {
        this.rID = rID;
        this.rName = rName;
        this.cID = cID;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
    }

    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }

}
