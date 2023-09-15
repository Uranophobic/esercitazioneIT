package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implement.Appello;
import implement.Lezione;
import implement.Query;


/**
 * Servlet implementation class Prenotazione
 */
@WebServlet("/Prenotazione")
public class Prenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String materia=request.getParameter("materia");
		Lezione lezione  = new Lezione();
		Query query = new Query();
		Connection conn= null;
		try {
			
			int idcorso = Integer.parseInt(materia);
			
			
//			
//			conn = Connessione.getInstance().getConnection();
//			
//			PreparedStatement smt1=conn.prepareStatement("select materia from lezione where idcorso=CAST(? AS UNSIGNED INTEGER)");
//			smt1.setString(1, materia);
//			ResultSet rs1 = smt1.executeQuery();
			
			ResultSet rs1 = lezione.ricerca(idcorso);
			rs1.next();
			
			
			//restituisce il nome della materia che vogliamo stampare
			
			String nomeMateria=rs1.getString("materia");
			
//			PreparedStatement smt= conn.prepareStatement("select idAppello,Data from appello where materia=CAST(? AS UNSIGNED INTEGER)");
//			smt.setString(1,nomeMateria);
//			
			//ResultSet rs= smt.executeQuery();//questo resultset mi prende appelli e date richiesti nella prepared
			
			ResultSet rs=	query.getResult("select idAppello,Data from appello where materia='"+nomeMateria+"'");
			RequestDispatcher rd=request.getRequestDispatcher("studente.jsp");
			request.setAttribute("materia", nomeMateria);
			request.setAttribute("elenco_appelli", rs);
			rd.forward(request, response);
			
			
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		}
	
	
	
	
	}
	


