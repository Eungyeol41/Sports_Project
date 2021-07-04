package com.team.sport.service;

import java.util.List;

public interface GenericService <VO,PK>{
	
	public List<VO> selectAll();
	public Integer insert(VO vo);
	public Integer update(VO vo);
	public Integer delete(PK pk);

}
