package com.woori.myapp.repository;

import java.util.List;

import com.woori.myapp.entity.LikesDto;
import com.woori.myapp.entity.RecipeDto;

public interface RecipeDao {
	
	List<RecipeDto> getRecipeList(RecipeDto dto);
	
	int getRecipeTotalCnt();

	RecipeDto getRecipeInfo(Integer rcp_seq);

	int insertRecipeLike(LikesDto likesDto);

	int deleteRecipeLike(LikesDto likesDto);

	boolean checkRecipeLike(LikesDto likesDto);

	List<RecipeDto> getRecipeLikeList(long mem_seq);

}
