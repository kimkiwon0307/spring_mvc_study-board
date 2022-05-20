package com.kkw.mapper;

import java.util.List;

import com.kkw.domain.BoardVO;

public interface BoardMapper {
	
	//게시판 목록
	public List<BoardVO> getList();
	
	//게시판 등록
	public void insert(BoardVO board);
	
	//게시판 등록후 등록번호 알기
	public void insertSelectKey(BoardVO board);
	
	//게시판 조회
	public BoardVO read(Long bno);
	
	//게시판 삭제
	public int delete (Long bno);
	
	//게시판 수정
	public int update (BoardVO board);
	
}
