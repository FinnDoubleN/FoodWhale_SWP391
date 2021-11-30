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
import model.Admin;

/**
 *
 * @author This PC
 */
public class DAOAdmin {
      Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext dbconn = null;

    public DAOAdmin(DBContext dbconn) {
        conn = dbconn.connection;
        this.dbconn = dbconn;
    }

    public Admin loginAdmin(String username, String password) {
        try {
            String sql = "select * from Admin where username = ? and password = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();

            while (rs.next()) {
                Admin ad = new Admin( rs.getString(1), rs.getString(2));
                return ad;
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
}
