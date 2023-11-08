package com.woori.myapp.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.MemberDto;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public void insert(MemberDto dto) {
		
		sm.insert("Member_insert",dto);

	}

	@Override
	public MemberDto login_proc(MemberDto dto) {
		return sm.selectOne("Member_login",dto);
		
	}


	@Override
	public MemberDto getMypage(MemberDto dto) {
		return sm.selectOne("Member_getMypage",dto);
	}

	@Override
	public boolean idCheck(MemberDto dto) {
		int cnt = sm.selectOne("Member_idcheck",dto);
		if(cnt==0) {
			return true;
		}					
		return false;
	}

	@Override
	public void update(MemberDto dto) {
		sm.update("Member_modify",dto);
		
		
	}





}
