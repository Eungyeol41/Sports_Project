package com.team.sport.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.sport.model.QnAVO;
import com.team.sport.model.UserVO;
import com.team.sport.service.QnAService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/qna")
public class QnAController {
	protected final QnAService qnaService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String qna(Model model) {

		List<QnAVO> qnaList = qnaService.selectAll();
		model.addAttribute("QNA", qnaList);

//		log.debug("qnaList: {}", qnaList);

		return "/qna/list";
	}


	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, Long seq, HttpSession session ) {
		
		UserVO uservo = (UserVO) session.getAttribute("USER");
		
		if(uservo == null) {
			return "redirect:/user/login";
		}
		QnAVO qnavo = qnaService.findById(seq);
		qnaService.countUpdate(seq);
		model.addAttribute("QNA", qnavo);
		return "/qna/detail";
		
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String insert(Model model,HttpSession session,Long seq) {
		
		UserVO uservo = (UserVO) session.getAttribute("USER");
		
		if(uservo == null) {
			return "redirect:/user/login";
		}
		
		QnAVO qnavo = new QnAVO();
		model.addAttribute("QNA", qnavo);
		return "/qna/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String insert(QnAVO vo) {

		Integer res = qnaService.insert(vo);
		return "redirect:/qna";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Long seq, Model model) {

		QnAVO vo = qnaService.findById(seq);
		model.addAttribute("QNA", vo);

//		log.debug("Qna VO {}", vo.toString());

		return "/qna/insert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Long seq, QnAVO vo) {

		vo.setQna_seq(seq);
		Integer res = qnaService.update(vo);
//		log.debug("update Qna VO {}", vo.toString());

		return "redirect:/qna";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long seq, QnAVO vo) {

		vo.setQna_seq(seq);
		qnaService.delete(seq);
//		log.debug("delete seq {}", seq.toString());
		return "redirect:/qna";

	}
	
	@RequestMapping(value="/search/title", method = RequestMethod.GET)
	public String searchTitle(Model model, String keyword) {
		
		List<QnAVO> qnaList = qnaService.findByTitle(keyword);
		log.debug("controller title : {}", qnaList.toString());
		model.addAttribute("RESULT",qnaList);

		return  "/qna/list";
	}
	
	@RequestMapping(value="/search/text", method = RequestMethod.GET)
	public String searchText(Model model, String keyword) {
		
		List<QnAVO> qnaList = qnaService.findByText(keyword);
		log.debug("controller text : {}", qnaList.toString());
		model.addAttribute("RESULT",qnaList);
		
		return  "/qna/list";
	}
	
	@RequestMapping(value="/search/user", method = RequestMethod.GET)
	public String searchUser(Model model, String keyword) {
		
		List<QnAVO> qnaList = qnaService.findByUser(keyword);
		log.debug("controller id : {}", qnaList.toString());
		model.addAttribute("RESULT",qnaList);
		
		return  "/qna/list";
	}
}
