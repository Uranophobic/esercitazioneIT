package control;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implement.Studente;
import implement.Ticket;


@WebServlet("/ApriTicket")
public class TicketControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Studente studente = new Studente();
       private Ticket ticket = new Ticket();
       private String matricola1 = "";
   
    public TicketControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session;
		matricola1 =  request.getParameter("matricola");
		
		try {
			ResultSet rs = studente.ricerca(matricola1);
			rs.next();
			String matricola = rs.getString(1);
			String nome = rs.getString("nome");
			String cognome = rs.getString("cognome");
			String richiesta = "";
			String idtickect = "";
			rs = ticket.lista();
			System.out.println();
			while(rs.next()) {
				
				if (rs.getString("idstud").equals(matricola)) {
					idtickect=rs.getString("idticket");
					richiesta=rs.getString("richiesta");
					
				}
			}
			
			session = request.getSession(true); // se la sessione esiste(esiste l'oggetto session) altrimenti ti
												// crea un oggetto di tipo HttpSession
			session.setAttribute("matricola", matricola);
			session.setAttribute("nome", nome);
			session.setAttribute("cognome", cognome);
			session.setAttribute("richiesta", richiesta);
			session.setAttribute("idticket", idtickect);
			RequestDispatcher rd = request.getRequestDispatcher("ticket.jsp"); 
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		// con resultset abbiamo preso la
																				// tabella dei corsi disponibili
		
		
	}

}
