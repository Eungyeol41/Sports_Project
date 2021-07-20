package com.team.sport.service;

import java.util.List;

import org.springframework.ui.Model;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;

public interface SearchService {

	public DetailDTO findSeq(Long v_seq);
	public List<DetailDTO> selectView();
	
	public List<AllListVO> selectAllList(int intPageNum, Model model) throws Exception;

	public List<AllListVO> findFree(String al_free, String al_name, String al_addr, String al_sport
			,int intPageNum, Model model) throws Exception ;

	List<AllListVO> selectAllPage(int intPageNum, Model model) throws Exception;

	void findBySearchPage(int pageNum, Model model);

	public DetailDTO findBySeq(Long seq);
}