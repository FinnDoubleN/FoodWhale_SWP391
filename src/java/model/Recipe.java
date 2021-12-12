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
    String cName;

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

    public Recipe(int rID, String rName, String cName, String image, String difficulty, int time, int uID, String rDescription, String guideline1, String guideline2, String guideline3) {
        this.rID = rID;
        this.rName = rName;
        this.cName = cName;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
        this.guideline1 = guideline1;
        this.guideline2 = guideline2;
        this.guideline3 = guideline3;
    }

    public Recipe(String rName, int cID, String image, String difficulty, int time, int uID, String rDescription, String guideline1, String guideline2, String guideline3, String cName) {
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
        this.cName = cName;
    }

    public Recipe(String rName, int cID, String image, String difficulty, int time, int uID, String rDescription, String guideline1, String guideline2, String guideline3) {
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

    public Recipe(int rID, String image, String rName, String rDescription, int time) {
        this.rID = rID;
        this.image = image;
        this.rName = rName;
        this.rDescription = rDescription;
        this.time = time;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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

    public String getGuideline1() {
        return guideline1;
    }

    public void setGuideline1(String guideline1) {
        this.guideline1 = guideline1;
    }

    public String getGuideline2() {
        return guideline2;
    }

    public void setGuideline2(String guideline2) {
        this.guideline2 = guideline2;
    }

    public String getGuideline3() {
        return guideline3;
    }

    public void setGuideline3(String guideline3) {
        this.guideline3 = guideline3;
    }

}
