package com.douzne.bookshop.dao.test;

import java.util.List;

import com.douzone.booksho.vo.CartVo;
import com.douzone.bookshop.dao.CartDao;

public class CartDaoTest {

	public static void main(String[] args) {
		//insertTest(2L,1L,1L);
		//insertTest(3L,2L,1L);
		
		selectTest();
	}
	
	public static void insertTest(Long amount, Long bookNo, Long memberNo) {
		CartVo vo = new CartVo();
		
		vo.setCartAmount(amount);
		vo.setBookNo(bookNo);
		vo.setMemberNo(memberNo);
		
		new CartDao().insert(vo);
	}
	
	public static void selectTest() {
		System.out.println("******************카트 리스트********************");
		List<CartVo> list = new CartDao().findAll();
		for(CartVo vo : list) {
			System.out.println(
					"[도서제목]: " + vo.getTitle() + 
					", [수량]: " + vo.getCartAmount() +
					", [가격]: " + vo.getTotalPrice()
					);
		}
	}
	
}
