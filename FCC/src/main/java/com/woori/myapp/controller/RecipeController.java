package com.woori.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
	
	@GetMapping("/recipe/list")
	public String recipe_list() {
		return "/recipe/recipe_list";
	}
	
	@GetMapping("/recipe/view")
	public String recipe_view() {
		return "/recipe/recipe_view";
	}
	
}
