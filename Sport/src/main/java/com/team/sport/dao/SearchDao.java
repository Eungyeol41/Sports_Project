package com.team.sport.dao;

import java.util.List;

import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;

public interface SearchDao extends GenericDao<SearchVO, String>{
	
	public List<DetailDTO> selectView();
	
	public List<AllListVO> selectAllList();

}
