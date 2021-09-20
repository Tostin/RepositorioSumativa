 
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>PRODUCTO</title>
	</head>
<body>
	<div>
		<form:form action="/usuario/crear" method="post" modelAttribute="usuario">
			<label for="producto">Seleccione los productos</label>
			<select name="producto" multiple>
				<c:forEach var="producto" items="${lista_productos}" >
					<option value="<c:out value="${producto.id}" />"> <c:out value="${producto.nombre}" /> </option>
				</c:forEach>
			</select>
			<br>
			<input type="submit" value="comprar">
		</form:form>
		<br>
			<hr>
				<h2>Lista de productos</h2>
			<table>
				<thead>
					<tr>
						<th>#</th>
						<th>Nombre</th>
						<th>caracteristicas</th>
						<th>precio</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${lista_productos}" >
					<tr>
						<td><c:out value="${producto.id}" /> </td>
						<td><c:out value="${producto.nombre}" /> </td>
						<td><c:out value="${producto.caracteristicas}" /> </td>
						<td><c:out value="${producto.precio}" /> </td>
						<td>
							<a href="/producto/actualizar/${producto.id}">Editar</a>

							<form action="/producto/eliminar" method="POST">
								<input type="hidden" name="id" value="<c:out value="${producto.id}" />" >
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