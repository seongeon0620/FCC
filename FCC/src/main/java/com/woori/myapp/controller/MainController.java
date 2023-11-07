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
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.MainDto;
import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.service.MainService;

import jakarta.annotation.Resource;

@Controller
public class MainController {
	
	@Resource( name="mainService" )
	MainService service;
	
	// 메인 페이지_레시피 리스트
	@GetMapping("/index")
	public String index( Model model, MemberDto mto ) {
		Long member_seq = 1L; 
		mto.setMember_seq(member_seq);
		
		List<RecipeDto> list = service.getRecipeList( null );
		model.addAttribute( "list", list );
		model.addAttribute( "mto", mto );
		
		return "/index";
	}
	
	// 냉장고 정보
	@PostMapping("/index/refigoInfo")
	@ResponseBody
	public HashMap<String, Object> mainRefigoInfo (  MainDto mto ) {
		HashMap<String, Object> resultMap = new HashMap<>();
		List<MainDto> list = service.getFrigoInfo( mto );
		resultMap.put( "result", "success" );
		resultMap.put( "list", list );
		
		return resultMap;
	}
	
	// 식품 영양 성분
	@PostMapping("/index/nutrition/{ingre_seq}")
	@ResponseBody
	public HashMap<String, Object> mainNutritionInfo (  MainDto mto, @PathVariable("ingre_seq") int ingre_seq ) {
		HashMap<String, Object> resultMap = new HashMap<>();
		mto.setIngre_seq(ingre_seq+"");
		MainDto resultDto = service.getNutritionInfo( mto );
		resultMap.put( "result", "success" );
		resultMap.put( "resultDto", resultDto );
		
		
		return resultMap;
	}
	
	//프로그래스바
	@PostMapping("/index/progressbar")
	@ResponseBody
	public MainDto mainProgress ( MainDto mto ) {
		mto = service.getFrigoFreshInfo( mto );	
		
		return mto;
	}
	
}
