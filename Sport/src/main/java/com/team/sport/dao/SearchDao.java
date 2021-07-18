package com.team.sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;

public interface SearchDao extends GenericDao<AllListVO, String>{
	
	public List<DetailDTO> selectView();
	public DetailDTO findSeq(Long v_seq);
	
	public List<AllListVO> selectAllList();

	public List<AllListVO> findFree(@Param("al_free") String al_free,
									@Param("al_name") String al_name,
									@Param("al_addr") String al_addr,
									@Param("al_sport") String al_sport
									);
	public List<AllListVO> findByAllList(String AllList_column, String AllList_text);
}