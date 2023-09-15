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

import implement.Appello;
import implement.DataFormato;
import implement.Query;

/**
 * Servlet implementation class StampaStudenti
 */
@WebServlet("/StampaStudenti")
public class StampaStudenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Query query = new Query();
	private Appello appello = new Appello();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StampaStudenti() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAppello = request.getParameter("ID_appello");
		
		int id = Integer.parseInt(idAppello);

		try {

			ResultSet rs1 = query.getResult(
					"select distinct nome,cognome,Matricola from studente join (appello join prenotazione on CAST("
							+ idAppello + " AS UNSIGNED INTEGER)=id_app) on Matricola=matricola_stud");

			ResultSet rs = appello.ricerca(id);

			rs.next();
			String Materia = rs.getString("Materia");
			String Data1 = rs.getString("Data");
			DataFormato Data = new DataFormato();

			ResultSet rs2 = query.getResult("select materia from lezione where materia='" + Materia + "'");
			rs2.next();
			String nomeMateria = rs2.getString(1);

			RequestDispatcher rd = request.getRequestDispatcher("professore.jsp");
			request.setAttribute("Materia", nomeMateria);
			request.setAttribute("Data", Data.dataIngToIta(Data1));
			request.setAttribute("elenco_studenti", rs1);
			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
