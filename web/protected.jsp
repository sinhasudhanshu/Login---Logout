<%-- 
    Document   : protected
    Created on : 13 Sep, 2022, 6:17:56 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home</h1>
        <a href="logout.jsp">Logout</a>
        <%
            if(session.getAttribute("username")==null)
            {
               response.sendRedirect("test.jsp");
               return;
            }
        String username="" + session.getAttribute("username");
        out.println(username);
        
        
        
        %>
    </body>
</html>
