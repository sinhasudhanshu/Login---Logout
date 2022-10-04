<%-- 
    Document   : product
    Created on : 15 Sep, 2022, 1:49:11 PM
    Author     : ASUS
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SHOP</title>
    </head>
    <body>
         <%
            String check = request.getParameter("check");  
            String option="";
            boolean ispostback;
            if (check == null) {
                ispostback = false;
            } else {
                ispostback = true;
            }
            String productid = "", productname = "", price="", description = "", discount = "",measurment = "" , category="", result="";
            System.out.println(ispostback);

            if (ispostback) {
                try {
                    option = request.getParameter("option");
                    if(option.equals("Submit"))
                    {
                    productid = request.getParameter("productid");
                    productname = request.getParameter("productname");
                    price = request.getParameter("price");
                    description = request.getParameter("description");
                    discount = request.getParameter("discount");
                    measurment = request.getParameter("measurment");
                    category = request.getParameter("category");
                    PreparedStatement ps = datapackage.DbConnect.connect().prepareStatement("insert into product values(?,?,?,?,?,?,?)");
                    ps.setString(1, productid);
                    ps.setString(2, productname);
                    ps.setString(3, price);
                    ps.setString(4, description);
                    ps.setString(5, discount);
                    ps.setString(6, measurment);
                    ps.setString(7, category);
                    int n = ps.executeUpdate();
                    result = "Inserted " + n + " records";
                }
               } catch (Exception ex) {
                    System.out.println(ex);
                    result = ex.getMessage();
                }
            }

        %>

    <center>
        <h1>Shop Management</h1>
        <form method="post">
            <h3><%=result%></h3>
            <input type="hidden" name="check" value="1">
            productid<input value="<%=productid%>" name="productid" type="number">
            <br>
            <br>
            productname<input value="<%=productname%>" name="productname" type="text">
            <br>
            <br>
            price<input name="price" value="<%=price%>" type="number">
            <br>
            <br>
            description<input name="description" value="<%=description%>" type="text">
            <br>
            <br>
            discount<input value="<%=discount%>" name="discount" type="number">
            <br>
            <br>
            measurment<input name="measurment" value="<%=measurment%>" type="text">
            <br>
            <br>
            category<input value="<%=category%>" name="category" type="text">
            <br>
            <br>
            
            <input name="option" type="submit">
            <input name="option" type="submit" value="Clear">
        </form>
    </center>
    </body>
</html>
