package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Connessione;

public class Studente {

	private Connection con = null;

	// non mettere la primary-key nell'inserimento
	public void inserire(int matricola, String nome, String cognome, String username,String password, String corso_di_laurea, String anno_immatricolazione ) {
		
		String query = "INSERT INTO Studente(matricola, nome, cognome, username, password, corso_di_laurea, anno_immatricolazione) values(?,?,?,?,?,?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, matricola);
			pst.setString(2, nome);
			pst.setString(3, cognome);
			pst.setString(4, username);
			pst.setString(5, password);
			pst.setString(6, corso_di_laurea);
			pst.setString(7, anno_immatricolazione);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// non fare set per primary-key
	public void modifica(int matricola, String nome, String cognome, String username,String password, String corso_di_laurea, String anno_immatricolazione) {
		String query = "UPDATE studente SET matricola = ?, nome = ?, cognome = ?, username = ?, password = ?, corso_di_laurea = ?, anno_immatricolazione = ? WHERE matricola ='"+matricola+"'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,matricola);
			pst.setString(2, nome);
			pst.setString(3, cognome);
			pst.setString(4, username);
			pst.setString(5, password);
			pst.setString(6, corso_di_laurea);
			pst.setString(7, anno_immatricolazione);
			pst.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// eliminare sempre per primary-key
    public void elimina(String matricola) {
        String query = "DELETE FROM studente WHERE matricola ='"+matricola+"'";
        
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
        String query = "SELECT * FROM studente";
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            result = pst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public ResultSet ricerca(String matricola) {
        ResultSet result = null;
        String query = "SELECT * FROM studente WHERE matricola ='"+matricola+"'";
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
