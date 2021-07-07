package com.team.sport.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.sport.dao.QnADao;
import com.team.sport.model.QnAVO;
import com.team.sport.service.QnAService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value="/qna")
public class QnAController {
	protected final QnADao qnaDao;
	protected final QnAService qnaService;

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String qna(Model model) {
			
		List<QnAVO> qnaList = qnaService.selectAll();
		model.addAttribute("QNA", qnaList);
		
		log.debug("qnaList: {}", qnaList);
		
		return "/qna/list";
	}
//	@RequestMapping(value = "/list", method = RequestMethod.POST)
//	public String list(@RequestParam(defaultValue = "text") String search_option,
//			@RequestParam(defaultValue = "")String keyword) { //option 1번 text , 기본값 keyword
//		
//		QnAVO vo = new QnAVO();
//		List<QnAVO> qnaList = qnaService.selectAll(search_option, keyword);
//		
//		Map<String, Object> map = new HashMap<>();
//		
//		map.put("search_option", search_option);
//		map.put("keyword", keyword);
//		
//		qnaList.add(map);
//		
//
//		
//		return "/qna/list";
//	}
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(Model model, Long seq) {
		
		QnAVO vo = qnaService.detail(seq);
		model.addAttribute("QNA", vo);
		return "/qna/detail";
		
	}
	@RequestMapping(value="/write", method= RequestMethod.GET)
	public String insert() {
		
		
		return "/qna/write";
	}
	
	@RequestMapping(value="/write", method= RequestMethod.POST)
	public String insert( QnAVO vo) {
		
		Integer res = qnaService.insert(vo);
		return "redirect:/qna";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String update(Long seq,Model model) {
		
		QnAVO vo = qnaService.findById(seq);
		model.addAttribute("QNA",vo);
		
		return "/qna/insert";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String update(QnAVO vo) {
		
		Integer res = qnaService.update(vo);
		
		return "redirect:/qna";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(Long seq) {
		
		qnaService.delete(seq);
		
		return "redirect:/qna";
		
	}
}
