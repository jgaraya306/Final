/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.SpaceBussines;
import Data.CustomerData;
import Data.SpaceData;
import Domain.Customer;
import Domain.Space;
import Domain.VehicleType;
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
@WebServlet(name = "SpaceRetrievalServlet", urlPatterns = {"/SpaceRetrievalServlet"})
public class SpaceRetrievalServlet extends HttpServlet {

    SpaceBussines spaceBussines;
    CustomerData customerData;
    SpaceData spaceData;
    LinkedList<Space> spaces;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SpaceRetrievalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SpaceRetrievalServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init()
            throws ServletException {
        spaceBussines = new SpaceBussines();
        spaceData = new SpaceData();
        spaces = new LinkedList<>();
        customerData = new CustomerData();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            String idParking = request.getParameter("idParking");
            String vehicleType = request.getParameter("vehicleType");
            String customerID = request.getParameter("customerID");

            Customer customer = customerData.getCustomerById(customerID);
            System.out.println("idCustomer----------- " + customer.getId());

            if (request.getParameter("rol") == null) { //Perspectiva del administrador
                spaces = spaceBussines.getAllSpaces(idParking);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("show_all_spaces.jsp");
                request.setAttribute("listaEspacios", spaces);

                requestDispatcher.forward(request, response);

            } else {// perspectiva del usuario
                if (customer.isDisabilityPresented() || customer.isGoldenCiticen()) {
                    spaces = spaceData.getSpacesOfType(idParking, vehicleType);
                    if (spaces.size() == 0) {
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("NoSpacesDisponible.jsp");
                        requestDispatcher.forward(request, response);
                    }
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("spaceSelected.jsp");
                    request.setAttribute("listaEspacios", spaces);
                    request.setAttribute("customerID", customerID);
                    request.setAttribute("vehicleType", vehicleType);
                    requestDispatcher.forward(request, response);
                } else {
                    spaces = spaceData.getSpacesOfTypeForNoPreference(idParking, vehicleType);
                    if (spaces.size() == 0) {
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("NoSpacesDisponible.jsp");
                        requestDispatcher.forward(request, response);
                    }
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("spaceSelected.jsp");
                    request.setAttribute("listaEspacios", spaces);
                    request.setAttribute("customerID", customerID);
                    request.setAttribute("vehicleType", vehicleType);
                    requestDispatcher.forward(request, response);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(SpaceRetrievalServlet.class.getName()).log(Level.SEVERE, null, ex);
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
