package com.woori.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.woori.myapp.entity.BoardDto;
import com.woori.myapp.service.BoardService;

import jakarta.annotation.Resource;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
	BoardService service;
	
	@GetMapping("board/list/{pg}")
	public String board_list(Model model, BoardDto dto, @PathVariable("pg") Integer pg) {
		List<BoardDto> list = service.getList(dto);
		dto.setPg(pg);
		model.addAttribute("boardList", list);
		
		return "board/board_list";
	}
	
	@GetMapping("board/view")
	public String board_view() {
		return "board/board_view";
	}
}
