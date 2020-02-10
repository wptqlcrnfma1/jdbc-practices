package com.douzone.bookmall.test;

import java.util.List;
import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//insert into book values(1,'트와일라잇', '대여가능', 1);
		
		insertTest("트와일라잇1", "대여가능", 1L);	
		insertTest("뉴문", "대여가능", 2L);		
		insertTest("아리랑", "대여가능", 3L);
		
		selectTest();
		
	}
	
	public static void insertTest(String title, String state, Long authorNo) {
		BookVo vo = new BookVo();

		vo.setTitle(title);
		vo.setState(state);
		vo.setAuthorNo(authorNo);

		new BookDao().insert(vo);
		
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}

}
