package com.team.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.team.sport.model.SearchVO;
import com.team.sport.service.SearchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchServiceImplV1 implements SearchService{

	@Override
	public List<SearchVO> selectAll() {
		List<SearchVO> scList = new ArrayList<SearchVO>();
		log.debug("Search {} ", scList.toString());
		
		return scList;
		
	}

	@Override
	public List<SearchVO> selectMoney() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchVO> selectDistric() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchVO> selectSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchVO> selectSport() {
		// TODO Auto-generated method stub
		return null;
	}

}
