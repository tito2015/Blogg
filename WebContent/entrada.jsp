<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/Blogg/assets/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<title>Entrada</title>
</head>
<body>

	<h2>Welcome: ${Usuario.usu_usuario}</h2>
	<a href="formulario.jsp" class="pull-right btn btn-primary">Agregar entrada</a><br><br>

	<c:forEach items="${entradaList}" var="entrada">
	<div class="container">
		<div class="panel panel-success">
		
		<c:if test="${entrada.ent_usu_usuario == Usuario.usu_usuario}">
		
			<button type="button" class="btn btn-success pull-right" onclick="eliminar(${entrada.id})">
				<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			</button>
		
		</c:if>
		
			<div class="panel-heading"><h2>Titulo:${entrada.titulo}</h2></div>
			<div class="panel-body"><h3>${entrada.contenido}</h3></div>
			<div class="panel-footer"><strong class="pull-right">${entrada.fecha}</strong></div>
		</div>
	</div>
	</c:forEach>
	
		<script>
			function eliminar(id){
				var respuesta = confirm("¿Esta seguro que desea eliminar esta publicación?");
				
				if (respuesta == true) {
					$.ajax({
						url : '${pageContext.request.contextPath}/FormularioController?operacion=eliminar&id='+id,
						type : 'POST',
						success : function(data) {
							if (data.error != null) {
								alert(data.error);
							} else {
		
								window.location = "${pageContext.request.contextPath}/FormularioController?operacion=listar";
								
							}
						}

					});

				} 
				
							
			}
		
	</script>

</body>
</html>