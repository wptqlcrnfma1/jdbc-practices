package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;

public class BookDao {
	
	public List<BookVo> findAll(){
		List<BookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select a.title , b.name , a.state , b.no, a.author_no" + 
					     " from book a, author b" + 
					     " where a.author_no = b.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//5. 결과 가져오기
			while(rs.next()) {
				String title = rs.getString(1);
				String authorName = rs.getString(2);
				String state = rs.getString(3);
				Long no = rs.getLong(4);
				Long authorNo = rs.getLong(5);
				
				BookVo vo = new BookVo();
				
				vo.setTitle(title);
				vo.setAuthorName(authorName);
				vo.setState(state);
				vo.setNo(no);
				vo.setAuthorNo(authorNo);
				
				
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			//6. 자원정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		
		return result;
	}
	
	public Boolean update(BookVo vo) {
		return false;
	}

	public Boolean update(Long no, String status) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();


			String sql = " update book " + 
						"  set status=? " + 
						" where no=? ";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, status);
			pstmt.setLong(2, no);

			int count = pstmt.executeUpdate();
			result = count == 1; 

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (pstmt != null) {
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
	
	public Boolean insert(BookVo bookVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getState());
			pstmt.setLong(3, bookVo.getAuthorNo());
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			//6. 자원정리
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;		
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
			
	}
}
