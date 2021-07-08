package com.team.sport.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.sport.dao.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;
import com.team.sport.service.SearchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("searchServiceV1")
public class SearchServiceImplV1 implements SearchService{

	protected final SearchService sService;
	
	@Override
	public List<SearchVO> selectAll() {
		
		return null;
		
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

	@Override
	public List<DetailDTO> selectView() {
		
		List<DetailDTO> dtList = sService.selectView();
		
		return dtList;
	}

	@Override
	public List<AllListVO> selectAllList() {
		
		List<AllListVO> alList = sService.selectAllList();
		return alList;
	}

}
