package driver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class MyDriver implements Driver {
	static {
		//로딩될 때 제일 먼저 실행된다. mysql의 경우 여기서 connection한다.
		try {
			System.out.println("static code area");
			DriverManager.registerDriver(new MyDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean acceptsURL(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		System.out.println("url : "+ url);
		System.out.println("info :" + info);
		return new Myconnection();
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String arg0, Properties arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

}
