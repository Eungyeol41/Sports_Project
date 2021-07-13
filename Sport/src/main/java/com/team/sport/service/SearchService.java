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
	
	public List<DetailDTO> findByDistric(String keyword);
	public List<DetailDTO> findBySearch(String keyword);
	public List<DetailDTO> findBySport(String keyword);
	
}
