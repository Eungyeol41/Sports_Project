package com.team.map.dao;

import java.util.List;

import com.team.map.model.MapVO;

public interface MapDao {

	public List<MapVO> selectAll();

	public int insert();

}
