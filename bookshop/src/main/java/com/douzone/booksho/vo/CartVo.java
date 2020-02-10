package com.douzone.booksho.vo;

public class CartVo {
	private Long cartAmount;
	private Long bookNo;
	private Long memberNo;
	private String title;
	private Long totalPrice;
	public Long getCartAmount() {
		return cartAmount;
	}
	public void setCartAmount(Long cartAmount) {
		this.cartAmount = cartAmount;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "CartVo [cartAmount=" + cartAmount + ", bookNo=" + bookNo + ", memberNo=" + memberNo + ", title=" + title
				+ ", totalPrice=" + totalPrice + "]";
	}
	
}
