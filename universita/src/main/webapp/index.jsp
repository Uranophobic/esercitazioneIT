<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="index.css" rel="stylesheet">
		<link href="style.css" rel="stylesheet">
		<title>Benvenuto!</title>
	</head>
	<header>
		<img src="logo.png" class="logo">
	</header>
	<body>
		<img src="background1.jpg" class="background">
		
		<div class="form">
			<form action="login" method="post">
				<h2>Login</h2>
				<h3>Username</h3>
				<input type="text" name="username" id="username">
				<h3>Password</h3>
				<input type="password" name="password" id="password">
				<button type="button" id="mostra_password">Mostra Password</button>
				<span class="errore" id="errore">
					<%String messaggio= (String)request.getAttribute("messaggio");%>
					<% 
					if(messaggio!=null){%>   
						<p ><%out.print("Username o Password non sono corretti");%></p>
					<%} %>
				</span>
				<button type="submit" value="Accedi" id="submit">Accedi</button>
			</form>
		</div>
	</body>
	<script src="./obbligo_accesso.js"></script>
</html>