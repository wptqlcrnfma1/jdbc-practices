package com.douzone.booksho.vo;

public class OrderBookVo {

	private Long bookNo;
	private String bookTitle;
	private Long cartAmount;
	private String orderNo;
	
	
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public Long getCartAmount() {
		return cartAmount;
	}
	public void setCartAmount(Long cartAmount) {
		this.cartAmount = cartAmount;
	}
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "OrderBookVo [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", cartAmount=" + cartAmount
				+ ", orderNo=" + orderNo + "]";
	}
}