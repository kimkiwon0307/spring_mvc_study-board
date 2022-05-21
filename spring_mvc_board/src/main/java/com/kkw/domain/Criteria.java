package com.kkw.domain;

import lombok.Data;

@Data
public class Criteria {
	
	private int pageNum;  //페이지 번호
	private int amount;   // 한페이지당 보여줄 갯수
	
	// 기본 생성자
	public Criteria() {
		this(1,10);
	}
	
	
	// pageNum과 amount를 받는 생성자
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

}
