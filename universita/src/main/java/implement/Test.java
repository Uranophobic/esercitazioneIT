package implement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws SQLException {	
		Lezione lo = new Lezione();
		//lo.inserire("Programmazione Object Oriented", "9:00", "aula1");
		//lo.modifica(5, "Programmazione Object Oriented", "8:00", "aula2");
//		ResultSet rs =lo.ricerca(5);
//		while(rs.next()) {
//			System.out.println(rs.getString(2));
//		}
		lo.elimina(5);
	}
}
 