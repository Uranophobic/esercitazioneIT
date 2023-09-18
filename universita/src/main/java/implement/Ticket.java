package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Connessione;

public class Ticket {
	private Connection con = null;

// non mettere la primary-key nell'inserimento
	public void inserire(int idstud, String titolo, String richiesta) {
		boolean chiuso = false;
		String query = "INSERT INTO ticket(idstud, titolo, richiesta, chiuso) values(?,?,?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, idstud);
			pst.setString(2, titolo);
			pst.setString(3, richiesta);
			pst.setBoolean(4, chiuso);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

// non fare set per primary-key
	public void modifica(int idticket, boolean chiuso) {
		String query = "UPDATE ticket SET  chiuso = ? WHERE idticket ='" + idticket + "'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setBoolean(1, chiuso);

			pst.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

// eliminare sempre per primary-key
	public void elimina(int idticket) {
		String query = "DELETE FROM ticket WHERE idticket ='" + idticket + "'";

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
		String query = "SELECT * FROM ticket";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			result = pst.executeQuery();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public ResultSet ricerca(int idticket) {
		ResultSet result = null;
		String query = "SELECT * FROM ticket WHERE idticket ='" + idticket + "'";
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