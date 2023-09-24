package implement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		Studente studente = new Studente();
	
		Login login = new Login();
		ResultSet rs = login.prof("s.rossi", "s.rossi");
		try {
			while(rs.next()) {
				System.out.println( rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
