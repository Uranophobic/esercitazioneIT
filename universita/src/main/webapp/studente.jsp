<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="studente.css">
<head>
<meta charset="ISO-8859-1">
<title>Area Studenti</title>
<header>
<img src="logo.png" class="logo">

<span onclick="openMenu()">&#9776; Menu</span>
            <div id="myNav" class="overlay">
                <a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
                <div class="ContenutoMenu">
                    <ul class="list">
                        <li class="titoli">
</header>
</head>

<body>
<%String matricola=(String)session.getAttribute("matricola");
ResultSet res=(ResultSet) request.getAttribute("tabella_corso");
ResultSet res1=(ResultSet) request.getAttribute("elenco_appelli");
String materia=(String) request.getAttribute("materia");
String messaggio = (String) request.getAttribute("successo");
String data = (String) request.getAttribute("data");
String materia2 = (String) request.getAttribute("materia2");
%>
<% if(matricola==null){
	
	response.sendRedirect("index.jsp");
}
%>
<p style="text-align:right;">Benvenuto <%=matricola %></p> 
<a href="logout.jsp"> logout</a>
<% if(res!=null) {%>
<p style="text-align:center;">Inserisci la prenotazione che vuoi effettuare:

<form action="Prenotazione" method="post">
<table border=4>
<tr>
<th></th>
<th>ID corso</th>
<th>materia</th>
<th>docente</th>
</tr>

<%
while(res.next()){	
%>

<tr>
<td><input type="radio" id="Scelta" name="materia" value=<%=res.getInt("idcorso") %>></td>
<td><%=res.getInt("idcorso") %></td>
<td><%=res.getString("materia") %></td>
<td><%=res.getString("cognome") %><%=res.getString("nome") %></td>
<%} %>
</tr>
</table>

<button type="submit" value="Prenota">Prenota</button>
<%} %>
</form>

<% if(res1!=null) {%>
<p>Per l'esame di <%=materia%> sono disponibili i seguenti appelli:</p>
<form action="Prenota" method="post">
<table border=4>
<tr>
<th></th>
<th>ID Appello</th>
<th>Data</th>
</tr>
<%
while(res1.next()){	
%>
Inserisci la prenotazione che vuoi effettuare
<tr>
<td><input type="radio" id="Scelta2" name="materia2" value=<%=res1.getInt(1)%>></td>
<td><%=res1.getInt(1)%></td>
<td><%=res1.getDate("Data") %></td>
<%} %>
</tr>
</table>
<form action="Prenota" method="post">

<input type="submit" value="Prenota"></form>
<%} %>
<%if(messaggio!=null) %>
<%=messaggio %>

<%if(materia2!=null && data!=null){ %>
<p> Prenotazione effettuata con successo in data <%=data %> per il corso <%=materia2 %></p>
<%} %>

</body>
<script src="JS.js"></script>
</html>