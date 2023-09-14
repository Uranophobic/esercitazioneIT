package implement;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws SQLException {	
		
		Studente s= new Studente();
		s.inserire(103, "Paolo", "Bianchi", "p.Bianchi", "p.bianchi", "Triennale Informatica", "2020");
		
	}
}
 