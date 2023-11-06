package com.woori.myapp.service;

import java.util.List;

import com.woori.myapp.entity.BoardDto;

public interface BoardService {
	List<BoardDto> getList(BoardDto dto);
}
