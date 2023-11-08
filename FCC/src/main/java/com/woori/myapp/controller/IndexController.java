package com.woori.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.entity.RecipeDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto resultDto = (MemberDto)session.getAttribute("logInfo");
		
		if ( resultDto != null ) {
			return "redirect:/index";
		}
		return "/main";
	}
}
