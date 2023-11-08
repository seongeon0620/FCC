package com.woori.myapp.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.MainDto;
import com.woori.myapp.entity.RecipeDto;

@Repository("mainDao")
public class MainDaoImpl implements MainDao{
	
	@Autowired
	SqlSessionTemplate sm;

	// 냉장고 요약
	@Override
	public List<MainDto> getFrigoInfo(MainDto mto) {
		return sm.selectList( "MainRefriList", mto );
	}
	
	// 레시피
	@Override
	public List<RecipeDto> randomRecipeList(RecipeDto Rto) {
		return sm.selectList( "randomRecipeList", Rto );
	}
	
	// 영양 성분
	@Override
	public MainDto getNutritionInfo(MainDto mto) {
		return sm.selectOne( "ingreNutritionInfo", mto );
	}
	
	// 냉장고 신선도
	@Override
	public MainDto getFrigoFreshInfo( MainDto mto ) {
		return sm.selectOne( "RefriFreshInfo", mto );
	}


}
