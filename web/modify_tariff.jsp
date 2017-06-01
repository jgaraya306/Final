<%-- 
    Document   : modify_tariff
    Created on : 20-may-2017, 10:37:43
    Author     : Allan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar cliente</title>

    </head>
  <body background="imagenes/7.jpg">

    <center>
        <i>
           <b><font color="black" size="8">Modificación de Clientes del Sistema </font></b>
      
        </i>
        <form name="modifyCustomerForm" action="TarifaManagementServlet.do" method="post">

            <table>
                <tr><h2>  Formulario de modificación de tarifas </h2></tr>
                
                <tr>
                    <td><input hidden type="text" name="id" size="30" value="${tariff.id}"></td>
                </tr>
                
                <tr>
                    <td><font size="5" color="black"><b> <label>Tipo de vehiculo </label> </b></font> </td>
                    <td><input type="text" name="vehicleType" size="30" value="${tariff.vehicleType}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Tarifa media hora: </label> </b></font></td> 
                    <td><input type="text" name="priceHalfHour" size="30" value="${tariff.priceHalfHour}"></td>  
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Tarifa por hora: </label> </b></font></td>
                    <td><input type="text" name="priceOneHour" size="30" value="${tariff.priceOneHour}"></td>             
                </tr>
                <tr>
                    <td><font size="5" color="black"><b> <label>Tarifa por dia: </label> </b></font></td>
                    <td><input type="text" name="pricePerDay" size="30" value="${tariff.pricePerDay}"></td>             
                </tr>
                <tr>
                    <td><font size="5" color="black"><b> <label>Tarifa por semana </label> </b></font></td> 
                    <td><input type="text" name="pricePerWeek" size="30" value="${tariff.pricePerWeek}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Tarifa por mes: </label> </b></font></td>
                    <td><input type="text" name="pricePerMonth" size="30" value="${tariff.pricePerMonth}"></td>
                </tr>
                 <tr>
                    <td><font size="5" color="black"><b> <label>Tarifa por año: </label> </b></font></td>
                    <td><input type="text" name="pricePerYear" size="30" value="${tariff.pricePerYear}"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Modificar tarifa"/></td>
                    <td><input type="reset" value="Cancelar" /></td>         
                </tr>
            </table>
        </form>
    </center>

</body>
</html>
