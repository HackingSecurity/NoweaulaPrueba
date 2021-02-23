<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header>
	<img class="img1" src="img/nowe.jpeg">
</header>

<form action="singresoretiro" method="post">
	<table class="tb">
		<tr>
			<td><input type="radio" name="opcion" value="ingreso">Ingresar Saldo</td>
			<td><input type="radio" name="opcion" value="retiro">Retirar Saldo</td>
			
		</tr>
		<tr>
			<td>Cuenta: <input type="text" name="idcuenta"></td>
			<td>Cantidad: <input type="text" name="idcdt" ></td>
		</tr>
		<tr>
			<td  align="center">
				<input type="submit" value="Enviar">
			</td>
			<td align="center">
				<input type="reset" value="Borrar valores">
 			
		</tr>
	</table>
	
	
	<p> <input type="text" name="resultado" value="<%=request.getAttribute("movimientos_rq")%>"/></p>


</form>

<a href="index.jsp">Volver index</a><br/>
</body>
</html>