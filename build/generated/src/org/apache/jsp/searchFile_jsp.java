package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.ResultSet;
import com.util.DbConnector;
import java.sql.PreparedStatement;

public final class searchFile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("$(document).ready(function(){\n");
      out.write("  $(document).on(\"submit\",\"#searh_form\",function(e){\n");
      out.write("      e.preventDefault();\n");
      out.write("      $.ajax({type: \"POST\",\n");
      out.write("            url: \"/FtpNew/FileSearching\",\n");
      out.write("            data: { id: $(\"#sendToFetch\").val(),search : $(\"#search\").val()},\n");
      out.write("            success:function(result){\n");
      out.write("                var names = result.split(\",\");\n");
      out.write("                console.log(names);\n");
      out.write("                var s ='<table>';\n");
      out.write("                for(var i = 0 ; i < names.length-1; i++){\n");
      out.write("                    console.log(names[i]);\n");
      out.write("                    s+= \"<tr><td>\"+names[i]+\"</td><td><a href= '/FtpNew/FileDataFetcher?fileName=\"+names[i]+\"'>download</a></td></tr>\";\n");
      out.write("                }\n");
      out.write("                s+= '</table>';\n");
      out.write("                $(\".bdy\").append(s);\n");
      out.write("    }});\n");
      out.write(" });\n");
      out.write("});\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"menu-wrapper\">\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"userHome.jsp\">User Home</a></li>\n");
      out.write("                    <li><a href=\"Insert_tags.jsp\">Upload</a></li>\n");
      out.write("                    <li><a href=\"report.jsp\">Report</a></li>\n");
      out.write("                    <li class=\"current_page_item\"><a href=\"#\">Search File</a></li>\n");
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
      out.write("        <div class=\"bdy\">\n");
      out.write("           \n");
      out.write("        <table >\n");
      out.write("            <form method=\"POST\"  id=\"searh_form\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>Enter Search Key</td>\n");
      out.write("                    <td><textarea cols=\"60\" rows=\"5\" name=\"search\" id = \"search\"> </textarea></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\"  value=\"Search File!!\"> </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("        </table>  \n");
      out.write("        </div>                          \n");
      out.write("        <div id=\"footer\">\n");
      out.write("        </div>\n");
      out.write("        <!-- end #footer -->\n");
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
