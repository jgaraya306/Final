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
    <body   <body background="imagenes/7.jpg">

    <center>
        <i>
            <b><font color="black" size="8">Modificar el Parqueo</font></b>
         
        </i>
        <form name="modifyParkingLotForm" action="ParkingManagmentServlet.do" method="post">

            <table>
                <tr><h2>  Formulario de modificación de parqueo </h2></tr>

                <tr>
                    <td><input hidden type="text" name="name" size="30" value="${parkingLot.name}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Id: </label> </b></font></td> 
                    <td><input type="text" name="ID" size="30" value="${parkingLot.id}"></td>  
                </tr>
                
                <tr>
                    <td><font size="5" color="black"><b> <label>Nombre: </label> </b></font></td> 
                    <td><input type="text" name="name" size="30" value="${parkingLot.name}"></td>  
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>techo: </label> </b></font></td> 
                    <td><input type="text" name="ceiling" size="30" value="${parkingLot.ceiling}"></td>  
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Numero de espacios: </label> </b></font></td>
                    <td><input type="text" name="numberOfSpaces" size="30" value="${parkingLot.numberOfSpaces}"></td>             
                </tr>

                <tr>
                    <td><input type="submit" value="Modificar parqueo"/></td>
                    <td><input type="reset" value="Cancelar" /></td>         
                </tr>

            </table>
        </form>
    </center>

</body>
</html>