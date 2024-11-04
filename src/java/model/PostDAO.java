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

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    public List<PostModel> getAllPosts(String favorivate) {
        List<PostModel> postList = new ArrayList<>();
        DBContext db = DBContext.getInstance();
        String sql = "SELECT p.post_id, p.isFavorite, p.user_id, p.title, p.post_content, p.post_img, u.username "
                + "FROM Posts p  join Users u on u.user_id = p.user_id "
                + favorivate
                + " ORDER BY post_id DESC";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                postList.add(new PostModel(result.getInt(1),
                        result.getInt(2) == 1 ? true : false,
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7)
                ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return postList;
    }

    public void addPost(String currentUser, String title,
            String content, String imgageURL) {
        DBContext db = DBContext.getInstance();

        String sql = "insert into Posts(user_id,title,post_content,post_img) \n"
                + "values ((select user_id from Users where username = ?),?,?,?);";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, currentUser);
            statement.setString(2, title);
            statement.setString(3, content);
            statement.setString(4, imgageURL);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    //co nen de la int khong?
    public void deletePost(int postId) {
        DBContext db = DBContext.getInstance();
        String sql = "delete from Posts where post_id = ? ";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setInt(1, postId);
            statement.execute();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public PostModel getPostById(int postId) {
        DBContext db = DBContext.getInstance();
        String sql = "SELECT p.post_id,p.user_id, p.title, p.post_content, p.post_img FROM Posts p where p.post_id=?;";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setInt(1, postId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                return new PostModel(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updatePost(String newTitle, String newContent, String newImage, int postId) {
        String sql = "UPDATE Posts SET title= ?, post_content= ?, post_img= ?  WHERE post_id = ? ";
        DBContext db = DBContext.getInstance();

        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setString(1, newTitle);
            statement.setString(2, newContent);
            statement.setString(3, newImage);
            statement.setInt(4, postId);

            statement.executeUpdate();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public List<PostModel> search(String keyword) {
        List<PostModel> postList = new ArrayList<>();
        String sql = "SELECT p.post_id, p.isFavorite, p.user_id, p.title, p.post_content, p.post_img, u.username  \n"
                + "FROM Posts p  \n"
                + "join Users u on u.user_id = p.user_id \n"
                + "where p.title like ? \n"
                + "or p.post_content like ? \n"
                + "ORDER BY post_id DESC;";
        DBContext db = DBContext.getInstance();
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {

            String searchKeyword = "%" + keyword + "%";
            statement.setString(1, searchKeyword);
            statement.setString(2, searchKeyword);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                postList.add(new PostModel(
                        result.getInt(1),
                        result.getInt(2) == 1 ? true : false,
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7)
                ));
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return postList;
    }
//    }
//
//    public boolean isFavorite(int postId, String username) {
//
//        String sql = "select COUNT(fp.favorite_id) isFavorite from Favorite_Posts fp join "
//                + "Users u on fp.user_id = u.user_id "
//                + "where fp.post_id=? and u.username=?";
//        DBContext db = DBContext.getInstance();
//        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
//
//            statement.setInt(1, postId);
//            statement.setString(2, username);
//            ResultSet result = statement.executeQuery();
//            if (result.next()) {
//                return result.getInt(1) > 0 ? true : false;
//            }
//        } catch (Exception ex) {
//            LOGGER.log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }

//    public void createFavoritePost(int postId, String username) {
//        String sql = "insert into Favorite_Posts(user_id,post_id) \n"
//                + "values (?,(select user_id from Users where username = ?))";
//        DBContext db = DBContext.getInstance();
//        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
//
//            statement.setInt(1, postId);
//            statement.setString(2, username);
//            statement.execute();
//        } catch (Exception ex) {
//            LOGGER.log(Level.SEVERE, null, ex);
//        }
//    }
    public void markFavoritePost(int postId, String username, boolean isFav) {
        String sql = "update Posts set isFavorite=? \n"
                + "where post_id=? and user_id = (select user_id from Users where username = ?)";
        DBContext db = DBContext.getInstance();
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setBoolean(1, !isFav);
            statement.setInt(2, postId);
            statement.setString(3, username);
            statement.executeUpdate();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public List<PostModel> getMyPosts(String currentUser, String favorivate) {
        List<PostModel> postList = new ArrayList<>();
        DBContext db = DBContext.getInstance();
        String sql = "SELECT p.post_id, p.isFavorite, p.user_id, p.title, p.post_content, p.post_img, u.username \n"
                + "FROM Posts p \n"
                + "JOIN Users u ON p.user_id = u.user_id \n"
                + "WHERE u.username = ? \n"
                + favorivate
                + "ORDER BY p.post_id DESC";
        try (Connection con = db.openConnection(); PreparedStatement statement = con.prepareStatement(sql);) {
            statement.setString(1, currentUser);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                postList.add(new PostModel(result.getInt(1),
                        result.getInt(2) == 1 ? true : false,
                        result.getInt(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7)
                ));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return postList;
    }

}
