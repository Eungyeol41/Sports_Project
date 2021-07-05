package com.team.sport.dao;

import com.team.sport.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String>{
	
	public UserVO findById(String user_id, String user_pw);
	
}
