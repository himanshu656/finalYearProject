/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action;

import com.util.LoginProcessor;
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
 * @author Sabari
 */
public class UserLogin extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try{
             Boolean flag=(LoginProcessor.getUserDetailsClient(request.getParameter("_name"), request.getParameter("_password")));
             String name=request.getParameter("_name");
             String password=request.getParameter("_password") ;
             String sql="select * from user where name='"+name+"' and password='"+password+"'";
             Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "ftp";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String passwd = "password";
             Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, passwd);
             Statement st= conn.createStatement();
             ResultSet rs=st.executeQuery(sql);
             if(rs.next())
             {
                 
             
                HttpSession session=request.getSession();
                session.setAttribute("userid",request.getParameter("_name") );
                session.setAttribute("user_email",rs.getString("emailid"));
                
                System.out.println(">>>>>>>"+session.getAttribute("userid"));
                response.sendRedirect("userHome.jsp");
            } else {
                response.sendRedirect("userLogin.jsp?msg=Check Userid or Password");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
