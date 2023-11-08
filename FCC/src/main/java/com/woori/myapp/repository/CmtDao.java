package com.woori.myapp.repository;

import java.util.List;

import com.woori.myapp.entity.CmtDto;

public interface CmtDao {
	List<CmtDto> getCmtList(CmtDto dto);
	int getCmtCount(CmtDto dto);
	void insert(CmtDto dto);
	void delete(CmtDto dto);
}
