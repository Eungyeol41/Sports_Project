package com.team.sport.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team.sport.dao.UserDao;
import com.team.sport.model.UserVO;
import com.team.sport.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("userServiceV1")
@RequiredArgsConstructor
public class UserServiceImplV1 implements UserService{
	
	protected final UserDao userDao;

	@Override
	public UserVO login(String user_id, String user_pw) {
		// TODO Login
		
		UserVO vo = userDao.login(user_id, user_pw);
		
		if(vo == null) return null;
		
		return vo;
	}

	@Override
	public UserVO join(UserVO userVO) {
		// TODO 회원가입
		List<UserVO> userList = userDao.selectAll();
		log.debug("User :{}", userList.toString());
		
		if(userList == null || userList.size() < 1) {
			userVO.setUser_level(0);
		} else {
			userVO.setUser_level(9);
		}
		
		userDao.insert(userVO);
		
		return userVO;
	}

	@Override
	public int expire(String username) {
		// TODO Auto-generated method stub
		
		userDao.delete(username);
		
		return 0;
	}

	@Override
	public UserVO findById(String user_id) {
		return userDao.findById(user_id);
	}

	@Override
	public int update_pw(UserVO userVO) {
		// TODO 비밀번호 수정
		userDao.update_pw(userVO);
		return 0;
	}

	@Override
	public UserVO findId(UserVO vo) {
		// TODO ID 찾기
		return userDao.findId(vo);
	}
	
	@Override
	public UserVO findPw(UserVO vo) {
		// TODO PW 찾기
		return userDao.findPw(vo);
	}
/*
	@Override
	public String findId(@Param("user_name") String user_name, @Param("user_tel") String user_tel) {
		// TODO Auto-generated method stub
		
		String result = userDao.findId(user_name, user_tel);
		
		return result;
	}
*/
}
