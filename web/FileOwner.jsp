<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<style>        
    .header
        {
        width:100%;
        height:100px;
        border:1px solid white;
        background-color:aqua;
        border-radius:12px;
        }
        .bdy
        {
        width:100%;
        height:400px;
        border:1px solid white;
        background-color:#E6E6E6;
        border-radius:12px;
        }
        .footer
        {
        width:100%;
        height:100px;
        border:1px solid white;
        background-color:aqua;
        border-radius:12px;
        }
        </style>
    </head>
<body>
    
    <div id="menu-wrapper">
            <div id="menu">
                <ul>
                    <li><a href="userHome.jsp">User Home</a></li>
                    <li><a href="FileOwner.jsp">Upload</a></li>
                    <li><a href="report.jsp">Report</a></li>
                    <li><a href="searchFile.jsp">Search File</a></li>
                    <li><a href="getKey.jsp">Acquire Key</a></li>
                     <li class="current_page_item"><a href="#">File Owner</a></li>
                    <li><a href="decryptFile.jsp">Decrypt File</a></li>
                    <li><a href="index.jsp">Log out</a></li>
                </ul>
            </div>
            <!-- end #menu -->
        </div>

    
    <div class="bdy">
            <%
           HttpSession se= request.getSession();
           out.print("<h2>Hello  "+se.getAttribute("user_email")+"</h2>");
           String file_name=(String)se.getAttribute("file_name");
           String size=(String)se.getAttribute("size");
           String owner_email=(String)se.getAttribute("user_email");
           String pyarakey=(String)se.getAttribute("pyarakey");
    
    %>
    <table>
        <form method="POST" action="FileOwner">
                <tr>
                    <td>Enter File Name :</td>
                    <td><input type="text" cols="60" rows="2" name="fileName"> </textarea></td>
                    
                    
                </tr>
                <br>
                    <br>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="submit"  value="Who is my Owner !!"> </td>
                </tr>
            </form>
        </table>
        <%
        
       if (request.getParameter("msg") != null) {
                                            out.println(request.getParameter("msg"));
                                        }
        %>
        
        
        
    </div>
    <div class="footer"></div>
</body>
</html>