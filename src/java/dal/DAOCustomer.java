/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author This PC
 */
public class DAOCustomer {
   Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbconn = null;
    
    public DAOCustomer(DBContext dbconn) {
        conn = dbconn.connection;
        this.dbconn = dbconn;
    }

    public DAOCustomer() {
    }
    
    public User loginCustomer(String username, String password) {
        try {
            String sql = "select * from [FoodWhale].[dbo].[User] where uName = ? and password = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            while (rs.next()) {
//                Customer cus = new Customer(rs.getString(1), rs.getString(2));
                User cus = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10));
                return cus;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public User CheckExistCustomer(String username) {
        try {
            String sql = "select * from [FoodWhale].[dbo].[User] where uName = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                User cus = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10));
                return cus;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertCus(User cus) {
        int n = 0;
        try {
            String sql = "insert into [FoodWhale].[dbo].[User](email, password, uName, "
                    + "image, DoB, gender,address,phone)\n"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, cus.getEmail());
            ps.setString(2, cus.getPassword());
            ps.setString(3, cus.getUsername());
            ps.setString(4, cus.getImage());
            ps.setDate(5, cus.getDate());
            ps.setString(6, cus.getGender());
            ps.setString(7, cus.getAddress());
            ps.setString(8, cus.getPhone());

            
            n = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    } 
}
