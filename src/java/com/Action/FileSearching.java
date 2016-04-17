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
            int count1 = 0, count2 = 0;
            for (int i = 0; i < tagLen; i++) {
                if (tagArr[i].equals("bird")) {
                    count1++;
                }
                if (tagArr[i].equals("wings")) {
                    count1++;
                }
                if (tagArr[i].equals("sweet")) {
                    count1++;
                }
                if (tagArr[i].equals("fly")) {
                    count1++;
                }
                if (tagArr[i].equals("animal")) {
                    count2++;
                }
                if (tagArr[i].equals("walk")) {
                    count2++;
                }
                if (tagArr[i].equals("big")) {
                    count2++;
                }
                if (tagArr[i].equals("four legs")) {
                    count2++;
                }
            }
            String[] fileList = null;
            if (count1 >= count2) {
                File f = new File("C:\\Cloud\\birds\\");
                fileList = f.list();
                for (int i = 0; i < fileList.length; i++) {
                    out.print(fileList[i]);
                    out.print(",");
                }
            } else if (count1 < count2) {
                File f = new File("C:\\Cloud\\animals\\");
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
