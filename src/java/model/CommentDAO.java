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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class CommentDAO {
    
    public List<CommentModel> getComment(){
    List<CommentModel> comment = new ArrayList();
    DBContext db = DBContext.getInstance();
    String query ="";
    try{
    Connection con = db.openConnection();
    Statement statement = con.createStatement();
    ResultSet rs = statement.executeQuery(query);
    while(rs.next()) {
        int cmt_id = rs.getInt(1);
        int user_id = rs.getInt(2);
        int post_id = rs.getInt(3);
        String title = rs.getString(4);
        String post_content = rs.getString(5);
        String post_img = rs.getString(6);
        comment.add(new CommentModel(cmt_id, user_id, post_id, title, post_content, post_img));
    }
    con.close();
    statement.close();
    rs.close();
    }catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return comment;
    }
    
    public void deleteComment(String post_id){
    DBContext db = DBContext.getInstance();
    Connection con = null;
    PreparedStatement statement = null;
    String query = "";
    try{
        con = db.openConnection();
        statement = con.prepareStatement(query);
        statement.setString(1, post_id);
        statement.execute();
    
    } catch(Exception ex){Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public void createComment(){
        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        String query ="";
        try{
            con = db.openConnection();
            statement = con.prepareStatement(query);
            
        }
    }
}
