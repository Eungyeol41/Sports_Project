package com.team.sport.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.sport.model.AllListVO;
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;
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
						@RequestParam(name="sname", required = false) String al_name ,
						@RequestParam(name="al_addr", required = false) String al_addr ,
//						@RequestParam(name="sports", required = false) String al_sport ,
//						@RequestParam(name="addr1" , required = false) String addr1 ,
//						@RequestParam(name="addr2" , required = false) String addr2 ,
//						@RequestParam(name="addr3" , required = false) String addr3 ,
//						@RequestParam(name="addr4" , required = false) String addr4 ,
//						@RequestParam(name="addr5" , required = false) String addr5 ,
						Model model) {
		
		List<AllListVO> alList = sService.findFree(al_free, al_name, al_addr
				);
		// ,addr1,addr2,addr3,addr4,addr5
		
		model.addAttribute("RESULT",alList);
		log.debug("free : {}", al_free );
		log.debug("al_name : {}", al_name);
		log.debug("al_addr : {}", al_addr);
//		log.debug("al_sport : {}", al_sport);
//		log.debug("sname : {}", addr1);
//		log.debug("sname : {}", addr2);
//		log.debug("sname : {}", addr3);
//		log.debug("sname : {}", addr4);
//		log.debug("sname : {}", addr5);

		
		return "/search/search";
	}
//	@RequestMapping(value="/detail2", method=RequestMethod.GET)
//	public String detail(Model model) {
//		
//		List<DetailDTO> dtList = sService.selectView();
//		
//		model.addAttribute("DT",dtList);
//		return "/search/detail2";
//	}
	
	@RequestMapping(value="/detail2", method=RequestMethod.GET)
	public String detail(Model model) {
		
		List<DetailDTO> dtList = sService.selectView();
		
		model.addAttribute("DT",dtList);
		return "/search/detail2";
	}
	
	@RequestMapping(value = "/allList", method = RequestMethod.GET)
	public String allList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") String pageNum, Model model) {
		
		int intPageNum = Integer.valueOf(pageNum);
		List<SearchVO> gList = gService.selectAllPage(intPageNum, model);
		
		if(intPageNum > 0) {
			model.addAttribute("PAGE_NUM", intPageNum);
		}
		
		return "search/all_list";
	}
	
}