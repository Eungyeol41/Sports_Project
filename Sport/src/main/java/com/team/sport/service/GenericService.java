package com.team.sport.service;

import java.util.List;

public interface GenericService <VO,PK>{
	
	public List<VO> selectAll();
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
	
}
