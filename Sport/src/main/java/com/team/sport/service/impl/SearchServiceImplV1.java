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
public class SearchServiceImplV1 implements SearchService {

	protected final SearchDao sDao;
	protected final PageService pService;

	@Override
	public List<AllListVO> selectAll() {

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
	public List<AllListVO> findFree(String al_free, String al_name, String al_addr, String al_sport) {

		List<AllListVO> alList = sDao.findFree(al_free, al_name, al_addr, al_sport);

		return alList;
	}
	
	
	@Override
	public List<AllListVO> findFree(String al_free, String al_name, String[] addrs, String al_sport) {

		List<AllListVO> alList = sDao.findFreeAddr(al_free, al_name, addrs, al_sport);
		
		return alList;
	}


	@Override
	public DetailDTO findSeq(Long v_seq) {

		DetailDTO dtDTO = sDao.findSeq(v_seq);
		return dtDTO;
	}

	@Override
	public List<AllListVO> selectAllPage(int intPageNum, Model model) {
		// TODO Auto-generated method stub
		List<AllListVO> allistAll = sDao.selectAll();
		int totalListSize = allistAll.size();
//	      log.debug("데이터 개수 : {}", totalListSize);

		PageDTO pageDTO = pService.makePagination(totalListSize, intPageNum);

		List<AllListVO> pageList = new ArrayList<>();
		for (int i = pageDTO.getOffset(); i < pageDTO.getLimit(); i++) {
			pageList.add(allistAll.get(i));
		}

		model.addAttribute("PAGE_NAV", pageDTO);
		model.addAttribute("PLIST", pageList);

		return null;

	}

	@Override
	public void findBySearchPage(int intPageNum, Model model, String pageNum) {
		// TODO Auto-generated method stub
		List<AllListVO> alList = sDao.selectAll();

		int totalListSize = alList.size();
		PageDTO pageDTO = pService.makePagination(totalListSize, intPageNum);

		List<AllListVO> pList = new ArrayList<>();

		for (int i = pageDTO.getOffset(); i < pageDTO.getLimit(); i++) {
			pList.add(alList.get(i));
		}

		model.addAttribute("PLIST", pList);

	}


}