package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping("board/list")
	public String board_list() {
		return "board/board_list";
	}
	
	@GetMapping("board/view")
	public String board_view() {
		return "board/board_view";
	}
}
