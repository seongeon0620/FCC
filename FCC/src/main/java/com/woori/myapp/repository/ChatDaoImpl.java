package com.woori.myapp.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.MainDto;
import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.entity.RecipeDto;

@Repository("chatDao")
public class ChatDaoImpl implements ChatDao {
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<MemberDto> getUserList (MemberDto mto) {
		return sm.selectList( "UserList", mto );
	}





}
