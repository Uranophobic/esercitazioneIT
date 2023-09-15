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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Prenota
 */
@WebServlet("/Prenota")
public class Prenota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prenota() {
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
		HttpSession session= request.getSession();
		String appello = request.getParameter("appello");
		String matricola=(String) session.getAttribute("matricola");
	
		Connection conn=null; 	
		try {
			conn = Connessione.getInstance().getConnection();
			Statement smt23=conn.createStatement();

			ResultSet rs2=smt23.executeQuery("SELECT id_prof FROM  materia  WHERE nome_materia = ( SELECT materia FROM appello WHERE idappello='"+appello+"' )");
			rs2.next();
			String idprof =rs2.getString(1);
			PreparedStatement smt2 = conn.prepareStatement("insert into prenotazione (matricola_stud ,id_app , id_prof) values (CAST(? AS UNSIGNED INTEGER),CAST(? AS UNSIGNED INTEGER),CAST(? AS UNSIGNED INTEGER))");
			smt2.setString(1, matricola);
			smt2.setString(2, appello);
			smt2.setString(3, idprof);
			smt2.executeUpdate();
			PreparedStatement recuperoData = conn.prepareStatement("select data from appello where idAppello=CAST(? AS UNSIGNED INTEGER)");
			recuperoData.setString(1, appello);
			ResultSet data=recuperoData.executeQuery();
			data.next();
			String dataScelta=data.getString(1);
			PreparedStatement recuperoMateria=conn.prepareStatement("select materia from lezione where idcorso=CAST(? AS UNSIGNED INTEGER)");
			recuperoMateria.setString(1, appello);
			ResultSet materia=recuperoMateria.executeQuery();
			materia.next();
			String nomeMateria=materia.getString(1);
			RequestDispatcher rd1=request.getRequestDispatcher("studente.jsp");
			
			request.setAttribute("data", dataScelta);
			request.setAttribute("materia2", nomeMateria);
			rd1.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
