package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		
		Connection conn= null;
		try {
			conn = Connessione.getInstance().getConnection();
			PreparedStatement smt1=conn.prepareStatement("select materia from corso where idcorso=CAST(? AS UNSIGNED INTEGER)");
			smt1.setString(1, materia);
			ResultSet rs1 = smt1.executeQuery();
			rs1.next();//restituisce il nome della materia che vogliamo stampare
			
			String nomeMateria=rs1.getString(1);
			PreparedStatement smt= conn.prepareStatement("select idAppello,Data from appello where materia=CAST(? AS UNSIGNED INTEGER)");
			smt.setString(1,materia);
			
			ResultSet rs= smt.executeQuery();//questo resultset mi prende appelli e date richiesti nella prepared
			RequestDispatcher rd=request.getRequestDispatcher("studente.jsp");
			request.setAttribute("materia", nomeMateria);
			request.setAttribute("elenco_appelli", rs);
			rd.forward(request, response);
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		}
	
	
	
	
	}
	


