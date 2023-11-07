package com.woori.myapp.repository;

import java.util.List;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;

public interface FrigoDao {
	int insert(FrigoDto dto);
	FrigoDto getInsertResult(int frigoSeq);
	List<FrigoResponseDto> getList(FrigoResponseDto frigoResponseDto);
}
