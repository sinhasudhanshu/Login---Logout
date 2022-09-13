package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class condition_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String check = request.getParameter("check");
            //System.out.println(check);
            boolean ispostback;
            if (check == null) {
                ispostback = false;
            } else {
                ispostback = true;
            }
            int a = 0, b = 0, result = 0;
            String option = "";

            if (ispostback) {
                option = request.getParameter("option");
                a = (Integer.parseInt(request.getParameter("a")));
                b = (Integer.parseInt(request.getParameter("b")));
                if (option.equals("Addition")) {
                    result = a + b;
                }
                if (option.equals("Subtract")) {
                    result = a - b;
                }

                if (option.equals("Divide")) {
                    result = a % b;
                }
                if (option.equals("Multiplication")) {
                    result = a * b;
                }

            }


        
      out.write("\n");
      out.write("        <center>\n");
      out.write("        <h1>Calculations</h1>\n");
      out.write("        <form>\n");
      out.write("            <input value=\"1\" type=\"hidden\" name=\"check\">\n");
      out.write("            N1<input value=\"");
      out.print(a);
      out.write("\" name=\"a\" type=\"number\">\n");
      out.write("            N2<input  value=\"");
      out.print(b);
      out.write("\"  name=\"b\" type=\"number\">\n");
      out.write("            Result<input readonly  value=\"");
      out.print(result);
      out.write("\"  type=\"number\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input name=\"option\" type=\"submit\" value=\"Addition\"/>\n");
      out.write("            <input name=\"option\" type=\"submit\" value=\"Subtract\"/>\n");
      out.write("            <input name=\"option\" type=\"submit\" value=\"Divide\"/>\n");
      out.write("            <input name=\"option\" type=\"submit\" value=\"Multiplication\"/>\n");
      out.write("        </form>\n");
      out.write("        </center>\n");
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
