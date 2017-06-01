/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Business.SpaceBussines;
import Domain.Space;
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
 * @author Julio
 */
public class SpaceManagementServlet extends HttpServlet {

    SpaceBussines spaceBussines;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SpaceManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SpaceManagementServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init()
            throws ServletException {
        spaceBussines = new SpaceBussines();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            try {
                String spaceID = request.getParameter("id");
                String idParking = request.getParameter("idParking");

                spaceBussines.deleteSpace(spaceID, idParking);
                

                request.setAttribute("listaEspacios", spaceBussines.getAllSpaces(idParking));

                RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_spaces.jsp");
                dispatcher.forward(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(SpaceManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (action.equalsIgnoreCase("edit")) {
            String spaceID = request.getParameter("id");
            String spaceIdParking = request.getParameter("idParking");
            Space space = new Space();
            try {
                space = spaceBussines.getSpaceByID(spaceID, spaceIdParking);
            } catch (ParseException ex) {
                Logger.getLogger(SpaceManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("space", space);
            RequestDispatcher dispatcher = request.getRequestDispatcher("modify_spaces.jsp");
            dispatcher.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(request.getParameter("id"));
            int idParking = Integer.parseInt(request.getParameter("idParking"));
            String vehicleType = request.getParameter("vehicleType");
            boolean disabilityAdaptation = request.getParameter("disabilityAdaptation").equalsIgnoreCase("true");
            boolean spaceTaken = request.getParameter("spaceTaken").equalsIgnoreCase("true");
            int idCustomer = 0;
            if(request.getParameter("idCustomer")!=null){
                idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
            }

            Space space = new Space(idParking, id, disabilityAdaptation, spaceTaken, vehicleType,idCustomer);
            spaceBussines.modifySpace(idParking, id, space);
            request.setAttribute("listaEspacios", spaceBussines.getAllSpaces(""+idParking));

            RequestDispatcher dispatcher = request.getRequestDispatcher("show_all_spaces.jsp");
            dispatcher.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SpaceManagementServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
