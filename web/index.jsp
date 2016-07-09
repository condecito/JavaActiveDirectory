<%-- 
    Document   : index
    Created on : 07-09-2016, 09:22:41 AM
    Author     : Edwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String mensaje=request.getParameter("msj");
mensaje=mensaje==null?"":mensaje;

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <form action="principal.jsp" method="post">
        <div align="center" >
            <p><label>Usuario</label><input type="text" name="usuario" required="true"></p>
            <p><label> contrasena</label><input type="password" name="contrasena" required="true"></p>
            <input type="submit" value="enviar">
            <p><%=mensaje %></p>
        </div>
            </form>
    </body>
</html>
