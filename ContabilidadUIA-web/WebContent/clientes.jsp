<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "uia.com.contabilidad.ContabilidadUIA.*" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página de cliente</title>
</head>
<body>
	<h1>Datos del cliente</h1>
	<jsp:useBean id = "conta" class = "uia.com.contabilidad.ContabilidadUIA"></jsp:useBean>
	<jsp:useBean id = "cliente" class = "uia.com.presentacion.ClienteJSP"></jsp:useBean>
	
	
	<!-- aquí se captura el parámetro que se paso por el formulario -->
	<%!
	String t1 = null;
	%>
	
	
	<%
	if (request.getParameter("cliente") != null){
		t1 = request.getParameter("cliente");
	}
	out.println(t1);
	
	// aquí debo meter un método al que le ingrese el parámetro y me devuelva la lista correspondiente
	%>
	
</body>
</html>