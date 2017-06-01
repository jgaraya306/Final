<%-- 
    Document   : show_info_tariff
    Created on : 20-may-2017, 10:24:14
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos insertados</title>
        <%
            String priceHalfHour = request.getParameter("priceHalfHour");
            String priceOneHour = request.getParameter("priceOneHour");
            String pricePerDay = request.getParameter("pricePerDay");
            String pricePerWeek = request.getParameter("pricePerWeek");
            String pricePerMonth = request.getParameter("pricePerMonth");
            String pricePerYear = request.getParameter("pricePerYear");
            String vehicleTypeS = request.getParameter("vehicleType");
        %>

    </head>
  <body background="imagenes/7.jpg">
    <center>
        <h1>Sus datos ya han sido guardados:</h1>

        <br/>

        Tipo de vehículo: <%=vehicleTypeS%><br/><br/>    
        Precio por media hora:  <%=priceHalfHour%> <br/><br/>
        Precio por hora: <%=priceOneHour%><br/><br/>
        Precio por dia: <%=pricePerDay%><br/><br/>
        Precio por semana: <%=pricePerWeek%><br/><br/>
        Precio por mes: <%=pricePerMonth%><br/><br/>
        Precio por año: <%=pricePerYear%><br/><br/>

        <hr/>
        <a href="index.html">Regresar a la pantalla de inicio</a>
    </center>
</body>

</html>
