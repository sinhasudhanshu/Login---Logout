<%-- 
    Document   : productstock
    Created on : 15 Sep, 2022, 5:02:55 PM
    Author     : ASUS
--%>

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="datapackage.DbConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Stock</title>
    </head>
    <body>
    <center>
        <%
            PreparedStatement ps = DbConnect.connect().prepareStatement("select * from product order by productid");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int n = rsmd.getColumnCount();
        %>

        <table border="1">
            <tr>
                <%
                    for (int i = 1; i <= n; i++) {
                %>
                <th><%=rsmd.getColumnLabel(i)%></th>

                <%
                    }

                %>
            </tr>
            <%   while (rs.next()) {%>
            <tr>
                <%
                    for (int i = 1; i <= n; i++) {
                %>
                <th><%=rs.getObject(i)%></th>
                    <%
                        }
                    %>
            </tr>
            <%
                }
            %>
        </table>
    </center>
</body>
</html>
