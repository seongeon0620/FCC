package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.woori.myapp.entity.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	
	@GetMapping("/hello")
	public String hello(  ) {
		
		return "redirect:member/login";
	}
}
