package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.ResultSet;
import com.util.DbConnector;
import java.sql.PreparedStatement;

public final class userHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta name=\"keywords\" content=\"\" />\r\n");
      out.write("        <meta name=\"description\" content=\"\" />\r\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <title>Cloud</title>\r\n");
      out.write("        <link href=\"http://fonts.googleapis.com/css?family=Arvo\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"http://fonts.googleapis.com/css?family=Coda:400,800\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"menu-wrapper\">\r\n");
      out.write("            <div id=\"menu\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li class=\"current_page_item\"><a href=\"#\">User Home</a></li>\r\n");
      out.write("                    <li><a href=\"Insert_tags.jsp\">Upload</a></li>\r\n");
      out.write("                    <li><a href=\"report.jsp\">Report</a></li>\r\n");
      out.write("                    <li><a href=\"searchFile.jsp\">Search File</a></li>\r\n");
      out.write("                    <li><a href=\"index.jsp\">Log out</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- end #menu -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"header-wrapper\">\r\n");
      out.write("            <div id=\"header\">\r\n");
      out.write("                <div id=\"logo\">\r\n");
      out.write("                    <h1><a href=\"#\">Storing of Encrypted Data on Cloud using  <span>KNN Algorithm</span></a></h1>                    \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"banner\"><img src=\"images/img04.jpg\" width=\"1000\" height=\"350\" alt=\"\" /></div>\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("            <!-- end #header -->\r\n");
      out.write("            <div id=\"page\">\r\n");
      out.write("                <div id=\"page-bgtop\">\r\n");
      out.write("                    <div id=\"page-bgbtm\">\r\n");
      out.write("                        <div id=\"content\">\r\n");
      out.write("                            <div class=\"post\">                               \r\n");
      out.write("                                <div style=\"clear: both;\">&nbsp;</div>\r\n");
      out.write("                                <div class=\"entry\">\r\n");
      out.write("                                    ");
if (request.getParameter("msg") != null) {
                                            out.println(request.getParameter("msg"));
                                        }
      out.write("\r\n");
      out.write("                                    <h3>Users</h3>\r\n");
      out.write("                                    <table border=\"1\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th>User</th>\r\n");
      out.write("                                            <!--<th>FileName</th> -->\r\n");
      out.write("                                            <th>Age</th>\r\n");
      out.write("                                            <th>Email</th>\r\n");
      out.write("                                            <th>Mobile No.</th>\r\n");
      out.write("                                            <th>Gender</th>\r\n");
      out.write("                                           <!-- <th>Download</th> -->\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                        ");


                                            Connection con = DbConnector.getConnection();
                                            PreparedStatement pstm = null;
                                            String sql = "select * from user";
                                            pstm = con.prepareStatement(sql);
                                            ResultSet rs = pstm.executeQuery();
                                            while (rs.next()) {
      out.write("\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                           <!-- <td>");
      out.print(rs.getString(1));
      out.write("</td> -->\r\n");
      out.write("                                            <td>");
      out.print(rs.getString(2));
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(rs.getString(3));
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(rs.getString(4));
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(rs.getString(5));
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(rs.getString(6));
      out.write("</td> \r\n");
      out.write("                                            ");
 if (rs.getString(3).contains("s")) {
      out.write("\r\n");
      out.write("                                            <td><a href=\"FileDownload?ip=");
      out.print(rs.getString(4));
      out.write("&filename=");
      out.print(rs.getString(2));
      out.write("\" style=\"text-decoration: none;\">Click Here</a></td>\r\n");
      out.write("                                            ");
} else {
      out.write("\r\n");
      out.write("                                           <!-- <td></td>-->\r\n");
      out.write("                                            ");
}
      out.write("\r\n");
      out.write("                                        </tr>\r\n");
      out.write("\r\n");
      out.write("                                        ");
}
                                        
      out.write("\r\n");
      out.write("                                    </table>    \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div style=\"clear: both;\">&nbsp;</div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- end #content -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- end #sidebar -->\r\n");
      out.write("                        <div style=\"clear: both;\">&nbsp;</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- end #page -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"footer\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- end #footer -->\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
