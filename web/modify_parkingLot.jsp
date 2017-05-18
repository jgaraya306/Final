<%-- 
    Document   : modify_customer
    Created on : May 1, 2017, 4:54:16 PM
    Author     : Allan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar parqueo</title>

    </head>
    <body background="Images/background-image.gif">
        <i>
            <marquee  <b><font color="lightgreen" size="8">Modificación de Clientes del Sistema </font></b>
            </marquee>
        </i>
    <center>

        <form name="modifyParkingLotForm" action="ParkingManagmentServlet.do" method="post">

            <table>
                <tr><h2>  Formulario de modificación de parqueo </h2></tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Nombre: </label> </b></font> </td>
                    <td><input type="text" name="name" size="30" value="${parkingLot.name}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Id: </label> </b></font></td> 
                    <td><input type="text" name="ID" size="30" value="${parkingLot.ID}"></td>  
                </tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Numero de espacios: </label> </b></font></td>
                    <td><input type="text" name="numberOfSpaces" size="30" value="${parkingLot.numberOfSpaces}"></td>             
                </tr>
                <%-- <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Dirección: </label> </b></font></td>
                    <td><input type="text" name="address" size="30" value="${parkingLot.n}"></td>             
                </tr>
                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Username: </label> </b></font></td> 
                    <td><input type="text" name="username" size="30" value="${customer.username}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="lightgreen"><b> <label>Password: </label> </b></font></td>
                    <td><input type="text" name="password" size="30" value="${customer.password}"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Modificar cliente"/></td>
                    <td><input type="reset" value="Cancelar" /></td>         
               --%> </tr>
            </table>
        </form>
    </center>

</body>
</html>