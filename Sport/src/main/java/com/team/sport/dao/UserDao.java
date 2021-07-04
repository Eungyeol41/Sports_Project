package com.team.sport.dao;

import java.util.List;

import com.team.sport.model.UserVO;

public interface UserDao {
	
	public UserVO findById(String user_id, String user_pw);
	
	public int insert(UserVO vo);
	public int update(UserVO vo);
	public int delete(String user_id);

}
