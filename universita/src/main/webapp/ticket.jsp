<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Sezione Ticket</title>
		<link rel="stylesheet" href="studente.css">
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="menu.css">
		<link rel="stylesheet" href="ticket.css">
		<script src="menu.js"defear></script>
	</head>
	<body>
		<%
		String matricola = (String) session.getAttribute("matricola");
		String nome_alunno = (String) session.getAttribute("nome");
		String cognome_alunno = (String) session.getAttribute("cognome");
		String messaggioticket = (String) session.getAttribute("richiesta");
		String idticket = (String) session.getAttribute("idticket");
		%>
		<header>
			<img src="logo.png" class="logo"> <span onclick="openMenu()"
				class="menu">&#9776;</span>
			<div id="myNav" class="overlay">
				<a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
				<div class="ContenutoMenu">
					<a href="#">Home</a> 
					<a href="#">Segreteria</a> 
					<a href="logout.jsp">Logout</a>
				</div>
				<div id="blocco" class="blocco"></div>
			</div>
		</header>
		<% if(messaggioticket!=null){ %>
			<form action="ApriTicket" method="post">
				<div class="background">
					<div class="container">
						<div class="screen">
							<div class="screen-header">
								<div class="screen-header-left">
									<div class="screen-header-button close"></div>
									<div class="screen-header-button maximize"></div>
									<div class="screen-header-button minimize"></div>
								</div>
								<div class="screen-header-right">
									<div class="screen-header-ellipsis"></div>
									<div class="screen-header-ellipsis"></div>
									<div class="screen-header-ellipsis"></div>
								</div>
							</div>
							<div class="screen-body">
								<div class="screen-body-item left">
									<div class="app-title">
										<span>APRI UN</span> <span>TICKET</span>
									</div>
		
								</div>
								<div class="screen-body-item">
									<div class="app-form">
										<div class="app-form-group">
											<input type="text" class="app-form-control" name="matricola" placeholder="MATRICOLA"
												value="<%=matricola%>">
										</div>
										<div class="app-form-group">
											<input type="text" class="app-form-control" placeholder="NOME" name="nome" value="<%=cognome_alunno%>">
										</div>
										<div class="app-form-group message">
											<input  type="text"class="app-form-control" placeholder="TITOLO" name="titolo" >
										</div>
		
										<div class="app-form-group message">
											<input type="text" class="app-form-control" placeholder="MESSAGGIO" name="messaggio">
										</div>
										<div class="app-form-group buttons">
		
											<button class="app-form-button" button type="submit">INVIA</button>
										</div>
									</div>
								</div>
							</div>
						</div>
		
					</div>
				</div>
			</form>
		<% }%>
	
		<%-- 
		<% if(idticket!=null && chiuso==true){ %>
		<form action="Mostraticket" method="post">
			<button type="submit" value="Stampa">Mostra ticket aperti</button>
		</form>
		<% }%> 
		 --%>
		<footer>
			<p>&copy; Università degli Studi di Napoli Federico II</p>
		</footer>
	</body>
</html>