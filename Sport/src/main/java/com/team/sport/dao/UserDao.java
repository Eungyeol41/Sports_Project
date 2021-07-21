package com.team.sport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.sport.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String>{
	
	public UserVO login(@Param("user_id") String user_id, @Param("user_pw") String user_pw);
	public List<UserVO> join(UserVO userVO);
	
	public UserVO findId(UserVO vo);
	public UserVO findPw(UserVO vo);
	public int update_pw(UserVO vo);
	public int delete(UserVO userVO);
	
	public Integer insertOrUpdate(UserVO vo);

}
