package com.team.sport.service;

import java.util.List;

import org.springframework.ui.Model;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;

public interface SearchService {

	public List<AllListVO> selectAll();
	
	public DetailDTO findSeq(Long v_seq);
	public List<DetailDTO> selectView();
	
	public List<AllListVO> selectAllList();

	public List<AllListVO> findFree(String al_free, String al_name, String al_addr, String al_sport
			);

	public List<AllListVO> selectAllPage(int intPageNum, Model model);

	public void findBySearchPage(int intPageNum, Model model, String pageNum);

	public List<AllListVO> findFree(String al_free, String al_name, String[] addrs, String al_sport);

}