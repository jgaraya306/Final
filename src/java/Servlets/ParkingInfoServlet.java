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
@WebServlet(name = "ParkingInfoServlet", urlPatterns = {"/ParkingInfoServlet"})
public class ParkingInfoServlet extends HttpServlet {
    VehicleType vehicleType;
    
  
    @Override
    public void init(){
        vehicleType=new VehicleType();
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
          
            ParkingLotData parkingLotData = new ParkingLotData();
            
            ParkingLot parkingLot = new ParkingLot(id,name, parkingNumberOfSpaces,spaces,true);
            
           ParkingLotBusiness parkingLotBusiness =new ParkingLotBusiness();
           parkingLotBusiness.insertParkingLot(parkingLot);
           
            parkingLotData.registerParkingLot(name,spaces);
           RequestDispatcher dispacher = request.getRequestDispatcher("show_info_parkingLot.jsp");
            dispacher.forward(request, response);
            //llenar arreglo de spaces con los vehiculos que se registren
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
