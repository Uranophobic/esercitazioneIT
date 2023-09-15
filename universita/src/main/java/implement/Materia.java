package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Connessione;

public class Materia {

	
	private Connection con = null;

	// non mettere la primary-key nell'inserimento
	public void inserire(String nome_materia, int id_prof, int anno_corso, int semestre, int cfu ) {
		
		String query = "INSERT INTO materia(nome_materia, id_prof, anno_corso, semestre, cfu) values(?,?,?,?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, nome_materia);
			pst.setInt(2, id_prof);
			pst.setInt(3, anno_corso);
			pst.setInt(4, semestre);
			pst.setInt(5, cfu);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// non fare set per primary-key
	public void modifica(String nome_materia, int id_prof, int anno_corso, int semestre, int cfu, String nuovo_nome_materia) {
		String query = "UPDATE materia SET nome_materia = ?, id_prof = ?, anno_corso = ?, semestre = ?, cfu = ? WHERE nome_materia ='"+nome_materia+"'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,nuovo_nome_materia);
			pst.setInt(2, id_prof);
			pst.setInt(3, anno_corso);
			pst.setInt(4, semestre);
			pst.setInt(5, cfu);
			pst.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// eliminare sempre per primary-key
    public void elimina(String nome_materia) {
        String query = "DELETE FROM materia WHERE nome_materia ='"+nome_materia+"'";
        
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
        String query = "SELECT * FROM materia";
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            result = pst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public ResultSet ricerca(String nome_materia) {
        ResultSet result = null;
        String query = "SELECT * FROM materia WHERE nome_materia ='"+nome_materia+"'";
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
