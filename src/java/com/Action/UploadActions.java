/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Action;

import com.AES;
import com.util.Constant;
import com.util.DbConnector;
import com.util.SimpleFTPClient;
import com.util.Utilities;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Sabari
 */
public class UploadActions extends HttpServlet {

    private static final String TMP_DIR_PATH = "c:\\tmp";
    private File tmpDir;
    private static final String DESTINATION_DIR_PATH = "file";
    private File destinationDir;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        /*
         *Set the size threshold, above which content will be stored on disk.
         */
        fileItemFactory.setSizeThreshold(1 * 1024 * 1024); //1 MB
		/*
         * Set the temporary directory to store the uploaded files of size above threshold.
         */
        fileItemFactory.setRepository(tmpDir);

        ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);
        Connection con = null;
        PreparedStatement pstm = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        PreparedStatement pstm3 = null;

        

            
       //-----------------------  Creating folder Program--------------------
            HttpSession se= request.getSession();
            String user_email=(String)se.getAttribute("user_email");
            String user_name=(String)se.getAttribute("userid");
            File theDir = new File("C:\\Cloud\\"+user_email);

            // if the directory does not exist, create it
            if (!theDir.exists()) {
               // System.out.println("creating directory: " + fileName);
                boolean result = false;

                try{
                    theDir.mkdir();
                    result = true;
                } 
                catch(SecurityException see){
                    //handle it
                }        
                
            }

//  ---------------------------------------------------------------------------------------------      
            
            
            
            con = DbConnector.getConnection();
            List items = uploadHandler.parseRequest(request);
            Iterator itr = items.iterator();            
            String fileName = "";
            FileItem item = (FileItem) itr.next();
            String fName=item.getName();
            String sql1 = "select * from transaction where filename='" + item.getName() + "'";
            out.println(">>>>>>>>>>" + sql1+"<br>");
            pstm = con.prepareStatement(sql1);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>.loop");
               // response.sendRedirect("fileUpload.jsp?msg=File Name Already Exist");
                out.println("FILE ALREADY EXIST.");
                return;
            } else {
                fileName = (String) item.getName();
                out.println("FILENAME:  "+fileName+"<br>");
                //File file = new File(Constant.file, item.getName());
                //item.write(file);
                //out.println("" + file.getAbsolutePath());
                //out.println(fileName);
                int x=fileName.lastIndexOf('\\');
                String fN=fileName.substring(x+1, fileName.length());
                System.out.println(fN);
                SimpleFTPClient client = null;
                String sq1 = "select * from cloud where status='Active'";
                //out.println("QUERY:  "+sq1+"<br>");
                pstm3 = con.prepareStatement(sq1);
                ResultSet rs1 = pstm3.executeQuery();
                String user="";
                String cld="";
                
                //-------------------------- FILE ENCRYPTION --------------------
                
             String path="C:\\Users\\User\\Desktop\\MyFiles\\"+fileName;
             out.println("PATH: "+path);
             FileReader fileReader =new FileReader(path);
             BufferedReader br= new BufferedReader(fileReader);
             String line="";
             String data="";
             while((line=br.readLine())!=null)
                {
                   data+=line;
                }
            br.close();
            out.println("path: "+path+"  content:=  "+data );     
            AES algo= new AES("Mypassword");
            File   input   = new File(path);
            File   eoutput = new File("C:\\Cloud\\"+user_email+"\\"+fileName);  
            out.println("<br>C:\\Cloud\\"+user_email+"\\"+fileName);
            String iv=null;
            String salt=null;
            algo.WriteEncryptedFile(new FileInputStream(input), new FileOutputStream(eoutput));
        
             
                //------------------------------------------------------------------

               if (rs1.next()) {
                    client=new SimpleFTPClient();
                    cld=rs1.getString("Ip");
                    user=rs1.getString("uname");
                    client.setHost(rs1.getString("Ip"));
                    client.setUser(rs1.getString("uname"));
                    client.setPassword(rs1.getString("password"));
                    client.setRemoteFile("fN");

                   boolean log= client.connect(); 
                   //if(log){
                        //if (client.uploadFile(item.getInputStream())){
                        user = (String) request.getSession().getAttribute("userid");
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + user);
                        String sq2 = "insert into transaction values('" + user_email+"_"+fileName + "','Success','"+cld+"',now(),'Upload','"+user+"')";
                        pstm1 = (PreparedStatement) con.prepareStatement(sq2);
                        pstm1.executeUpdate();
                        
                        
                  /*      
                        
                    } else {
                           System.out.println(">>>>>>else");
                        response.sendRedirect("fileUpload.jsp?msg=Cloud Not Connected");
                         String sq3 = "insert into transaction values('" + user + "','" + fileName + "','Failed','"+cld+"',now(),'Upload')";
                        pstm2 = (PreparedStatement) con.prepareStatement(sq3);
                        pstm2.executeUpdate();
                       
                        
                    }
                   }else{
                       System.out.println("not connected");
                   }*/
                     
                } 
                //response.sendRedirect("fileUpload.jsp?msg=Check Report");
               se.setAttribute("owner_email",user_email);
               se.setAttribute("size", (data.length()+""));
               se.setAttribute("file_name",fileName);
               se.setAttribute("pyarakey",algo.key );
                response.sendRedirect("Insert_tags.jsp");
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
//            response.sendRedirect("fileUpload.jsp?msg=updated successfully");
            // log("Error encountered while uploading file", ex);
        }
//        response.sendRedirect("fileUpload.jsp?msg=Check Report for status");
      //  response.sendRedirect("Insert_tags.jsp");
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
