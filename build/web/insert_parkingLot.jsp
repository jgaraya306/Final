<%-- 
    Document   : CrearParqueo
    Created on : 29-abr-2017, 15:37:21
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <center>
        <body background="imagenes/7.jpg">

            <form action="ParkingInfoServlet" method="get">
                <h1>A continuacion configure los espacios del parqueo</h1>

                <h2>Datos del parqueo:</h2>
                <table>
                    <tr>
                        <td>identificacion:</td>
                        <td><input type="text" name="id" size="30"></td>
                    </tr>

                    <tr>
                        <td>nombre:</td>
                        <td><input type="text" name="name" size="30"></td>
                    </tr>

                    <tr>
                        <td>numero de espacios:</td>
                        <td><input type="text" name="numberOfSpaces" size="30"></td>    
                    </tr>

                    <tr>
                        <td>numero de espacios para personas con discapacidad: </td>
                        <td><input type="text" name="spacesDisability" size="30"><td>
                    </tr>

                    <tr>
                        <td>Tiene techo el parqueo?</td>
                        <td><input type="text" name="cieling" size="30"><td> 
                    </tr>

                </table>
                <input type="submit" value="Registrarse">
                <input type="submit" value="Cancelar">
            </form>
        </body>
    </center>
</html>
