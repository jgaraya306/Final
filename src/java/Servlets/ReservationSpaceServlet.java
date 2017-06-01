/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.SpaceBussines;
import Data.SpaceData;
import Domain.Space;
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
 * @author Julio
 */
@WebServlet(name = "ReservationSpaceServlet", urlPatterns = {"/ReservationSpaceServlet"})
public class ReservationSpaceServlet extends HttpServlet {

    SpaceBussines spaceBussines;
    SpaceData spaceData;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReservationSpaceServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReservationSpaceServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init()
            throws ServletException {
        spaceBussines = new SpaceBussines();
        spaceData = new SpaceData();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int idParking = Integer.parseInt(request.getParameter("idParking"));
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        
        String vehicleType = request.getParameter("vehicleType");
        String action = request.getParameter("action");

        Space space = new Space();

        try {
            space = spaceData.getSpaceById("" + id, "" + idParking);
            if (action.equals("reservation")) {
                space.setSpaceTaken(true);
                space.setIdCustomer(idCustomer);
                
            } else {
                space.setSpaceTaken(false);
                space.setIdCustomer(0);
            }

            spaceBussines.modifySpace(idParking, id, space);
            request.setAttribute("listaEspacios", spaceData.getSpacesOfType("" + idParking, vehicleType));
            request.setAttribute("vehicleType", vehicleType);
            if (!action.equalsIgnoreCase("cancelReservation")) {
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("spaceReserved.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("spaceSelected.jsp");
                dispatcher.forward(request, response);
            }

        } catch (ParseException ex) {
            Logger.getLogger(ReservationSpaceServlet.class.getName()).log(Level.SEVERE, null, ex);
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
