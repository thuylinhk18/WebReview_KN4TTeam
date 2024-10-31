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
                UserModel user = new UserModel(result.getString(1),
                        result.getString(2),
                        result.getString(3));

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

    public void CreateUser(String fullname, String username,
            String password, String email, String roles, String avt) {
        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;

        String query = "insert into Users values (?,?,?,?,?,?);";
        try {
            con = db.openConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, fullname);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.setString(5, roles);
            statement.setString(6, avt);
            statement.execute();
        } catch (Exception ex) {
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
