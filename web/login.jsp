<%-- 
    Document   : login
    Created on : Oct 21, 2024, 6:04:44 PM
    Author     : bebet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login form</h1>
        <h3 style="color: red">${requestScope.message}</h3>
        <c:set var="cookie" value="${pageContext.request.cookies}"/>
        <form action="LoginServlet" method="post">
            Username: <input type="text" name="username" 
                             value="${cookie.nameCookie.value}"
                             required /><br/>
            
            Password: <input type="text" name="password" 
                             value="${cookie.passCookie.value}"
                             required /><br/>
            <input type="checkbox" 
                   ${(cookie.remCookie!=null?'checked':'')}
                   name="rememberMe" value="ON"/> Remember me <br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
