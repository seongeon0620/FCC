package com.woori.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.repository.ChatDao;

import jakarta.annotation.Resource;

@Service("chatService")
public class ChatServiceImpl implements ChatService {
	
	@Resource( name="chatDao" )
	ChatDao dao;

	@Override
	public List<MemberDto> getUserList(MemberDto mto) {
		return dao.getUserList(mto);
	}


}
