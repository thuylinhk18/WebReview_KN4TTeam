/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connect.DBContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author bebet
 */
public class UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    public List<UserModel> getUsers() {
        List<UserModel> users = new ArrayList<>();
        DBContext db = DBContext.getInstance();
        String sql = "SELECT * FROM Users";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String fullname = rs.getString(3);
                String pass = rs.getString(4);
                String email = rs.getString(5);
                String roles = rs.getString(6);
                String avt = rs.getString(7);
                users.add(new UserModel(id, username, fullname, pass, email, roles, avt));

            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public UserModel checkAuth(String userNameToCheck, String passwordToCheck) {

        DBContext db = DBContext.getInstance();
        ResultSet result = null;
        String sql = "select userName,password,roles from Users \n"
                + "where userName = ? and password = ?";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {

            statement.setString(1, userNameToCheck);
            statement.setString(2, passwordToCheck);
            result = statement.executeQuery();
            if (result.next()) {
                return new UserModel(result.getString(1),
                        result.getString(2),
                        result.getString(3));

            }
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean checkUsernameExist(String userNameToCheck, String currentUsername) {

        DBContext db = DBContext.getInstance();
        //to register
        String sql = "select * from Users  where userName = ?";
        if (userNameToCheck.equals(currentUsername)) {
            return false;
        }
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            ResultSet result = null;
            statement.setString(1, userNameToCheck);
            result = statement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean checkEmailExist(String emailToCheck, String currentUsername) {

        DBContext db = DBContext.getInstance();
        String sql = "select * from Users  where email = ?";
         if (currentUsername != null) {
            sql = "select * from Users where email = ? and userName <> ?";
        }
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, emailToCheck);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void addUser(String username, String fullname,
            String password, String email) {
        DBContext db = DBContext.getInstance();

        String sql = "insert into Users(username,fullname,password,email) values\n"
                + "(?,?,?,?);";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, username);
            statement.setString(2, fullname);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(String username) {
        DBContext db = DBContext.getInstance();
        String sql = "delete from Users where username = ? ";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, username);
            statement.execute();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(String newUsername, String fullname,
            String email, String oldUsername) {
        String sql = "UPDATE Users SET username = ?, fullname= ?, email = ? WHERE username = ? ";
        DBContext db = DBContext.getInstance();
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, newUsername);
            statement.setString(2, fullname);
            statement.setString(3, email);
            statement.setString(4, oldUsername);

            statement.executeUpdate();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

    }
      public void changePassword(String currentUser, String newPass) {
        String sql = "UPDATE Users SET password=? WHERE username = ?";
        DBContext db = DBContext.getInstance();
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, newPass);
            statement.setString(2, currentUser );
            statement.executeUpdate();
            
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

    }

    public UserModel getUserByUsername(String username) {

        DBContext db = DBContext.getInstance();
        ResultSet result = null;
        String sql = "select * from Users  where userName = ? ";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, username);
            result = statement.executeQuery();
            if (result.next()) {
                return new UserModel(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7));

            }
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
