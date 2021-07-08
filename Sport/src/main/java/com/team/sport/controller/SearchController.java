package com.team.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
/*
*asdasdgasfgasgasdasd
*/
@Controller
@Slf4j
@RequestMapping(value="/search")
public class SearchController {
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String search(Model model) {
		
		return "search/search";
	}
	
	@RequestMapping(value = {"/","/detail"}, method = RequestMethod.GET)
	public String detail(Model model) {
		
		return "search/detail";
	}
	
	@RequestMapping(value = {"/","/board"}, method = RequestMethod.GET)
	public String board(Model model) {
		
		return "search/board";
	}
}
