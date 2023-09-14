package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connessione {

	private static Connessione instance;

	public static Connessione getInstance() {
		if (instance == null) {
			instance = new Connessione();
		}
		return instance;
	}

	private Connection conn;

	private Connessione() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "root");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universita", connectionProps);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		return conn;
	}

}