package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.woori.myapp.common.Pager;
import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.service.RecipeService;

import jakarta.annotation.Resource;

@Controller
public class RecipeController {
	
	@Resource(name = "recipeService")
	RecipeService service;
	
	@GetMapping("/recipe/list")
	public String recipe_list(Model model, RecipeDto dto) {
		
		model.addAttribute("recipeList", service.getRecipeList(dto));	
		model.addAttribute("page", Pager.makePage(9, service.getRecipeTotalCnt(), 0));	
		return "/recipe/recipe_list";
	}
	
	@GetMapping("/recipe/list/{pg}")
	public String recipe_list(Model model, RecipeDto dto, @PathVariable("pg") Integer pg) {
		
		dto.setPg(pg);
		model.addAttribute("recipeList", service.getRecipeList(dto));
		model.addAttribute("page", Pager.makePage(9, service.getRecipeTotalCnt(), pg));
		return "/recipe/recipe_list";
	}
	
	@GetMapping("/recipe/view")
	public String recipe_view() {
		return "/recipe/recipe_view";
	}
	
}
