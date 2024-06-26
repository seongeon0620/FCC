package com.woori.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woori.myapp.entity.FrigoDto;
import com.woori.myapp.entity.FrigoResponseDto;
import com.woori.myapp.entity.MemberDto;
import com.woori.myapp.entity.RecipeDto;
import com.woori.myapp.repository.FrigoDao;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;

@Service("frigoService")
public class FrigoServiceImpl implements FrigoService {
	
	@Resource(name="frigoDao")
	FrigoDao dao;
	
	@Autowired
	private HttpSession session;

	@Override
	public FrigoResponseDto insert(FrigoDto dto) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");
		dto.setMem_seq(memberDto.getmem_seq());
		
		dao.insert(dto);
		FrigoResponseDto reponseDto = dao.getInsertResult(dto.getFrigo_seq());
		return reponseDto;
	}

	@Override
	public List<FrigoResponseDto> getList(FrigoResponseDto frigoResponseDto, String category) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");
		frigoResponseDto.setMem_seq(memberDto.getmem_seq());
		
		frigoResponseDto.setFrigo_storage(category);
		return dao.getList(frigoResponseDto);
	}

	@Override
	public int deleteAll(FrigoDto frigoDto) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");
		frigoDto.setMem_seq(memberDto.getmem_seq());
		
		return dao.deleteAll(frigoDto);
	}

	@Override
	public int deleteOne(FrigoDto frigoDto) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");
		frigoDto.setMem_seq(memberDto.getmem_seq());
		
		return dao.deleteOne(frigoDto);
	}

	@Override
	public int updateDatail(FrigoDto frigoDto) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");
		frigoDto.setMem_seq(memberDto.getmem_seq());
		
		return dao.updateDetail(frigoDto);
	}

	@Override
	public int updateStatus(FrigoDto frigoDto) {
		MemberDto memberDto = (MemberDto) session.getAttribute("logInfo");
		frigoDto.setMem_seq(memberDto.getmem_seq());
		
		return dao.updateStatus(frigoDto);
	}

	@Override
	public List<RecipeDto> getRecipeList() {
		return dao.getRecipeList();
	}

	
	
}
