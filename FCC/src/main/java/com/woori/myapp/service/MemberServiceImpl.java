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

}
