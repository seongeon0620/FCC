package com.woori.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.repository.RecipeDao;

import jakarta.annotation.Resource;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService{
	
	@Resource(name="recipeDao")
	RecipeDao dao;
	
	private static int totalCnt;

	@Override
	public List<RecipeDto> getRecipeList(RecipeDto dto) {
		
		return dao.getRecipeList(dto);
	}

	@Override
	public int getRecipeTotalCnt() {
		if( totalCnt == 0 ) {
			totalCnt = dao.getRecipeTotalCnt();
		}
		return totalCnt;
	}

}
