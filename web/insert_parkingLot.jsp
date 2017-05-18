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
    <body>
        <form action="ParkingInfoServlet" method="get">
            <h1>A continuacion podra crear los parqueos que desee</h1>

                <h2>Datos del parqueo:</h2>
                <table>
                    <tr>
                        <td>identificacion:</td>
                        <td>
                    <input type="text" name="ID" size="30">
                    </td>
                    </tr>
                    <tr>
                        <td>nombre:</td>
                        <td>
                         <input type="text" name="name" size="30">
                        </td>
                    </tr>
                    <tr>
                        <td>numero de espacios:</td>
                       <td>    
                    <input type="text" name="numberOfSpaces" size="30">
                     </td>
                    </tr>
                    <tr>
                        <td>numero de espacios para personas con discapacidad: </td>
                     <td>   
                    <input type="text" name="spacesDisability" size="30">
                     <td> 
                    </tr>
                    <tr>
                    <br>
                    <br/>
                    <tr>
                          <tr>
                        <td>Tiene techo el parqueo?</td>
                         <td> 
                       <input type="text" name="cieling" size="30">
                        <td> 
                    </tr>
                    
                        <td><h3> Seleccione la cantidad de vehiculos segun la categoria</h3></td>
                    </tr>
                    <td>motocicleta:</td>
                     <td>  
                    <input type="text" name="motorcycle" size="30">
                     </td> 
                    </tr>
                    <tr>
                        <td>vehiculo pesado:</td>
                     <td>    
                    <input type="text" name="heavyVehicle" size="30">
                    </td> 
                     <td> 
                    </tr>
                    <tr>
                        <td> vehiculo liviano:</td>
                     <td>    
                    <input type="text" name="vehicle" size="30">
                    </td>
                    </tr>
                    
                        <td>bicicleta:</td>
                        <td>
                        <input type="text" name="bicycle" size="30">
                        </td> 
                    </tr>
                    
                    <tr>
                </table>
                <br/>
                <input type="submit" value="Registrarse">
            <input type="submit" value="Cancelar">
                </body>
                </html>
