package com.team.map.dao;

import java.util.List;
import java.util.Map;

import com.team.map.model.DetailVO;


public interface DetailDao {

	public List<DetailVO> selectAll();

	public int insert(Map<String, String> map);
	
	public int update(Map<String, String> map);

}
