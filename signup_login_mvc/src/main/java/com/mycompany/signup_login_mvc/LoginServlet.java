/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.signup_login_mvc;

import models.UserDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHATRI
 */
public class LoginServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
        UserDetails userDetails = new UserDetails();
        userDetails.setFormData(uname,pass);
        try {
            /* TODO output your page here. You may use following sample code. */
            Connection myCon  = (Connection)getServletContext().getAttribute("dBConnection");
            
            try {
                PreparedStatement myPst;
                myPst = myCon.prepareStatement("SELECT * FROM user WHERE name=?");
                myPst.setString(1,uname);
                ResultSet rs;
                rs = myPst.executeQuery();
                boolean hasUser = false;
                while(rs.next()){
                    userDetails.setDbData(rs.getString("name") , rs.getString("pass"));
                    
                    if(userDetails.passcheck()){
                        request.getRequestDispatcher("welcome.jsp").forward(request, response);
                        hasUser = true;
                   }
                    
                }
               if(!hasUser){
                   String err = "Invalid Password";
                        request.setAttribute("passwd_msg", err);
                    
                        request.getRequestDispatcher("index.jsp").forward(request, response);
            }         
            }
            
            catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.println(ex);
            }
            catch (IOException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.println(ex);
            }
            catch (Exception ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                out.println(ex);
            }
        } finally {
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
