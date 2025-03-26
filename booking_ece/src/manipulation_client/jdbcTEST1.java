package manipulation_client;
import java.sql.*;

public class jdbcTEST1 {

	public static void main( String args[] ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
			con.close();
		} catch ( Exception e ) {
			System.out.println(e.getMessage());
		}
	}
	
}
