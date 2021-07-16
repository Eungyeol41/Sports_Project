package com.team.sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;

public interface SearchDao extends GenericDao<AllListVO, String>{
	
	public List<DetailDTO> selectView();
	public DetailDTO findSeq(Long v_seq);
	
	public List<AllListVO> selectAllList();

	public List<AllListVO> findFree(@Param("al_free") String al_free,
									@Param("al_name") String al_name,
									@Param("al_addr") String al_addr
//									@Param("al_sport") String al_sport
//									@Param("addr1") String addr1,
//									@Param("addr2") String addr2,
//									@Param("addr3") String addr3,
//									@Param("addr4") String addr4,
//									@Param("addr5") String addr5
									);
	public List<SearchVO> findBySearch(String search_column, String search_text);
}