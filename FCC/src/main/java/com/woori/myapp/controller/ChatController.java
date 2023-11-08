package com.woori.myapp.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.woori.myapp.entity.Message;

@Controller
public class ChatController {
	@GetMapping("appchat")
	public String appChat() {
		return "/app-chat";
	}
	
	//업그레이드
    @MessageMapping("/all") //여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에서 적용한건 앞에 생략
    @SendTo("/topic/all")   //구독하고 있는 장소로 메시지 전송 (목적지)  -> WebSocketConfig Broker 에서 적용한건 앞에 붙어줘야됨
    public Message send_room_message(@DestinationVariable String roomid, Message msg) {

    	System.out.println(roomid);
        //채팅 저장
//        Chat chat = chatService.createChat(roomId, message.getSender(), message.getMessage());
//        return ChatMessage.builder()
//                .roomId(roomId)
//                .sender(chat.getSender())
//                .message(chat.getMessage())
//                .build();
    	return msg;
    }	
}
