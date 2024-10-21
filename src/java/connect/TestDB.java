/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import model.UserDAO;


/**
 *
 * @author bebet
 */
public class TestDB {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        System.out.println(dao.getUsers());
    }
}
