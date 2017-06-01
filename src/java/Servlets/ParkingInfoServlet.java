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
@WebServlet(name = "ParkingInfoServlet", urlPatterns = {"/ParkingInfoServlet"})
public class ParkingInfoServlet extends HttpServlet {

    VehicleType vehicleType;
    ParkingLotData parkingLotData;
    ParkingLot parkingLot;
    ParkingLotBusiness parkingLotBusiness;
    LinkedList spaces;

    @Override
    public void init() {
        vehicleType = new VehicleType();
        parkingLotData = new ParkingLotData();
        parkingLotBusiness = new ParkingLotBusiness();
        spaces = new LinkedList();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        int numberOfSpaces = Integer.parseInt(request.getParameter("numberOfSpaces"));
        int spacesDisability = Integer.parseInt(request.getParameter("spacesDisability"));
        int id = Integer.parseInt(request.getParameter("id"));
        boolean cieling = (request.getParameter("cieling").equalsIgnoreCase("Yes"));
        
        spaces = parkingLotBusiness.createSpaces(id, numberOfSpaces, spacesDisability);


        parkingLot = new ParkingLot(id, name, numberOfSpaces, spaces, cieling);
        parkingLotBusiness.insertParkingLot(parkingLot);

        
        
        RequestDispatcher requestDispatcher
                = request.getRequestDispatcher("insertSpace.jsp");
        
        request.setAttribute("listaEspacios", spaces);

        parkingLotData.registerParkingLot(name, spaces);
        
        requestDispatcher.forward(request, response);

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
