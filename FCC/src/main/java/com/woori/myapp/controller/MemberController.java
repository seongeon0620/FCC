package com.woori.myapp.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.woori.myapp.entity.MemberDto;
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
	public String member_login(HttpSession sess) {
		if(sess.getAttribute("mem_name")!=null) {
			return "redirect:/";
		}
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


	@PostMapping("/member/update") 
	@ResponseBody
	public HashMap<String,Object> member_update(MemberDto dto){
		HashMap<String,Object> map = new HashMap<String,Object>();
		service.update(dto);
		map.put("result","success");
		return map;
	}
	
	@PostMapping("/logout")
	public String member_logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@GetMapping("/member/idcheck")
	@ResponseBody
	public HashMap<String,Object> member_idcheck(MemberDto dto){
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		if(service.idCheck(dto)) {
			map.put("result", "success");
		}else {
			map.put("result","fail");
		}
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
			map.put("msg", "로그인 성공");
			session.setAttribute("mem_seq", resultDto.getMember_seq());
			session.setAttribute("mem_name", resultDto.getMem_name());
			session.setAttribute("mem_password", resultDto.getMem_password());
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

	
	
//	
//	@Value("${fileUploadPath}")
//	String  fileUploadPath;  //application.properties 파일에서 ${키값}
//	
//	@Value("${domain}")
//	String  domain;
//	
//	@PostMapping("/member/upload")
//	@ResponseBody 
//	public HashMap<String, Object> upload(MultipartFile file){
//		HashMap<String, Object> resultMap = new HashMap<String, Object>();
//		//이미 업로드 시킨 파일은 임시경로에 올라와있다
//		String filename = file.getOriginalFilename();//본래파일명 
//		
//		try
//		{
//			Path uploadPath = Paths.get(fileUploadPath);
//			Path filePath = uploadPath.resolve(filename);
//			InputStream inputStream = file.getInputStream();
//			Files.copy(inputStream,  filePath, StandardCopyOption.REPLACE_EXISTING);
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		
//		resultMap.put("filename", filename);
//		resultMap.put("image_url", domain + "/"+fileUploadPath+"/"+filename);
//		
//		
//		return resultMap;
//	}


	
	

}
