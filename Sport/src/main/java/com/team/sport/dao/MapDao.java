package com.team.sport.dao;

import java.util.List;
import java.util.Map;

import com.team.sport.model.DetailVO;

public interface MapDao extends GenericDao<DetailVO, String>{

	public List<DetailVO> selectAll();
	 
	public List<DetailVO> select(); 

	public int insert(Map<String, String> map);
	
}
