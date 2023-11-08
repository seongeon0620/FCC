package com.woori.myapp.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.LikesDto;
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

	@Override
	public int insertRecipeLike(LikesDto likesDto) {
		
		return sm.insert("Recipe_insertLike", likesDto);
	}

	@Override
	public int deleteRecipeLike(LikesDto likesDto) {
		
		return sm.delete("Recipe_deleteLike", likesDto);
	}

	@Override
	public boolean checkRecipeLike(LikesDto likesDto) {
		if( sm.selectOne("Recipe_selectLike", likesDto) == null ) {
			return true;
		}
		return false;
	}

	@Override
	public List<RecipeDto> getRecipeLikeList(long mem_seq) {
		
		return sm.selectList("Recipe_getLikeList", mem_seq);
	}

	
	

}
