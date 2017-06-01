<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="fnt" uri="http://java.sun.com/jstl/fmt_rt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar espacio</title>

    </head>
     <body background="imagenes/7.jpg">

    <center>
        <i>
           <b><font color="black" size="8">Modificar spacio</font></b>
           
        </i>
        <form name="modifyAdminForm" action="SpaceManagementServlet.do" method="post">

            <table>
                <tr><h2>Editar espacios del parqueo creado</h2></tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Id del parqueo: </label> </b></font> </td>
                    <td><input type="text" name="idParking" size="30" value="${space.idParking}"></td>
                </tr>            

                <tr>
                    <td><font size="5" color="black"><b> <label>Id del espacio: </label> </b></font> </td>
                    <td><input type="text" name="id" size="30" value="${space.id}"></td>
                </tr>
                <tr>
                    <td><font size="5" color="black"><b> <label>Espacio preferencial: </label> </b></font></td>
                    <td><input type="text" name="disabilityAdaptation" size="30" value="${space.disabilityAdaptation}"></td>             
                </tr>
                <tr>
                    <td><font size="5" color="black"><b> <label>Espacio ocupado: </label> </b></font></td> 
                    <td><input type="text" name="spaceTaken" size="30" value="${space.spaceTaken}"></td>
                </tr>

                <tr>
                    <td><font size="5" color="black"><b> <label>Tipo de vehiculo: </label> </b></font></td>
                    <td><input type="text" name="vehicleType" size="30" value="${space.vehicleType}"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Modificar espacio"/></td>
                    <td><input type="reset" value="Cancelar" /></td>         
                </tr>
            </table>
        </form>
    </center>

</body>
</html>