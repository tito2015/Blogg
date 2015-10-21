<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/Blogg/assets/css/bootstrap.min.css">
<title>Ingrese su entrada</title>
</head>
<body>
	<div class="container">
		<form action="FormularioController" method="post">
			<h1>Ingresar entrada</h1>
			<label>Titulo</label><br> 
			<input type="text"placeholder="titulo" name="titulo"><br> 
			<label>Contenido</label><br>
			<textarea rows="10" cols="70" placeholder="Ingrese su contenido" name="contenido"></textarea><br> 
			<input type="submit" values="Enviar" class="btn btn-primary"> 
			<a href="entrada.jsp" class="btn btn-primary">Ver las entradas</a>
		</form>
	</div>
</body>
</html>