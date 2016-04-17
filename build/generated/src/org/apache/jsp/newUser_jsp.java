package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"menu-wrapper\">\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"adminHome.jsp\">Admin Home</a></li>\n");
      out.write("                    <!-- <li><a href=\"createCloud.jsp\">Create Cloud</a></li>    -->\n");
      out.write("                <!--     <li><a href=\"cloudDetails.jsp\">Cloud Details</a></li>        -->                  \n");
      out.write("                    <li class=\"current_page_item\"><a href=\"newUser.jsp\">Create Member</a></li>\n");
      out.write("                    <li><a href=\"viewUser.jsp\">Member Details</a></li>\n");
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
      out.write("        <div id=\"banner\"><img src=\"images/img04.jpg\" width=\"1000\" height=\"350\" alt=\"\" /></div>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <!-- end #header -->\n");
      out.write("            <div id=\"page\">\n");
      out.write("                <div id=\"page-bgtop\">\n");
      out.write("                    <div id=\"page-bgbtm\">\n");
      out.write("                        <div id=\"content\">\n");
      out.write("                            <div class=\"post\">\n");
      out.write("                                <h3>New Member</h3>\n");
      out.write("                                <div style=\"clear: both;\">&nbsp;</div>\n");
      out.write("                                <div class=\"entry\">\n");
      out.write("                                    ");
if (request.getParameter("msg") != null) {
                                                                out.println(request.getParameter("msg"));
                                                            }
      out.write("\n");
      out.write("                                    <form method=\"post\" action=\"NewUserReg\">\n");
      out.write("                                        <table width=\"90%\">\n");
      out.write("                                            <tr style=\"height: 40px;\"><td>User id:</td><td><input type=\"text\" size=\"30\" style=\"height: 25px;\" id=\"_name\" name=\"_name\"/></td></tr>\n");
      out.write("                                            <tr style=\"height: 40px;\"><td>Password:</td><td><input type=\"password\" size=\"30\" style=\"height: 25px;\" id=\"_password\" name=\"_password\"/></td></tr>\n");
      out.write("                                            <tr style=\"height: 40px;\"><td>Gender:</td><td><input type=\"radio\" name=\"sex\" id=\"sex\" value=\"male\" /> Male\n");
      out.write("                                                    <input type=\"radio\" name=\"sex\" id=\"sex\" value=\"female\" /> Female</td></tr>\n");
      out.write("                                            <tr style=\"height: 40px;\"><td>Age:</td><td><input type=\"text\" size=\"30\" style=\"height: 25px;\" id=\"_age\" name=\"_age\"/></td></tr>\n");
      out.write("                                            <tr style=\"height: 40px;\"><td>Phone:</td><td><input type=\"text\" size=\"30\" style=\"height: 25px;\" id=\"_phone\" name=\"_phone\"/></td></tr>\n");
      out.write("                                            <tr style=\"height: 40px;\"><td>Email-Id:</td><td><input type=\"text\" size=\"30\" style=\"height: 25px;\" id=\"_emailid\" name=\"_emailid\"/></td></tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            <tr style=\"height: 40px;\"><td></td><td><input type=\"submit\" value=\"Submit\" style=\"height: 25px;width: 90px;\"/></td></tr>\n");
      out.write("                                        </table>\n");
      out.write("                                    </form>\t\n");
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
      out.write("            <p></p>\n");
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
