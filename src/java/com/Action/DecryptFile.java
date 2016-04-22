package com.Action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Himanshu Joshi
 */
public class DecryptFile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String fileNam=request.getParameter("fileName");
            String fileName=fileNam.trim();
            String key=request.getParameter("keyValue");
            String keyValue="com.sun.crypto.provider.PBKDF2KeyImpl@"+key;
            out.print(fileName+"...."+keyValue);
            
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "ftp";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String passwd = "password";
        String sql="select * from csp_data where file_name='"+fileName+"' and enckey='"+keyValue+"'";
             
            Class.forName(driver).newInstance();
            Connection conn = null;
            conn = DriverManager.getConnection(url + dbName, userName, passwd);
             Statement st= conn.createStatement();
             ResultSet rs=st.executeQuery(sql);
             String[] fileList;
             if(rs.next())
             {           
                 HttpSession se= request.getSession();
                 se.setAttribute("fileName", fileName);
                  response.sendRedirect("decryptFile.jsp?msg=File is decrypted");
                 
                // out.println("bingo");
                /// fileList = f.list();
            //    for (int i = 0; i < fileList.length; i++) 
                {
             //       out.print(fileList[i]);
                   // out.print(",");
                  //File f = new File("E:\\Netbeans Projects\\birds\\"+fileName);
                //response.sendRedirect("getKey.jsp?msg="+s[1]);
             //   HttpSession session=request.getSession();
              //  session.setAttribute("userid",request.getParameter("_name") );
               // session.setAttribute("user_email",rs.getString("emailid"));
                
              //  System.out.println(">>>>>>>"+session.getAttribute("userid"));
             //   response.sendRedirect("userHome.jsp");
             
                }
            }
                else 
            {
                                  response.sendRedirect("decryptFile.jsp?msg=Key is not matched :(");

                 //out.println("poor");
            //   File f = new File("E:\\Netbeans Projects\\animals\\");
             //   fileList = f.list();
              //  for (int i = 0; i < fileList.length; i++) 
                                  {
               //     out.print(fileList[i]);
                //    out.print(",");
            }
            }
                out.flush();
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }       
       
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
