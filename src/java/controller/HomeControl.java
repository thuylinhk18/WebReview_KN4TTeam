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
import java.io.PrintWriter;
import model.UserDAO;
import model.UserModel;

/**
 *
 * @author bebet
 */
public class HomeControl extends HttpServlet {

    private static final String MESSAGE_LABEL = "message";
    private static final String MESSAGE_WRONG_PASSWORD = "Mật khẩu xác nhận sai!";
    private static final String MESSAGE_EXISTED_USERNAME = "Tên đăng nhập đã tồn tại!";
    private static final String MESSAGE_EXISTED_EMAIL = "Email đã tồn tại!";
    private static final String MESSAGE_LOGIN_SUCCESSFULLY = "Đăng ký thành công! Đăng nhập lại để tiếp tục!";
    private static final String SESSION_USERNAME = "username";
    private static final String MESSAGE_EDIT_PROFILE_SUCCESSFULLY = "Thay đổi thành công.";
    private static final String MESSAGE_PASSWORD_NOT_MATCHING = "Xác nhận mật khẩu sai";
    private static final String MESSAGE_REGISTER_SUCCESSFULLY = "Đăng ký thành công! Đăng nhập lại để tiếp tục!";
    private static final String MESSAGE_CHANGE_PASSWORD_SUCCESSFULLY = "Đổi mật khẩu thành công. Đăng nhập lại để tiếp tục!";
    private static final String MESSAGE_REMOVE_ACCOUNT_SUCCESSFULLY = "Xóa tài khoản thành công!";

    private UserDAO dao = new UserDAO();

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
            out.println("<title>Servlet StudentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
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
            case "VIEW_PROFILE" -> {
                viewProfile(request, response);
                break;
            }
            case "LOGOUT" -> {
                logout(request, response);
                break;
            }
            default ->
                homepageUser(request, response);
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
            case "LOGIN" -> {
                login(request, response);
                break;
            }
            case "REGISTER" -> {
                register(request, response);
                break;
            }
            case "REGISTER_FORM" -> {
                registerForm(request, response);
                break;
            }
            case "EDIT_PROFILE" -> {
                editProfile(request, response);
                break;
            }
            case "CHANGE_PASSWORD" -> {
                changePassword(request, response);
                break;
            }
            case "REMOVE_ACCOUNT" -> {
                removeAccount(request, response);
                break;
            }
        }
    }

    protected void homepageUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("home.jsp");
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter(SESSION_USERNAME);
        String password = request.getParameter("password");
        String rem = request.getParameter("rememberMe");
        // tao 3 cookies: username,password,rem

        // check if userName is null or not
        if (rem != null) {
            Cookie nameCookie = new Cookie("name", username);
            Cookie passCookie = new Cookie("pass", password);
            Cookie remCookie = new Cookie("rem", rem);
            remCookie.setMaxAge(60 * 60 * 24 * 7); // 7days
            nameCookie.setMaxAge(60 * 60 * 24 * 7);
            passCookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(nameCookie);
            response.addCookie(passCookie);
            response.addCookie(remCookie);
        }

        UserModel user = dao.checkAuth(username, password);
        if (user == null) {
            request.setAttribute("message", "Tên đăng nhập hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute(SESSION_USERNAME, user.getUsername());
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
        //remove session 
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
        String username = request.getParameter(SESSION_USERNAME);
        String password = request.getParameter("password");
        String repass = request.getParameter("repassword");
        String email = request.getParameter("email");
        //check whether repassword equals password or not
        if (!password.equals(repass)) {
            request.setAttribute(MESSAGE_LABEL, MESSAGE_PASSWORD_NOT_MATCHING);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {

            //check whether username is existed
            if (dao.checkUsernameExist(username, null)) {
                request.setAttribute(MESSAGE_LABEL, MESSAGE_EXISTED_USERNAME);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } //check whether email is existed
            else if (dao.checkEmailExist(email, null)) {
                request.setAttribute(MESSAGE_LABEL, MESSAGE_EXISTED_EMAIL);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
            //Add user
            dao.addUser(username, fullName, password, email);
            request.setAttribute(MESSAGE_LABEL, MESSAGE_REGISTER_SUCCESSFULLY);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    protected void viewProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = session.getAttribute(SESSION_USERNAME).toString();

        UserModel user = dao.getUserByUsername(username);
        request.setAttribute("user", user);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    protected void removeAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String currentUser = getCurrentUser(request);
        dao.deleteUser(currentUser);
        logout(request, response);
    }

    private void editProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullname");
        String newUsername = request.getParameter(SESSION_USERNAME);
        String email = request.getParameter("email");
        UserModel tempUser = new UserModel();
        tempUser.setFullname(fullName);
        tempUser.setUsername(newUsername);
        tempUser.setEmail(email);
        String currentUser = getCurrentUser(request);
        if (dao.checkUsernameExist(newUsername, currentUser)) {
            request.setAttribute(MESSAGE_LABEL, MESSAGE_EXISTED_USERNAME);
            request.setAttribute("user", tempUser);
        } else if (dao.checkEmailExist(email, currentUser)) {
            request.setAttribute(MESSAGE_LABEL, MESSAGE_EXISTED_EMAIL);
            request.setAttribute("user", tempUser);
        } else {
            dao.updateUser(newUsername, fullName, email, currentUser);
            UserModel user = dao.getUserByUsername(newUsername);
            request.setAttribute("user", user);
            request.setAttribute(MESSAGE_LABEL, MESSAGE_EDIT_PROFILE_SUCCESSFULLY);
        }
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

    private String getCurrentUser(HttpServletRequest request)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute(SESSION_USERNAME);
        return username;
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String rePass = request.getParameter("reNewPass");
        String currentUser = getCurrentUser(request);

        if (dao.checkAuth(currentUser, oldPass) == null) {
            request.setAttribute(MESSAGE_LABEL, MESSAGE_WRONG_PASSWORD);
        } else if (!newPass.equals(rePass)) {
            request.setAttribute(MESSAGE_LABEL, MESSAGE_PASSWORD_NOT_MATCHING);
        } else {
            dao.changePassword(currentUser, newPass);
            request.setAttribute(MESSAGE_LABEL, MESSAGE_CHANGE_PASSWORD_SUCCESSFULLY);
        }

        request.getRequestDispatcher("change-password.jsp").forward(request, response);
        logout(request, response);
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
