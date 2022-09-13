
<%@page import="datapackage.DbConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update</title>
    </head>
    <body>
       
        <%
            String check = request.getParameter("check");
            boolean ispostback;
            if (check == null) {
                ispostback = false;
            } else {
                ispostback = true;
            }
            
            String option = "", serialno = "", task = "", description = "", status = "", result = "";
            if (ispostback) {
                option = request.getParameter("option");
                if (option.equals("update")) {
                    out.println("update code");
                    task = request.getParameter("task");
                    description = request.getParameter("description");
                    status = request.getParameter("status");
                    serialno=request.getParameter("serialno");
                    PreparedStatement ps = DbConnect.connect().prepareStatement("update todo set task=?,description=?,status=? where serialno=?");
                    ps.setString(1, task);
                    ps.setString(2, description);
                    ps.setString(3, status);
                    ps.setString(4, serialno);
                    ps.executeUpdate();
                    
                }
            }
        %>
    <center>
        <%=result%>
        <h1>Todo update</h1>
        <form>
            <input type="hidden" name="check"/>

            serialno<input value="<%=serialno%>"name="serialno" type="number">
            task<input value="<%=task%>"name="task" type="text">
            description<input value="<%=description%>"name="description" type="text">
            status<input value="<%=status%>"name="status" type="text">
            <br>
            <br>
            <input name="option" type="submit" value="update"/>
        </form>
    </center>    
    </body>
</html>
