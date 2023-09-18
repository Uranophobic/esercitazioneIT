<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>

	<head>
		<script src="menu.js"></script>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="professore.css">
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="menu.css">
		<title>Area segreteria</title>
	</head>
	
    <body style="background: linear-gradient(to top right, #808080 0%, #d3d3d3 45%);height:90vh;background-repeat: no-repeat;">
	    <section>
	        <% String nome=(String)session.getAttribute("nome"); String
			cognome=(String)session.getAttribute("cognome"); String
			materia=(String)session.getAttribute("materia"); ResultSet
			appelli=(ResultSet)request.getAttribute("appelli"); ResultSet
			elenco=(ResultSet)request.getAttribute("elenco_studenti"); String

			nomeMateria=(String)request.getAttribute("Materia"); String
			Data=(String)request.getAttribute("Data"); %>
			<% if(nome==null && cognome==null){ response.sendRedirect("index.jsp"); } %>
			
			<header>
				<img src="logo.png" class="logo">
				<span onclick="openMenu()" class="menu">&#9776;</span>
				<div id="myNav" class="overlay">
				    <a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
		           	<div class="ContenutoMenu">
		               <a href="#">Home</a>
		               <a href="logout.jsp"> logout</a>
		           	</div>
		           	<div id="blocco" class="blocco"></div>
		       </div>
			</header>
			<h1 style="text-align:center">Bentornato <%=nome%> <%=cognome%> !</h1>
<!-- 			<form action="Prenotazione" method="post"> -->
				<table>
					<tr>
						<th></th>
						<th>ID ticket</th>
						<th>Titolo</th>
						<th>Stato</th>
					</tr>
					
				</table>
<!-- 			</form> -->
	    </section>
	    <footer>
        	<p>&copy; Università  degli Studi di Napoli Federico II</p>
  		</footer>
	</body>
</html>