/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ADMIN
 */
public class FoodWhaleDAO extends DBContext {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        String query = "select * from [FoodWhale].[dbo].[User]";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteUser(int id) {
        try {
            String query = "delete from [FoodWhale].[dbo].[User] where Uid=?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> search(int uID) {
        ArrayList<User> list = new ArrayList<>();
        String query = "select Email, Password, uName,Image,DoB,Gender,Address,Phone,Role\n"
                + "from [FoodWhale].[dbo].[User] \n"
                + "where uID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, uID);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }
         public void updateUser(User u) {
        try {
            String sql = "update [FoodWhale].[dbo].[User] set Email=?, Password=?,uName=?,Image=?,DoB=?,Gender=?,Address=?,Phone=?,Role=? where uID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, u.getEmail());
            statement.setString(2, u.getPassword());
            statement.setString(3, u.getUsername());
            statement.setString(4, u.getImage());
            statement.setDate(5, u.getDate());
            statement.setString(6, u.getGender());
            statement.setString(7, u.getAddress());
            statement.setString(8, u.getPhone());
            statement.setString(9, u.getRole());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void createUser(String email, String password, String username, String image, Date date, String gender, String address, String phone, String role) {
        try {
            String sql = "INSERT INTO [FoodWhale].[dbo].[User](name, gender, dob) VALUES (?, ?, ?,?, ?, ?,?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, username);
            statement.setString(4, image);
            statement.setDate(5, date);
            statement.setString(6, gender);
            statement.setString(7, address);
            statement.setString(8, phone);
            statement.setString(9, role);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
