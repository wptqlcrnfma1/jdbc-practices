package com.douzne.bookshop.dao.test;

import java.util.List;

import com.douzone.booksho.vo.CategoryVo;
import com.douzone.bookshop.dao.CategoryDao;

public class CategoryDaoTest {
	
	public static void main(String[] args) {
		//insert into `member` values (null, '고객이름', '전화번호', '이메일', '비밀번호');
		
		//insertTest("소설");
		//insertTest("수필");
		//insertTest("컴퓨터/IT");
		
		selectTest();
	}
	

	public static void insertTest(String name) {
		CategoryVo vo = new CategoryVo();
		
		vo.setCategoryName(name);
		
		new CategoryDao().insert(vo);
	}
	
	public static void selectTest() {
		System.out.println("******************카테고리 리스트********************");
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}
