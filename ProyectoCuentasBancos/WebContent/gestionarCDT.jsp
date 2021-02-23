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

<form action="sgestionarcdt" method="post">
	<table class="tb">
		<tr>
			<td><input type="radio" name="opcioncdt" value="crcdt">Crear CDT</td>
			<td><input type="radio" name="opcioncdt" value="ccdt">Cerrar CDT</td>
			
		</tr>
		<tr>
			<td>Cuenta: <input type="text" name="idcuenta"></td>
			<td>CDT: <input type="text" name="idcdt" ></td>
		</tr>
			
			<td >Interes: <input type="text" name="interes"></td>
			<td> 
		<tr>
			<td>Monto: <input type="text" name="monto"></td>
		</tr>
		<tr>
			<td  align="center">
				<input type="submit" value="Enviar">
			</td>
			<td align="center">
				<input type="reset" value="Borrar valores">
 			
		</tr>
	</table>
	
	
	<p> <input type="text" name="resultado" value="<%=request.getAttribute("ctd_rq")%>"/></p>


</form>

<a href="index.jsp">Volver index</a><br/>
</body>
</html>