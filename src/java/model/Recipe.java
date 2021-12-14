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
    String guideline;
    String cName;
    String Status;

    public Recipe() {
    }

    public Recipe(int rID, String Status) {
        this.rID = rID;
        this.Status = Status;
    }

    public Recipe(int rID, String rName, int cID, String image, String difficulty, int time, int uID, String rDescription, String guideline) {
        this.rID = rID;
        this.rName = rName;
        this.cID = cID;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
        this.guideline = guideline;
    }
    
    public Recipe(int rID, String rName, int cID, String image, String difficulty, int time, int uID, String rDescription, String guideline, String Status) {
        this.rID = rID;
        this.rName = rName;
        this.cID = cID;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
        this.guideline = guideline;
        this.Status = Status;
    }

    public Recipe(int rID, String rName, String cName, String image, String difficulty, int time, int uID, String rDescription, String guideline, String Status) {
        this.rID = rID;
        this.rName = rName;
        this.cName = cName;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
        this.guideline = guideline;
        this.Status = Status;
    }
    
    public Recipe(int rID, String rName, String cName, String image, String difficulty, int time, int uID, String rDescription, String guideline) {
        this.rID = rID;
        this.rName = rName;
        this.cName = cName;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
        this.guideline = guideline;
    }

    public Recipe(String rName, int cID, String image, String difficulty, int time, int uID, String rDescription, String guideline, String cName) {
        this.rName = rName;
        this.cID = cID;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
        this.guideline = guideline;
        this.cName = cName;
    }

    public Recipe(String rName, int cID, String image, String difficulty, int time, int uID, String rDescription, String guideline) {
        this.rName = rName;
        this.cID = cID;
        this.image = image;
        this.difficulty = difficulty;
        this.time = time;
        this.uID = uID;
        this.rDescription = rDescription;
        this.guideline = guideline;
    }

    public Recipe(int rID, String image, String rName, String rDescription, int time) {
        this.rID = rID;
        this.image = image;
        this.rName = rName;
        this.rDescription = rDescription;
        this.time = time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
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

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline1) {
        this.guideline = guideline;
    }

}
