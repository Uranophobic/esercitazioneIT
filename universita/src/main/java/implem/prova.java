package implem;

<<<<<<< HEAD
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
=======
public class prova {
	
	public static void main(String[] args) {
		
		Login l = new Login();
		try {
			if (l.prof("stud1", "stud1")!=null) {
				System.out.println("Im teach");
			}else if (l.student("stud1", "stud1")!=null){
				System.out.println("Im student");
			}else {
				System.out.println("non ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
>>>>>>> 5f8cbf54f3668974da98bf69ec422278f0f9856a
	}

}
