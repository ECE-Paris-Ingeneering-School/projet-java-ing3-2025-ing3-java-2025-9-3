package manipulation_client;
import java.sql.*;
import java.util.*;

public class communicator {

	public static void main( String args[] ) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Client C2 = new Client( "SkibidiBiden" , "MODEPA3" , "INDATE3" , "Client" );
			
			ArrayList<Client> liste1 = Client.LireTout();
			System.out.println(liste1.size());
			
			//conn1.close();
			
        } catch ( Exception E1 ) {
        	E1.printStackTrace();
        } finally {
        	System.out.println("FIN");
        }
	}
	
}
