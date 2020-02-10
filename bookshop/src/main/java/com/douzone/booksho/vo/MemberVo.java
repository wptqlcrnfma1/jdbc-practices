package com.douzone.booksho.vo;

public class MemberVo {
	private Long memberNo;
	private String memberName;
	private String memberTel;
	private String memberEmail;
	private String memberPassword;
	
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	
	@Override
	public String toString() {
		return "MemberVo [memberNo=" + memberNo + ", memberName=" + memberName + ", memberTel=" + memberTel
				+ ", memberEmail=" + memberEmail + ", memberPassword=" + memberPassword + "]";
	}
	
	
	
}
