package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import datapackage.DbConnect;

public final class studentsearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Student search</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    ");

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
        
      out.write("\n");
      out.write("    <center>\n");
      out.write("        ");
      out.print(result);
      out.write("\n");
      out.write("        <h1>Student Search and Delete</h1>\n");
      out.write("        <form>\n");
      out.write("            <h3>");
      out.print(result);
      out.write("</h3>\n");
      out.write("            <input type=\"hidden\" name=\"check\" value=\"2\">\n");
      out.write("            Name<input name=\"name\" value=\"");
      out.print(name);
      out.write("\" type=\"text\">\n");
      out.write("            Roll no.<input value=\"");
      out.print(rollno);
      out.write("\" name=\"rollno\" type=\"number\">\n");
      out.write("            age<input value=\"");
      out.print(age);
      out.write("\" name=\"age\" type=\"number\">\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("            <input type=\"submit\" name=\"option\" value=\"Search\"/>\n");
      out.write("            <input type=\"submit\" name=\"option\" value=\"Delete\"/>\n");
      out.write("        </form>\n");
      out.write("    </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
