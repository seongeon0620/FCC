package com.woori.myapp.repository;

import java.util.List;

import com.woori.myapp.entity.MemberDto;

public interface ChatDao {
	// 유저 리스트
	List<MemberDto> getUserList ( MemberDto mto );
}
