package dao;

import java.sql.*;
import java.util.*;

public class demo_script {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Client C1 = new Client();
			ArrayList<Client> list1 = C1.getAll();
			for ( Client C : list1 ) {
				C.afficher();
			}
		} catch ( ClassNotFoundException CNFE1 ) {
			CNFE1.printStackTrace();
		} catch (SQLException SQLE1) {
			SQLE1.printStackTrace();
		}
	}

}
