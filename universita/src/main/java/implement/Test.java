package implement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws SQLException {
		Iscrizione ap = new Iscrizione();
		
		//ap.inserire(100, "Ingegneria del software"); // inserisce con 7
		//ap.modifica(10, 101, "Ingegneria del software");
		// ap.elimina(10);
		
		/*ResultSet rs = ap.lista();
		while(rs.next())
			System.out.println("Lista : " +rs.getString("nome_mat"));
		*/
		
		/*
		rs = ap.ricerca(1);
		rs.next();
		System.out.println("\nRicerca : " +rs.getString("nome_mat"));
		*/
		
	}
}
 