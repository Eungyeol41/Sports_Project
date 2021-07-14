package com.team.sport.dao;

import java.util.List;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;

public interface SearchDao extends GenericDao<AllListVO, String>{
	
	public List<DetailDTO> selectView();
	
	public List<AllListVO> selectAllList();

	public List<AllListVO> findFree(String al_free, String al_name, String al_sport);
}