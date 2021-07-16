package com.team.map.service;

import java.util.List;

import com.team.map.model.MapVO;

public interface MapService {

	public List<MapVO> select();
	
	public List<MapVO> selectAddr(String al_addr);

	public int insert(MapVO vo);
	
}
