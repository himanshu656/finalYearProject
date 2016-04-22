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
                      if(fileTags[i].equals("bird")||fileTags[i].equals("fly")||fileTags[i].equals("small"))
                      {
                          count1++;                                                    
                      }
                      else if(fileTags[i].equals("animal")||fileTags[i].equals("walk")||fileTags[i].equals("big"))
                      {
                          count2++;                         
                      }
               } 
               if(count1>=count2)
               {
                   fname="birds/"+strArr[1];
               }
               else{
                    fname="animals/"+strArr[1];
               }
               String file_loc= "C:\\Cloud\\"+fname;
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
