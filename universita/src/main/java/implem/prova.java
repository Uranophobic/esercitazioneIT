package implem;


import java.sql.ResultSet;

import data.DataFormato;

public class prova {

	public static void main(String[] args) {
	Login l = new Login();
	try {
	ResultSet a =l.appelli("Ingegneria del software");
	a.next();
	String data =a.getString("data");
	System.out.println(a.getString("data"));
	DataFormato da = new DataFormato();
	
	System.out.println(da.dataIngToIta(data));
	}catch (Exception e) {
		// TODO: handle exception
	}


	}
}