/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bebet
 */
public class UserModel {

    private int userId;
    private String username;
    private String fullname;
    private String password;
    private String email;
    private String roles;
    private String avt;

    public UserModel() {
    }

    public UserModel(int userId, String username, String fullname, String password, String email, String roles, String avt) {
        this.userId = userId;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.avt = avt;
    }

    public UserModel(String username, String fullname, String roles) {
        this.username = username;
        this.fullname = fullname;
        this.roles = roles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    @Override
    public String toString() {
        return "UserModel{" + "userId=" + userId + ", username=" + username + ", fullname=" + fullname + ", password=" + password + ", email=" + email + ", roles=" + roles + ", avt=" + avt + '}';
    }

    
}
