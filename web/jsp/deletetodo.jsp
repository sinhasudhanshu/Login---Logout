<%-- 
    Document   : deletetodo
    Created on : 8 Sep, 2022, 3:28:00 PM
    Author     : ASUS
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="datapackage.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
           
            String option="";
           
           
             
            String sno = "", task = "", description = "", status = "",result ="",delete ="";
            System.out.println(ispostback);


           if(ispostback)
               
        {
            try
            {
            sno=request.getParameter("serialno");
         

            PreparedStatement ps=DbConnect.connect().prepareStatement("delete from todo where serialno=?");
            ps.setString(1, sno);
         
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
        <%=result%>
        <form>
            <input type="hidden" name="check"/>
            <h1>TODO </h1>
            serialno<input name="serialno" value="<%=sno%>" type="number">
            <br>
            <br>
           <input name="option" type="submit" value="delete"/>

           
        </form>
    </center>
    </body>
</html>
