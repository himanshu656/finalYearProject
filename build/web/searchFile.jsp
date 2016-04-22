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
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
$(document).ready(function(){
  $(document).on("submit","#searh_form",function(e){
      e.preventDefault();
      $.ajax({type: "POST",
            url: "/FtpNew/FileSearching",
            data: { id: $("#sendToFetch").val(),search : $("#search").val()},
            success:function(result){
                var names = result.split(",");
                console.log(names);
                $("#t1").remove();
                var s ='<table id="t1">';
                for(var i = 0 ; i < names.length-1; i++){
                    console.log(names[i]);
                    console.log($("#search").val().trim()+"+"+names[i]);
                    var x = $("#search").val().trim()+"/"+names[i];
                    s+= "<tr><td>"+names[i]+"</td><td><a href= '/FtpNew/FileDataFetcher?fileName="+x+"'>download</a></td></tr>";
                }
                s+= '</table>';
                $(".bdy").append(s);
    }});
 });
});
</script>
    </head>
    <body>
        <div id="menu-wrapper">
            <div id="menu">
                <ul>
                    <li><a href="userHome.jsp">User Home</a></li>
                    <li><a href="Insert_tags.jsp">Upload</a></li>
                    <li><a href="report.jsp">Report</a></li>
                    <li class="current_page_item"><a href="#">Search File</a></li>
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
    <!--    <div id="banner"><img src="images/img04.jpg" width="1000" height="350" alt="" /></div>  -->
        <div class="bdy">
           
        <table >
            <form method="POST"  id="searh_form">
                <tr>
                    <td>Enter Search Key</td>
                    <td><textarea cols="60" rows="5" name="search" id = "search"> </textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"  value="Search File!!"> </td>
                </tr>
                
            </form>
        </table>  
        </div>                          
        <div id="footer">
        </div>
        <!-- end #footer -->
    </body>
</html>