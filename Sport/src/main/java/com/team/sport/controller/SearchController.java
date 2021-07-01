package com.team.sport.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
/*
*asdasdgasfgasg
*/
@Controller
@Slf4j
@RequestMapping(value="/search")
public class SearchController {
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String search(Locale locale, Model model) {
		
		return "search/search";
	}
	
}
