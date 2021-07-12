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
	
	@RequestMapping(value = "/login/{url}", method = RequestMethod.GET)
	public String login(@PathVariable("url") String url) {
		return "redirect:/user/login?url=login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession hSession) {
		
		hSession.removeAttribute("USER");
		hSession = null;
		
		return "redirect:/";
	}
	
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
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		
		return "user/update";
	}
	
	
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
	
	@RequestMapping(value = "/info_update", method = RequestMethod.GET)
	public String info_update(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO) hSession.getAttribute("USER");
		
		return "user/info_update";
	}
	
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

	@RequestMapping(value = "/findId", method = RequestMethod.GET)
	public String findId() {
		return "user/find_Id";
	}
	
	@RequestMapping(value = "/findId", method = RequestMethod.POST)
	public String findId(Model model, UserVO vo) {
		
		UserVO userVO = userService.findId(vo);
		
		if(userVO == null) {
			model.addAttribute("USERVO", "NONE");
		} else {
			model.addAttribute("USERVO", "CHECK");
			model.addAttribute("ID", userVO.getUser_id());
		}
		
		return "user/find_Id";
	}
	
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPw() {
		return "user/find_Pw";
	}

	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String findPw(UserVO vo, Model model) {
		
		UserVO userVO = userService.findPw(vo);
		
		if(userVO == null) {
			model.addAttribute("USERVO", "NONE");
		} else {
			model.addAttribute("USERVO", "CHECK");
			model.addAttribute("USER", userVO);
		}
		
		return "user/find_Pw";
	}

	@RequestMapping(value = "/updatePw", method = RequestMethod.GET)
	public String updatePw(@RequestParam(value = "updatePw", defaultValue = "", required = false) String user_id, UserVO userVO) {
		
		userVO.setUser_id(user_id);
		userService.update_pw(userVO);
		
		return "user/update_pw";
	}
	
	@RequestMapping(value = "/checkPw", method = RequestMethod.GET)
	public String checkPassword(HttpSession hSession, Model model) {
		
		UserVO userVO = (UserVO) hSession.getAttribute("USER");
		
		if(userVO == null) {
			return "user/login";
		} else {
			return "user/checkPass";
		}
	}
	
	public String admin_login() {
		
		
		
		return "user/admin";
	}
	
}