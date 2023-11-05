package com.woori.myapp.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.service.MemberService;

import jakarta.annotation.Resource;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	MemberService service;
	
	@GetMapping("/member")
	public String member_join() {
		
		return "/member/member_join";
	}
	
	@GetMapping("/member/login")
	public String member_login() {
		
		return "/member/member_login";
	}


	
	@PostMapping("/member/save") 
	@ResponseBody
	public HashMap<String,Object> member_save(MemberDto dto){
		HashMap<String,Object> map = new HashMap<String,Object>();
		service.insert(dto);
		
		map.put("result","success");
		return map;
	}
	
}
