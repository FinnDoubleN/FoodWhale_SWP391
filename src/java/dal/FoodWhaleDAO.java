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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ingredient;
import model.Recipe;
import model.User;

/**
 *
 * @author ADMIN
 */
public class FoodWhaleDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public Boolean IsMember(String username, String password) throws SQLException {
        String query = "select count(*) 'count' from [dbo].[User] where uName = '" + username + "' and Password = '" + password + "'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int count = rs.getInt(1);
                if (count != 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
        }
        return false;
    }

    public Boolean IsActive(String username, String password) throws SQLException {
        String query = "select Status from [dbo].[User] where uName = '" + username + "' and Password = '" + password + "'";
        ps = connection.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            boolean status = rs.getBoolean(1);
            if (status != false) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getAllAccount() {
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

    public ArrayList<User> getAllCustomer() {
        ArrayList<User> list = new ArrayList<>();
        String query = "select * from [FoodWhale].[dbo].[User] where Role = 'user'";
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
            statement.setInt(10, u.getuID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUserByID(int uID) throws Exception {
        User user = new User();
        String xsql = "select * from [FoodWhale].[dbo].[User] where uID= ?";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(xsql);
                ps.setInt(1, uID);
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

    public void createUser(String email, String password, String username, String image, Date date, String gender, String address, String phone, String role) {
        try {
            String sql = "INSERT INTO [FoodWhale].[dbo].[User](Email, Password, uName,Image, DoB, Gender, Address,Phone, Role) VALUES (?, ?, ?,?, ?, ?,?, ?, ?)";
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

    public User getProfileByUsername(String uName) throws SQLException {
        String sql = "select * from [dbo].[User] where [User].uName = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, uName);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            User p = new User(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDate(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10));
            return p;
        }
        return null;
    }

    public ArrayList<Recipe> getAllRecipe() {
        ArrayList<Recipe> list = new ArrayList<>();
        String query = "select * from [FoodWhale].[dbo].[Recipe] order by rID offset 0 rows fetch next 3 rows only";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Ingredient> getAllIngredient() {
        ArrayList<Ingredient> list = new ArrayList<>();
        String query = "select * from [FoodWhale].[dbo].[Ingredient]";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Ingredient(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Recipe> get3Recipe() {
        ArrayList<Recipe> list = new ArrayList<>();
        String query = "select * from [FoodWhale].[dbo].[Recipe] order by rID offset 6 rows fetch next 3 rows only";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
