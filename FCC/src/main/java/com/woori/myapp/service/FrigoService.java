package com.woori.myapp.service;

import java.util.HashMap;
import java.util.List;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;

public interface FrigoService {
	FrigoResponseDto insert(FrigoDto frigoDto);
	List<FrigoResponseDto> getList(FrigoResponseDto frigoResponseDto, String category);
	int deleteOne(FrigoDto frigoDto);
	int deleteAll(FrigoDto frigoDto);
}
