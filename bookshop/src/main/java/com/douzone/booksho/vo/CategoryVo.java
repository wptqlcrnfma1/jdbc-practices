package com.douzone.booksho.vo;

public class CategoryVo {
	private Long categoryNo;
	private String categoryName;
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + "]";
	}
	
	
}
