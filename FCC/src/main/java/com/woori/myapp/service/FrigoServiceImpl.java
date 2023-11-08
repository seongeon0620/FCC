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
	public FrigoResponseDto insert(FrigoDto dto) {
		dao.insert(dto);
		FrigoResponseDto reponseDto = dao.getInsertResult(dto.getFrigo_seq());
		return reponseDto;
	}

	@Override
	public List<FrigoResponseDto> getList(FrigoResponseDto frigoResponseDto, String category) {
		frigoResponseDto.setFrigo_storage(category);
		return dao.getList(frigoResponseDto);
	}

	@Override
	public int deleteAll(FrigoDto frigoDto) {
		return dao.deleteAll(frigoDto);
	}

	@Override
	public int deleteOne(FrigoDto frigoDto) {
		return dao.deleteOne(frigoDto);
	}

	@Override
	public int updateDatail(FrigoDto frigoDto) {
		return dao.updateDetail(frigoDto);
	}

	@Override
	public int updateStatus(FrigoDto frigoDto) {
		return dao.updateStatus(frigoDto);
	}

	
	
}
