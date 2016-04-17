package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Insert_005ftags_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("<style>        \n");
      out.write("    .header\n");
      out.write("        {\n");
      out.write("        width:100%;\n");
      out.write("        height:100px;\n");
      out.write("        border:1px solid white;\n");
      out.write("        background-color:aqua;\n");
      out.write("        border-radius:12px;\n");
      out.write("        }\n");
      out.write("        .bdy\n");
      out.write("        {\n");
      out.write("        width:100%;\n");
      out.write("        height:400px;\n");
      out.write("        border:1px solid white;\n");
      out.write("        background-color:#E6E6E6;\n");
      out.write("        border-radius:12px;\n");
      out.write("        }\n");
      out.write("        .footer\n");
      out.write("        {\n");
      out.write("        width:100%;\n");
      out.write("        height:100px;\n");
      out.write("        border:1px solid white;\n");
      out.write("        background-color:aqua;\n");
      out.write("        border-radius:12px;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("    <div id=\"menu-wrapper\">\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"userHome.jsp\">User Home</a></li>\n");
      out.write("                    <li class=\"current_page_item\"><a href=\"#\">Upload</a></li>\n");
      out.write("                    <li><a href=\"report.jsp\">Report</a></li>\n");
      out.write("                    <li><a href=\"searchFile.jsp\">Search File</a></li>\n");
      out.write("                    <li><a href=\"index.jsp\">Log out</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- end #menu -->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"bdy\">\n");
      out.write("            ");

           HttpSession se= request.getSession();
           out.print("<h2>Hello  "+se.getAttribute("user_email")+"</h2>");
           String file_name=(String)se.getAttribute("file_name");
           String size=(String)se.getAttribute("size");
           String owner_email=(String)se.getAttribute("user_email");
           String pyarakey=(String)se.getAttribute("pyarakey");
    
    
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <form method=\"POST\" action=\"InsertTags\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Enter Tags</td>\n");
      out.write("                    <td><textarea cols=\"60\" rows=\"10\" name=\"tags\"> </textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\"  value=\"Insert tags!!\"> </td>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        ");

        
        if(request.getAttribute("msg_report")!=null)
        {
            String msg=(String)se.getAttribute("msg_report");
            out.println("<h3 style='color:red;'>'"+msg+"'</h3>");
            
        }
        
        
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("    <div class=\"footer\"></div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
