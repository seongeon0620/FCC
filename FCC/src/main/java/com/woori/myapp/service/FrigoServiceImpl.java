package com.woori.myapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;
import com.woori.myapp.repository.FrigoDao;

import jakarta.annotation.Resource;

@Service("frigoService")
public class FrigoServiceImpl implements FrigoService {
	
	@Resource(name="frigoDao")
	FrigoDao dao;

	@Override
	public HashMap<String, FrigoDto> insert(FrigoDto dto) {
		dao.insert(dto);
		return null;
	}

	@Override
	public List<FrigoResponseDto> getList(FrigoResponseDto frigoResponseDto, String category) {
		frigoResponseDto.setFrigo_seq(1L);	// 임시
		frigoResponseDto.setFrigo_storage(category);
		return dao.getList(frigoResponseDto);
	}
	
}
