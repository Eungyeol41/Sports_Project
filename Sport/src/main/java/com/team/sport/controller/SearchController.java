package com.team.sport.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.sport.dao.AllListVO;
import com.team.sport.dao.SearchDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/*
*asdasdgasfgasgasdasd
*/
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/search")
public class SearchController {
	
	protected final SearchDao sDao;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String search(Model model) {
		
		List<AllListVO> alList = sDao.selectAllList();
		
		model.addAttribute("ALLIST",alList);
		
		return "search/search";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model) {
		
		return "search/detail";
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Model model) {
		
		return "search/board";
	}
}
