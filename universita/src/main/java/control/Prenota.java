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
import javax.servlet.http.HttpSession;

import implement.Appello;
import implement.DataFormato;
import implement.Prenotazione;
import implement.Query;

@WebServlet("/Prenota")
public class Prenota extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Query query = new Query();
	private Prenotazione prenotazione = new Prenotazione();
	private Appello appello1 = new Appello();
	private DataFormato dataFormato = new DataFormato();

	public Prenota() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String appello = request.getParameter("appello");
		String matricola = (String) session.getAttribute("matricola");

		try {

			

			int idmatri = Integer.parseInt(matricola);
			int idappel = Integer.parseInt(appello);
			
			
			prenotazione.inserire( idappel, idmatri);

			ResultSet data = appello1.ricerca(idappel);
			data.next();

			String dataScelta = dataFormato.dataIngToIta(data.getString("data"));

			ResultSet materia = query.getResult("select materia from appello where idappello='" + idappel + "'");
			materia.next();
			String nomeMateria = materia.getString(1);

			RequestDispatcher rd1 = request.getRequestDispatcher("studente.jsp");
			request.setAttribute("data", dataScelta);
			request.setAttribute("materia2", nomeMateria);
			rd1.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
