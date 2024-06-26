package com.woori.myapp.service;

import java.util.HashMap;
import java.util.List;

import com.woori.myapp.entity.RecipeDto;

import jakarta.servlet.http.HttpServletRequest;

public interface RecipeService {
	
	List<RecipeDto> getRecipeList(RecipeDto dto);
	
	int getRecipeTotalCnt();

	RecipeDto getRecipeInfo(Integer rcp_seq);

	HashMap<String, Object> analyzeRecipe(RecipeDto recipeInfo);

	HashMap<String, Object> likeRecipe(HttpServletRequest request, String like_type, Integer rcp_seq);
	
	Long getMemSeqToSession(HttpServletRequest request);

	String checkRecipeLike(HttpServletRequest request, Integer rcp_seq);

	List<RecipeDto> getRecipeLikeList(HttpServletRequest request);

}
