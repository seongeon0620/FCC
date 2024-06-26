package com.woori.myapp.controller;


import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woori.myapp.common.Pager;
import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.service.RecipeService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RecipeController {
	
	@Resource(name = "recipeService")
	RecipeService service;
	
	@GetMapping("/recipe/list")
	public String recipe_list(Model model, RecipeDto dto) {
		
		model.addAttribute("recipeList", service.getRecipeList(dto));	
		model.addAttribute("page", Pager.makePage(12, service.getRecipeTotalCnt(), 0));	
		return "/recipe/recipe_list";
	}
	
	@GetMapping("/recipe/list/{pg}")
	public String recipe_list(Model model, RecipeDto dto, @PathVariable("pg") Integer pg) {
		
		dto.setPg(pg);
		model.addAttribute("recipeList", service.getRecipeList(dto));
		model.addAttribute("page", Pager.makePage(12, service.getRecipeTotalCnt(), pg));
		return "/recipe/recipe_list";
	}
	
	@GetMapping("/recipe/view/{rcp_seq}")
	public String recipe_view(HttpServletRequest request, Model model, @PathVariable("rcp_seq") Integer rcp_seq) {
		RecipeDto recipeInfo = service.getRecipeInfo(rcp_seq);
		model.addAttribute("recipeInfo", recipeInfo);
		model.addAttribute("recipeAnalysis", service.analyzeRecipe(recipeInfo));
		model.addAttribute("checkRecipeLike", service.checkRecipeLike(request, rcp_seq));
		return "/recipe/recipe_view";
	}
	
	@GetMapping("/recipe/like/{rcp_seq}")
	@ResponseBody
	public HashMap<String, Object> recipe_like(HttpServletRequest request, String like_type, @PathVariable("rcp_seq") Integer rcp_seq) {

		HashMap<String, Object> map = service.likeRecipe(request, like_type, rcp_seq);
		return map;
	}
	
	@GetMapping("/recipe/like/list")
	public String recipe_like_list(Model model, HttpServletRequest request) {
		
		model.addAttribute("recipeList", service.getRecipeLikeList(request));
		return "/recipe/recipe_like_list";
	}
	
}