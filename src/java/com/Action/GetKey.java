/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action;

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
public class GetKey extends HttpServlet {

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
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "ftp";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String passwd = "password";
        String file_nam=request.getParameter("fileName");
        String file_name=file_nam.trim();
        out.println(file_name);
        HttpSession session=request.getSession();
        String user_email=(String) session.getAttribute("owner_email");
        //out.println(user_naam);
                
        String sql="select enckey from csp_data where file_name='"+file_name+"' and email='"+user_email+"'";
             
            Class.forName(driver).newInstance();
            Connection conn = null;
            conn = DriverManager.getConnection(url + dbName, userName, passwd);
             Statement st= conn.createStatement();
             ResultSet rs=st.executeQuery(sql);
             if(rs.next())
             {
                 String str=rs.getString(1);
                 String s[]=str.split("@");
                 
             response.sendRedirect("getKey.jsp?msg="+s[1]);
               // session.setAttribute("userid",request.getParameter("_name") );
               // session.setAttribute("user_email",rs.getString("emailid"));
                
              //  System.out.println(">>>>>>>"+session.getAttribute("userid"));
                //response.sendRedirect("userHome.jsp");
            } else {
                response.sendRedirect("getKey.jsp?msg=You does not own this file..");
            }
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
