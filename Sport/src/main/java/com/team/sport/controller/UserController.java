package com.team.sport.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.sport.model.QnAVO;
import com.team.sport.model.UserVO;
import com.team.sport.service.QnAService;
import com.team.sport.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
	
	protected final UserService userService;
	protected final QnAService qnaService;

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String user() {
		
		return "user/login";
	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(name = "MSG", required = false) String msg, Model model) {
		
		if(msg == null) {
			
			model.addAttribute("MSG", "NONE");
			
		} else if(msg.equals("LOGIN")) {
			
			model.addAttribute("MSG", "로그인을 해주세요!!");
			
		} else if(msg.equals("LOGIN_FAIL")) {
			
			model.addAttribute("MSG", "ID나 PW가 틀렸습니다.");
			
		}
		
		return "user/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("user_id") String user_id, @RequestParam("user_pw") String user_pw, HttpSession hSession, Model model) {
		log.debug("ID : {}", user_id);
		log.debug("비밀번호 : {}", user_pw);
		
		UserVO vo = userService.login(user_id, user_pw);
		
		if(vo == null) {
			
			model.addAttribute("MSG", "LOGIN_FAIL");
			return "redirect:/user/login";
			
		}
		log.debug("UserVO {}", vo.toString());
		hSession.setAttribute("USER", vo);
		return "redirect:/";
	}
	
	// 바로 관리자 창으로 넘어가는 것 방지
	@RequestMapping(value = "/login/{url}", method = RequestMethod.GET)
	public String login(@PathVariable("url") String url) {
		return "redirect:/user/login?url=login";
	}
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession hSession) {
		
		hSession.removeAttribute("USER");
		hSession = null;
		
		return "redirect:/";
	}
	
	// 회원가입
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		
		return "user/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO vo) {
		log.debug("join {}", vo.toString());
		
		userService.join(vo);
		
		return "redirect:/";
	}
	// MyPage
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypgae(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO) hSession.getAttribute("USER");
		String qna_id = userVO.getUser_id();
		log.debug("qna_id {}", qna_id);
		
		List<QnAVO> qnaList = qnaService.findByIdWithList(qna_id);
		log.debug("QnaList : {}", qnaList.toString());
		
		model.addAttribute("QNALIST", qnaList);
		
		return "user/mypage";
	}
	
	// Id 확인
	@ResponseBody
	@RequestMapping(value="/id_check",method=RequestMethod.GET)
	public String id_check(String user_id) {
		
		UserVO userVO = userService.findById(user_id);

		if(userVO == null) {
			return "NOT_USE_ID";
		} else {
			return "USE_ID";
		}
	}
		
	// 비밀번호 확인하기
	@RequestMapping(value = "/checkPw", method = RequestMethod.GET)
	public String checkPassword(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO) hSession.getAttribute("USER");
		
		if(userVO == null) {
			return "user/login";
		} else {
			return "user/checkPass";
		}
	}
	
	// 회원정보 수정하기
	@RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
	public String updateInfo(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO) hSession.getAttribute("USER");

		model.addAttribute("USER", userVO);
		
		String qna_id = userVO.getUser_id();
		List<QnAVO> qnaList = qnaService.findByIdWithList(qna_id);
		
		model.addAttribute("QNALIST", qnaList);
		
		return "user/mypage";
	}
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public String updateInfo(UserVO userVO, Model model, HttpSession hSession) {
		
		userService.insertOrUpdate(userVO);
		
		hSession.setAttribute("USER", userVO);
		
		return "redirect:/user/updateInfo";
	}

	/* 탈퇴하기 */
	@RequestMapping(value = "/expire", method = RequestMethod.GET)
	public String expire() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/expire", method = RequestMethod.POST)
	public String expire(UserVO userVO, HttpSession hSession) {
		
		UserVO vo = (UserVO) hSession.getAttribute("USER");
		
		if (vo.getUser_pw().equals(userVO.getUser_pw())) {
			// 탈퇴
			userService.expire(userVO);
			hSession.removeAttribute("USER");
			hSession.invalidate();
			return "redirect:/";
			
		} else {
			// 탈퇴 실패
			return "user/join";
		}
	}
}