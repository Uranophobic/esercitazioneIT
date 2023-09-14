package mypackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implem.Login;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username"); // abbiamo preso username e password
		String password = request.getParameter("password");

		Login lo = new Login();

		try {

			HttpSession session;

			if (lo.prof(username, password) != null) {
				
				session = request.getSession(true);
				ResultSet rs4 = lo.prof(username, password);
				rs4.next();

				String nome = rs4.getString("nome");
				String cognome = rs4.getString("cognome");
				int  idProfessore = rs4.getInt("idProfessore");
				
				ResultSet rs5 =lo.corso(idProfessore);
				rs5.next();
				
				String lezionemateria = rs5.getString("materia");
			
				ResultSet appelli = lo.appelli(lezionemateria);
				
				
				session.setAttribute("nome", nome);
				session.setAttribute("cognome", cognome);
				RequestDispatcher rd4 = request.getRequestDispatcher("professore.jsp");
				session.setAttribute("materia", lezionemateria);
				request.setAttribute("appelli", appelli);
				rd4.forward(request, response);
				
			} else if (lo.student(username, password) != null) {
				
				lo.tabella();
				ResultSet rs= lo.student(username, password);
				rs.next();
				String matricola = rs.getString(1);
				session = request.getSession(true); // se la sessione esiste(esiste l'oggetto session) altrimenti ti
													// crea un oggetto di tipo HttpSession
				session.setAttribute("matricola", matricola);
				RequestDispatcher rd = request.getRequestDispatcher("studente.jsp"); // con resultset abbiamo preso la
																						// tabella dei corsi disponibili
				request.setAttribute("tabella_corso", lo.tabella());
				rd.forward(request, response);
				
			} else {

				// ci vuole un controllo
				RequestDispatcher rd3 = request.getRequestDispatcher("index.jsp");
				String messaggio = "username e password non sono presenti";
				request.setAttribute("messaggio", messaggio);
				rd3.forward(request, response);

			}
	


		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

	}
}
