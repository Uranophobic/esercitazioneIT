package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Connessione;

public class Lezione {
	private Connection con = null;

	// non mettere la primary-key nell'inserimento
	public void inserire(String materia, String orario, String aula ) {
		
		String query = "INSERT INTO lezione(materia, orario, aula) values(?,?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, materia);
			pst.setString(2, orario);
			pst.setString(3, aula);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// non fare set per primary-key
	public void modifica(int idcorso, String materia, String orario, String aula) {
        String query = "UPDATE lezione SET materia = ?, orario = ?, aula = ? WHERE idcorso ='"+idcorso+"'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, materia);
			pst.setString(2, orario);
			pst.setString(3, aula);
			pst.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// eliminare sempre per primary-key
    public void elimina(int idcorso) {
        String query = "DELETE FROM lezione WHERE idcorso ='"+idcorso+"'";
        
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
        String query = "SELECT * FROM lezione";
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            result = pst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public ResultSet ricerca(int idcorso) {
        ResultSet result = null;
        String query = "SELECT * FROM lezione WHERE idcorso ='"+idcorso+"'";
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
