package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Connessione;

public class Professore {
	private Connection con = null;

	// non mettere la primary-key nell'inserimento
	public void inserire(String nome, String cognome, String username,String password ) {
		
		String query = "INSERT INTO professore(nome, cognome, username,password) values(?,?,?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, username);
			pst.setString(4, password);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// non fare set per primary-key
	public void modifica(int idprofessore,String nome, String cognome, String username,String password) {
        String query = "UPDATE professore SET nome = ?, cognome = ?, username = ?, password = ? WHERE idprofessore ='"+idprofessore+"'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, username);
			pst.setString(4, password);
			pst.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// eliminare sempre per primary-key
    public void elimina(int idprofessore) {
        String query = "DELETE FROM professore WHERE idprofessore ='"+idprofessore+"'";
        
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
        String query = "SELECT * FROM professore";
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            result = pst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public ResultSet ricerca(int idprofessore) {
        ResultSet result = null;
        String query = "SELECT * FROM professore WHERE idprofessore ='"+idprofessore+"'";
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