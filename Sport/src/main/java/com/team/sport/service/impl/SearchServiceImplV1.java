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
	public List<AllListVO> findFree(String al_free, String al_name, String al_addr
			) {
		
		//String al_sport,String addr1,String addr2,String addr3,String addr4,String addr5
		List<AllListVO> alList = sDao.findFree(al_free, al_name, al_addr
				);
//		log.debug("asdasdasd :",al_sport);
		// , al_sport,addr1,addr2,addr3,addr4,addr5
		return alList;
	}

	@Override
	public DetailDTO findSeq(Long v_seq) {
		
		DetailDTO dtDTO = sDao.findSeq(v_seq);
		return dtDTO;
	}





}