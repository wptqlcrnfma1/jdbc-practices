package com.douzone.bookshop.main.test;

import com.douzne.bookshop.dao.test.BookDaoTest;
import com.douzne.bookshop.dao.test.CartDaoTest;
import com.douzne.bookshop.dao.test.CategoryDaoTest;
import com.douzne.bookshop.dao.test.MemberDaoTest;
import com.douzne.bookshop.dao.test.OrderDaoTest;

public class run {
	
	public static void main(String[] args) {
		MemberDaoTest.insertTest("김정석", "010-9636-1855", "zozfd@daum.net", "password");
		MemberDaoTest.insertTest("인순이", "010-1234-5678", "wptqlcrnfma1@naver.com", "password");

		CategoryDaoTest.insertTest("소설");
		CategoryDaoTest.insertTest("수필");
		CategoryDaoTest.insertTest("컴퓨터/IT");
		
		BookDaoTest.insertTest("모모", 12000L, 1L);
		BookDaoTest.insertTest("운수좋은 날", 15000L, 2L);
		BookDaoTest.insertTest("인문학과 컴퓨터", 30000L, 3L);
				
		CartDaoTest.insertTest(2L, 1L, 1L);
		CartDaoTest.insertTest(3L, 2L, 1L);
		
		OrderDaoTest.insertTest("20200202-0001", "김정석", 69000L, "창원" , 1L); //order
		
		OrderDaoTest.insertBookTest(3L, 2L, "20200202-0001"); //orderbook
		OrderDaoTest.insertBookTest(2L, 3L, "20200202-0001");
		
		MemberDaoTest.selectTest();
		CategoryDaoTest.selectTest();
		BookDaoTest.selectTest();
		CartDaoTest.selectTest();
		
		OrderDaoTest.selectTest();
	}
}
