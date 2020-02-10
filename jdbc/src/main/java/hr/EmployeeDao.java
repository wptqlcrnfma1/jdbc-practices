package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public Boolean insert(EmployeeVo vo) {
		return false;
	}
	
	public Boolean delete(Long no) {
		return false;
	}
	
	public Boolean delete(String firstName) {
		return false;
	}
	
	public List<EmployeeVo> FindByName(EmployeeVo vo){
		List<EmployeeVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees";
			conn = DriverManager.getConnection(url, "root", "manager");

			
			
			//3. SQL문 준비(Prepare, 완성된 쿼리가 아님, 파라미터바인딩)
			String sql = "select emp_no, first_name, last_name, hire_date" +
					" from employees" +
					" where first_name like ?" +
					" order by first_name";

			pstmt = conn.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString(1, "%" + vo.getFirstName() + "%");
			
			//5 SQL문 실행
			rs = pstmt.executeQuery(); //(sql)하면 안된다. 바인딩이 되어있는 그대로 sql을 날리기 때문에 넣으면 에러
			
			//5. 결과 바인딩
			while(rs.next()) { //rs가 true 즉 있으면
				Long no = rs.getLong(1); //0부터 시작하지 않는다. 받을때는 long값으로 받는다.
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);
				
				EmployeeVo employeeVo = new EmployeeVo();
				employeeVo.setNo(no);
				employeeVo.setFirstName(firstName);
				employeeVo.setLastName(lastName);
				employeeVo.setHireDate(hireDate);
				
				result.add(employeeVo); //순서대로 하나씩 넣어두고 사라지지 않도록 관리
				
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
				if(pstmt != null) {
					pstmt.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		return result;
	}
	
	
	
}
