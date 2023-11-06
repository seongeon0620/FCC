package com.woori.myapp.repository;

import java.util.List;

import com.woori.myapp.entity.RecipeDto;

public interface RecipeDao {
	
	List<RecipeDto> getRecipeList(RecipeDto dto);
	
	int getRecipeTotalCnt();

}
