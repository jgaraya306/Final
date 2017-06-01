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
     <body background="imagenes/7.jpg">
    <center>
        <form action="VehicleInfoServlet" method="get">
            <h1>A continuacion ingrese los datos solicitados para registrar su vehiculo</h1>

            <h2>Datos Personales:</h2>
            <table>

                <tr>
                    <td>Ingrese el tipo de vehículo(pesado,liviano,bicicleta,motocicleta):</td>
                    <td><input type="text" name="type"></td>
                </tr>

                <tr>
                    <td>Ingrese la placa del vehículo:</td>
                    <td><input type="text" name="plate"></td>
                </tr>

                <tr>
                    <td>Ingrese el color de su vehículo: </td>
                    <td><input type="text" name="color"></td>
                </tr>

                <tr>
                    <td>Ingrese la marca de su vehículo:</td>
                    <td><input type="text" name="brand"></td>
                </tr>

                <tr>
                    <td>Ingrese el modelo del vehículo:</td>
                    <td><input type="text" name="model"></td>
                </tr>

                <tr>
                    <td>Ingrese su identification:</td>
                    <td><input type="text" name="idCustomer"></td>
                    <td><input type="text" name="reservarEspacio" value="yes" hidden></td>
                </tr>
            </table>

            <br/><input type="submit" value="Registrar vehiculo">
            <br/><input type="submit" value="Cancelar">
        </form>
        <br><br>
        <a href="index.html">Regresar a la pantalla de inicio</a>
    </center>
</body>
</html>
