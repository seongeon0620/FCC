package com.woori.myapp.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	@GetMapping("/index")
	public String index() {
		return "/index";
	}
	
//	@PostMapping("/index/refigo")
//	@ResponseBody
//	public HashMap<String, Object> mainRefigoInfo ( refidoDto to ) {
//		HashMap<String, Object> resultMap = new HashMap<>();
//	}
	
	
	@GetMapping("/test")
	public String test() {
		return "/test";
	}
	
}
