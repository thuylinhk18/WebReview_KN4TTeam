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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bebet
 */
public class PostDAO {

    public List<PostModel> getPosts() {
        // Khai bao list de do result vao
        List<PostModel> sl = new ArrayList<>();
        // Tao ket noi CSDL
        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = db.openConnection();
            if (con == null) {
                System.err.println("Error: Unable to open database connection.");
                return sl; // Trả về danh sách rỗng nếu không mở được kết nối
            }
            // Hien thi sap xep id theo thu tu
            String sql = "Select * from Post";
            // execute cau lenh sql
            statement = con.prepareStatement(sql);
            //. It returns an object of the class ResultSet. rs
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2).trim();
                PostModel post = new PostModel(id, fullName);
                sl.add(tmpPostModel);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostModelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostModelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PostModelDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sl;
    }
}
