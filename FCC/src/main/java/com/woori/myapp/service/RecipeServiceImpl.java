package com.woori.myapp.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.repository.RecipeDao;

import jakarta.annotation.Resource;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

	@Resource(name = "recipeDao")
	RecipeDao dao;

	private static int totalCnt;
	

	@Override
	public List<RecipeDto> getRecipeList(RecipeDto dto) {

		return dao.getRecipeList(dto);
	}

	@Override
	public int getRecipeTotalCnt() {
		if (totalCnt == 0) {
			totalCnt = dao.getRecipeTotalCnt();
		}
		return totalCnt;
	}

	@Override
	public RecipeDto getRecipeInfo(Integer rcp_seq) {

		return dao.getRecipeInfo(rcp_seq);
	}

	@Override
	public HashMap<String, Object> analyzeRecipe(RecipeDto recipeInfo) {
		
		HashMap<String, Object> map = new HashMap<>();
		int rcp_per_eng = (int)(recipeInfo.getRcp_eng() / 5);
		int rcp_per_car = (int)(recipeInfo.getRcp_car() * 3 / 2);
		int rcp_per_pro = (int)(recipeInfo.getRcp_pro() * 2);
		int rcp_per_fat = (int)(recipeInfo.getRcp_fat() * 7 / 3);
		int rcp_per_na = (int)(recipeInfo.getRcp_na() / 10);
		
		if (rcp_per_eng > 100) rcp_per_eng = 100;
		if (rcp_per_car > 100) rcp_per_car = 100;
		if (rcp_per_pro > 100) rcp_per_pro = 100;
		if (rcp_per_fat > 100) rcp_per_fat = 100;
		if (rcp_per_na > 100) rcp_per_na = 100;
		
		map.put("rcp_per_eng", rcp_per_eng+"%");
		map.put("rcp_per_car", rcp_per_car+"%");
		map.put("rcp_per_pro", rcp_per_pro+"%");
		map.put("rcp_per_fat", rcp_per_fat+"%");
		map.put("rcp_per_na", rcp_per_na+"%");
		return map;
	}


}
