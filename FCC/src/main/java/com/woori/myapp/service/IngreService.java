package com.woori.myapp.service;

import java.util.List;

import com.woori.myapp.entity.IngreDto;

public interface IngreService {
	List<String> getMainList();
	List<IngreDto> getSubList(String category);
}
