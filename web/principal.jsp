<%-- 
    Document   : principal
    Created on : 07-09-2016, 09:48:48 AM
    Author     : Edwin
--%>

<%@page import="activeDirectory.security.seguridadActiveDirectory"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String usuario = request.getParameter("usuario");
    String pass = request.getParameter("contrasena");
    String dominio = request.getParameter("dominio");
    usuario = usuario == null ? "" : usuario;
    pass = pass == null ? "" : pass;
    dominio = dominio == null ? getServletContext().getInitParameter("dominio") : dominio;
    if (!usuario.equals("") && !pass.equals("")) {
        seguridadActiveDirectory AcDirectory = new seguridadActiveDirectory();
        String servidor = getServletContext().getInitParameter("servidor");
        String dn = usuario.toUpperCase()+"@"+dominio; //"CN=Person,CN=Schema,CN=Configuration,DC="+dominio+",DC=HN";//dominio + "\\" + usuario;//se construlle con el dominio\\usuario CN=Person,CN=Schema,CN=Configuration,DC=PATH-II,DC=HN
        String tipoAutenticacion = getServletContext().getInitParameter("tipoAutenticacion");
        AcDirectory.autenticarUsuario(usuario, pass, servidor, dn, tipoAutenticacion);
        if (AcDirectory.isAtenticado()) {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <div>SI ESTAS AQUI ES POR QUE ESTAS EN EL Active Directory <%= usuario %></div>
    </body>
</html>

<%
        } else {
            response.sendRedirect("index.jsp?msj=" + AcDirectory.getMensajeError());
        }
    } else {
        response.sendRedirect("index.jsp?msj=usuario y clave vacios");

    }
%>

