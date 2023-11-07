package com.woori.myapp.service;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.repository.MemberDao;

import jakarta.annotation.Resource;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberDao")
	MemberDao dao;
	
	@Override
	public void insert(MemberDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public MemberDto login_proc(MemberDto dto) {
		
		MemberDto resultDto = dao.login_proc(dto);
		
		return resultDto;
	}

	@Override
	public MemberDto getMypage(MemberDto dto) {
		MemberDto resultDto = dao.getMypage(dto);
		return resultDto;
	}

	@Override
	public boolean idCheck(MemberDto dto) {
		return dao.idCheck(dto);
	}

}
