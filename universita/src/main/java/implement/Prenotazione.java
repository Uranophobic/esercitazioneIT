package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Connessione;

public class Prenotazione {

	private Connection con = null;

	// non mettere la primary-key nell'inserimento
	public void inserire(int id_prof, int id_app, int matricola_stud) {
		
		
		String query = "INSERT INTO prenotazione(id_prof, id_app, matricola_stud) values(?,?,?)";
		ResultSet r = lista();
		try {
		while (r.next()) {
			if (r.getString("id_prof").equals(id_prof) && r.getString("id_app").equals(id_app) && r.getString("matricola_stud").equals(matricola_stud)) {
			
					con = Connessione.getInstance().getConnection();
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1, id_prof);
					pst.setInt(2, id_app);
					pst.setInt(3, matricola_stud);
					pst.executeUpdate() ;
				
		}
		} 
	}catch (SQLException | ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}
		
		
	}

	// non fare set per primary-key
	public void modifica(int idprenotazione, int id_prof, int id_app, int matricola_stud) {
		String query = "UPDATE prenotazione SET id_prof = ?, id_app = ?, matricola_stud = ? WHERE idprenotazione ='"
				+ idprenotazione + "'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id_prof);
			pst.setInt(2, id_app);
			pst.setInt(3, matricola_stud);
			pst.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// eliminare sempre per primary-key
	public void elimina(int idprenotazione) {
		String query = "DELETE FROM prenotazione WHERE idprenotazione ='" + idprenotazione + "'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet lista() {
		ResultSet result = null;
		String query = "SELECT * FROM prenotazione";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			result = pst.executeQuery();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public ResultSet ricerca(int idprenotazione) {
		ResultSet result = null;
		String query = "SELECT * FROM prenotazione WHERE idprenotazione ='" + idprenotazione + "'";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			result = pst.executeQuery();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
