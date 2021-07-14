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
						@RequestParam(name="sname", required = false) String al_name ,
						@RequestParam(name="sports", required = false) String al_sport ,
//						@RequestParam(name="dist1" , required = false) String dist1 ,
//						@RequestParam(name="dist2" , required = false) String dist2 ,
//						@RequestParam(name="dist3" , required = false) String dist3 ,
//						@RequestParam(name="dist4" , required = false) String dist4 ,
//						@RequestParam(name="dist5" , required = false) String dist5 ,
						Model model) {
		
		List<AllListVO> alList = sService.findFree(al_free, al_sport, al_sport);
		
		model.addAttribute("RESULT",alList);
		log.debug("free : {}", al_free );
		log.debug("sname : {}", al_name);
		log.debug("sports : {}", al_sport);
//		log.debug("dist1 : {}", dist1);
//		log.debug("dist2 : {}", dist2);
//		log.debug("dist3 : {}", dist3);
//		log.debug("dist4 : {}", dist4);
//		log.debug("dist5 : {}", dist5);
		
		return "/search/search";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(Model model) {
		
		List<DetailDTO> dtList = sService.selectView();
		
		model.addAttribute("DTLIST",dtList);
		return "/search/detail";
	}
	
}