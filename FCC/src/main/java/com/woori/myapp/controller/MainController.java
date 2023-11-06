package com.woori.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.service.MainService;

import jakarta.annotation.Resource;

@Controller
public class MainController {
	
	@Resource( name="mainService" )
	MainService service;
	
	// 메인 페이지_레시피 리스트
	@GetMapping("/index")
	public String index(Model model, RecipeDto Rto) {
		List<RecipeDto> list = service.getRecipeList( Rto );
		for ( int i=0; i<list.size() ; i++) {
			System.out.println("메인 레시피 list >>>>>>>" + list.get(i) );
		}
		model.addAttribute("list", list);
		return "/index";
	}
	
	// 냉장고 정보
	@PostMapping("/index/refigo")
	@ResponseBody
	public HashMap<String, Object> mainRefigoInfo (  FrigoDto Fto ) {
		HashMap<String, Object> resultMap = new HashMap<>();
		service.getFrigoInfo( Fto );
		resultMap.put( "result", "success" );
		// 데이터가 넘어 왔나
		resultMap.put( "frigo_seq", Fto.getFrigo_seq() );
		resultMap.put( "frigo_storage", Fto.getFrigo_storage() );
		
		return resultMap;
	}
	
	
	// 냉동고 정보
	@PostMapping("/index/ice")
	@ResponseBody
	public HashMap<String, Object> mainIceInfo (  FrigoDto Fto ) {
		HashMap<String, Object> resultMap = new HashMap<>();
		service.getIceInfo( Fto );
		resultMap.put( "result", "success" );
		// 데이터가 넘어 왔나
		resultMap.put( "frigo_seq", Fto.getFrigo_seq() );
		resultMap.put( "frigo_storage", Fto.getFrigo_storage() );
		
		return resultMap;
	}
	
	// 실온 보관 정보
	@PostMapping("/index/indoor")
	@ResponseBody
	public HashMap<String, Object> mainIndoorInfo (  FrigoDto Fto ) {
		HashMap<String, Object> resultMap = new HashMap<>();
		service.getIndoorInfo( Fto );
		resultMap.put( "result", "success" );
		// 데이터가 넘어 왔나
		resultMap.put( "frigo_seq", Fto.getFrigo_seq() );
		resultMap.put( "frigo_storage", Fto.getFrigo_storage() );
		
		return resultMap;
	}
	
	// 식품 영양 성분
	@PostMapping("/index/nutrition")
	@ResponseBody
	public HashMap<String, Object> mainNutritionInfo (  IngreDto Ito ) {
		HashMap<String, Object> resultMap = new HashMap<>();
		service.getNutritionInfo( Ito );
		resultMap.put( "result", "success" );
		// 데이터가 넘어 왔나
		resultMap.put( "ingre_name", Ito.getIngre_name() );
		resultMap.put( "ingre_pro", Ito.getIngre_pro() );
		resultMap.put( "ingre_car", Ito.getIngre_car() );
		resultMap.put( "ingre_fat", Ito.getIngre_fat() );
		
		return resultMap;
	}
	
	// 냉장고 신선도
	@PostMapping("/index/fresh")
	@ResponseBody
	public HashMap<String, Object> mainFreshInfo (  FrigoDto Fto ) {
		HashMap<String, Object> resultMap = new HashMap<>();
		service.getFrigoFreshInfo( Fto );
		resultMap.put( "result", "success" );
		// 데이터가 넘어 왔나
		resultMap.put( "frigo_expiration", Fto.getFrigo_expiration() );
		return resultMap;
	}
	
	
	
	
	@GetMapping("/test")
	public String test() {
		return "/test";
	}
	
}
