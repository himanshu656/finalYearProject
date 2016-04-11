/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action;

import com.util.DbConnector;
import java.io.IOException;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Himanshu Joshi
 */
public class ForDelete extends HttpServlet{
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
           
            Connection conn=DbConnector.getConnection();
            Statement stmt=conn.createStatement();
            String s=request.getParameter("");
        }
}
