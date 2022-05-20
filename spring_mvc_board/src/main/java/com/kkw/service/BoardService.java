package com.kkw.service;

import java.util.List;

import com.kkw.domain.BoardVO;

public interface BoardService {
	
	//게시판 등록
	public void register(BoardVO board);
	
	//게시판 조회
	public BoardVO get(Long bno);
	
	//게시판 수정
	public boolean modify(BoardVO board);
	
	//게시판 삭제
	public boolean remove(Long bno);
	
	//게시판 목록
	public List<BoardVO> getList();

}
