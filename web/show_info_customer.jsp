<%-- 
    Document   : show_info_customer
    Created on : 30/04/2017, 09:35:53 AM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos insertados</title>
        <%
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            String disability = request.getParameter("disabilityPresented");
            String goldenCiticen = request.getParameter("goldenCiticen");
        %>

    </head>
    <body background="imagenes/4.jpg">
    <center>
        <h1>Sus datos ya han sido guardados:</h1>

        <br/>
        Nombre:  <%=name%> <br/><br/>
        Dirección: <%=address%><br/><br/>
        Usuario: <%=username%><br/><br/>
        Password: <%=password%><br/><br/>
        Phone: <%=phone%><br/><br/>
        Mail: <%=mail%><br/><br/>
        Disability: <%=disability%><br/><br/>
        GoldenCiticen: <%=goldenCiticen%><br/><br/>       
        <hr/>
        <a href="ReservarEspacio.jsp">Reservar su espacio en el parqueo</a><br><br>
        <a href="index.html">Regresar a la pantalla de inicio</a>
    </center>
</body>

</html>
