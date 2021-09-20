<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<div>
		<form:form action="/registro/modificar" method="post" modelAttribute="registro">
		
			<input type="hidden" name="_method" value="put" >
			<form:hidden path="id"/>
			
			<form:label path="rut">rut:</form:label>
			<form:input type="text" path="rut"/><br>
			
			<form:label path="nombre">nombre:</form:label>
			<form:input type="text" path="nombre"/><br>
			
			<form:label path="apellido">apellido:</form:label>
			<form:input type="text" path="apellido"/><br>
			
			<form:label path="email">email:</form:label>
			<form:input type="text" path="email"/><br>
			

			<form:label path="password">password:</form:label>
			<form:input type="text" path="password"/><br>
			<input type="submit" value="modificar registro">
		</form:form>
		
	</div>
</body>
</html>