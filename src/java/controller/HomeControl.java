/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.PostDAO;
import model.PostModel;
import model.UserDAO;
import model.UserModel;

/**
 *
 * @author bebet
 */
public class HomeControl extends HttpServlet {

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
        PostDAO dao = new PostDAO();
        List<PostModel> postList = dao.getAllPosts();
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("forum.jsp").forward(request, response);
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
        processRequest(request, response);
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
            case "LOGIN" ->
                login(request, response);
            case "LOGOUT" ->
                logout(request, response);

            case "REGISTER" ->
                register(request, response);
            case "REGISTER_FORM" ->
                registerForm(request, response);

        }
    }

    protected void homepageUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("home.jsp");
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rem = request.getParameter("rememberMe");
        // tao 3 cookies: username,password,rem
        Cookie nameCookie = new Cookie("name", username);
        Cookie passCookie = new Cookie("pass", password);
        Cookie remCookie = new Cookie("rem", rem);

        // check if userName is null or not
        if (rem != null) {
            remCookie.setMaxAge(60 * 60 * 24 * 7); // 7days
            nameCookie.setMaxAge(60 * 60 * 24 * 7);
            passCookie.setMaxAge(60 * 60 * 24 * 7);
        } else {
            remCookie.setMaxAge(0); // 0day
            nameCookie.setMaxAge(0);
            passCookie.setMaxAge(0);
        }
        response.addCookie(nameCookie);
        response.addCookie(passCookie);
        response.addCookie(remCookie);

        UserDAO dao = new UserDAO();
        UserModel user = dao.checkAuth(username, password);
        if (user == null) {
            request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            //just save uesrId &username of user, not whole object
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUsername());
            if (user.getRoles().equals("user")) {
                //day ve servlet de load du lieu, khong phai jsp
                homepageUser(request, response);
            } else {
                request.getRequestDispatcher("admin-homepage.jsp").forward(request, response);
            }

        }
    }
      protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession(false);
            session.invalidate();
            homepageUser(request, response);
    }

    protected void registerForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("register.jsp");
    }

    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repass = request.getParameter("repassword");
        String email = request.getParameter("email");
        //check whether repassword equals password or not
        if (!password.equals(repass)) {
            request.setAttribute("message", "Mật khẩu xác nhận sai!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            UserDAO dao = new UserDAO();
            //check whether username is existed
            if (dao.checkUsernameExist(username)) {
                request.setAttribute("message", "Tên đăng nhập đã tồn tại!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } //check whether email is existed
            else if (dao.checkEmailExist(email)) {
                request.setAttribute("message", "Email đã tồn tại!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            //Add user
            dao.addUser(username, fullName, password, email);
            request.setAttribute("message", "Đăng ký thành công! Đăng nhập lại để tiếp tục!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
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
