package com.douzone.bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private String state;
	private Long authorNo;
	// private AuthorVo author; 원래 도메인 분석해서 이렇게 해야하는데 데이터모델로했고 칼럼의 row를 모델로 받아쓰기때문에
	// 이렇게 하지않고 밑에처럼 한다.
	private String authorName;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", state=" + state + ", authorNo=" + authorNo + ", authorName="
				+ authorName + "]";
	}

}
