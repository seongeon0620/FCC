package com.woori.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.woori.myapp.entity.Message;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
 
@Controller
public class ChatController {
	@GetMapping("/appchat")
	public String appChat() {
		return "/soket";
	}
	
// List<String> roomList = new ArrayList<String>();
	
	//topic로 시작하면 구독하는 모든 소켓에 통신을 한다 
//	@MessageMapping("/hello")
//	@SendTo("/topic/greeting")
//	public Message send_message(Message msg) throws InterruptedException {
//		//잠깐 cpu 를 릴리즈한다 
//		Thread.sleep(1000); //스레드가 1초동안 대기를 타도록 한다 
//		return msg;
//	}

	//업그레이드
    @MessageMapping("/all") //여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에서 적용한건 앞에 생략
    @SendTo("/topic/all")   //구독하고 있는 장소로 메시지 전송 (목적지)  -> WebSocketConfig Broker 에서 적용한건 앞에 붙어줘야됨
    public Message send_room_message( Message msg) {
    	System.out.println(msg.getMem_name());
  
    	return msg;
    }	
	
}
