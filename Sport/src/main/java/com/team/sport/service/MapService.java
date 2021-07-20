package com.team.sport.service;

import java.util.List;
import java.util.Map;

import com.team.sport.model.DetailVO;

public interface MapService extends GenericService<DetailVO, String>{

	public List<DetailVO> select();
	
	public List<DetailVO> selectAddr(String al_addr);

	public int insert(DetailVO vo);
	
	public int insert(Map<String, String> map);
	
	public int update(Map<String, String> map);
	

	
	
}
