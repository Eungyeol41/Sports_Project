package com.team.sport.dao;

import org.apache.ibatis.annotations.Param;

import com.team.sport.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String>{
	
	public UserVO login(@Param("user_id") String user_id, @Param("user_pw") String user_pw);
	
}
