package com.woori.myapp.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.RecipeDto;

@Repository("recipeDao")
public class RecipeDaoImpl implements RecipeDao{
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<RecipeDto> getRecipeList(RecipeDto dto) {
		
		return sm.selectList("Recipe_getList", dto);
	}

	@Override
	public int getRecipeTotalCnt() {
		
		return sm.selectOne("Recipe_getTotalCnt");
	}

	@Override
	public RecipeDto getRecipeInfo(Integer rcp_seq) {
		
		return sm.selectOne("Recipe_getInfo", rcp_seq);
	}

	
	

}
