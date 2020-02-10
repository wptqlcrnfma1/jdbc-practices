package com.douzone.booksho.vo;

public class OrderVo {
	
	private String orderNo;
	private String orderName;
	private Long orderPrice;
	private String orderAddress;
	private Long memberNo;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Long getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Long orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	
	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", orderName=" + orderName + ", orderPrice=" + orderPrice
				+ ", orderAddress=" + orderAddress + ", memberNo=" + memberNo + "]";
	}
	
	
	
}
