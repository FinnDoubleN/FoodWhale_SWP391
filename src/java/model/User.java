/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class User {
    
    public int uID;
    public String email;
    public String password;
    public String username;
    public String image;
    public Date date;
    public String gender;
    public String address;
    public String phone;
    public String role;
    public Boolean status;
    
    public User() {
    }

    public User(int uID, String email, String password, String username, String image, Date date, String gender, String address, String phone, String role, Boolean status) {
        this.uID = uID;
        this.email = email;
        this.password = password;
        this.username = username;
        this.image = image;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }
    
    public User(int uID, String email, String password, String username, String image, Date date, String gender, String address, String phone, String role) {
        this.uID = uID;
        this.email = email;
        this.password = password;
        this.username = username;
        this.image = image;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public User(String email, String password, String username, String image, Date date, String gender, String address, String phone, String role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.image = image;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public User(String email, String password, String username, String image, Date date, String gender, String address, String phone) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.image = image;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }
public User(int id, String email, String username, String image, String gender, String address, String phone) {
        this.uID = id;
        this.email = email;
        this.username = username;
        this.image = image;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }
    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    

    

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
