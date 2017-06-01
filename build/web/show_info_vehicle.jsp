<%-- 
    Document   : show_info_customer
    Created on : 30/04/2017, 09:35:53 AM
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos insertados</title>
        <%
            
        String plate = request.getParameter("plate");
        String color = request.getParameter("color");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String customer = request.getParameter("customer");
        String description = request.getParameter("type");
        %>

    </head>
     <body background="imagenes/7.jpg">
        <h1>Sus datos ya han sido guardados:</h1>
        
        <br/>
        Placa:  <%=plate%> <br/><br/>
        Color: <%=color%><br/><br/>
        Marca <%=brand%><br/><br/>
        Modelo: <%=model%><br/><br/>
        Cliente: <%=customer%><br/><br/>
        Tipo de vehiculo: <%=description%><br/><br/>
           
        <hr/>
        <a href="ReservarEspacio.jsp">Reservar su espacio en el parqueo</a>
    </body>
    
</html>
