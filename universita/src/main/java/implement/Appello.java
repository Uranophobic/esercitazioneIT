package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.Connessione;

public class Appello {	

	private Connection con = null;

	// non mettere la primary-key nell'inserimento
	public void inserire(String data, String aula, String orario, String materia ) {
		
		String query = "INSERT INTO appello(data, aula, orario, materia) values(?,?,?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, data);
			pst.setString(2, aula);
			pst.setString(3, orario);
			pst.setString(4, materia);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	// non fare set per primary-key
	public void modifica(int idappello, String data, String aula, String orario, String materia) {
        String query = "UPDATE appello SET data = ?, aula = ?, orario = ?, materia = ? WHERE idappello ='"+idappello+"'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, data);
			pst.setString(2, aula);
			pst.setString(3, orario);
			pst.setString(4, materia);
			pst.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// eliminare sempre per primary-key
    public void elimina(int idappello) {
        String query = "DELETE FROM appello WHERE idappello ='"+idappello+"'";
        
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
        String query = "SELECT * FROM appello";
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            result = pst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public ResultSet ricerca(int idappello) {
        ResultSet result = null;
        String query = "SELECT * FROM appello WHERE idappello ='"+idappello+"'";
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
