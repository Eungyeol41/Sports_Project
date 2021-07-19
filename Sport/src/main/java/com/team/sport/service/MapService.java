package com.team.sport.service;

import java.util.List;

import com.team.sport.model.DetailVO;

public interface MapService extends GenericService<DetailVO, String>{

	public List<DetailVO> select();
	
	public List<DetailVO> selectAddr(String al_addr);

	public int insert(DetailVO vo);
	
	public int update(DetailVO vo);
	
}
