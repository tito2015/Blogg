<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/Blogg/assets/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
	<div class="container">

		<form action="PruebaServlet" method="post" class="form-horizontal">
			<fieldset>


				<h1 class="text-center">Ingrese su Usuario</h1>


				<div class="form-group">
					<label class="col-sm-2 control-label">Usuario</label>
					<div class="col-sm-10">
						<input name="usuario" type="text" placeholder="usuario"
							class="form-control">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input name="password" type="password" placeholder="password"
							class=" form-control">
					</div>
				</div>

				<!-- Button -->
				<div class="control-group">
					<label class="control-label" for="singlebutton"></label>
					<div class="controls">
						<button id="boton" name="boton" class="btn btn-primary pull-right">Enviar</button>
						</br> </br>
					</div>
				</div>

			</fieldset>
		</form>
	</div>
	</form>
	</center>
	<div class="col-sm-offset-3 col-sm-7 text-center">
		<c:if test="${not empty datosVacios}">
			<!-- Aca pone el elemento que quieras acomodar-->
			<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign"
					aria-hidden="true"></span> <span class="sr-only">Error:</span>
				${datosVacios}
			</div>
		</c:if>
	</div>
</body>
</html>