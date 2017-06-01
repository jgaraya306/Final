<%-- 
    Document   : modify_customer
    Created on : May 12, 2017, 4:54:16 PM
    Author     : Allan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html Lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar vehículo</title>

    </head>
    <body background="imagenes/7.jpg">
        
           
           
        
    <center>
        <i><b><font color="black" size="8">Modificación de Vehículos del Sistema </font></b></i>
        <form name="modifyVehicleForm" action="VehicleManagmentServlet.do" method="post">

            <table>
                <tr><h1>  Formulario de modificación de vehículo </h1></tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Tipo: </label> </b></font></td> 
                    <td><input type="text" name="type" size="30" value="${vehicle.vehicleType}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Placa: </label> </b></font></td>       
                    <td><input type="text" name="plate" size="30" value="${vehicle.plate}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Color: </label> </b></font></td> 
                    <td><input type="text" name="color" size="30" value="${vehicle.color}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Marca: </label> </b></font></td> 
                    <td><input type="text" name="brand" size="30" value="${vehicle.brand}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Modelo: </label> </b></font></td> 
                    <td><input type="text" name="model" size="30" value="${vehicle.model}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Id del cliente: </label> </b></font> </td>
                    <td><input type="text" name="customer" size="30" value="${vehicle.idCustomer}"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Modificar vehiculo"/></td>
                    <td><input type="reset" value="Cancelar" /></td>
                </tr>

            </table>

        </form>
        <br><br><br><font size="6"> <a href="VehicleRetrievalServlet" style="color:#A4A4A4">Ir a la tabla de vehículos</a></font>

        <br><br><font size="6"> <a href="index.html"style="color:#A4A4A4" >Volver al menu principal</a></font>
    </center>



</body>
</html>
