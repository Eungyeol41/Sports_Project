package com.team.sport.service;

import java.util.List;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;

public interface SearchService {

	public List<SearchVO> selectAll();
	
	public List<DetailDTO> selectView();
	
	public List<AllListVO> selectAllList();
	
	public DetailDTO findSeq(Long v_seq);
	
	public List<SearchVO> selectMoney();
	public List<SearchVO> selectDistric();
	public List<SearchVO> selectSearch();
	public List<SearchVO> selectSport();
	
}
