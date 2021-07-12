package com.team.sport.service;

import java.util.List;

import com.team.sport.model.UserVO;

public interface UserService {
	
	public UserVO login(String username, String password);
	
	public UserVO join(UserVO userVO);
//	public int update(UserVO userVO);
	public int update_pw(UserVO userVO);
	
	public int expire(String username);

	public UserVO findById(String user_id);
	
	public UserVO findId(UserVO vo);
	public UserVO findPw(UserVO vo);

//	public List<UserVO> findId(UserVO vo);

}
