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

    public List<PostModel> getAllPosts() {
        List<PostModel> postList = new ArrayList<>();

        DBContext db = DBContext.getInstance();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            con = db.openConnection();
            if (con == null) {
                System.err.println("Error: Unable to open database connection");
                return postList;
            }

            String query = "select * from Posts";
            statement = con.prepareStatement(query);
            result = statement.executeQuery();
            while (result.next()) {
                postList.add(new PostModel(result.getInt(1),
                        result.getString(3),
                        result.getString(4),
                        result.getDate(5),
                        result.getString(6)));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                result.close();
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return postList;
    }

    public static void main(String[] args) {
        PostDAO dao = new PostDAO();
        List<PostModel> postList = dao.getAllPosts();
        System.out.println(postList);
    }
//public void addStudent(Student student) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = db.openConnection();
//
//            if (con == null) {
//                System.err.println("Error: Unable to open database connection");
//                return;
//            }
//            String query = "insert into student(id,firstName,lastname,email) values(?,?,?,?);";
//            statement = con.prepareStatement(query);
//            statement.setString(1, student.getId());
//            statement.setString(2, student.getFirstName());
//            statement.setString(3, student.getLastName());
//            statement.setString(4, student.getEmail());
//            statement.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                statement.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    public void removeStudent(String id) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = db.openConnection();
//            if (con == null) {
//                System.err.println("Error: Unable to open database connection");
//                return;
//            }
//            String query = "delete from student where id = ?";
//            statement = con.prepareStatement(query);
//            statement.setString(1, id);
//            statement.execute();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                statement.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    public void updateStudent(Student student) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = db.openConnection();
//            if (con == null) {
//                System.err.println("Error: Unable to open database connection");
//                return;
//            }
//            String query = "UPDATE student SET firstName = ?, lastname= ?, email = ? WHERE id = ?";
//            statement = con.prepareStatement(query);
//            statement.setString(1, student.getFirstName());
//            statement.setString(2, student.getLastName());
//            statement.setString(3, student.getEmail());
//            statement.setString(4, student.getId());
//            statement.execute();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                statement.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//    public void addStudent(Student student) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = db.openConnection();
//
//            if (con == null) {
//                System.err.println("Error: Unable to open database connection");
//                return;
//            }
//            String query = "insert into student(id,firstName,lastname,email) values(?,?,?,?);";
//            statement = con.prepareStatement(query);
//            statement.setString(1, student.getId());
//            statement.setString(2, student.getFirstName());
//            statement.setString(3, student.getLastName());
//            statement.setString(4, student.getEmail());
//            statement.execute();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                statement.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    public void removeStudent(String id) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = db.openConnection();
//            if (con == null) {
//                System.err.println("Error: Unable to open database connection");
//                return;
//            }
//            String query = "delete from student where id = ?";
//            statement = con.prepareStatement(query);
//            statement.setString(1, id);
//            statement.execute();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                statement.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    public void updateStudent(Student student) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            con = db.openConnection();
//            if (con == null) {
//                System.err.println("Error: Unable to open database connection");
//                return;
//            }
//            String query = "UPDATE student SET firstName = ?, lastname= ?, email = ? WHERE id = ?";
//            statement = con.prepareStatement(query);
//            statement.setString(1, student.getFirstName());
//            statement.setString(2, student.getLastName());
//            statement.setString(3, student.getEmail());
//            statement.setString(4, student.getId());
//            statement.execute();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                statement.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
