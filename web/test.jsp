

<%@page import="authpackage.LoginManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <%
                boolean ispostback;
                String check = request.getParameter("check");
                if (check == null) {
                    ispostback = false;
                } else {
                    ispostback = true;
                }
                String username = "", password = "",result="";
                if (ispostback) {
                    username = request.getParameter("username");
                    password = request.getParameter("password");
                   
                    boolean b = LoginManager.isUsernameAndPasswordCorrect(username, password);
                    if(b)
                    {
                        session.setAttribute("username", username);
                        response.sendRedirect("protected.jsp");
                        return;
                        
                    }
                    result="Failed";
                }
            %>
            <h2><%=result%></h2>
        <form method="post">
            <input type="hidden" name="check"/>
            Username<input value="<%=username%>" type="text" name="username"/>
            <br>
            Password<input value="<%=password%>" type="password" name="password"/>
            <br>
            <input type="submit" value="Login"/>
            <br>
        </form>
    </body>
</html>
