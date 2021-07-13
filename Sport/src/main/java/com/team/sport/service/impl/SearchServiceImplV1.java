package com.team.sport.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.sport.dao.SearchDao;
import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;
import com.team.sport.service.SearchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("searchServiceV1")
public class SearchServiceImplV1 implements SearchService{

	protected final SearchDao sDao;
	
	@Override
	public List<SearchVO> selectAll() {
		
		return null;
		
	}

	@Override
	public List<DetailDTO> selectView() {
		
		List<DetailDTO> dtList = sDao.selectView();
		
		return dtList;
	}

	@Override
	public List<AllListVO> selectAllList() {
		
		List<AllListVO> alList = sDao.selectAllList();
		return alList;
	}

	@Override
	public DetailDTO findSeq(Long v_seq) {
		// TODO Auto-generated method stub
		
		DetailDTO dtDTO = sDao.findSeq(v_seq);
		return dtDTO;
	}

	@Override
	public List<DetailDTO> findByDistric(String keyword) {
		
		List<DetailDTO> dtList = sDao.findByDistric(keyword);
		
		return dtList;
	}

	@Override
	public List<DetailDTO> findBySearch(String keyword) {

		List<DetailDTO> dtList = sDao.findBySearch(keyword);
		
		return dtList;
	}

	@Override
	public List<DetailDTO> findBySport(String keyword) {

		List<DetailDTO> dtList = sDao.findBySport(keyword);
		
		return dtList;
	}

	@Override
	public DetailDTO findFree(String v_free) {
		
		DetailDTO dtDTO = sDao.findFree(v_free);
		
		return dtDTO;
	}

}
