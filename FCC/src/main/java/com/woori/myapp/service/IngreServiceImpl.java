package com.woori.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.repository.IngreDao;

import jakarta.annotation.Resource;

@Service("ingreService")
public class IngreServiceImpl implements IngreService {

	@Resource(name="ingreDao")
	IngreDao dao;
	
	@Override
	public List<String> getMainList() {
		return dao.getMainList();
	}

	@Override
	public List<IngreDto> getSubList(String category) {
		return dao.getSubList(category);
	}


}
