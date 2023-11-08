package com.woori.myapp.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.RecipeDto;

@Repository("mainDao")
public class MainDaoImpl implements MainDao{
	
	@Autowired
	SqlSessionTemplate sm;

	// 냉장고 요약
	@Override
	public List<FrigoDto> getFrigoInfo(FrigoDto Fto) {
		return sm.selectList( "MainRefriList", Fto );
	}
	
	// 냉동고
	@Override
	public List<FrigoDto> getIceInfo(FrigoDto Fto) {
		return sm.selectList( "MainIceList", Fto );
	}
	
	// 실온
	@Override
	public List<FrigoDto> getIndoorInfo(FrigoDto Fto) {
		return sm.selectList( "MainIndoorList", Fto );
	}
	
	// 레시피
	@Override
	public List<RecipeDto> randomRecipeList(RecipeDto Rto) {
		System.out.println("daoimpl >>>>> " + sm.selectList( "randomRecipeList", Rto ) );
		return sm.selectList( "randomRecipeList", Rto );
	}
	
	// 영양 성분
	@Override
	public IngreDto getNutritionInfo(IngreDto Ito) {
		return sm.selectOne( "getNutritionInfo", Ito );
	}
	
	// 냉장고 신선도
	@Override
	public FrigoDto getFrigoFreshInfo( FrigoDto Fto ) {
		return sm.selectOne( "RefriFreshInfo", Fto );
	}


}
