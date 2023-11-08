package com.woori.myapp.service;

import java.util.List;

import com.woori.myapp.entity.CmtDto;

public interface CmtService {
	List<CmtDto> getCmtList(CmtDto dto);
	int getCmtCount(CmtDto dto);
	void insert(CmtDto dto);
	void delete(CmtDto dto);
}
