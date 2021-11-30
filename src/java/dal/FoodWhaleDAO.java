/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author ADMIN
 */
public class FoodWhaleDAO extends DBContext {
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<User> getAllUser(){
         List<User> list = new ArrayList<>();
        String query = "select * from departments";
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
                rs.getCharacterStream(7),
                rs.get));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
