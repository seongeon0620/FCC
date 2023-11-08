package com.woori.myapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.service.IngreService;

import jakarta.annotation.Resource;

@RestController
public class IngreController {
	
	@Resource(name="ingreService")
	IngreService service;
	
	@GetMapping("/api/getMainIngre")
	public List<String> get_main_ingre() {
		return service.getMainList(); 
	}
	
	@GetMapping("/api/getSubIngre/{category}")
	public List<IngreDto> get_sub_ingre(@PathVariable("category") String category) {
		return service.getSubList(category);
	}
}
