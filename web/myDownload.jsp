<%-- 
    Document   : myDownload
    Created on : 21-Apr-2016, 21:51:02
    Author     : Himanshu Joshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%    
             HttpSession se= request.getSession();
             String fileName=(String)se.getAttribute("fileName");
  String filename = fileName;   
  String filepath = "E:\\makeshift\\";   
  response.setContentType("APPLICATION/OCTET-STREAM");   
  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
  java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath + filename);  
            
  int i;   
  while ((i=fileInputStream.read()) != -1) {  
    out.write(i);   
  }   
  fileInputStream.close();   
%>
    </body>
</html>
