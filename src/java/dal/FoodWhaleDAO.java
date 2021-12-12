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
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Category;
import model.Ingredient;
import model.Order;
import model.Order_Detail;
import model.Recipe;
import model.Recipe_Like;
import model.Recipe_ingredient;
import model.User;

/**
 *
 * @author ADMIN
 */
public class FoodWhaleDAO extends DBContext {

    private static final Random rand = new Random();
    PreparedStatement ps;
    ResultSet rs;

    public Boolean IsMember(String username, String password) throws SQLException {
        String query = "select count(*) 'count' from foodwhale.user where uName = '" + username + "' and Password = '" + password + "'";
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
        String query = "select Status from foodwhale.user where uName = '" + username + "' and Password = '" + password + "'";

        ps = connection.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            String status = rs.getString(1);
            if (status.equalsIgnoreCase("Active")) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getAllAccount() {
        ArrayList<User> list = new ArrayList<>();
        String query = "select * from foodwhale.user";

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
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<User> getAllCustomer() {
        ArrayList<User> list = new ArrayList<>();
        String query = "select * from foodwhale.user where Role = 'user'";

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
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> list = new ArrayList<>();
        String query = "select * from foodwhale.category";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> list = new ArrayList<>();
        String query = "select o.oID , u.uName, u.Address, o.Date, o.Status from foodwhale.order o inner join foodwhale.user u on o.uID = u.uID";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Order getOrderByID(int oID) throws Exception {
        Order order = new Order();
        String xsql = "select o.oID , u.Email, u.uName, u.Address, o.Date, o.Status from foodwhale.order o inner join foodwhale.user u on o.uID = u.uID where oID=?";

        try {
            if (connection != null) {
                ps = connection.prepareStatement(xsql);
                ps.setInt(1, oID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    order.setoID(rs.getInt(1));
                    order.setuEmail(rs.getString(2));
                    order.setuName(rs.getString(3));
                    order.setuAddress(rs.getString(4));
                    order.setDate(rs.getDate(5));
                    order.setStatus(rs.getString(6));
                    System.out.println(order);
                }
            }
        } catch (SQLException e) {
        }
        return order;
    }

    public void deleteUser(int id) {
        try {
            String query = "delete from foodwhale.user where Uid=?";

            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRecipe(int id) {
        try {
            String query = "delete from foodwhale.recipe where rID=?";
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteIngredientDetail(int id) {
        try {
            String query = "delete from foodwhale.ingredient where inID=?";
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
                + "from foodwhale.user \n"
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
        } catch (SQLException e) {
        }
        return list;
    }

    public void updateUser(User u) {
        try {
            String sql = "update foodwhale.user set Email=?,uName=?,Image=?,DoB=?,Gender=?,Address=?,Phone=?,Role=?, sName=?, Status=? where uID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, u.getEmail());
            statement.setString(2, u.getUsername());
            statement.setString(3, u.getImage());
            statement.setDate(4, u.getDate());
            statement.setString(5, u.getGender());
            statement.setString(6, u.getAddress());
            statement.setString(7, u.getPhone());
            statement.setString(8, u.getRole());
            statement.setString(9, u.getsName());
            statement.setString(10, u.getStatus());
            statement.setInt(11, u.getuID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRecipe(Recipe r) {
        try {
            String sql = "update foodwhale.recipe set rName=?, cID=?,Image=?,Difficulty=?, Time=?, uID=?, rDescription=?, Guideline1=?, Guideline2=?, Guideline3=?, Status = ? where rID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, r.getrName());
            statement.setInt(2, r.getcID());
            statement.setString(3, r.getImage());
            statement.setString(4, r.getDifficulty());
            statement.setInt(5, r.getTime());
            statement.setInt(6, r.getuID());
            statement.setString(7, r.getrDescription());
            statement.setString(8, r.getGuideline1());
            statement.setString(9, r.getGuideline2());
            statement.setString(10, r.getGuideline3());
            statement.setString(11, r.getStatus());
            statement.setInt(12, r.getrID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateIngredient(Ingredient in) {
        try {
            String sql = "update foodwhale.ingredient set inName=?,Image=?,Type=?, Price=?, categoryID=?, description=?, guideline=?, Status = ? where inID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, in.getInName());
            statement.setString(2, in.getImage());
            statement.setString(3, in.getType());
            statement.setDouble(4, in.getMoney());
            statement.setInt(5, in.getCategoryID());
            statement.setString(6, in.getDescription());
            statement.setString(7, in.getGuideline());
            statement.setString(8, in.getStatus());
            statement.setInt(9, in.getInID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateCategory(Category c) {
        try {
            String sql = "update foodwhale.category set cName=?, Status = ? where categoryID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getCname());
            statement.setString(2, c.getStatus());
            statement.setInt(3, c.getCategoryID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void IngredientDelete(Ingredient i) {
        try {
            String sql = "update foodwhale.ingredient set Status=? where inID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, i.getStatus());
            statement.setInt(2, i.getInID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RecipeDelete(Recipe r) {
        try {
            String sql = "update foodwhale.recipe set Status=? where rID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, r.getStatus());
            statement.setInt(2, r.getrID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CategoryDelete(Category c) {
        try {
            String sql = "update foodwhale.category set Status=? where categoryID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, c.getStatus());
            statement.setInt(2, c.getCategoryID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AccountDelete(User u) {
        try {
            String sql = "update foodwhale.user set Status=? where uID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, u.getStatus());
            statement.setInt(2, u.getuID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUserByID(int uID) throws Exception {
        User user = new User();
        String xsql = "select * from foodwhale.user where uID= ?";

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
                    user.setsName(rs.getString(11));
                    user.setStatus(rs.getString(12));
                }
            }
        } catch (SQLException e) {
        }
        return user;
    }

    public Category getCategoryDetailByID(int categoryID) throws Exception {
        Category category = new Category();
        String xsql = "select * from foodwhale.category where categoryID= ?";

        try {
            if (connection != null) {
                ps = connection.prepareStatement(xsql);
                ps.setInt(1, categoryID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    category.setCategoryID(rs.getInt(1));
                    category.setCname(rs.getString(2));
                    category.setStatus(rs.getString(3));
                }
            }
        } catch (SQLException e) {
        }
        return category;
    }

    public Recipe getRecipeDetailByID(int rID) throws Exception {
        Recipe recipe = new Recipe();
        String xsql = "select * from foodwhale.recipe where rID= ?";

        try {
            if (connection != null) {
                ps = connection.prepareStatement(xsql);
                ps.setInt(1, rID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    recipe.setrID(rs.getInt(1));
                    recipe.setrName(rs.getString(2));
                    recipe.setcID(rs.getInt(3));
                    recipe.setImage(rs.getString(4));
                    recipe.setDifficulty(rs.getString(5));
                    recipe.setTime(rs.getInt(6));
                    recipe.setuID(rs.getInt(7));
                    recipe.setrDescription(rs.getString(8));
                    recipe.setGuideline1(rs.getString(9));
                    recipe.setGuideline2(rs.getString(10));
                    recipe.setGuideline3(rs.getString(11));
                    recipe.setStatus(rs.getString(12));
                }
            }
        } catch (SQLException e) {
        }
        return recipe;
    }

    public Ingredient getIngredientDetailByID(int inID) throws Exception {
        Ingredient ingredient = new Ingredient();
        String xsql = "select * from foodwhale.ingredient where inID= ?";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(xsql);
                ps.setInt(1, inID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ingredient.setInID(rs.getInt(1));
                    ingredient.setInName(rs.getString(2));
                    ingredient.setImage(rs.getString(3));
                    ingredient.setType(rs.getString(4));
                    ingredient.setMoney(rs.getDouble(5));
                    ingredient.setCategoryID(rs.getInt(6));
                    ingredient.setDescription(rs.getString(7));
                    ingredient.setGuideline(rs.getString(8));
                    ingredient.setStatus(rs.getString(9));
                }
            }
        } catch (SQLException e) {
        }
        return ingredient;
    }

    public void createUser(String email, String password, String username, String image, Date date, String gender, String address, String phone, String role, String sName) {
        try {
            String sql = "Insert into `User`(Email, Password, uName, Image, DoB, Gender, Address, Phone, Role, sName) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
            statement.setString(10, sName);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createRecipe(String image, String rName, int cID, String Difficulty, int Time, int uID, String Description, String Guideline1, String Guideline2, String Guideline3) {
        try {
            String sql = "Insert into Recipe(rName, cID, Image, Difficulty, Time, uID, rDescription, Guideline1, Guideline2, Guideline3) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, rName);
            statement.setInt(2, cID);
            statement.setString(3, image);
            statement.setString(4, Difficulty);
            statement.setInt(5, Time);
            statement.setInt(6, uID);
            statement.setString(7, Description);
            statement.setString(8, Guideline1);
            statement.setString(9, Guideline2);
            statement.setString(10, Guideline3);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getProfileByUsername(String uName) throws SQLException {
        String sql = "select * from foodwhale.user where uName = ?";
        ps = connection.prepareStatement(sql);
        ps.setString(1, uName);
        rs = ps.executeQuery();
        while (rs.next()) {
            User p = new User(
                    rs.getInt(1),
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
        String query = "select * from foodwhale.recipe order by rID desc";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Recipe> searchRecipeByRecipe(String searchData) {
        ArrayList<Recipe> list = new ArrayList<>();
        String query = "select distinct r.rID, r.Image, r.rName, r.rDescription, r.Time from foodwhale.recipe r inner join foodwhale.recipe_ingredient ri on r.rID = ri.rID inner join foodwhale.ingredient i on ri.inID = i.inID where r.rName like '%" + searchData + "%'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Recipe> searchRecipeByIngredient(String searchData) {
        ArrayList<Recipe> list = new ArrayList<>();
        String query = "select distinct r.rID, r.Image, r.rName, r.rDescription, r.Time from foodwhale.recipe r inner join foodwhale.recipe_ingredient ri on r.rID = ri.rID inner join foodwhale.ingredient i on ri.inID = i.inID where i.inName like '%" + searchData + "%'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Recipe> getRecipeWithCategory() {
        ArrayList<Recipe> list = new ArrayList<>();
        String query = "select r.rID, r.rName, c.cName, r.Image, r.Difficulty, r.Time, r.uID, r.rDescription, r.Guideline1, r.Guideline2, r.Guideline3, r.Status from foodwhale.recipe r inner join foodwhale.category c on r.cID = c.categoryID";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Ingredient> getIngredientWithCategory() {
        ArrayList<Ingredient> list = new ArrayList<>();
        String query = "select i.inID , i.inName, i.Type, i.Price, c.cName, i.Status from foodwhale.ingredient i inner join foodwhale.category c on i.categoryID = c.categoryID order by i.inID ASC;";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Ingredient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Ingredient> getAllIngredient() {
        ArrayList<Ingredient> list = new ArrayList<>();
        String query = "select * from foodwhale.ingredient";
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
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Ingredient> searchIngredientByRecipe(String searchData) {
        ArrayList<Ingredient> list = new ArrayList<>();
        String query = "select distinct i.inID, i.inName, i.Price, i.description, i.Image from foodwhale.recipe r inner join foodwhale.recipe_ingredient ri on r.rID = ri.rID inner join foodwhale.ingredient i on ri.inID = i.inID where r.rName like '%" + searchData + "%'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Ingredient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Ingredient> searchIngredientByIngredient(String searchData) {
        ArrayList<Ingredient> list = new ArrayList<>();
        String query = "select distinct i.inID, i.inName, i.Price, i.description, i.Image from foodwhale.recipe r inner join foodwhale.recipe_ingredient ri on r.rID = ri.rID inner join foodwhale.ingredient i on ri.inID = i.inID where i.inName like '%" + searchData + "%'";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Ingredient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Ingredient> getIngredientByID(int id) {
        ArrayList<Ingredient> list = new ArrayList<>();
        String query = "select i.inID, i.inName,i.Image, i.Type, i.Price, c.cName, i.description, i.Guideline from foodwhale.ingredient i inner join foodwhale.category c on i.categoryID = c.categoryID where i.inID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Ingredient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Recipe> getRecipeByID(int id) {
        ArrayList<Recipe> list = new ArrayList<>();
        String query = "select r.rID, r.rName, c.cName, r.Image, r.Difficulty, r.Time, r.uID, r.rDescription, r.Guideline1, r.Guideline2, r.Guideline3 from foodwhale.recipe r inner join foodwhale.category c on r.cID = c.categoryID where r.rID = ?";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Recipe(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getInt(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11)));
                }
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Ingredient> getIngredientByRecipeId(int rid) {
        ArrayList<Ingredient> list = new ArrayList<>();
        String query = "select i.inID, i.inName, i.Image, i.Type, i.Price, i.categoryID, i.description, i.guideline from foodwhale.recipe_ingredient ri inner join foodwhale.ingredient i on ri.inID = i.inID where ri.rID = ?";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(query);
                ps.setInt(1, rid);
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Ingredient(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getDouble(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(8)));
                }
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public User loginCustomer(String username, String password) {
        try {
            String sql = "select * from foodwhale.user where uName = ? and password = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                User cus = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
                return cus;
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public User CheckExistCustomer(String username) {
        try {
            String sql = "select * from foodwhale.user where uName = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User cus = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
                return cus;
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public int insertCus(User cus) {
        int n = 0;
        try {
            String sql = "insert into foodwhale.user(email, password, uName, "
                    + "image, DoB, gender,address,phone)\n"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
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
        }
        return n;
    }

    public boolean getCustomerByUser(String user) {
        try {
            String sql = "select uName from foodwhale.user where uName = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    public String getEmailByUser(String user) {
        String sql = "select email from foodwhale.user where uName = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
        }
        return null;
    }

    public void resetPass(String password, String username) {
        String sql = "update foodwhale.user set password ='" + password + "' where uName='" + username + "'";
        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public void EditUser(User u) {
        try {
            String sql = "update foodwhale.user set Email=? ,uName=?,Image=?,Gender=?,Address=?,Phone=? where uID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, u.getEmail());
            statement.setString(2, u.getUsername());
            statement.setString(3, u.getImage());
            statement.setString(4, u.getGender());
            statement.setString(5, u.getAddress());
            statement.setString(6, u.getPhone());
            statement.setInt(7, u.getuID());
            statement.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public User getUserByEmail(String email) throws Exception {
        User user = new User();
        String xsql = "select * from foodwhale.user where Email='?' ";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(xsql);
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

    public void send(String m, String sub, String messg) {
        final String user = "swpgroup2@gmail.com";
        final String pass = "A123456@";
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.host", "gmail");
        props.put("mail.user", "quocthhe150051@fpt.edu.vn");
        props.put("mail.password", "quoc1910");
        props.put("mail.port", "465");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(m));
            message.setSubject(sub);
            message.setText(messg);
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePassword(User u) {
        try {
            String sql = "update foodwhale.user set Password=? where uID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, u.getPassword());
            statement.setInt(2, u.getuID());
            statement.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public String RanCode() {
        String ALPHA_NUMERIC = "0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public String RegisterNoti() {
        return "We send you an email confirmation code";
    }

    public void addRecipe(Recipe recipe) {
        try {
            String sql = "INSERT INTO foodwhale.recipe(rName, cID, Image, Difficulty, Time, uID,rDescription, Guideline1,Guideline2,Guideline3) VALUES (?, ?, ?,?, ?, ?,?, ?, ?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, recipe.getrName());
            statement.setInt(2, recipe.getcID());
            statement.setString(3, recipe.getImage());
            statement.setString(4, recipe.getDifficulty());
            statement.setInt(5, recipe.getTime());
            statement.setInt(6, recipe.getuID());
            statement.setString(7, recipe.getrDescription());
            statement.setString(8, recipe.getGuideline1());
            statement.setString(9, recipe.getGuideline2());
            statement.setString(10, recipe.getGuideline3());
            statement.executeUpdate();
        } catch (SQLException ex) {
        }
    }

    public int checkUserOrder(String uName) {
        String xsql = "select MAX(oID) as 'orderNo' from foodwhale.order o inner join foodwhale.user u on o.uID = u.uID where u.uName = ?";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(xsql);
                ps.setString(1, uName);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int count = rs.getInt(1);
                    if (count != 0) {
                        return count;
                    }
                }
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public void createOrder(int uID, String date) {
        try {
            String sql = "insert into foodwhale.order(uID, Date, Total) values (?, ?, 0)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, uID);
            ps.setString(2, date);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addToCart(int oID, int inID) {
        try {
            String sql = "insert into foodwhale.order_detail(oID, inID, Quantity) values (?, ?, 1)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, oID);
            ps.setInt(2, inID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkDuplicateIngredient(int oID, int inID) {
        try {
            String sql = "select count(*) 'count' from foodwhale.order_detail where oID = " + oID + " and inID = " + inID + "";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int count = rs.getInt(1);
                if (count != 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void addQuantity(int oID, int inID) {
        try {
            String sql = "update foodwhale.order_detail SET Quantity = Quantity + 1 where oID = " + oID + " and inID = " + inID + "";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void minusQuantity(int oID, int inID) {
        try {
            String sql = "update foodwhale.order_detail SET Quantity = Quantity - 1 where oID = " + oID + " and inID = " + inID + "";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTotal(int oID, int total) {
        try {
            String sql = "update foodwhale.order set Total = " + total + " where oID = " + oID + "";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteIngredient(int oID, int inID) {
        try {
            String sql = "delete from foodwhale.order_detail where oID = " + oID + " and inID = " + inID + "";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateOrderStatus(int oID) {
        try {
            String sql = "update foodwhale.order set Status = 'Waiting' where oID = " + oID + "";
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkOrderEmpty(int oID) {
        try {
            String sql = "select count(*) 'count' from foodwhale.order_detail where oID = " + oID + "";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int count = rs.getInt(1);
                if (count == 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FoodWhaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Order_Detail> getUserCart(int oID) {
        ArrayList<Order_Detail> list = new ArrayList<>();
        String query = "select * from foodwhale.order_detail od inner join foodwhale.ingredient i on od.inID = i.inID where od.oID = ?";
        try {
            if (connection != null) {
                ps = connection.prepareStatement(query);
                ps.setInt(1, oID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Order_Detail(
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getInt(9)));
                }
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Recipe_Like> getAllFavouriteRecipe(int uID) {
        ArrayList<Recipe_Like> list = new ArrayList<>();
        String query = "select * from foodwhale.recipe_like where uID = " + uID + "";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe_Like(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getBoolean(4)));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public Recipe getRecipebyID(int i) {
        String query = "select * from foodwhale.recipe where rID = " + i + "";

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Recipe r = new Recipe(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)
                );
                return r;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<Recipe> getRecipeByUser(int uID) {
        String query = "select * from foodwhale.recipe where uID = " + uID + "";
        ArrayList<Recipe> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Recipe(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));

            }
        } catch (SQLException e) {
        }
        return list;
    }
}
