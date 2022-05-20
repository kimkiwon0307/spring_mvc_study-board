package com.kkw.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	
	//게시판번호
	private Long bno;

	//게시판제목
	private String title;
	
	//게시판내용
	private String content;
	
	//게시판작성자
	private String writer;
	
	//게시판등록날짜
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	
	//게시판수정날짜
	private Date updateDate;
}


