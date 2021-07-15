package com.team.sport.service;

import java.util.List;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;

public interface SearchService {

	public List<SearchVO> selectAll();
	
	public DetailDTO findSeq(Long v_seq);
	public List<DetailDTO> selectView();
	
	public List<AllListVO> selectAllList();

	public List<AllListVO> findFree(String al_free, String al_name, String al_addr
			);
	// ,String addr1,String addr2,String addr3,String addr4,String addr5

	
}