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
public class TarifaManagementServlet extends HttpServlet {

    TariffBusiness tariffBusiness;

    @Override
    public void init()
            throws ServletException {

        tariffBusiness = new TariffBusiness();

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TariffManagmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TariffManagmentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {

            String id = request.getParameter("id");
            try {
                tariffBusiness.deleteTariff(Integer.parseInt(id));
                request.setAttribute("tariffs", tariffBusiness.getAllTariff());
            } catch (ParseException ex) {
                Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.text.ParseException ex) {
                Logger.getLogger(TarifaManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_tariffs.jsp");
            dispatcher.forward(request, response);

        } else if (action.equalsIgnoreCase("edit")) {

            String id = request.getParameter("id");
            Tariff tariff = new Tariff();
            try {
                tariff = tariffBusiness.getTariffById(Integer.parseInt(id));
                request.setAttribute("tariff", tariff);
                RequestDispatcher dispatcher = request.getRequestDispatcher("modify_tariff.jsp");
                dispatcher.forward(request, response);

            } catch (ParseException ex) {
                Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (java.text.ParseException ex) {
                Logger.getLogger(TarifaManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        String vehicleType = request.getParameter("vehicleType");

        Tariff tariff = new Tariff(id, priceHalfHour, priceOneHour, pricePerDay,
                pricePerWeek, pricePerMonth, pricePerYear, vehicleType);


        try {
            tariffBusiness.modifyTariff(id, tariff);
            request.setAttribute("tariffs", tariffBusiness.getAllTariff());

        } catch (ParseException ex) {
            Logger.getLogger(CustomerManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(TarifaManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_tariffs.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
