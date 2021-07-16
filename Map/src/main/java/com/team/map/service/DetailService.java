package com.team.map.service;

import java.util.List;

import com.team.map.model.DetailVO;

public interface DetailService {

	public List<DetailVO> selectAddr(String al_addr);

	public int insert(DetailVO vo);

	public int update(DetailVO vo);
	
}
