package com.kkw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kkw.domain.BoardVO;
import com.kkw.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	//의존 관계
	private BoardMapper mapper;
	
	//게시판 등록
	@Override
	public void register(BoardVO board) {
		
		mapper.insertSelectKey(board);
	}

	//게시판 조회
	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	//게시판 수정
	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board)==1;
	}

	//게시판 삭제
	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno)==1;
	}
	//게시판 목록
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

}
