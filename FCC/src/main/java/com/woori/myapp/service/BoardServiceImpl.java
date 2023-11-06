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

}
