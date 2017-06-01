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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Julio
 */
public class VehicleManagmentServlet extends HttpServlet {

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
            out.println("<title>Servlet VehicleManagmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleManagmentServlet at " + request.getContextPath() + "</h1>");
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

            try {
                String idCustomer = request.getParameter("idCustomer");

                vehicleBusiness.deleteCustomer(idCustomer);

                try {
                    request.setAttribute("vehicles", vehicleBusiness.getAllVehicles());
                } catch (java.text.ParseException ex) {
                    Logger.getLogger(VehicleManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_vehicles.jsp");
                dispatcher.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(VehicleManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action.equalsIgnoreCase("edit")) {

            String idCustomer = request.getParameter("idCustomer");
            Vehicle vehicle = new Vehicle();
            System.out.println("PERROOOOOOOOOOOOOOOO");
            try {
                vehicle = vehicleBusiness.getVehiclebyID(idCustomer);
            } catch (ParseException ex) {
                Logger.getLogger(VehicleManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            request.setAttribute("vehicle", vehicle);
            RequestDispatcher dispatcher = request.getRequestDispatcher("modify_vehicle.jsp");
            dispatcher.forward(request, response);
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
            String type = request.getParameter("type");//cambiar a checkbox
            String plate = request.getParameter("plate");
            String color = request.getParameter("color");
            String brand = request.getParameter("brand");
            String model = request.getParameter("model");
            String customerID = request.getParameter("customer");
            
            //  (String plate, String color, String brand, String model, Customer customer, VehicleType vehicleType
            Vehicle vehicle = new Vehicle(plate, color, brand, model, customerID, type);
            
            vehicleBusiness.modifyVehicle(customerID, vehicle);
            request.setAttribute("vehicles", vehicleBusiness.getAllVehicles());
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_vehicles.jsp");
            dispatcher.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(VehicleManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(VehicleManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
