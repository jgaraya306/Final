/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.CustomerData;
import Business.CustomerBusiness;
import Domain.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Allan
 */
@WebServlet(name = "CustomerLoginInfo", urlPatterns = {"/CustomerLoginInfo"})
public class CustomerLoginInfo extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CustomerLoginInfo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerLoginInfo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
       
        
        String[] login = new String[2];
        boolean exist = false;
        login[0] = username;
        login[1] = password;

        CustomerData c1 = new CustomerData();
        try {
            c1.userCustomerExist(login);
        } catch (ParseException ex) {
            Logger.getLogger(CustomerLoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            exist = c1.userCustomerExist(login);
        } catch (ParseException ex) {
            Logger.getLogger(CustomerLoginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (exist == true) {
            
            RequestDispatcher dispacher = request.getRequestDispatcher("customersOptions.jsp");
            request.setAttribute("username", username);
            dispacher.forward(request, response);
        } else {
            RequestDispatcher dispacher = request.getRequestDispatcher("loginCustomer.jsp");
            dispacher.forward(request, response);

        }

        RequestDispatcher dispacher = request.getRequestDispatcher("show_info_customer.jsp");
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
