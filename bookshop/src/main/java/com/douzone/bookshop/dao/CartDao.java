package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.booksho.vo.CartVo;

public class CartDao {

	public List<CartVo> findAll(){
		List<CartVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select b.book_title, c.cart_amount , b.book_price*c.cart_amount"
					 + " from `member` a, book b, cart c"
					 + " where a.member_no =c.member_no" 
					 + " and b.book_no =c.book_no";
					     
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//5. 결과 가져오기
			while(rs.next()) {		
				String title = rs.getString(1);
				Long cartAmount = rs.getLong(2);
				Long totalPrice = rs.getLong(3);
					
				CartVo vo = new CartVo();
				
				vo.setTitle(title);
				vo.setCartAmount(cartAmount);
				vo.setTotalPrice(totalPrice);
				
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
	
	
	public Boolean insert(CartVo cartVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();

			String sql = "insert into cart values(? , ? , ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, cartVo.getCartAmount());
			pstmt.setLong(2, cartVo.getBookNo());
			pstmt.setLong(3, cartVo.getMemberNo());

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
