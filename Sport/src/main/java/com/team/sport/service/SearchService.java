package com.team.sport.service;

import java.util.List;

import com.team.sport.model.SearchVO;

public interface SearchService {

	public List<SearchVO> selectAll();
	
	public List<SearchVO> selectMoney();
	public List<SearchVO> selectDistric();
	public List<SearchVO> selectSearch();
	public List<SearchVO> selectSport();
	
}
