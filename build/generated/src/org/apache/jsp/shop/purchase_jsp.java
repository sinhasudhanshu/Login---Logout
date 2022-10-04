package org.apache.jsp.shop;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;

public final class purchase_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>purchaseorder</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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

        
      out.write("\n");
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <h1>Purchase</h1>\n");
      out.write("        <form>\n");
      out.write("            <h3>");
      out.print(result);
      out.write("</h3>\n");
      out.write("            <input type=\"hidden\" name=\"check\" value=\"1\">\n");
      out.write("            receiptno<input  name=\"receiptno\" autocomplete=\"off\" value=\"");
      out.print(receiptno);
      out.write("\" type=\"number\"><br>\n");
      out.write("           \n");
      out.write("            customername<input name=\"customername\" autocomplete=\"off\" value=\"");
      out.print(customername);
      out.write("\" type=\"text\"><br>\n");
      out.write("            \n");
      out.write("            mobileno<input name=\"mobileno\" autocomplete=\"off\" value=\"");
      out.print(mobileno);
      out.write("\" type=\"number\"><br>\n");
      out.write("            \n");
      out.write("            dateofpurchase<input name=\"dateofpurchase\" autocomplete=\"off\" value=\"");
      out.print(dateofpurchase);
      out.write("\" type=\"date\"><br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\">\n");
      out.write("            \n");
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
