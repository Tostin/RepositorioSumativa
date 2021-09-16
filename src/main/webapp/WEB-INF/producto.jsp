<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
</head>
<body>
	<div>
	<br>
		<form:form action="/producto/crear" method="post" modelAttribute="producto">
			<form:label path="nombre">nombre: </form:label>
			<form:input type="text" path="nombre"/><br>
			<br>
			<form:label path="codigo">codigo: </form:label>
			<form:input type="text" path="codigo"/><br>
			<br>
			<form:label path="valorBase">valor Base: </form:label>
			<form:input type="text" path="valorBase"/><br>
			<br>
			<form:label path="categoria">categoria: </form:label>
			<form:input type="text" path="categoria"/><br>
			<br>
			<input type="submit" value="Crear Producto">
		</form:form>
		<br>
		<hr>
		<h1>Lista de Productos</h1>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre</th>
					<th>Codigo</th>
					<th>ValorBase</th>
					<th>Categoria</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="producto" items="${lista_productos}" >
				<tr>
					<td><c:out value="${producto.id}" /> </td>
					<td><c:out value="${producto.nombre}" /> </td>
					<td><c:out value="${producto.codigo}" /> </td>
					<td><c:out value="${producto.valorBase}" /> </td>
					<td><c:out value="${producto.categoria}" /> </td>
					<td>
						<a href="/producto/actualizar/${producto.id}">EDITAR</a>
						
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