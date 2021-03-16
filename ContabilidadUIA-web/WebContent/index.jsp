<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "uia.com.contabilidad.ContabilidadUIA.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>
</head>
<body>
	<h1>Clientes</h1>
	
	<jsp:useBean id = "contabilidad" class = "uia.com.contabilidad.ContabilidadUIA"></jsp:useBean>
	
	<table border=1>
        <thead>
            <tr>
                <th>Cliente</th>
                <th>Id</th>
                <th>Compras</th>
                <th>Cuentas</th>
                <th>Cheques</th>
                <th colspan=2>Mantenimiento</th>
            </tr>
        </thead>
        
        <tbody>          
        	<c:forEach var="cliente" items="${contabilidad.getListaProveedores()}">
                <tr>
                    <td><c:out value="${cliente.name}" /></td>
                    <td><c:out value="${cliente.id}" /></td>
                    <td><a href="ClienteController?action=verCompras&clienteName=<c:out value="${cliente.name}"/>">Ver</a></td>
                    <td><a href="ClienteController?action=verCuentas&clienteName=<c:out value="${cliente.name}"/>">Ver</a></td>
                    <td><a href="ClienteController?action=verCheques&clienteName=<c:out value="${cliente.name}"/>">Ver</a></td>
                    <td><a href="ClienteController?action=Actualiza&clienteName=<c:out value="${cliente.name}"/>">Actualizar</a></td>
                    <td><a href="ClienteController?action=Borra&clienteName=<c:out value="${cliente.name}"/>">Borrar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
	
	<p><a href="ClienteController?action=insert">Agregar Cliente</a></p>
	
	
	
	<jsp:useBean id = "date" class = "java.util.Date"/>
	<p>Today is <%=date%></p>
	
</body>
</html>