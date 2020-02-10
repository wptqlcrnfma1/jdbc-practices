package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.booksho.vo.MemberVo;

public class MemberDao {	
	
	public List<MemberVo> findAll(){
		List<MemberVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select *" + 
					     " from member" ;
					     
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//5. 결과 가져오기
			while(rs.next()) {
				Long memberNo = rs.getLong(1);
				String memberName = rs.getString(2);
				String memberTel = rs.getString(3);
				String memberEmail = rs.getString(4);
				String memberPassword = rs.getString(5);
				
				MemberVo vo = new MemberVo();
				
				vo.setMemberNo(memberNo);
				vo.setMemberName(memberName);
				vo.setMemberTel(memberTel);
				vo.setMemberEmail(memberEmail);
				vo.setMemberPassword(memberPassword);
						
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
	
	
	public Boolean insert(MemberVo memberVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into member values(null, ?, ?, ?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//insert into `member` values (null, '고객이름', '전화번호', '이메일', '비밀번호');
				
			pstmt.setString(1, memberVo.getMemberName());
			pstmt.setString(2, memberVo.getMemberTel());
			pstmt.setString(3, memberVo.getMemberEmail());
			pstmt.setString(4, memberVo.getMemberPassword());
			
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
			
			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url, "bookshop", "bookshop");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
			
	}
}
