/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.TariffBusiness;
import Domain.Tariff;
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
@WebServlet(name = "TarifaInfoServlet", urlPatterns = {"/TarifaInfoServlet"})
public class TarifaInfoServlet extends HttpServlet {

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
            out.println("<title>Servlet TarifaInfoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TarifaInfoServlet at " + request.getContextPath() + "</h1>");
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
        
        float priceHalfHour = Float.parseFloat(request.getParameter("priceHalfHour"));
        float priceOneHour = Float.parseFloat(request.getParameter("priceOneHour"));
        float pricePerDay = Float.parseFloat(request.getParameter("pricePerDay"));
        int id = Integer.parseInt(request.getParameter("id"));
        float pricePerWeek = Float.parseFloat(request.getParameter("pricePerWeek"));
        float pricePerMonth = Float.parseFloat(request.getParameter("pricePerMonth"));
        float pricePerYear = Float.parseFloat(request.getParameter("pricePerYear"));
        String descripcion = request.getParameter("vehicleType");
   
        Tariff tariff = new Tariff(id, priceHalfHour, priceOneHour, pricePerDay,
                pricePerWeek, pricePerMonth, pricePerYear, descripcion);
        
        TariffBusiness tariffBusiness = new TariffBusiness();
        tariffBusiness.insertTariff(tariff);

        RequestDispatcher dispacher = request.getRequestDispatcher("TarifaRetrievalServlet");
        dispacher.forward(request, response);
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
     * @return a s containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
