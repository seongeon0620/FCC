package com.woori.myapp.repository;

import java.util.List;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;

public interface FrigoDao {
	void insert(FrigoDto dto);
	FrigoResponseDto getInsertResult(Long frigoSeq);
	List<FrigoResponseDto> getList(FrigoResponseDto frigoResponseDto);
	int deleteAll(FrigoDto dto);
	int deleteOne(FrigoDto dto);
	int updateDetail(FrigoDto dto);
	int updateStatus(FrigoDto dto);
}
