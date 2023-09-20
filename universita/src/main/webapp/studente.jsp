<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>	
	<head>
		<link rel="stylesheet" href="studente.css">
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="menu.css">
		<script src="menu.js"defear></script>
		<script src="https://cdn.lordicon.com/bhenfmcm.js"></script>
		<meta charset="ISO-8859-1">
		<title>Area Studenti</title>
	</head>
	<body style="background: linear-gradient(to top right, #808080 0%, #d3d3d3 45%);height:90vh;background-repeat: no-repeat;">
		<%
		String matricola = (String) session.getAttribute("matricola");
		String nome_alunno = (String) session.getAttribute("nome");
		String cognome_alunno = (String) session.getAttribute("cognome");
		ResultSet res = (ResultSet) request.getAttribute("tabella_corso");
		ResultSet res1 = (ResultSet) request.getAttribute("elenco_appelli");
		String materia = (String) request.getAttribute("materia");
		String messaggio = (String) request.getAttribute("successo");
		String data = (String) request.getAttribute("data");
		String materia2 = (String) request.getAttribute("materia2");
		boolean esito = (boolean)request.getAttribute("esito");
		%>
		<%if (matricola == null) {response.sendRedirect("index.jsp");}%>
		
		<header>
			<img src="logo.png" class="logo">
			<span onclick="openMenu()" class="menu">&#9776;</span>
	        <div id="myNav" class="overlay">
	            <a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
	            <div class="ContenutoMenu">
	                <a href="#">Home</a>
	                <a href="ApriTicket?matricola=<%=matricola%>" > Ticket</a>
	                <a href="logout.jsp"> logout</a>
	            </div>
	            <div id="blocco" class="blocco">
	        	</div>
	        </div>
		</header>
		
		<h2 style="text-align:center;padding-top:1%">Benvenuto <%=nome_alunno%> <%=cognome_alunno%></h2>
		
		<%if (res != null) {%>
			<p style="text-align: center;">Inserisci la prenotazione che vuoi effettuare:</p>
			<form action="Prenotazione" method="post">
				<table>
					<tr>
						<th></th>
						<th>ID corso</th>
						<th>materia</th>
						<th>docente</th>
					</tr>
					<%while(res.next()){%>
						<tr>
							<td><input type="radio" id="Scelta" name="materia" value=<%=res.getInt("idcorso")%>></td>
							<td><%=res.getInt("idcorso")%></td>
							<td><%=res.getString("materia")%></td>
							<td><%=res.getString("cognome")%> <%=res.getString("nome")%></td>
						</tr>
					<%}%>
				</table>
				<button type="submit" value="Prenota" class="bottoneP">Prenota</button>
			</form>
		<%}%>
			
		<%if (res1 != null) {%>
			<p style="text-align:center">Per l'esame di <%=materia%> sono disponibili i seguenti appelli: <br>
										Inserisci la prenotazione che vuoi effettuare</p>
			<form action="Prenota" method="post">
				<table>
					<tr>
						<th></th>
						<th>ID Appello</th>
						<th>Data</th>
					</tr>
					<%while (res1.next()) {%>
						<tr>
							<td><input type="radio" name="appello"
								value=<%=res1.getInt(1)%>></td>
							<td><%=res1.getInt(1)%></td>
							<td><%=res1.getDate("Data")%></td>
						</tr>
					<%}%>
				</table>
				<button type="submit" value="Prenota" class="bottoneP">Prenota</button>
			</form>
		<%}%>
		
		<!-- prenotazione NON ok -->
		<%if (esito){%>
	        <p> Sei già iscritto a questo esame </p>
		<%} else {%><%} %>
		
		<!-- prenotazione ok -->
		<% if (materia2 != null && data != null) {%>
	        <p id="messaggio_prenotazione" style="text-align:center;">Prenotazione effettuata con successo in data <b><%=data%></b> per il corso <b><%=materia2%></b></p>
	   		<a href="javascript: window.history.go(-2)">
	   			<lord-icon
				    src="https://cdn.lordicon.com/zmkotitn.json";
				    trigger="hover";
				    colors="primary:#121331";
				    style="width:50px;height:50px;transform: scaleX(-1);margin-top:10%">
				</lord-icon>
	   		</a>
	    <%} else {%><%}%>
	    <footer>
        	<p>&copy; Università  degli Studi di Napoli Federico II</p>
  		</footer>
	</body>
</html>