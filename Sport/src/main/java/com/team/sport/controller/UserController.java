package com.team.sport.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.sport.model.UserVO;
import com.team.sport.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
	
	protected final UserService userService;

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
	public String login(String user_id, String user_pw, HttpSession hSession, Model model) {
		log.debug("ID : {}", user_id);
		log.debug("비밀번호 : {}", user_pw);
		
		UserVO vo = userService.login(user_id, user_pw);
		
		if(vo == null) {
			
			model.addAttribute("MSG", "LOGIN_FAIL");
			return "redirect:/user/login";
			
		}
		
		hSession.setAttribute("USER", vo);
		return "redirect:/";
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
		
		userService.join(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		
		return "user/update";
	}
	
}
