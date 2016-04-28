<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.util.DbConnector"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Cloud</title>
        <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
        <link href="http://fonts.googleapis.com/css?family=Coda:400,800" rel="stylesheet" type="text/css" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <div id="menu-wrapper">
            <div id="menu">
                <ul>
                    <li><a href="userHome.jsp">User Home</a></li>
                    <li><a href="Insert_tags.jsp">Upload</a></li>
                    <li class="current_page_item"><a href="report.jsp">Report</a></li>
                    <li><a href="searchFile.jsp">Search File</a></li>
                     <li><a href="getKey.jsp">Acquire Key</a></li>
                     <li><a href="FileOwner.jsp">File Owner</a></li>
                     <li><a href="decryptFile.jsp">Decrypt File</a></li>
                    <li><a href="index.jsp">Log out</a></li>
                </ul>
            </div>
            <!-- end #menu -->
        </div>
        <div id="header-wrapper">
            <div id="header">
                <div id="logo">
                    <h1><a href="#">Storing of Encrypted Data on Cloud using  <span>KNN Algorithm</span></a></h1>                    
                </div>
            </div>
        </div>
        <div id="banner"><img src="images/img04.jpg" width="1000" height="350" alt="" /></div>
        <div id="wrapper">
            <!-- end #header -->
            <div id="page">
                <div id="page-bgtop">
                    <div id="page-bgbtm">
                        <div id="content">
                            <div class="post">
                                <h3>Report</h3>
                                <div style="clear: both;">&nbsp;</div>
                                <div class="entry">
                                    <%if (request.getParameter("msg") != null) {
                                            out.println(request.getParameter("msg"));
                                        }%>
                               
                                    <table border="1" width="100%" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <th>Status</th>
                                            <th>Date & Time</th>
                                            <th>File Name</th>
                                          <!--  <th>Download</th>-->
                                        </tr>
                                        <%
                                            HttpSession se= request.getSession();                                            
                                             String user=(String)se.getAttribute("userid");
                                            out.print("<h2>Hello : "+user+"</h2>");
                                            Connection con = DbConnector.getConnection();
                                            PreparedStatement pstm = null;
                                            String sql = "select * from transaction where name='"+user+"' group by filename ";
                                            pstm = con.prepareStatement(sql);
                                            ResultSet rs = pstm.executeQuery();
                                            while (rs.next()) {%>
                                        <tr>
                                            <td><%=rs.getString(2)%></td>
                                            <td><%=rs.getString(3)%></td>
                                            <td><%=rs.getString(1)%></td>
                                            <!--<td><%=rs.getString(5)%></td> -->
                                           <!-- <td><a href="FileDownload?ip=<%=rs.getString(4)%>&file=<%=rs.getString(2)%>">Download</a></td> -->

                                        </tr>

                                        <%}
                                        %>
                                    </table>      
                                </div>
                            </div>
                            <div style="clear: both;">&nbsp;</div>
                        </div>
                        <!-- end #content -->

                        <!-- end #sidebar -->
                        <div style="clear: both;">&nbsp;</div>
                    </div>
                </div>
            </div>
            <!-- end #page -->
        </div>
        <div id="footer">
           
        </div>
        <!-- end #footer -->
    </body>
</html>
