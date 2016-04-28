/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Himanshu Joshi
 */
@WebServlet(name = "FileDataFetcher", urlPatterns = {"/FileDataFetcher"})
public class FileDataFetcher extends HttpServlet {

    public static final Logger logger = Logger.getLogger("FileDataFetcher.class");
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fileName = request.getParameter("fileName");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        try (PrintWriter pw = response.getWriter()) {
               String[] strArr=fileName.split("/");
               String[] fileTags=strArr[0].split(" ");
               String fname="";
               int count1=0,count2=0;
               for(int i=0;i<fileTags.length;i++)
               {
                      if(fileTags[i].equals("physics")||fileTags[i].equals("gravitation")||fileTags[i].equals("kinematics")||
                         fileTags[i].equals("thermodynamics")||fileTags[i].equals("mechanics")||fileTags[i].equals("energy")||
                         fileTags[i].equals("light")||fileTags[i].equals("wave")||fileTags[i].equals("particle")||
                         fileTags[i].equals("nuclear")||fileTags[i].equals("velocity")||fileTags[i].equals("rotation")||
                         fileTags[i].equals("potential")||fileTags[i].equals("kinetic")||fileTags[i].equals("newton"))
                      {
                          count1++;                                                    
                      }
                      else if(fileTags[i].equals("maths")||fileTags[i].equals("calculus")||fileTags[i].equals("differentiation")||fileTags[i].equals("integration")||
                              fileTags[i].equals("addition")||fileTags[i].equals("substraction")||fileTags[i].equals("division")||fileTags[i].equals("multiplication")||
                              fileTags[i].equals("circle")||fileTags[i].equals("square")||fileTags[i].equals("triangle")||fileTags[i].equals("rectangle")||
                              fileTags[i].equals("algebra")||fileTags[i].equals("trigonometry")||fileTags[i].equals("coordinates")||fileTags[i].equals("geometry")||
                              fileTags[i].equals("probability")||fileTags[i].equals("permutation")||fileTags[i].equals("combination")||fileTags[i].equals("matrix")||
                              fileTags[i].equals("determinant")||fileTags[i].equals("complex")||fileTags[i].equals("iota")||fileTags[i].equals("imaginary")||
                              fileTags[i].equals("axis")||fileTags[i].equals("graphs")||fileTags[i].equals("binomial")||fileTags[i].equals("theorem")||
                              fileTags[i].equals("quadratic")||fileTags[i].equals("terms")||fileTags[i].equals("progression")||fileTags[i].equals("parallel")||
                              fileTags[i].equals("perpendicular"))
                      {
                          count2++;                         
                      }
               } 
               if(count1>=count2)
               {
                   fname="physics/"+strArr[1];
               }
               else{
                    fname="maths/"+strArr[1];
               }
               String file_loc= "C:\\Users\\Himanshu Joshi\\Dropbox\\"+fname;
            File my_file = new File(file_loc);
            //out.println(strArr[0]+","+strArr[1]);
            
            FileInputStream in = new FileInputStream(my_file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = br.readLine())!= null){
                pw.println(line);
            }
            in.close();
            pw.flush();
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