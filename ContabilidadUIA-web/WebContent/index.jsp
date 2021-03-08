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
	<h1>Página de Proveedores</h1>
	
	<jsp:useBean id = "contabilidad" class = "uia.com.contabilidad.ContabilidadUIA"></jsp:useBean>
	<!--  La idea es que en este formulario se envíe el id del proveedor seleccionado a clientes.jsp -->
	<form name = "formClientes" id= "form1" action="clientes.jsp" method = "post">
		Proveedor: <select name = "cliente">
		<c:forEach var = "cliente" items = "${contabilidad.getListaProveedores()}">
			<option value = "${cliente.id}"> ${cliente.name}</option>
		</c:forEach>
		</select>
		<input type = "submit" value = "Submit">
	</form>
	
	<form name = "formCuentas" id = "form2" action="/cuentas.jsp">
		Cuenta: <select name = "cuenta">
		<c:forEach var = "cuenta" items = "${contabilidad.getListaCuentas()}">
			<option value = "${cuenta.id}"> ${cuenta.name}</option>
		</c:forEach>
		</select>
		<input type = "submit" value = "Submit">
	</form>
	
	<form name = "formCheques" id = "form2" action = "/cuentas.jsp">
		Cheque: <select name = "cuenta">
		</select>
		<input type = "submit" value = "Submit">
	</form>
	
	
	<jsp:useBean id = "date" class = "java.util.Date"/>
	<p>Today is <%=date%></p>
	
</body>
</html>