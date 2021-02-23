<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="estilos/estilos.css">
</head>
<body>

<header>
	<img class="img1" src="img/nowe.jpeg">
</header>

<form action="ssaldos" method="post">
	<table class="tb">
		<tr>
			<td class="tb" colspan="2" align="center"><input type="radio" name="tsaldo" value="sc">Saldo cuenta
			<input type="radio" name="tsaldo" value="scdt">Saldo CDT
			<input type="radio" name="tsaldo" value="scl">Saldo Cliente<br/>
			</td>
			
		</tr>
		<tr>
			<td align="center" >Dato: <input type="text" name="dato"></td>
			<td></td>
			</td>
		</tr>
			<td align="cent">Su saldo es: <input type="text" name="resultado" value="<%=request.getAttribute("jspSaldo_rq")%>"/> </td>
			<td></td>
		<tr>
			
		</tr>
		<tr>
			<td  align="center">
				<input type="submit" value="Consultar Saldo">
			</td>
			<td align="center">
				<input type="reset" value="Borrar valores">
 			
		</tr>
	
	
	</table>


</form>

<a href="index.jsp">Volver index</a><br/>

</body>
</html>