package com.woori.myapp.repository;

import java.util.List;

import com.woori.myapp.entity.IngreDto;

public interface IngreDao {
	List<String> getMainList();
	List<IngreDto> getSubList(String category);
}
