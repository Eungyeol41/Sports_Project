package com.team.sport.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team.sport.dao.SearchDao;
import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.PageDTO;
import com.team.sport.model.SearchVO;
import com.team.sport.service.PageService;
import com.team.sport.service.SearchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("searchServiceV1")
public class SearchServiceImplV1 implements SearchService{

	protected final SearchDao sDao;
	protected final PageService pService;
	
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

	@Override
	public void findBySearchPage(String search_column, String search_text, int pageNum, Model model) {
		// TODO Auto-generated method stub
		
		List<SearchVO> gList = sDao.findBySearch(search_column, search_text);
		
		int totalListSize = gList.size();
		PageDTO pageDTO = pService.makePagination(totalListSize, pageNum);
		
		List<SearchVO> pList = new ArrayList<>();
		
		if(pageDTO == null) {
//			model.addAttribute("GALLERYS", gList);
			// 검색 결과 없으면 전체 리스트 나오게 하는거
			model.addAttribute("GALLERYS", gDao.selectAll());
			return;
		}
		
		for(int i = pageDTO.getOffset(); i < pageDTO.getLimit(); i++) {
			pList.add(gList.get(i));
		}
		
		model.addAttribute("GALLERYS", pList);
	}



}