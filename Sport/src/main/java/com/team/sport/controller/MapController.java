package com.team.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.sport.model.MapVO;

@Controller
//@RequiredArgsConstructor
@RequestMapping(value = "/map")
public class MapController {
	
//	protected final MapDao mapDao;

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String map(Model model, MapVO vo) {
		
//		MapVO mapVO = mapDao.insert(vo);
		
		return "map/basic";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(Model model, MapVO vo) {
		return "map/search";
	}
}
