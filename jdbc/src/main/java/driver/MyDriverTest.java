package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDriverTest {

	public static void main(String[] args) {
		
		try {
			//1. JDBC Driver(Mydriver) Loading
			Class.forName("driver.MyDriver");
			String url = "jdbc:mysql://127.0.0.1:9999/webdb";
			Connection connection = DriverManager.getConnection(url,"webdb","webdb");
			System.out.println(connection);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
