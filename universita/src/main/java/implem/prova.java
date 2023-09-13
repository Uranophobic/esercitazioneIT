package implem;

import java.sql.ResultSet;

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
	

	}

}
