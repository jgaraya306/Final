<%-- 
    Document   : Administrador
    Created on : 29-abr-2017, 13:04:11
    Author     : Allan
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
        <p>
        <h1> Ventana de administrador</h1>
    </p>
    <h2> Seleccione la acción que desea ejecutar. </h2>
    <h3> Opciones para vehiculo </h3>
        <a href="ReservarEspacio.jsp">Ingresar vehiculo</a><br><br/>  
        <a href="ReservarEspacio.jsp">Modificar vehiculo</a><br><br/>    
        <a href="ReservarEspacio.jsp">Suprimir  vehiculo </a> <br><br/>
    
    <h3> Opciones para cliente </h3>
        <a href="RegistrationWindow.jsp">Ingresar cliente</a><br><br/>    
        <a href="CustomerRetrievalServlet">Consultar clientes</a><br><br/>
        
    <h3> Opciones para trabajadores </h3>
        <a href="ClerkRetrievalServlet">Todos los trabajadores</a><br><br/>  
        <a href="RegistrationWindowClerk.jsp">Registrar nuevo trabajador</a><br><br/>  
    
    <h3> Opciones para las reservaciones </h3>
        <a href="ReservarEspacio.jsp">Consultar reservaciones</a><br><br/>
        <a href="ReservarEspacio.jsp">Rechazar reseravaciones</a><br><br/>
    
    <h3> Opciones de faturación </h3>
    <a href="ReservarEspacio.jsp">Cobrar servicio</a><br><br/> 
    <a href="ReservarEspacio.jsp">Emitir factura</a><br><br/>
    
    <h3> Opciones para el parqueo </h3>
    <a href="CrearParqueo.jsp">Ingresar parqueo</a><br><br/>   
    <a href="ParkingRetrievalServlet">Consultar parqueos</a><br><br/>
     
    <h3> Opciones para los espacios del parqueo </h3>
        <a href="insert_parkingLot.jsp">Ingresar un parqueo</a><br><br/>
        <a href="ParkingRetrievalServlet">Consultar parqueos</a><br><br/>   

      
    <h3> Opciones para los roles de usuario  </h3>
        <a href="ReservarEspacio.jsp">Ingresar rol</a><br><br/> 
        <a href="ReservarEspacio.jsp">Modificar rol</a><br><br/>   
        <a href="ReservarEspacio.jsp">Suprimir  rol</a> <br><br/>
      
    <h3>Opciones para los precios segun el vehiculo  </h3>
        <a href="ReservarEspacio.jsp">Ingresar tarifa</a><br><br/>
        <a href="ReservarEspacio.jsp">Modificar tarifa</a> <br><br/>
        <a href="ReservarEspacio.jsp">Consultar tarifa</a><br><br/> 
        <a href="ReservarEspacio.jsp">Eliminar tarifa</a><br><br/>
    
    <br><br><hr/>
    <a href="index.html">Regresar a la pantalla de inicio</a>
    <center>
        </body>
        </html>
