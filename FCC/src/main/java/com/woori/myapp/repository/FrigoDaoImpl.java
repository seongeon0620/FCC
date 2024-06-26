package com.woori.myapp.repository;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;
import com.woori.myapp.entity.RecipeDto;

@Repository("frigoDao")
public class FrigoDaoImpl implements FrigoDao {
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public void insert(FrigoDto dto) {
		sm.insert("Frigo_insert", dto);
	}

	@Override
	public FrigoResponseDto getInsertResult(Long frigoSeq) {
		return sm.selectOne("Frigo_getInsertResult", frigoSeq);
	}

	@Override
	public List<FrigoResponseDto> getList(FrigoResponseDto dto) {
		return sm.selectList("Frigo_getList", dto);
	}

	@Override
	public int deleteAll(FrigoDto dto) {
		return sm.delete("Frigo_deleteAll", dto);
	}

	@Override
	public int deleteOne(FrigoDto dto) {
		return sm.delete("Frigo_deleteOne", dto);
	}

	@Override
	public int updateDetail(FrigoDto dto) {
		return sm.update("Frigo_updateDetail", dto);
	}

	@Override
	public int updateStatus(FrigoDto dto) {
		return sm.update("Frigo_updateStatus", dto);
	}

	@Override
	public List<RecipeDto> getRecipeList() {
		return sm.selectList("Frigo_getRandomList");
	}

	

}
