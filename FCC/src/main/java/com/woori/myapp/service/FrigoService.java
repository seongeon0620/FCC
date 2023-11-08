package com.woori.myapp.service;

import java.util.HashMap;
import java.util.List;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;

public interface FrigoService {
	HashMap<String, FrigoDto> insert(FrigoDto dto);
	List<FrigoResponseDto> getList(FrigoResponseDto frigoResponseDto, String category);
}
