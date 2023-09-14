<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>	
	<head>
		<link rel="stylesheet" href="studente.css">
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="menu.css">
		<script src="JS.js"></script>
		<meta charset="ISO-8859-1">
		<title>Area Studenti</title>
	</head>
	<header>
		<img src="logo.png" class="logo">
		<span onclick="openMenu()">&#9776;</span>
        <div id="myNav" class="overlay">
            <a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
            <div class="ContenutoMenu">
                <a href="#">Home</a>
                <a href="#">Segreteria</a>
                <a href="logout.jsp"> logout</a>
            </div>
            <div id="blocco" class="blocco">
        	</div>
        </div>
	</header>
	<body id="body">
		<%
		String matricola = (String) session.getAttribute("matricola");
		ResultSet res = (ResultSet) request.getAttribute("tabella_corso");
		ResultSet res1 = (ResultSet) request.getAttribute("elenco_appelli");
		String materia = (String) request.getAttribute("materia");
		String messaggio = (String) request.getAttribute("successo");
		String data = (String) request.getAttribute("data");
		String materia2 = (String) request.getAttribute("materia2");
		%>
		<%
		if (matricola == null) {
	
			response.sendRedirect("index.jsp");
		}
		%>
		<p style="text-align:center;padding-top:1%">Benvenuto <%=matricola%></p>
		<%
		if (res != null) {
		%>
		<p style="text-align: center;">Inserisci la prenotazione che vuoi effettuare:</p>
		<form action="Prenotazione" method="post">
			<table border=4>
				<tr>
					<th></th>
					<th>ID corso</th>
					<th>materia</th>
					<th>docente</th>
				</tr>
	
				<%
				while (res.next()) {
				%>
	
				<tr>
					<td><input type="radio" id="Scelta" name="materia"
						value=<%=res.getInt("idcorso")%>></td>
					<td><%=res.getInt("idcorso")%></td>
					<td><%=res.getString("materia")%></td>
					<td><%=res.getString("cognome")%><%=res.getString("nome")%></td>
					<%
					}
					%>
				</tr>
			</table>
	
			<button type="submit" value="Prenota">Prenota</button>
			<%
			}
			%>
		</form>
	
		<%
		if (res1 != null) {
		%>
		<p style="text-align:center">Per l'esame di <%=materia%> sono disponibili i seguenti appelli: <br>
									Inserisci la prenotazione che vuoi effettuare</p>
		<form action="Prenota" method="post">
			<table border=4>
				<tr>
					<th></th>
					<th>ID Appello</th>
					<th>Data</th>
				</tr>
				<%
				while (res1.next()) {
				%>
				<tr>
					<td><input type="radio" name="appello"
						value=<%=res1.getInt(1)%>></td>
					<td><%=res1.getInt(1)%></td>
					<td><%=res1.getDate("Data")%></td>
					<%
					}
					%>
				</tr>
			</table>
		</form>
		<form action="Prenota" method="post">
			<button type="submit" value="Prenota" style="width: 38%">Prenota</button>
		</form>
		<%
		}
		%>
		<%
		if (messaggio != null){
	        %>
	        <p><%=messaggio%></p>

	        <%} else { 
	        %>
	        <%} %>

	        <% if (materia2 != null && data != null) {
	        %>
	        <p>
	            Prenotazione effettuata con successo in data
	            <%=data%>
	            per il corso
	            <%=materia2%></p>
	        <%
	        }
	        %>
	</body>
</html>