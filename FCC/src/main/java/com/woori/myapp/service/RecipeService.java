package com.woori.myapp.service;

import java.util.List;

import com.woori.myapp.entity.RecipeDto;

public interface RecipeService {
	List<RecipeDto> getRecipeList(RecipeDto dto);
	
	int getRecipeTotalCnt();
}
