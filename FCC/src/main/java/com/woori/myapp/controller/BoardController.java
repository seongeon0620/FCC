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
	public String board_list(Model model, BoardDto dto, @PathVariable("pg") int pg) {
		List<BoardDto> list = service.getList(dto);
		dto.setPg(pg);
		model.addAttribute("boardList", list);
		
		return "board/board_list";
	}
	
	@GetMapping("board/view/{board_seq}")
	public String board_view(Model model, @PathVariable("board_seq") long board_seq) {
		BoardDto dto = new BoardDto();
		dto.setBoardSeq(board_seq);
		BoardDto resultDto = service.getView(dto);
		String[] ingre = resultDto.getBoardIngredients().split(",");
		model.addAttribute("ingre",ingre);
		model.addAttribute("boardView", resultDto);
		
		return "board/board_view";
	}
}
