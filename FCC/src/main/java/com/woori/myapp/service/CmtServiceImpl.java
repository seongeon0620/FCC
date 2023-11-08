package com.woori.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.CmtDto;
import com.woori.myapp.repository.CmtDao;

import jakarta.annotation.Resource;

@Service("cmtService")
public class CmtServiceImpl implements CmtService {
	
	@Resource(name="cmtDao")
	CmtDao dao;

	@Override
	public List<CmtDto> getCmtList(CmtDto dto) {
		
		return dao.getCmtList(dto);
	}

	@Override
	public int getCmtCount(CmtDto dto) {
		
		return dao.getCmtCount(dto);
	}

	@Override
	public void insert(CmtDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public void delete(CmtDto dto) {
		dao.delete(dto);
		
	}
	
	
	
	
}
