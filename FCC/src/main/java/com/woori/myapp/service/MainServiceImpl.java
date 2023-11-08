package com.woori.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.IngreDto;
import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.repository.MainDao;

import jakarta.annotation.Resource;

@Service("mainService")
public class MainServiceImpl implements MainService {
	
	@Resource( name="mainDao" )
	MainDao dao;

	@Override
	public List<FrigoDto> getFrigoInfo(FrigoDto Fto) {
		return dao.getFrigoInfo(Fto);
	}

	@Override
	public List<FrigoDto> getIceInfo(FrigoDto Fto) {
		return dao.getIceInfo(Fto);
	}

	@Override
	public List<FrigoDto> getIndoorInfo(FrigoDto Fto) {
		return dao.getIndoorInfo(Fto);
	}

	@Override
	public List<RecipeDto> getRecipeList(RecipeDto Rto) {
		System.out.println("service***************************************");
		return dao.randomRecipeList(Rto);
	}

	@Override
	public IngreDto getNutritionInfo(IngreDto Ito) {
		IngreDto resultNutiIto = dao.getNutritionInfo(Ito);
		return resultNutiIto;
	}

	@Override
	public FrigoDto getFrigoFreshInfo(FrigoDto Fto) {
		FrigoDto resultFreshIto = dao.getFrigoFreshInfo(Fto);
		return resultFreshIto;
	}
	

}
