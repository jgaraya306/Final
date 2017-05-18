/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.ParkingLotBusiness;
import Data.ParkingLotData;

import Domain.ParkingLot;
import Domain.Space;
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
 * @author Allan
 */
public class ParkingManagmentServlet extends HttpServlet {

    ParkingLotBusiness parkingLotBusiness;
    VehicleType vehicleType;

    @Override
    public void init()
            throws ServletException {

        parkingLotBusiness = new ParkingLotBusiness();
        vehicleType = new VehicleType();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ParkingManagmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ParkingManagmentServlet at " + request.getContextPath() + "</h1>");
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

            String parkingLotName = request.getParameter("parkingLotName");
            try {
                parkingLotBusiness.deleteParkingLots(parkingLotName);
                 request.setAttribute("parkingLots", parkingLotBusiness.getAllParkingLots());
            } catch (ParseException ex) {
                Logger.getLogger(ParkingManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
           

            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_parkingLots.jsp");
            dispatcher.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {

            String parkingLotName = request.getParameter("parkingLotName");
            ParkingLot parkingLot = new ParkingLot();
            try {
                parkingLot = parkingLotBusiness.getParkingLotByName(parkingLotName);
                
            } catch (ParseException ex) {
                Logger.getLogger(ParkingManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("parkingLot", parkingLot);
                RequestDispatcher dispatcher = request.getRequestDispatcher("modify_parkingLot.jsp");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
       
        String name = request.getParameter("name");
        int ID = Integer.parseInt(request.getParameter("ID"));

        //   String parkingNumberOfSpaces = request.getParameter("parkingNumberOfSpaces");
         // String name = request.getParameter("name");       
            //boolean isCeiling = request.getParameter("ceiling").equalsIgnoreCase("yes");
            int parkingNumberOfSpaces = Integer.parseInt(request.getParameter("numberOfSpaces"));
            int numberOfSpaces = Integer.parseInt(request.getParameter("spacesDisability"));
            int id = Integer.parseInt(request.getParameter("ID"));
            
            Space[] spaces = new Space[numberOfSpaces];
            
          // (int id, boolean disabilityAdaptation, boolean spaceTaken, VehicleType vehicleType)
          vehicleType.setDescription("Heavy");
          vehicleType.setFee((float) 2.4);
          vehicleType.setId(1);
          vehicleType.setNumberOfTires((byte)2);
           spaces[0]=new Space(1,true,false,vehicleType);
        // parkingLotBusiness.modifyParkingLot(name, parkingLot);
         ParkingLot parkingLot = new ParkingLot(id,name, parkingNumberOfSpaces,spaces,true);
        try {
            parkingLotBusiness.modifyParkingLot(name,parkingLot);
               request.setAttribute("parkingLots", parkingLotBusiness.getAllParkingLots());
        } catch (ParseException ex) {
            Logger.getLogger(ParkingManagmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     

        RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_parkingLots.jsp");
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
