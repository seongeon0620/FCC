package com.woori.myapp.service;

import java.util.HashMap;
import java.util.List;

import com.woori.myapp.entity.RecipeDto;

public interface RecipeService {
	List<RecipeDto> getRecipeList(RecipeDto dto);
	
	int getRecipeTotalCnt();

	RecipeDto getRecipeInfo(Integer rcp_seq);

	HashMap<String, Object> analyzeRecipe(RecipeDto recipeInfo);
	

}
