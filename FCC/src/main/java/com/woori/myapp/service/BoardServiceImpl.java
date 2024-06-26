package com.woori.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.BoardDto;
import com.woori.myapp.repository.BoardDao;

import jakarta.annotation.Resource;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name="boardDao")
	BoardDao dao;

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return dao.getList(dto);
	}
	
	@Override
	public int getBoardTotalcnt() {
		
		return dao.getBoardTotalcnt();
	}

	@Override
	public BoardDto getView(BoardDto dto) {
		
		return dao.getView(dto);
	}

	@Override
	public void insert(BoardDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(BoardDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(BoardDto dto) {
		dao.delete(dto);
		
	}



}
