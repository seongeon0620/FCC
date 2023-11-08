package com.woori.myapp.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.CmtDto;

@Repository("cmtDao")
public class CmtDaoImpl implements CmtDao {
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<CmtDto> getCmtList(CmtDto dto) {
		
		return sm.selectList("Cmt_list", dto);
	}

	@Override
	public int getCmtCount(CmtDto dto) {
		
		return sm.selectOne("Cmt_count", dto);
	}

	@Override
	public void insert(CmtDto dto) {
		sm.insert("Cmt_insert",dto);
		
	}

	@Override
	public void delete(CmtDto dto) {
		sm.delete("Cmt_delete", dto);
		
	}

}
