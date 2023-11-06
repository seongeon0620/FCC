package com.woori.myapp.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.repository.MemberDao;
import com.woori.myapp.service.MemberService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	MemberService service;
	

	
	@GetMapping("/member")
	public String member_join() {
		
		return "/member/member_join";
	}
	
	@GetMapping("/member/login")
	public String member_login() {
		
		return "/member/member_login";
	}


	
	@PostMapping("/member/save") 
	@ResponseBody
	public HashMap<String,Object> member_save(MemberDto dto){
		HashMap<String,Object> map = new HashMap<String,Object>();
		service.insert(dto);
		
		map.put("result","success");
		return map;
	}
	
	@PostMapping("/member/loginproc") 
	@ResponseBody
	public HashMap<String,Object> member_logonproc(MemberDto dto,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		MemberDto resultDto = service.login_proc(dto);
		int result = getResult(resultDto,dto);
		map.put("result",result);
		if(result==1) {
			System.out.println(result);
			map.put("msg", "로그온 성공");
			session.setAttribute("mem_name", resultDto.getMem_name());
			session.setAttribute("mem_nickname", resultDto.getMem_nickname());
			session.setAttribute("mem_email", resultDto.getMem_email());
			session.setAttribute("mem_img", resultDto.getMem_img());
		}else if(result ==2) {
			System.out.println(result);
			map.put("msg", "아이디가 없습니다");
		}else {
			map.put("msg", "패스워드 불일치");
		}
				
		return map;
	}
	
	int getResult(MemberDto resultDto,MemberDto dto) {
		if(resultDto==null) {
			return 2;
		}
		if(!resultDto.getMem_password().equals(dto.getMem_password())) {
			return 3;
		}
		return 1;
	}
	
	@GetMapping("/member/mypage/{id}")
	public String mypage(Model model, @PathVariable("id")Long id) {
		MemberDto dto = new MemberDto();
		dto.setMember_seq(id);
		MemberDto resultDto = service.getMypage(dto);
		
		model.addAttribute("member",resultDto);
		
		return "/member/member_mypage";
	}
	
	@GetMapping("/member/modify/{id}")
	public String modify(Model model, @PathVariable("id")Long id) {
		MemberDto dto = new MemberDto();
		dto.setMember_seq(id);
		MemberDto resultDto = service.getMypage(dto);
		
		model.addAttribute("member",resultDto);
		
		return "/member/member_modify";
	}
	
	

}
