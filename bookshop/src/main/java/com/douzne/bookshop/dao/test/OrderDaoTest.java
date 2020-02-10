package com.douzne.bookshop.dao.test;

import java.util.List;

import com.douzone.booksho.vo.OrderBookVo;
import com.douzone.booksho.vo.OrderVo;
import com.douzone.bookshop.dao.OrderDao;

public class OrderDaoTest {

	public static void main(String[] args) {
		
		// insertTest("20200202-0001", "김정석", 51000L, "창원" , 1L);
		insertBookTest(2L, 1L, "20200202-0001");
		selectTest();
	}

	public static void insertTest(String orderNo, String orderName, Long orderPrice, String orderAddress,
			Long memberNo) {
		OrderVo vo = new OrderVo();

		vo.setOrderNo(orderNo);
		vo.setOrderName(orderName);
		vo.setOrderPrice(orderPrice);
		vo.setOrderAddress(orderAddress);
		vo.setMemberNo(memberNo);

		new OrderDao().insert(vo);
	}

	public static void insertBookTest(Long cartAmount ,Long bookNo, String orderNo) {
		OrderBookVo vo = new OrderBookVo();
		
		vo.setCartAmount(cartAmount);
		vo.setBookNo(bookNo);
		vo.setOrderNo(orderNo);
		
		new OrderDao().insertBook(vo);
	}

	public static void selectTest() {
		System.out.println("******************주문 리스트********************");
		List<OrderVo> orderList = new OrderDao().findAll();
		for (OrderVo vo : orderList) {
			System.out.println("[주문번호]: " + vo.getOrderNo() + " [주문자]: " + vo.getOrderName() + " [주문가격]: "
					+ vo.getOrderPrice() + " [배송지]: " + vo.getOrderAddress());

			List<OrderBookVo> orderBookList = new OrderDao().findAllBook(vo.getOrderNo());
			
			for (OrderBookVo vo2 : orderBookList) {
				System.out.println("       [책번호]: " + vo2.getBookNo() + " [책제목]: " + vo2.getBookTitle() + " [수량]: "
						+ vo2.getCartAmount());
			}
		}
	}
}
