package com.woori.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;
import com.woori.myapp.service.FrigoService;

import jakarta.annotation.Resource;

@Controller
public class FrigoController {
	
	@Resource(name="frigoService")
	FrigoService service;
	
	@GetMapping("/my_frigo")
	public String my_frigo(Model model, FrigoResponseDto dto) {
		dto.setMem_seq(1L);	//임시
		
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
	public HashMap<String, Object> save(FrigoDto dto) {
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		dto.setMem_seq(1L);	// 임시
		
		resultMap.put("result", service.insert(dto));
		resultMap.put("response", "success");
		
		return resultMap;
	}
	
	@PostMapping("/frigo/delete/{frigo_seq}")
	@ResponseBody
	public HashMap<String, Object> delete_one(FrigoDto dto, @PathVariable("frigo_seq") Long frigo_seq) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();

		dto.setMem_seq(1L);	// 임시
		int result = service.deleteOne(dto);
		if (result ==  0) {
			resultMap.put("response", "fail");
			return resultMap;
		}
		
		resultMap.put("response", "success");
		
		return resultMap;
	}
	
	
	@PostMapping("/frigo/deleteAll/{frigo_storage}")
	@ResponseBody
	public HashMap<String, Object> delete_all(FrigoDto dto, @PathVariable("frigo_storage") String frigo_storage) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		dto.setMem_seq(1L);	// 임시
		int deleteRow = service.deleteAll(dto);
		if (deleteRow > 0) {
			resultMap.put("response", "success");
		}
		
		return resultMap;
	}
	
	@PostMapping("/frigo/modify")
	@ResponseBody
	public HashMap<String, Object> modify(FrigoDto dto) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		dto.setMem_seq(1L);
		
		int result = service.updateDatail(dto);
		if (result == 0) {
			resultMap.put("response", "fail");
			return resultMap;
		}
		
		resultMap.put("response", "success");
		return resultMap;
	}
	
	@PostMapping("/frigo/updateStatus")
	@ResponseBody
	public HashMap<String, Object> update_status(FrigoDto dto) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		dto.setMem_seq(1L);
		int result = service.updateStatus(dto);
		if (result != 1) {
			resultMap.put("message", "fail");
			return resultMap;
		}
		
		resultMap.put("message", "success");
		
		return resultMap;
	}
	
}
