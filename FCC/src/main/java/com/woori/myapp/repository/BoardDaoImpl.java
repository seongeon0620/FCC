package com.woori.myapp.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.BoardDto;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return sm.selectList("Board_list", dto);
	}
	
	@Override
	public int getBoardTotalcnt() {

		return sm.selectOne("Board_getTotalCnt");
	}

	@Override
	public BoardDto getView(BoardDto dto) {
		
		return sm.selectOne("Board_view", dto);
	}

	@Override
	public void insert(BoardDto dto) {
		sm.insert("Board_write", dto);
		
	}


	
	
}
