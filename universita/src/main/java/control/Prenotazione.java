package control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implement.Lezione;
import implement.Query;

@WebServlet("/Prenotazione")
public class Prenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Prenotazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String materia = request.getParameter("materia");
		Lezione lezione = new Lezione();
		Query query = new Query();

		try {

			int idcorso = Integer.parseInt(materia);

			ResultSet rs1 = lezione.ricerca(idcorso);
			rs1.next();

			// restituisce il nome della materia che vogliamo stampare

			String nomeMateria = rs1.getString("materia");

			ResultSet rs = query.getResult("select idAppello,Data from appello where materia='" + nomeMateria + "'");

			RequestDispatcher rd = request.getRequestDispatcher("studente.jsp");

			request.setAttribute("materia", nomeMateria);
			request.setAttribute("elenco_appelli", rs);
			rd.forward(request, response);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
