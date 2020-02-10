package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.booksho.vo.OrderBookVo;
import com.douzone.booksho.vo.OrderVo;

public class OrderDao {

	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select a.orders_no , concat( a.orders_name, '/', b.member_email), a.orders_price,  a.orders_address \r\n"
					+ "from orders a, `member` b\r\n" + "where a.member_no =b.member_no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {
				String orderNo = rs.getString(1);
				String orderName = rs.getString(2);
				Long orderPrice = rs.getLong(3);
				String orderAddress = rs.getString(4);

				OrderVo vo = new OrderVo();

				vo.setOrderNo(orderNo);
				vo.setOrderName(orderName);
				vo.setOrderPrice(orderPrice);
				vo.setOrderAddress(orderAddress);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
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

	public List<OrderBookVo> findAllBook(String no) {
		List<OrderBookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select a.book_no, a.book_title, b.orderbook_amount\r\n" + "from book a,orderbook b"
					+ " where a.book_no =b.book_no and b.orders_no = ? order by book_no";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();

			// 5. 결과 가져오기
			while (rs.next()) {
				Long bookNo = rs.getLong(1);
				String bookTitle = rs.getString(2);
				Long cartAmount = rs.getLong(3);
			
				OrderBookVo vo = new OrderBookVo();

				vo.setBookNo(bookNo);
				vo.setBookTitle(bookTitle);
				vo.setCartAmount(cartAmount);
			
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
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

	public Boolean insert(OrderVo orderVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into orders values(?, ?, ?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, orderVo.getOrderNo());
			pstmt.setString(2, orderVo.getOrderName());
			pstmt.setLong(3, orderVo.getOrderPrice());
			pstmt.setString(4, orderVo.getOrderAddress());
			pstmt.setLong(5, orderVo.getMemberNo());

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원정리
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
	
	public Boolean insertBook(OrderBookVo orderBookVo) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// insert into orderbook values ( 1,2 ,'20200202-0001' );
			
			String sql = "insert into orderbook values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, orderBookVo.getCartAmount());
			pstmt.setLong(2, orderBookVo.getBookNo());
			pstmt.setString(3, orderBookVo.getOrderNo());
			
			
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원정리
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
