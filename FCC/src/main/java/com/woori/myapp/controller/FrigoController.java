package com.woori.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;
import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.service.FrigoService;

import jakarta.annotation.Resource;

@Controller
public class FrigoController {
	
	@Resource(name="frigoService")
	FrigoService service;
	
	@GetMapping("/my_frigo")
	public String my_frigo(Model model, FrigoResponseDto dto) {
		
		List<FrigoResponseDto> iceList = service.getList(dto, "냉장");
		List<FrigoResponseDto> frozenList = service.getList(dto, "냉동");
		List<FrigoResponseDto> roomList = service.getList(dto, "실온");
		
		model.addAttribute("iceList", iceList);
		model.addAttribute("frozenList", frozenList);
		model.addAttribute("roomList", roomList);
		return "my_frigo";
	}
	
	@PostMapping("/frigo/save")
	@ResponseBody
	public HashMap<String, FrigoDto> frigo_save(FrigoDto dto) {
		HashMap<String, FrigoDto> resultMap = new HashMap<String, FrigoDto>();
		
		resultMap = service.insert(dto);
		return resultMap;
	}
	
}
