/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Himanshu Joshi
 */
public class FileSearching extends HttpServlet {

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
            String search1 = request.getParameter("search");
            String search = search1.trim();
            String[] tagArr = search.split(" ");
            //out.println(Arrays.toString(tagArr));

            int tagLen = tagArr.length;
            int count1 = 0, count2 = 0,count3=0;
            for (int i = 0; i < tagLen; i++) {
                 if(tagArr[i].equals("physics")||tagArr[i].equals("gravitation")||tagArr[i].equals("kinematics")||
                         tagArr[i].equals("thermodynamics")||tagArr[i].equals("mechanics")||tagArr[i].equals("energy")||
                         tagArr[i].equals("light")||tagArr[i].equals("wave")||tagArr[i].equals("particle")||
                         tagArr[i].equals("nuclear")||tagArr[i].equals("velocity")||tagArr[i].equals("rotation")||
                         tagArr[i].equals("potential")||tagArr[i].equals("kinetic")||tagArr[i].equals("newton"))
                      {
                          count1++;                                                    
                      }
                      else if(tagArr[i].equals("animal")||tagArr[i].equals("calculus")||tagArr[i].equals("differentiation")||tagArr[i].equals("integration")||
                              tagArr[i].equals("addition")||tagArr[i].equals("substraction")||tagArr[i].equals("division")||tagArr[i].equals("multiplication")||
                              tagArr[i].equals("circle")||tagArr[i].equals("square")||tagArr[i].equals("triangle")||tagArr[i].equals("rectangle")||
                              tagArr[i].equals("algebra")||tagArr[i].equals("trigonometry")||tagArr[i].equals("coordinates")||tagArr[i].equals("geometry")||
                              tagArr[i].equals("probability")||tagArr[i].equals("permutation")||tagArr[i].equals("combination")||tagArr[i].equals("matrix")||
                              tagArr[i].equals("determinant")||tagArr[i].equals("complex")||tagArr[i].equals("iota")||tagArr[i].equals("imaginary")||
                              tagArr[i].equals("axis")||tagArr[i].equals("graphs")||tagArr[i].equals("binomial")||tagArr[i].equals("theorem")||
                              tagArr[i].equals("quadratic")||tagArr[i].equals("terms")||tagArr[i].equals("progression")||tagArr[i].equals("parallel")||
                              tagArr[i].equals("perpendicular"))
                      {
                          count2++;                         
                      }
            }
            String[] fileList = null;
            if (count1 >= count2) {
                File f = new File("C:\\Cloud\\physics\\");
                fileList = f.list();
                for (int i = 0; i < fileList.length; i++) {
                    out.print(fileList[i]);
                    out.print(",");
                }
            } else if (count1 < count2) {
                File f = new File("C:\\Cloud\\maths\\");
                fileList = f.list();
                for (int i = 0; i < fileList.length; i++) {
                    out.print(fileList[i]);
                    out.print(",");
                }
            }
            out.flush();
            out.close();
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
