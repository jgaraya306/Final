<%-- 
    Document   : ReservarEspacio
    Created on : 29/04/2017, 11:37:33 AM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="imagenes/4.jpg">
        <center>
        <form action="CustomerInfoServlet" method="get">
            <h1>A continuacion ingrese los datos solicitados para reservar un espacio en el parqueo</h1>

            <h2>Datos Personales:</h2>
            <table>
                <tr>
                    <td>Ingrese su identification:</td>
                    <td><input type="text"name="identification:"></input></td>

            </table>

            <h2>Datos de su vehiculo</h2>
            <table>
                <tr>
                    <td>Placa:</td>
                    <td><input type="text"></input></td>
                </tr>
                <tr>
                    <td>Color:</td>
                    <td><input type="text"></input></td>
                </tr>
                <tr>
                    <td>Marca:</td>
                    <td><input type="text"></input></td>
                </tr>
                <tr>
                    <td>Modelo:</td>
                    <td><input type="password"></input></td>
                </tr>
                <tr>
                    <td>Desea un parqueo bajo techo:</td>
                    <td><input name="parqueoBajoTecho" type="text">(Yes or Not)</input></td>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Continuar">
        </form>
        <br><br>
        <a href="index.html">Regresar a la pantalla de inicio</a>
        </center>
    </body>
</html>
