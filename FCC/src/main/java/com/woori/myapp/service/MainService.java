package com.woori.myapp.service;

import java.util.List;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.RecipeDto;

public interface MainService {
	// 냉장고
	List<FrigoDto> getFrigoInfo ( FrigoDto Fto );
	
	// 냉동고
	List<FrigoDto> getIceInfo ( FrigoDto Fto );
	
	// 실온 보관
	List<FrigoDto> getIndoorInfo ( FrigoDto Fto );
	
	// 레시피
	List<RecipeDto> getRecipeList ( RecipeDto Rto );
	
	// 영양 성분
	IngreDto getNutritionInfo ( IngreDto Ito );
	
	// 냉장고 신선도
	FrigoDto getFrigoFreshInfo ( FrigoDto Fto );

}
