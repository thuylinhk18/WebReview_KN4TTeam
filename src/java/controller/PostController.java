/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;
import model.PostDAO;
import model.PostModel;
import static util.HelperUtil.uploadFile;
import static util.HelperUtil.getCurrentUser;

/**
 *
 * @author bebet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 50)
public class PostController extends HttpServlet {

    private static final String SESSION_USERNAME = "username";
    private static final String UPLOAD_DIRECTORY = "top1server";
    private static final Logger LOGGER = Logger.getLogger(PostController.class.getName());
    private PostDAO dao = new PostDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PostController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PostController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("COMMAND");

        switch (command) {
            case "VIEW_FORUM" -> {
                viewForum(request, response);
                break;
            }
            case "REMOVE_POST" -> {
                removePost(request, response);
                break;
            }
            case "MARK_POST" -> {
                markPost(request, response);
                break;
            }

            case "VIEW_POST_TO_UPDATE" -> {
                viewPost(request, response);
                break;
            }
            case "VIEW_MY_POSTS" -> {
                viewMyPosts(request, response);
                break;
            }

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("COMMAND");
        switch (command) {
            case "CREATE_POST" -> {
                createPost(request, response);
            }
            case "EDIT_POST" -> {
                editPost(request, response);
                break;
            }
        }
    }

    protected void viewForum(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String favoriteView = (String) request.getParameter("isFavorite");
        if(favoriteView != null) {
            favoriteView = " where p.isFavorite = 1 ";
        } else {
            favoriteView = "";
        }
        List<PostModel> postList = dao.getAllPosts(favoriteView);
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("forum.jsp").forward(request, response);
    }

    protected void viewPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        PostModel post = dao.getPostById(postId);
        String content = post.getPostContent();
        request.setAttribute("title", post.getPostTitle());
        request.setAttribute("content", content);
        request.setAttribute("postId", postId);
        request.getRequestDispatcher("post-edit.jsp").forward(request, response);

    }

    protected void createPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String image = uploadFile(request,getServletContext().getRealPath(""));
        dao.addPost(getCurrentUser(request), title, content, image);
        viewForum(request, response);
    }

    protected void markPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int postId = Integer.parseInt(request.getParameter("postId"));
        boolean isCurrentFavorite = Boolean.parseBoolean(request.getParameter("isFavorite"));
        dao.markFavoritePost(postId, getCurrentUser(request), isCurrentFavorite);
        //get latest posts
        List<PostModel> latestPosts = dao.getAllPosts("");
        request.setAttribute("postList", latestPosts);
        request.getRequestDispatcher("forum.jsp").forward(request, response);
    }

    protected void removePost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        dao.deletePost(postId);
        viewForum(request, response);
    }

    protected void editPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int postId = Integer.parseInt(request.getParameter("postId"));
        String newTitle = request.getParameter("title");
        String newContent = request.getParameter("content");
        String newImage = uploadFile(request,getServletContext().getRealPath(""));
        dao.updatePost(newTitle, newContent, newImage, postId);
        viewForum(request, response);
    }

    protected void viewMyPosts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String favoriteView = (String) request.getParameter("isFavorite");
        if(favoriteView != null) {
            favoriteView = " and p.isFavorite = 1 ";
        }else {
            favoriteView = "";
        }
        List<PostModel> postList = dao.getMyPosts(getCurrentUser(request),favoriteView);
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("my-posts.jsp").forward(request, response);
    }

    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
