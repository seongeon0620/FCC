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
import com.woori.myapp.entity.CmtDto;
import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.service.BoardService;
import com.woori.myapp.service.CmtService;
import com.woori.myapp.service.MemberService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	@Resource(name="boardService")
	BoardService service;
	
	@Resource(name="cmtService")
	CmtService cmtService;
	
	@Resource(name="memberService")
	MemberService memService;
	
	@GetMapping("/board/list/{pg}")
	public String board_list(Model model, BoardDto dto, @PathVariable("pg") int pg) {
		List<BoardDto> list = service.getList(dto);
		dto.setPg(pg);
		model.addAttribute("page", Pager.makePage(9, service.getBoardTotalcnt(), pg));
		model.addAttribute("boardList", list);
		
		return "board/board_list";
	}
	
	@GetMapping("/board/view/{board_seq}")
	public String board_view(Model model, @PathVariable("board_seq") long board_seq, HttpServletRequest request) {
		BoardDto dto = new BoardDto();
		dto.setBoard_seq(board_seq);
		BoardDto resultDto = service.getView(dto);
		String[] ingre = resultDto.getBoard_ingredients().split(",");
		model.addAttribute("ingre",ingre);
		model.addAttribute("boardView", resultDto);
		
		CmtDto cmtDto = new CmtDto();
		cmtDto.setBoard_seq(board_seq);
		
		HttpSession session = request.getSession();
		MemberDto sessionDto = (MemberDto)session.getAttribute("logInfo");
		List<CmtDto> cmtList = cmtService.getCmtList(cmtDto);
		for(CmtDto c : cmtList) {
			if(c.getMember_seq().equals(sessionDto.getmem_seq())) {
				c.setMyCmt("mine");
			}
		}
		int cmtCount = cmtService.getCmtCount(cmtDto);
		model.addAttribute("cmtCount", cmtCount);
		model.addAttribute("cmtList", cmtList);
		
		return "board/board_view";
	}
	
	@GetMapping("/board/write")
	public String board_write() {

		
		return "board/board_write";
	}
	
	@PostMapping("/board/save")
	@ResponseBody
	public HashMap<String, Object> board_save(BoardDto dto, HttpServletRequest request){
		HttpSession session = request.getSession();
		MemberDto sessionDto = (MemberDto)session.getAttribute("logInfo");
		dto.setMember_seq(sessionDto.getmem_seq());
		
		service.insert(dto);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", "success");
		
		return resultMap;
		
	}
	
	@GetMapping("/board/edit/{board_seq}")
	public String board_edit(Model model, @PathVariable("board_seq") long board_seq) {
		BoardDto dto = new BoardDto();
		dto.setBoard_seq(board_seq);
		BoardDto resultDto = service.getView(dto);
		model.addAttribute("resultDto", resultDto);
		
		return "/board/board_edit";
	}
	
	@PostMapping("/board/update")
	@ResponseBody
	public HashMap<String, Object> board_update(BoardDto dto){
		
		service.update(dto);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", "success");
		
		return resultMap;
		
	}
	
	@GetMapping("/board/delete/{board_seq}")
	public String board_delete(@PathVariable("board_seq") long board_seq){
		BoardDto dto = new BoardDto();
		dto.setBoard_seq(board_seq);
		service.delete(dto);
		
		return "redirect:/board/list/0";
	}
	
	@PostMapping("/board/commentSave")
	@ResponseBody
	public HashMap<String, Object> comments_insert(CmtDto dto, HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto sessionDto = (MemberDto)session.getAttribute("logInfo");
		dto.setMember_seq(sessionDto.getmem_seq());
		
		cmtService.insert(dto);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", "success");
		
		return resultMap;
	}
	
	@GetMapping("/board/cmtDelete/{board_seq}/{cmt_seq}")
	public String cmt_delete(@PathVariable("board_seq") long board_seq, @PathVariable("cmt_seq") long cmt_seq){
		CmtDto dto = new CmtDto();
		dto.setCmt_seq(cmt_seq);
		cmtService.delete(dto);
		
		return "redirect:/board/view/" + board_seq;
	}
	
	
}
