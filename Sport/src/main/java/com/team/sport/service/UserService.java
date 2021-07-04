package com.team.sport.service;

import com.team.sport.model.UserVO;

public interface UserService {
	
	public UserVO login(String username, String password);
	public int join(UserVO vo);
	
	public int update(UserVO vo);
	
	public int expire(String username);

}
