package com.team.sport.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.service.SearchService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/search")
public class SearchController {
	
	protected final SearchService sService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String search(Model model) {
		
		List<AllListVO> alList = sService.selectAllList();
		
		model.addAttribute("ALLIST",alList);
		return "/search/search";
	}
	
	@RequestMapping(value ={"/",""}, method = RequestMethod.POST)
	public String search(@RequestParam(name="free", required = false) String al_free ,
						@RequestParam(name="search", required = false) String al_name ,
						@RequestParam(name="dong", required = false) String al_addr ,
						@RequestParam(name="search_sports", required = false ,defaultValue = "1") String al_sport ,

						Model model) {
		
		
		List<AllListVO> alList = sService.findFree(al_free, al_name, al_addr, al_sport
				);
		
		model.addAttribute("RESULT",alList);
		log.debug("free : {}", al_free );
		log.debug("al_name : {}", al_name);
		log.debug("al_addr : {}", al_addr);
		log.debug("al_sport : {}", al_sport);


		
		return "/search/search";
	}
	@RequestMapping(value="/findSeq", method=RequestMethod.GET)
	public String findSeq(Long seq, Model model, DetailDTO dto) {
		
		dto.getV_seq();
		sService.findSeq(seq);
		model.addAttribute("DT",seq);
		return "/search/detail2";
	}
	
	@RequestMapping(value="/detail2", method=RequestMethod.GET)
	public String detail(Model model) {
		
		List<DetailDTO> dtList = sService.selectView();
		
		model.addAttribute("DTLIST",dtList);
		return "/search/detail2";
	}
	
//	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
//	public String all_list(Model model) {
//		
//		List<AllListVO> alList = sService.selectAllList();
//		
//		model.addAttribute("ALLIST",alList);
//		return "/search/search";
//	}

	
}