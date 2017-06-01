/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.CustomerData;
import Data.SpaceData;
import Domain.Space;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
 * @author Julio
 */
@WebServlet(name = "RetireVehicleServlet", urlPatterns = {"/RetireVehicleServlet"})
public class RetireVehicleServlet extends HttpServlet {

    SpaceData spaceData;
    CustomerData customerData;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RetireVehicleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RetireVehicleServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init()
            throws ServletException {
        customerData = new CustomerData();
        spaceData = new SpaceData();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("showVehiclesOfUser")) {

                String customerUsername = request.getParameter("customerUsername");
                int idCustomer = customerData.getCustomerByUsername(customerUsername).getId();

                LinkedList spaces = spaceData.getSpacesForIdCustomer("" + idCustomer);
                System.out.println("spaces  " + spaces);

                RequestDispatcher dispatcher = request.getRequestDispatcher("CarsOfUserInParking.jsp");
                request.setAttribute("listaEspacios", spaces);
                request.setAttribute("idCustomer", idCustomer);
                dispatcher.forward(request, response);
            }else{
                int idSpace = Integer.parseInt(request.getParameter("id"));
                int idParking = Integer.parseInt(request.getParameter("idParking"));
                Space space = spaceData.getSpaceById(""+idSpace, ""+idParking);
                space.setSpaceTaken(false);
                space.setIdCustomer(0);
                spaceData.modifySpaceFromFile(idParking, idSpace, space);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("spaceEmpty.jsp");
                dispatcher.forward(request, response);
                
            }
        } catch (ParseException ex) {
            Logger.getLogger(RetireVehicleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
