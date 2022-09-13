<%-- 
    Document   : studentsearch
    Created on : 9 Sep, 2022, 3:12:24 AM
    Author     : ASUS
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="datapackage.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student search</title>
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
             String option = "", name="",rollno="",age="",result="";
            if (ispostback) {
                option = request.getParameter("option");
                
                if (option.equals("Search")) {
                    out.println("Search Code");
                    rollno = request.getParameter("rollno");
                    PreparedStatement ps = DbConnect.connect().prepareStatement("select * from student where rollno=?");
                    ps.setString(1, rollno);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        name = "" + rs.getObject("name");
                        age = "" + rs.getObject("age");
                    }
                }
                if (option.equals("Delete")) {
                    out.println("Delete Code");
                    
                    rollno = request.getParameter("rollno");
                    PreparedStatement ps = DbConnect.connect().prepareStatement("delete from student where rollno=?");
                    ps.setString(1, rollno);
                    int n=ps.executeUpdate();
                     result="Deleted " + n + " records";
                   
            }
            }
        %>
    <center>
        <%=result%>
        <h1>Student Search and Delete</h1>
        <form>
            <h3><%=result%></h3>
            <input type="hidden" name="check" value="2">
            Name<input name="name" value="<%=name%>" type="text">
            Roll no.<input value="<%=rollno%>" name="rollno" type="number">
            age<input value="<%=age%>" name="age" type="number">
        <br>
        <br>
            <input type="submit" name="option" value="Search"/>
            <input type="submit" name="option" value="Delete"/>
        </form>
    </center>
    </body>
</html>
