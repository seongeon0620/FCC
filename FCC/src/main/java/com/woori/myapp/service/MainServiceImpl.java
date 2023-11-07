package com.woori.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.MainDto;
import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.repository.MainDao;

import jakarta.annotation.Resource;

@Service("mainService")
public class MainServiceImpl implements MainService {
	
	@Resource( name="mainDao" )
	MainDao dao;

	@Override
	public List<MainDto> getFrigoInfo(MainDto mto) {
		return dao.getFrigoInfo(mto);
	}

	@Override
	public List<RecipeDto> getRecipeList(RecipeDto Rto) {
		System.out.println("service***************************************");
		return dao.randomRecipeList(Rto);
	}

	@Override
	public MainDto getNutritionInfo(MainDto mto) {
		MainDto resultNutiIto = dao.getNutritionInfo(mto);
		return resultNutiIto;
	}

	@Override
	public MainDto getFrigoFreshInfo(MainDto mto) {
		MainDto resultFreshIto = dao.getFrigoFreshInfo( mto );
		return resultFreshIto;
	}
	

}
