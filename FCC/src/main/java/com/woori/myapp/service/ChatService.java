package com.woori.myapp.service;

import java.util.List;

import com.woori.myapp.entity.MemberDto;

public interface ChatService {
	// 유저 리스트
	List<MemberDto> getUserList(MemberDto mto);
}
