<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>
	<div>
	<br>
		<form:form action="/usuario/crear" method="post" modelAttribute="usuario">
		
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			<br>
			<form:label path="nombre">Nombre: </form:label>
			<form:input type="text" path="nombre"/><br>
			<br>
			<form:label path="apellido">Apellido: </form:label>
			<form:input type="text" path="apellido"/><br>
			<br>
			<form:label path="email">Email: </form:label>
			<form:input type="text" path="email"/><br>
			<br>
			<form:label path="username">Username: </form:label>
			<form:input type="text" path="username"/><br>
			<br>
			<input type="submit" value="Crear Usuario">
		</form:form>
		<br>
		<hr>
		<h1>Lista de Usuarios</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>email</th>
					<th>Username</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${lista_usuarios}" >
				<tr>
					<td><c:out value="${usuario.id}" /> </td>
					<td><c:out value="${usuario.rut}" /> </td>
					<td><c:out value="${usuario.nombre}" /> </td>
					<td><c:out value="${usuario.apellido}" /> </td>
					<td><c:out value="${usuario.email}" /> </td>
					<td><c:out value="${usuario.username}" /> </td>
					<td>
						<a href="/usuario/actualizar/${usuario.id}">EDITAR</a>
						
						<form action="/usuario/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${usuario.id}" />" >
							<input type="submit" value="Eliminar">
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>