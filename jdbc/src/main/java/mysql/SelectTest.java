package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			//3. Statement 객체 생성
			stmt = conn.createStatement();
			
			//4. SQL문 실행
			String sql = "select no, name from dept;"; //SELECT문 입력
			rs = stmt.executeQuery(sql); //select는 executeQuery 나머지는 executeUpdate //resultset이란 객체에 row가 하나씩 저장되어 있다.
			
			//5. 결과 가져오기
			while(rs.next()) { //rs가 true 즉 있으면
				Long no = rs.getLong(1); //0부터 시작하지 않는다. 받을때는 long값으로 받는다.
				String name = rs.getString(2);
				System.out.println(no+":"+name);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			//6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
