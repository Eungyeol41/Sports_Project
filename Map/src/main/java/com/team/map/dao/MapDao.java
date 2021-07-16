package com.team.map.dao;

import java.util.List;
import java.util.Map;

import com.team.map.model.MapVO;

public interface MapDao {

	public List<MapVO> selectAll();

	public int insert(Map<String, String> map);

}
