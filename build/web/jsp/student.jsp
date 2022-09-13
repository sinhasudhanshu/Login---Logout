<%-- 
    Document   : student
    Created on : 8 Sep, 2022, 1:56:15 PM
    Author     : ASUS
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="datapackage.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
    </head>
    <body>
        
         <%
        String check=request.getParameter("check");
        boolean ispostback;
        if(check==null)
        ispostback=false;
        else
        ispostback=true;
        String name="",rollno="",age="",result="";
        System.out.println(ispostback);
       
        if(ispostback)
        {
            try
            {
            name=request.getParameter("name");
            rollno=request.getParameter("rollno");
             age=request.getParameter("age");
            PreparedStatement ps=DbConnect.connect().prepareStatement("insert into student values(?,?,?)");
            ps.setString(2, rollno);
            ps.setString(1, name);
             ps.setString(3, age);
                    int n=ps.executeUpdate();
                    result="Inserted " + n + " records";
            }
            catch(Exception ex)
            {
                System.out.println(ex);
                result=ex.getMessage();
            }
        }
   
        %>
        <center>
        <h1>Student</h1>
        <form>
            <h3><%=result%></h3>
            <input type="hidden" name="check" value="2">
            Name<input name="name" value="<%=name%>" type="text">
            Roll no.<input value="<%=rollno%>" name="rollno" type="number">
            age<input value="<%=age%>" name="age" type="number">
        <br>
        <br>
        <input type="submit">
        </form>
        </center>
    </body>
</html>
