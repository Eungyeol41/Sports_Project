package com.team.sport.service.impl;

import org.springframework.stereotype.Service;

import com.team.sport.dao.UserDao;
import com.team.sport.model.UserVO;
import com.team.sport.service.UserService;

import lombok.RequiredArgsConstructor;

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
	public int join(UserVO userVO) {
		// TODO 회원가입
		
		userDao.insert(userVO);
		
		return 0;
	}

	@Override
	public int update(UserVO userVO) {
		// TODO Auto-generated method stub
		
		userDao.update(userVO);
		
		return 0;
	}

	@Override
	public int expire(String username) {
		// TODO Auto-generated method stub
		
		userDao.delete(username);
		
		return 0;
	}

}
