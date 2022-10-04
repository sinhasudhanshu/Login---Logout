<%-- 
    Document   : purchase
    Created on : 19 Sep, 2022, 4:13:45 PM
    Author     : ASUS
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>purchaseorder</title>
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
            String receiptno = "", customername = "", mobileno = "", dateofpurchase = "", result = "";
            System.out.println(ispostback);

            if (ispostback) {
                try {
                    receiptno = request.getParameter("receiptno");
                    customername = request.getParameter("customername");
                    mobileno = request.getParameter("mobileno");
                    dateofpurchase = request.getParameter("dateofpurchase");
                    
                    
                    PreparedStatement ps = datapackage.DbConnect.connect().prepareStatement("insert into purchaseorder values(?,?,?,?)");
                    ps.setString(1, receiptno);
                    ps.setString(2, customername);
                    ps.setString(3, mobileno);
                    ps.setString(4, dateofpurchase);
                    
                    
                    int n = ps.executeUpdate();
                    result = "Inserted " +  " records";
                } catch (Exception ex) {
                    System.out.println(ex);
                    result = ex.getMessage();
                }
            }

        %>

    <center>
        <h1>Purchase</h1>
        <form>
            <h3><%=result%></h3>
            <input type="hidden" name="check" value="1">
            receiptno<input  name="receiptno" autocomplete="off" value="<%=receiptno%>" type="number"><br>
           
            customername<input name="customername" autocomplete="off" value="<%=customername%>" type="text"><br>
            
            mobileno<input name="mobileno" autocomplete="off" value="<%=mobileno%>" type="number"><br>
            
            dateofpurchase<input name="dateofpurchase" autocomplete="off" value="<%=dateofpurchase%>" type="date"><br>
            <br>
            <br>
            <input type="submit">
            
        </form>
    </center>
    </body>
</html>
