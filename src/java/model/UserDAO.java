/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import connect.DBContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
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

    public List<UserModel> getUsers() {
        List<UserModel> users = new ArrayList<>();
        DBContext db = DBContext.getInstance();
        String query = "SELECT * FROM Users";
        try {
            Connection con = db.openConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
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
            con.close();
            statement.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public UserModel checkAuth(String userNameToCheck, String passwordToCheck) {

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
                return new UserModel(result.getString(1),
                        result.getString(2),
                        result.getString(3));

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

    public boolean checkUsernameExist(String userNameToCheck) {

        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = db.openConnection();
            if (con == null) {
                System.err.println("Error: Unable to open database connection.");
            }
            String sql = "select * from Users  where userName = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, userNameToCheck);
            result = statement.executeQuery();
            if (result.next()) {
                return true;
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
        return false;
    }
    public boolean checkEmailExist(String emailToCheck) {

        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            con = db.openConnection();
            if (con == null) {
                System.err.println("Error: Unable to open database connection.");
            }
            String sql = "select * from Users  where email = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, emailToCheck);
            result = statement.executeQuery();
            if (result.next()) {
                return true;
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
        return false;
    }

    public void deleteUser(String id) {
        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        String query = "delete from Users\n"
                + "where user_id = ?; ";
        try {
            con = db.openConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, id);
            statement.execute();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addUser(String username, String fullname,
            String password, String email) {
        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;

        String query = "insert into Users(username,fullname,password,email) values\n"
                + "(?,?,?,?);";
        try {
            con = db.openConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, fullname);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateUser(String fullname, String username,
            String password, String email, String roles, String avt) {
        String query = "UPDATE Users SET username = ?, fullname= ?, password =?, email = ?, roles = ?,avt = ? WHERE user_id = ? ";
        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = db.openConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, fullname);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.setString(5, roles);
            statement.setString(6, avt);
            statement.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        dao.deleteUser("1");
    }

}
