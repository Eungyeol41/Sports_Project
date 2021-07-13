package com.team.sport.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.sport.dao.QnADao;
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
	protected final QnADao qnaDao;
	protected final QnAService qnaService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String qna(Model model) {

		List<QnAVO> qnaList = qnaService.selectAll();
		model.addAttribute("QNA", qnaList);

//		log.debug("qnaList: {}", qnaList);

		return "/qna/list";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(Model model, Long seq, HttpSession session) {

		log.debug("controller seq {}", seq);

		UserVO uservo = (UserVO) session.getAttribute("USER");

//		log.debug("UserVO {}", uservo.toString());

		if (uservo == null) {
			return "redirect:/user/login";
		} else {
			QnAVO qnavo = qnaService.detail(seq);
			qnaService.countUpdate(seq);
			model.addAttribute("QNA", qnavo);
			return "/qna/detail";
		}
//		if(qna_id ==  )

	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String insert(Model model, HttpSession session) {

//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//		
//		String curDate = sd.format(date);
//		
//		model.addAttribute("DATE",curDate);

		UserVO uservo = (UserVO) session.getAttribute("USER");

//		log.debug("UserVO {}", uservo.toString());

		if (uservo == null) {
			return "redirect:/user/login";
		} else {

			return "/qna/write";
		}
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String insert(QnAVO vo) {

		Integer res = qnaService.insert(vo);
		return "redirect:/qna";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String update(Long seq, Model model, HttpSession session) {

		UserVO uservo = (UserVO) session.getAttribute("USER");

		String qna_id = uservo.getUser_id();

		List<QnAVO> qnaList = qnaService.findByIdWithList(qna_id);

		QnAVO vo = qnaService.findById(seq);
		model.addAttribute("QNA", vo);

//		log.debug("Qna VO {}", vo.toString());

		return "/qna/insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
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
//		log.debug("detail seq {}", seq.toString());
		return "redirect:/qna";

	}

	@RequestMapping(value = "/search/title", method = RequestMethod.GET)
	public String searchTitle(Model model, String keyword) {

		List<QnAVO> qnaList = qnaService.findByTitle(keyword);

		log.debug("controller title : {}", qnaList.toString());

		model.addAttribute("RESULT", qnaList);

		// 왜 redirect를 쓰면 되지 않는건가........
		return "/qna/list";
	}

	@RequestMapping(value = "/search/text", method = RequestMethod.GET)
	public String searchText(Model model, String keyword) {

		List<QnAVO> qnaList = qnaService.findByText(keyword);

		log.debug("controller title : {}", qnaList.toString());

		model.addAttribute("RESULT", qnaList);

		return "/qna/list";
	}

	@RequestMapping(value = "/search/user", method = RequestMethod.GET)
	public String searchUser(Model model, String keyword) {

		List<QnAVO> qnaList = qnaService.findByUser(keyword);

		log.debug("controller title : {}", qnaList.toString());

		model.addAttribute("RESULT", qnaList);

		return "/qna/list";
	}
}
