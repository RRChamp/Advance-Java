/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.signup_login_mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class SignUpServlet extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
                String uname  = request.getParameter("username");
                String pass = request.getParameter("password");
                if(uname.isEmpty() || pass.isEmpty() || (request.getParameter("reptPassword")).isEmpty()){
                String EmptyFieldErr = "Field can't be empty!";
                    request.setAttribute("passMatch_err", EmptyFieldErr);
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }
                else{
                if(!pass.equals(request.getParameter("reptPassword"))){
                    String passMatchErr = "Password not match";
                    request.setAttribute("passMatch_err", passMatchErr);
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }
                else{
                Connection  myCon = (Connection)getServletContext().getAttribute("dBConnection");
                    try {
                        PreparedStatement myPst = myCon.prepareStatement("INSERT INTO user VALUES(?, ?);");
                        myPst.setString(1,uname);
                        myPst.setString(2, pass);
                        
                        int i = myPst.executeUpdate();
                        if(i!=0){
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }else {
                            request.getRequestDispatcher("signup.jsp").forward(request, response);
                        }
                    }catch(IOException | SQLException | ServletException ex) {
                out.println("<p id=\"error\">");
                ex.printStackTrace(new java.io.PrintWriter(out));
                out.println("</div>");
            }
                }}
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
