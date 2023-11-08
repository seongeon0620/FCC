package com.woori.myapp.service;

import com.woori.myapp.entity.MemberDto;

public interface MemberService {

	void insert(MemberDto dto);
	MemberDto login_proc(MemberDto dto);
	MemberDto getMypage(MemberDto dto);
	boolean idCheck(MemberDto dto);
	void update(MemberDto dto);

}
