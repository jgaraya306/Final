/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.AdminBussines;
import Domain.Administrator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
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
 * @author juang
 */
@WebServlet(name = "AdminManagmentServlet", urlPatterns = {"/AdminManagmentServlet"})
public class AdminManagmentServlet extends HttpServlet {

    AdminBussines adminBussines;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        adminBussines = new AdminBussines();
    }

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminManagmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminManagmentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {

            String adminUsername = request.getParameter("adminUsername");
            try {
                adminBussines.deleteAdmin(adminUsername);
                request.setAttribute("admins", adminBussines.getAllAdmins());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("show_all_admins.jsp");
                requestDispatcher.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(AdminManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action.equalsIgnoreCase("edit")) {
            try {
                String adminUsername = request.getParameter("adminUsername");
                Administrator administrator = new Administrator();
                administrator = adminBussines.getAdministratorByUsername(adminUsername);
                request.setAttribute("admin", administrator);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("modify_administrator.jsp");//muestra cliente en el formulario
                requestDispatcher.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(AdminManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
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
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            Administrator administrator = new Administrator();
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String identification = request.getParameter("id");
//        Date date = null;
//        HashMap schedule = null;
            administrator = new Administrator(identification, name, username, password, address);
            adminBussines.modifyAdmin(username, administrator);
            request.setAttribute("admins", adminBussines.getAllAdmins());
        } catch (ParseException ex) {
            Logger.getLogger(AdminManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_adminis.jsp");
        dispatcher.forward(request, response);
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
