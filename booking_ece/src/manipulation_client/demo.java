package manipulation_client;
import javax.swing.*;
import java.sql.*;

public class demo {

	public static void main( String args[] ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			JFrame F1 = new JFrame();
			F1.setSize(600,600);
			F1.setTitle("Booking.ECE");
			MasterPanel MP1 = new MasterPanel();
			F1.add(MP1);
			F1.setVisible(true);
		} catch ( Exception E1 ) {
			E1.printStackTrace();
		}
	
	}
}
