package com.douzne.bookshop.dao.test;

import java.util.List;

import com.douzone.booksho.vo.BookVo;
import com.douzone.bookshop.dao.BookDao;

public class BookDaoTest {

	public static void main(String[] args) {
		
		//insertTest("모모", 12000L, 1L);
		//insertTest("운수좋은 날", 15000L, 2L);
		//insertTest("인문학과 컴퓨터", 30000L, 3L);
		
		selectTest();
	}
	
	public static void insertTest(String title, Long price, Long categoryNo) {
		BookVo vo = new BookVo();
		
		vo.setBookTitle(title);
		vo.setBookPrice(price);
		vo.setCategoryNo(categoryNo);
		
		new BookDao().insert(vo);
	}
	
	public static void selectTest() {
		System.out.println("******************상품 리스트********************");
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(
							"[카테고리]: " + vo.getCategoryName() +
							", [제목]: " + vo.getBookTitle() +
							", [가격]: " + vo.getBookPrice()
					);
		}
	}
}
