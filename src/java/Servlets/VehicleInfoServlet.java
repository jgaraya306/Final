/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.VehicleBusiness;
import Domain.Customer;
import Domain.Vehicle;
import Domain.VehicleType;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio
 */
@WebServlet(name = "VehicleInfoServlet", urlPatterns = {"/VehicleInfoServlet"})
public class VehicleInfoServlet extends HttpServlet {

    VehicleBusiness vehicleBusiness;
    VehicleType vehicleType;
    Customer customer;

    @Override
    public void init()
            throws ServletException {

        vehicleBusiness = new VehicleBusiness();
        vehicleType = new VehicleType();
        customer = new Customer();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VehicleInfoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleInfoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");//cambiar a checkbox
        String plate = request.getParameter("plate");
        String color = request.getParameter("color");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String customerID = request.getParameter("idCustomer");


        Vehicle vehicle = new Vehicle(plate, color, brand, model, customerID, type);
        vehicleBusiness.insertVehicle(vehicle);

        if (request.getParameter("reservarEspacio").equals("yes")) {
            RequestDispatcher dispacher = request.getRequestDispatcher("ParkingRetrievalServlet");
            dispacher.forward(request, response);
        } else {

            RequestDispatcher dispacher = request.getRequestDispatcher("VehicleRetrievalServlet");
            dispacher.forward(request, response);
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
