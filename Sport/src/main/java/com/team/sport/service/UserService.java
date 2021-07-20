package com.team.sport.service;

import com.team.sport.model.UserVO;

public interface UserService {
	
	public UserVO login(String username, String password);
	public UserVO join(UserVO userVO);
	public int expire(UserVO userVO);
	
	public int update_pw(UserVO userVO);
	public int insertOrUpdate(UserVO vo);

	public UserVO findById(String user_id);
	
	public UserVO findId(UserVO vo);
	public UserVO findPw(UserVO vo);



}
