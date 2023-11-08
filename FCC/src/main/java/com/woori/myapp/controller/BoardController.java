package com.woori.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.common.Pager;
import com.woori.myapp.entity.BoardDto;
import com.woori.myapp.service.BoardService;
import com.woori.myapp.service.MemberService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
	BoardService service;
	
	@GetMapping("/board/list/{pg}")
	public String board_list(Model model, BoardDto dto, @PathVariable("pg") int pg) {
		List<BoardDto> list = service.getList(dto);
		dto.setPg(pg);
		model.addAttribute("page", Pager.makePage(9, service.getBoardTotalcnt(), pg));
		model.addAttribute("boardList", list);
		
		return "board/board_list";
	}
	
	@GetMapping("/board/view/{board_seq}")
	public String board_view(Model model, @PathVariable("board_seq") long board_seq) {
		BoardDto dto = new BoardDto();
		dto.setBoard_seq(board_seq);
		BoardDto resultDto = service.getView(dto);
		String[] ingre = resultDto.getBoard_ingredients().split(",");
		model.addAttribute("ingre",ingre);
		model.addAttribute("boardView", resultDto);
		
		return "board/board_view";
	}
	
	@GetMapping("/board/write")
	public String board_write() {

		
		return "board/board_write";
	}
	
	@PostMapping("/board/save")
	@ResponseBody
	public HashMap<String, Object> board_save(BoardDto dto, HttpServletRequest request){
		
		service.insert(dto);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", "success");
		
		return resultMap;
		
	}
}
