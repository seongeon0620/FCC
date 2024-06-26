package com.woori.myapp.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woori.myapp.entity.IngreDto;

@Repository("ingreDao")
public class IngreDaoImpl implements IngreDao {
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<String> getMainList() {
		return sm.selectList("Ingre_getMainList");
	}

	@Override
	public List<IngreDto> getSubList(String category) {
		return sm.selectList("Ingre_getSubList", category);
	}

}
