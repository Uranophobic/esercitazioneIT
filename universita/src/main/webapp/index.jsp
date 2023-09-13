<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="index.css" rel="stylesheet">
		<title>Benvenuto!</title>
	</head>
	<header>
		<img src="logo.png" class="logo">
	</header>
	<body>
		<img src="background1.jpg" class="background">
	
		<%
		String messaggio= (String)request.getAttribute("messaggio");
		%>
		<% 
		if(messaggio!=null){%>   
			<p>
				<a>
				<%out.print(messaggio);%></a> <%-- si poteva fare anche con l'espressione <%=messaggio%> --%>
			</p>
			<%} %>
		
		
		<div class="form">
			<form action="login" method="post">
				<h2>Login</h2>
				<h3>Email</h3>
				<input type="text" name="username">
				<h3>Password</h3>
				<input type="password" name="password">
				<button type="submit" value="Accedi">Accedi</button>
			</form>
		</div>
	</body>
	<footer>
	</footer>
</html>