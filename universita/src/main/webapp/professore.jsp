<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="java.sql.*" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Insert title here</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Bootstrap demo</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
                crossorigin="anonymous">
            <link rel="stylesheet" href="professore.css">
        </head>

        <body>
            <header>
                <div class="container-fluid">
                    <div class="row justify-content-center">
                        <img src="logo.png" class=" d-flex logo mt-5 mb-5">
                    </div>
                </div>
                <nav class="navbar bg-body-tertiary fixed-top mb-5 navcolor">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#"></a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                            data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
                            aria-labelledby="offcanvasNavbarLabel">
                            <div class="offcanvas-header">
                                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Menu</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="offcanvas"
                                    aria-label="Close"></button>
                            </div>
                            <div class="offcanvas-body">
                                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                                    <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Link</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="logout.jsp">Logout</a>
                                    </li>
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                </nav>

            </header>
            <section>
                <% String nome=(String)session.getAttribute("nome"); String
                    cognome=(String)session.getAttribute("cognome"); String
                    materia=(String)session.getAttribute("materia"); ResultSet
                    appelli=(ResultSet)request.getAttribute("appelli"); ResultSet
                    elenco=(ResultSet)request.getAttribute("elenco_studenti"); String
                    nomeMateria=(String)request.getAttribute("Materia"); String
                    Data=(String)request.getAttribute("Data"); %>
                    <% if(nome==null && cognome==null){ response.sendRedirect("index.jsp"); } %>
                        <h1>Bentornato <%=nome%>
                                <%=cognome%>
                        </h1>
                        
                     
                                <form action="StampaStudenti" method="post">
                                    <% if(appelli!=null){ %>
                                        <p class="pclass"> Per la sua materia: <%=materia %> sono disponibili i seguenti appelli </p>
                                        <table border=4 class="table-bordered">
                                            <tr>
                                                <th></th>
                                                <th>ID Appello</th>
                                                <th>Data</th>
                                                
            
                                            </tr>
                                            
                                            <% while(appelli.next()){ %>
                                                
                                                
                                                <td><input type="radio" name="ID_appello"
                                                    value=<%=appelli.getInt(1)%>></td>
                                            
                                            
                                                <td>
                                                    <%=appelli.getInt(1)%>
                                                </td>
                                                <td>
                                                    <%=appelli.getDate("Data") %>
                                                </td>
            
                                        </table>
                                        <% }%>
                                    
                                        <button type="submit" value="Stampa">Vai</button>
                                </form>
                                
                                <% }%>
                                    <% if(elenco!=null){%>

                                        <p>Per l'esame<%=nomeMateria %> in data<%=Data %>si sono prenotati i seguenti
                                                    studenti: </p>
                                        <table border=4>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Cognome</th>
                                                <th>Matricola</th>
                                            </tr>
                                            <% while(elenco.next()){ %>
                                                <tr>
                                                    
                                                    <td>
                                                        <%=elenco.getString("nome")%>
                                                    </td>
                                                    <td>
                                                        <%=elenco.getString("cognome")%>
                                                    </td>
                                                    <td>
                                                        <%=elenco.getString("Matricola") %>
                                                    </td>
                                                    <% }%>
                                                        <%} %>

                                        </table>
            </section>
            <div class="container-fluid">
                <footer>
                    <div class="footer fixed-bottom">&copy;<span id="year"> </span><span> Università degli Studi di Napoli Federico II</span></div>
                </footer>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
                crossorigin="anonymous"></script>
        </body>

        </html>