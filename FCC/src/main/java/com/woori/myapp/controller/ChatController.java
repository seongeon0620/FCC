package com.woori.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.entity.Message;
import com.woori.myapp.service.ChatService;

import jakarta.annotation.Resource;

@Controller
public class ChatController {

	@Resource(name = "chatService")
	ChatService service;

	@GetMapping("appchat")
	public String appChat() {
		return "/app-chat";
	}
	
	// 유저 정보
	@PostMapping("/chat/userlist")
	@ResponseBody
	public HashMap<String, Object> getUserLists ( MemberDto mto ) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<MemberDto> userlist = service.getUserList(mto);
		resultMap.put( "result", "success" );
		resultMap.put( "userlist", userlist );
		
		return resultMap;
	}

	// 업그레이드 : 채팅톡방
	@MessageMapping("/all") // 여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에서 적용한건 앞에 생략
	@SendTo("/topic/all") // 구독하고 있는 장소로 메시지 전송 (목적지) -> WebSocketConfig Broker 에서 적용한건 앞에 붙어줘야됨
	public Message send_room_message(Message msg) {

//    	System.out.println(msg.getMessage());
//    	System.out.println(msg.getMem_nickname());
		// 채팅 저장
//        Chat chat = chatService.createChat(roomId, message.getSender(), message.getMessage());
//        return ChatMessage.builder()
//                .roomId(roomId)
//                .sender(chat.getSender())
//                .message(chat.getMessage())
//                .build();
		return msg;
	}
}
