package com.woori.myapp.service;

import java.util.List;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.MainDto;
import com.woori.myapp.entity.RecipeDto;

public interface MainService {
	// 냉장고
	List<MainDto> getFrigoInfo ( MainDto mto );
	
	// 레시피
	List<RecipeDto> getRecipeList ( RecipeDto Rto );
	
	// 영양 성분
	MainDto getNutritionInfo ( MainDto mto );
	
	// 냉장고 신선도
	MainDto getFrigoFreshInfo ( MainDto mto );


}
