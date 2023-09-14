package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Connessione;

public class Iscrizione  {

	private Connection con = null;

	// non mettere la primary-key nell'inserimento
	public void inserire(int matr_stud, String nome_mat ) {
		
		String query = "INSERT INTO iscrizione(matr_stud, nome_mat) values(?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, matr_stud);
			pst.setString(2, nome_mat);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// non fare set per primary-key
	public void modifica(int idiscrizione, int matr_stud, String nome_mat ) {
        String query = "UPDATE iscrizione SET matr_stud = ?, nome_mat = ? WHERE idiscrizione ='"+idiscrizione+"'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, matr_stud);
			pst.setString(2, nome_mat);
			pst.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// eliminare sempre per primary-key
    public void elimina(int idiscrizione) {
        String query = "DELETE FROM iscrizione WHERE idiscrizione ='"+idiscrizione+"'";
        
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
        String query = "SELECT * FROM iscrizione";
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            result = pst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public ResultSet ricerca(int idiscrizione) {
        ResultSet result = null;
        String query = "SELECT * FROM iscrizione WHERE idiscrizione ='"+idiscrizione+"'";
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
