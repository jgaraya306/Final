/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.ParkingLotBusiness;
import Domain.ParkingLot;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
public class ParkingRetrievalServlet extends HttpServlet {

    ParkingLotBusiness parkingLotBusiness;
    LinkedList<ParkingLot> parkingLots;

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
            out.println("<title>Servlet ParkingRetrievalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkingRetrievalServlet at " + request.getContextPath() + "</h1>");
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
    public void init()
            throws ServletException {
        parkingLotBusiness = new ParkingLotBusiness();
        parkingLots = new LinkedList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            parkingLots = parkingLotBusiness.getAllParkingLots();
            String customerID = request.getParameter("idCustomer");
            System.out.println("El id del customer es: "+customerID);
            
            if (request.getParameter("reservarEspacio")!=null) {
                String vehicleType = request.getParameter("type");
                
                RequestDispatcher requestDispatcher
                        = request.getRequestDispatcher("parkingSelected.jsp");
                request.setAttribute("parkingLots", parkingLots);
                request.setAttribute("vehicleType", vehicleType);
                request.setAttribute("customerID", customerID);
                requestDispatcher.forward(request, response);
            }else{

            RequestDispatcher requestDispatcher
                    = request.getRequestDispatcher("show_all_parkingLots.jsp");

            request.setAttribute("parkingLots", parkingLots);
            requestDispatcher.forward(request, response);
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(ParkingRetrievalServlet.class.getName()).log(Level.SEVERE, null, ex);
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
