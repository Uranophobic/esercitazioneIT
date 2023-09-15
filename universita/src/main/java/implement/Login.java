package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import control.Connessione;


public class Login {
	
	private Connection conn = null;
	
	public ResultSet student(String username, String password) {
		ResultSet rsr = null;

		try {

			conn = Connessione.getInstance().getConnection();
			Statement smt = conn.createStatement(); // ci siamo presi le user e password dalla tabella studente
			ResultSet rs = smt.executeQuery("select username,password from studente where username='"+username+"' and password='"+password+"'");
			
			while (rs.next()) {
				if (rs.getString("username").equals(username)&& rs.getString("password").equals(password)) {
					PreparedStatement smt1 = conn.prepareStatement("select matricola from studente where username=?");
					smt1.setString(1, username); // abbiamo chiesto la stringa relativa all' username e password
					rsr = smt1.executeQuery(); // restituisce la collection contenente la matricola
				}
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return rsr;
	}
	
	public ResultSet prof(String username, String password) {
		ResultSet rsr = null;

		try {
			conn = Connessione.getInstance().getConnection();
			Statement smt3= conn.createStatement();
			ResultSet rs3= smt3.executeQuery("select username,password from professore where username='"+username+"' and password ='"+password+"'");
			
			while(rs3.next()) {
				if(rs3.getString("username").equals(username)&&rs3.getString("password").equals(password)){ 
					PreparedStatement smt4=conn.prepareStatement("select nome,cognome,idProfessore from professore where username=?"); 
					smt4.setString(1, username);
					 rsr= smt4.executeQuery();
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return rsr;
	}

	
	public ResultSet corso(int idprofe) {

		ResultSet rs5 = null;

		try {
			
			PreparedStatement smt6=conn.prepareStatement("select nome_materia from materia where id_prof=?");
			smt6.setInt(1, idprofe);
			ResultSet rs6 = smt6.executeQuery();
			rs6.next();
			String materia = rs6.getString("nome_materia");
			PreparedStatement smt5=conn.prepareStatement("select idcorso, materia from lezione where materia=?");
			smt5.setString(1,materia);
			 rs5=smt5.executeQuery();
		} catch  (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rs5;
	}

	public ResultSet appelli(String materia) {
		ResultSet appelli = null;

		try {
			
			conn = Connessione.getInstance().getConnection();

			PreparedStatement smt6=conn.prepareStatement("select idAppello,data from appello where materia=?");
			smt6.setString(1, materia);
			 appelli=smt6.executeQuery();
		

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return appelli;
	}
	
	public ResultSet tabella() {
		ResultSet rs2 =null;
		
		try {
			conn = Connessione.getInstance().getConnection();
			Statement smt2=conn.createStatement();

			 rs2=smt2.executeQuery("select idcorso,materia ,nome,cognome from lezione, professore, materia where materia = nome_materia and id_prof = idprofessore");
			

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return rs2;
	}
}
