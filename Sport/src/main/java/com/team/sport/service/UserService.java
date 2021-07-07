package com.team.sport.service;

import com.team.sport.model.UserVO;

public interface UserService {
	
	public UserVO login(String username, String password);
	
	public int insert(UserVO userVO);
	public int update(UserVO userVO);
	
	public int expire(String username);

	public UserVO findById(String user_id);
	
}
