

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="imagenes/7.jpg">
        <form action="VehicleInfoServlet" method="get">
            <center>
            <h1>Ingrese los datos del vehículo para registrarlo en el parqueo</h1>
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
                    <td>Ingrese el id del cliente:</td>
                    <td><input type="text" name="idCustomer"></td>
                    <td><input type="text" name="reservarEspacio" value="no" hidden></td>
                </tr>
            </table>

            <br/>
            <input type="submit" value="Registrarse">
            <input type="submit" value="Cancelar">
            </center>
        </form>

    </body>
</html>