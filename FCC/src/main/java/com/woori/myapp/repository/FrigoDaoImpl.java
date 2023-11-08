package com.woori.myapp.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;

@Repository("frigoDao")
public class FrigoDaoImpl implements FrigoDao {
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public int insert(FrigoDto dto) {
		return sm.insert("Frigo_insert", dto);
	}

	@Override
	public FrigoDto getInsertResult(int frigoSeq) {
		return sm.selectOne("Frigo_getInsertResult", frigoSeq);
	}

	@Override
	public List<FrigoResponseDto> getList(FrigoResponseDto dto) {
		return sm.selectList("Frigo_getList", dto);
	}

	

}