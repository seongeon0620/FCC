package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
	@GetMapping("app-chat")
	public String appChat() {
		return "/app-chat";
	}
	
}
