package com.woori.myapp.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.service.MemberService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Resource(name = "memberService")
	MemberService service;

	@GetMapping("/member")
	public String member_join() {

		return "/member/member_join";
	}

	@GetMapping("/member/login")
	public String member_login(HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");

		if (memberDto != null) {
		
			return "redirect:/index";
		}

		return "/member/member_login";
	}

	@PostMapping("/member/save")
	@ResponseBody
	public HashMap<String, Object> member_save(MemberDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		service.insert(dto);

		map.put("result", "success");
		return map;
	}

	@PostMapping("/member/update")
	@ResponseBody
	public HashMap<String, Object> member_update(MemberDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Long id = dto.getmem_seq();
	    dto.setmem_seq(id);
	    System.out.println("sea : " + dto.getmem_seq());
		service.update(dto);
		map.put("result", "success");
		return map;
	}

	@PostMapping("/logout")
	public String member_logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/index";
	}

	@GetMapping("/member/idcheck")
	@ResponseBody
	public HashMap<String, Object> member_idcheck(MemberDto dto) {

		HashMap<String, Object> map = new HashMap<String, Object>();

		if (service.idCheck(dto)) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}
	

	@PostMapping("/member/loginproc")
	@ResponseBody
	public HashMap<String, Object> member_logonproc(MemberDto dto, HttpServletRequest request) {

		HttpSession session = request.getSession();

		HashMap<String, Object> map = new HashMap<String, Object>();

		MemberDto resultDto = service.login_proc(dto);
		int result = getResult(resultDto, dto);
		map.put("result", result);
		if (result == 1) {
			System.out.println(result);
			map.put("msg", "로그인 성공");
			session.setAttribute("logInfo", resultDto);

		} else if (result == 2) {
			System.out.println(result);
			map.put("msg", "아이디가 없습니다");
		} else {
			map.put("msg", "패스워드 불일치");
		}

		return map;
	}

	int getResult(MemberDto resultDto, MemberDto dto) {
		if (resultDto == null) {
			return 2;
		}
		if (!resultDto.getMem_password().equals(dto.getMem_password())) {
			return 3;
		}
		return 1;
	}

	@GetMapping("/member/mypage")
	public String mypage(Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");
		
		if (memberDto != null) {
			Long memSeq = memberDto.getmem_seq();
			MemberDto dto = new MemberDto();		
			dto.setmem_seq(memSeq);
			MemberDto resultDto = service.getMypage(dto);
			model.addAttribute("member", resultDto);
			return "/member/member_mypage";
		} else {
			// 세션에 로그인 정보가 없는 경우
			return "redirect:/member/login";
		}
	}


	@GetMapping("/member/modify")
	public String modify(Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");	
		
		if (memberDto != null) {
			Long memSeq = memberDto.getmem_seq();
			MemberDto dto = new MemberDto();		
			dto.setmem_seq(memSeq);
			MemberDto resultDto = service.getMypage(dto);
			model.addAttribute("member", resultDto);
			return "/member/member_modify";
		} else {
			// 세션에 로그인 정보가 없는 경우
			return "redirect:/member/login";
		}
	}


}
