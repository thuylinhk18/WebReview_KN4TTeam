/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bebet
 */
@WebFilter(urlPatterns = {"/HomeControl"})
public class AuthorizeInterceptor implements Filter {

    private static final List<String> REQUIRED_LOGINS = List.of("VIEW_PROFILE", "EDIT_PROFILE", "REMOVE_ACCOUNT","CHANGE_PASSWORD");

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;

        String command = (String)request.getParameter("COMMAND");
        if (command == null) {
            response.sendRedirect("home.jsp");
            return;
        }
        boolean exist = REQUIRED_LOGINS.stream().anyMatch(data -> data.equalsIgnoreCase(command));
        if (exist) {
            if (!isLoggedIn(request)) {
                response.sendRedirect("login.jsp");
                return;
            }
        }
        fc.doFilter(sr, sr1);
    }

    private String getCurrentUser(HttpServletRequest request)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = (String)session.getAttribute("username");
        return username;
    }

    private boolean isLoggedIn(HttpServletRequest request)
            throws ServletException, IOException {
        String username = getCurrentUser(request);
        return username != null && username.trim() != "";

    }
}
