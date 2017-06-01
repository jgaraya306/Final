/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.VehicleBusiness;
import Domain.Vehicle;
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
@WebServlet(name = "VehicleRetrievalServlet", urlPatterns = {"/VehicleRetrievalServlet"})
public class VehicleRetrievalServlet extends HttpServlet {

    LinkedList<Vehicle> vehicles;
    VehicleBusiness vehicleBusiness;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VehicleRetrievalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VehicleRetrievalServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init() throws ServletException {
        vehicleBusiness = new VehicleBusiness();
        vehicles = new LinkedList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try {
            vehicles = vehicleBusiness.getAllVehicles();
        } catch (ParseException ex) {
            Logger.getLogger(VehicleRetrievalServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(VehicleRetrievalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(request.getParameter("rol")!=null){//dependiente
            RequestDispatcher resquestDispacher = request.getRequestDispatcher("show_all_vehiclesB.jsp");
            request.setAttribute("vehicles", vehicles);
            resquestDispacher.forward(request, response);
        }else{
        RequestDispatcher resquestDispacher = request.getRequestDispatcher("show_all_vehicles.jsp");
        //disparo l tabla para que el usuario vea los customers, indica el camino que a donde
        //persona con la idea del mandado request
        request.setAttribute("vehicles", vehicles);
        //chico con el manddo, que llevo
        resquestDispacher.forward(request, response);
        //vayase y traigame respuesta de como le fue
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
