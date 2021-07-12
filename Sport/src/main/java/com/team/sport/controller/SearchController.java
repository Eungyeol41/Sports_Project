package com.team.sport.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.sport.dao.SearchDao;
import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.QnAVO;
import com.team.sport.service.SearchService;

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
	
	protected final SearchService sService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String search(Model model) {
		
		List<DetailDTO> dtList = sService.selectView();
		
		model.addAttribute("DTLIST",dtList);
		
		return "search/search";
	}
	
	@RequestMapping(value = "/detail2", method = RequestMethod.GET)
	public String detail(Model model, Long v_seq) {
		
		DetailDTO dtDTO = sService.findSeq(v_seq);
		model.addAttribute("DT", dtDTO);
		return "/search/detail2";
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Model model) {
		List<DetailDTO> dtList = sService.selectView();
		model.addAttribute("DTLIST",dtList);
		return "/search/board";
	}
	
	@RequestMapping(value="/distric", method=RequestMethod.GET)
	public String distric(Model model, String keyword) {
		
		List<DetailDTO> dtList = sService.findByDistric(keyword);
		
		model.addAttribute("RESULT",dtList);
		
		return "/search/search";
	}
	
	@RequestMapping(value="/searchinput", method=RequestMethod.GET)
	public String searchinput(Model model, String keyword) {
		
		List<DetailDTO> dtList = sService.findBySearch(keyword);
		
		model.addAttribute("RESULT",dtList);
		
		return "/search/search";
	}
	
	@RequestMapping(value="/sport", method=RequestMethod.GET)
	public String sport(Model model, String keyword) {
		
		List<DetailDTO> dtList = sService.findBySport(keyword);
		
		model.addAttribute("RESULT",dtList);
		
		return "/search/board";
	}
}
