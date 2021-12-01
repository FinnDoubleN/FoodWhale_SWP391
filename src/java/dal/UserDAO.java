/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ADMIN
 */
public class UserDAO extends MyDAO {

    public User getUserByEmail(String email) throws Exception {
        User user = new User();
        ArrayList<User> lu = new ArrayList<>();
        String xsql = "select * from [FoodWhale].[dbo].[User] where Email='?' ";
        try {
            if (con != null) {
                ps = con.prepareStatement(xsql);
                ps.setString(1, email);
                rs = ps.executeQuery();
                while (rs.next()) {
                    user.setuID(rs.getInt(1));
                    user.setEmail(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setUsername(rs.getString(4));
                    user.setImage(rs.getString(5));
                    user.setDate(rs.getDate(6));
                    user.setGender(rs.getString(7));
                    user.setAddress(rs.getString(8));
                    user.setPhone(rs.getString(9));
                    user.setRole(rs.getString(10));
                    System.out.println(user);
                }
            }
        } catch (SQLException e) {
        }
        return user;
    }

    public static void main(String[] args) throws Exception {
        UserDAO a = new UserDAO();
        try {
            a.getUserByEmail("");
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
