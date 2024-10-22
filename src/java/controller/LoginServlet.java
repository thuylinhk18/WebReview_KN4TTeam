/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserDAO;
import model.UserModel;

/**
 *
 * @author bebet
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String rem = request.getParameter("rememberMe");
        // tao 3 cookies: username,password,rem
        Cookie nameCookie = new Cookie("name", userName);
        Cookie passCookie = new Cookie("pass", password);
        Cookie remCookie = new Cookie("rem", rem);
        nameCookie.setPath("/");
        passCookie.setPath("/");
        remCookie.setPath("/");
        // check if userName is null or not
        if ("ON".equalsIgnoreCase(rem)) {
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

        UserDAO userDAO = new UserDAO();
        UserModel user = userDAO.checkAccount(userName, password);
        if (user == null) {
            request.setAttribute("message", "Username or Password invalid!");
            response.sendRedirect("login.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("account", user);
            if (user.getRoles().equals("user")) {
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }

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
