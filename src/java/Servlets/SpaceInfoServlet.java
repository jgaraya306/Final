/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.SpaceBussines;
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
@WebServlet(name = "SpaceInfoServlet", urlPatterns = {"/SpaceInfoServlet"})
public class SpaceInfoServlet extends HttpServlet {

    SpaceBussines spaceBussines = new SpaceBussines();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SpaceInfoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SpaceInfoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Boolean disabilityAdaptation = request.getParameter("disabilityAdaptation").equalsIgnoreCase("true");
        Boolean spaceTaken = request.getParameter("spaceTaken").equalsIgnoreCase("true");
        String description = request.getParameter("vehicleType");

        // Space space = new Space(id, disabilityAdaptation, spaceTaken, vt);
        Space space = new Space(1,1, true, true, null,1);
        spaceBussines.insertSpace(space);
        processRequest(request, response);
        RequestDispatcher dispacher = request.getRequestDispatcher("show_info_space.jsp");
        dispacher.forward(request, response);
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
