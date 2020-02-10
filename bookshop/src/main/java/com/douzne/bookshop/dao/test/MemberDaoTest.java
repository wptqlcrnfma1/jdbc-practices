package com.douzne.bookshop.dao.test;

import java.util.List;

import com.douzone.booksho.vo.MemberVo;
import com.douzone.bookshop.dao.MemberDao;

public class MemberDaoTest {
	
	public static void main(String[] args) {

		//insertTest("김정석", "010-9636-1855", "zozfd@daum.net", "password");
		//insertTest("인순이", "010-1234-5678", "wptqlcrnfma1@naver.com", "password");
		
		selectTest();
		
		
	}
	
	public static void insertTest(String name, String tel, String email, String password) {
		MemberVo vo = new MemberVo();
		
		vo.setMemberName(name);
		vo.setMemberTel(tel);
		vo.setMemberEmail(email);
		vo.setMemberPassword(password);
		
		new MemberDao().insert(vo);
	}
	
	public static void selectTest() {
		System.out.println("******************멤버 리스트********************");
		List<MemberVo> list = new MemberDao().findAll();
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	}
	
}
