/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connect.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bebet
 */
public class UserDAO {
     public UserModel checkAccount(String userNameToCheck, String passwordToCheck) {

        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = db.openConnection();
            if (con == null) {
                System.err.println("Error: Unable to open database connection.");
                return null;
            }
            String sql = "select userName,password,roles from Users \n"
                    + "where userName = ? and password = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, userNameToCheck);
            statement.setString(2, passwordToCheck);
            result = statement.executeQuery();
            if (result.next()) {
                UserModel user = new UserModel(result.getString("userName"),
                        result.getString("password"),
                        result.getString("role"));

                return user;

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                result.close();
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
