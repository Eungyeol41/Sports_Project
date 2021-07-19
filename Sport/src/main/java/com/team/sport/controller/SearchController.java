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
	public String search(
			@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum,
			Model model) {
		
		List<AllListVO> alList = sService.selectAllList();
//		int intPageNum = Integer.valueOf(pageNum);
//		      List<AllListVO> alList = sService.selectAllPage(intPageNum, model);
//		   
//		      if(intPageNum > 0) {
//		         model.addAttribute("PAGE_NUM", intPageNum);
//		      }
//		      
//		      sService.findBySearchPage(intPageNum, model, pageNum);
//		
		model.addAttribute("ALLIST",alList);
		return "/search/search";
	}
	
	@RequestMapping(value ={"/",""}, method = RequestMethod.POST)
	public String search(@RequestParam(name="free", required = false, defaultValue = "") String al_free ,
						@RequestParam(name="search", required = false, defaultValue = "") String al_name ,
						@RequestParam(name="search_sports", required = false ,defaultValue = "1") String al_sport ,
						@RequestParam(name="addr[]", required = false, defaultValue = "") String al_addr,
						
						Model model) {
		
//		String[] dist = request.getParameterValues("addr[]");
		
		log.debug(al_addr);
		String addrs[] = al_addr.split(",");
		// List<AllListVO> alList = sService.findFree(al_free, al_name, al_addr, al_sport);
		List<AllListVO> alList = sService.findFree(al_free, al_name, addrs, al_sport);
		
		model.addAttribute("RESULT",alList);
		log.debug("free : {}", al_free );
		log.debug("al_name : {}", al_name);
		log.debug("al_addr : {}", al_addr);
		log.debug("al_sport : {}", al_sport);
	
		return "/search/search";
	}
	@RequestMapping(value="/detail2", method=RequestMethod.GET)
	public String findSeq(Long seq, Model model) {
		
		DetailDTO dto = sService.findSeq(seq); 
		
		model.addAttribute("DT",dto);
		return "/search/detail2";
	}
	
//	@RequestMapping(value="/detail2", method=RequestMethod.GET)
//	public String detail(Model model) {
//		
//		List<DetailDTO> dtList = sService.selectView();
//		
//		model.addAttribute("DTLIST",dtList);
//		return "/search/detail2";
//	}
	
//	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
//	public String all_list(Model model) {
//		
//		List<AllListVO> alList = sService.selectAllList();
//		
//		model.addAttribute("ALLIST",alList);
//		return "/search/search";
//	}

}