package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.util.DbConnector;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class decryptFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"keywords\" content=\"\" />\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <title>Cloud</title>\n");
      out.write("        <link href=\"http://fonts.googleapis.com/css?family=Arvo\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"http://fonts.googleapis.com/css?family=Coda:400,800\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("        <div id=\"menu-wrapper\">\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"userHome.jsp\">User Home</a></li>\n");
      out.write("                    <li><a href=\"Insert_tags.jsp\">Upload</a></li>\n");
      out.write("                    <li><a href=\"report.jsp\">Report</a></li>\n");
      out.write("                    <li><a href=\"searchFile.jsp\">Search File</a></li>\n");
      out.write("                    <li><a href=\"getKey.jsp\">Acquire Key</a></li>\n");
      out.write("                     <li><a href=\"FileOwner.jsp\">File Owner</a></li>\n");
      out.write("                     <li class=\"current_page_item\"><a href=\"#\">Decrypt File</a></li>\n");
      out.write("                    <li><a href=\"index.jsp\">Log out</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <!-- end #menu -->\n");
      out.write("        </div>\n");
      out.write("        <div id=\"header-wrapper\">\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <div id=\"logo\">\n");
      out.write("                    <h1><a href=\"#\">Storing of Encrypted Data on Cloud using  <span>KNN Algorithm</span></a></h1>                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    <!--    <div id=\"banner\"><img src=\"images/img04.jpg\" width=\"1000\" height=\"350\" alt=\"\" /></div>  -->\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <!-- end #header -->\n");
      out.write("            <div id=\"page\">\n");
      out.write("                <div id=\"page-bgtop\">\n");
      out.write("                    <div id=\"page-bgbtm\">\n");
      out.write("                        <div id=\"content\">\n");
      out.write("                            <div class=\"post\">                                \n");
      out.write("                                <div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("                                <div class=\"entry\">\n");
      out.write("                                    \n");
      out.write("                                    <h3>Decrypt File ...</h3>\n");
      out.write("                                    <!--form name=\"\" action=\"GetKey\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                                        <table-->\n");
      out.write("            <form method=\"POST\" action=\"DecryptFile\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Enter File Name :</td>\n");
      out.write("                    <td><input type=\"text\" cols=\"60\" rows=\"2\" name=\"fileName\"> </textarea></td>\n");
      out.write("                    \n");
      out.write("                    <td>&nbsp;&nbsp;&nbsp;&nbsp; Enter Key :</td>\n");
      out.write("                    <td><input type=\"text\" cols=\"60\" rows=\"2\" name=\"keyValue\"> </textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <br>\n");
      out.write("                    <br>\n");
      out.write("                        <tr><td>\n");
      out.write("                               </td>\n");
      out.write("                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                    <td><input type=\"submit\"  value=\"Decrypt me !!\"> </td>\n");
      out.write("                </tr>\n");
      out.write("            </form>\n");
      out.write("        <!--/table>\n");
      out.write("                                    </form-->\n");
      out.write("                              <br><br> <a href=\"myDownload.jsp\">Click me to download the requested file !</a>\n");
      out.write("                                ");
if (request.getParameter("msg") != null) {
                                            out.println(request.getParameter("msg"));
                                        }
                                        Connection con = DbConnector.getConnection();
                                        PreparedStatement pstm = null;
                                        String sql = "select count(*) from cloud where status like 'Active'";
                                        pstm = con.prepareStatement(sql);
                                        ResultSet rs = pstm.executeQuery();
                                        String a = "";
                                        if (rs.next()) {
                                            a = rs.getString(1);
                                        }
      out.write("\n");
      out.write("                                        <!--%if (request.getParameter(\"msg\") != null) {\n");
      out.write("                                            out.println(request.getParameter(\"msg\"));\n");
      out.write("                                        }%-->\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- end #content -->\n");
      out.write("\n");
      out.write("                        <!-- end #sidebar -->\n");
      out.write("                        <div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- end #page -->\n");
      out.write("        </div>\n");
      out.write("        <div id=\"footer\">\n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("        <!-- end #footer -->\n");
      out.write("    </body>\n");
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
