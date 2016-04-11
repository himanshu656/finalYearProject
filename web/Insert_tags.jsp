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
                    <li class="current_page_item"><a href="#">Upload</a></li>
                    <li><a href="report.jsp">Report</a></li>
                    <li><a href="index.jsp">Log out</a></li>
                </ul>
            </div>
            <!-- end #menu -->
        </div>

    
    <div class="bdy">
            <%
           HttpSession se= request.getSession();
           out.print("<h2>Hello : "+se.getAttribute("owner_email")+"</h2>");
           String file_name=(String)se.getAttribute("file_name");
           String size=(String)se.getAttribute("size");
           String owner_email=(String)se.getAttribute("owner_email");
           String pyarakey=(String)se.getAttribute("pyarakey");
    
    %>
        <table>
            <form method="POST" action="InsertTags">
                <tr>
                    <td>Enter Tags</td>
                    <td><textarea cols="60" rows="10" name="tags"> </textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"  value="Insert tags!!"> </td>
                </tr>
            </form>
        </table>
        
        <%
        
        if(request.getAttribute("msg_report")!=null)
        {
            String msg=(String)se.getAttribute("msg_report");
            out.println("<h3 style='color:red;'>'"+msg+"'</h3>");
            
        }
        
        %>
        
        
        
    </div>
    <div class="footer"></div>
</body>
</html>