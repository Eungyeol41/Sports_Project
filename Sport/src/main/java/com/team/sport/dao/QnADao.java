package com.team.sport.dao;

import java.util.List;

import com.team.sport.model.QnAVO;

public interface QnADao extends GenericDao<QnAVO, Long> {
	
	public QnAVO detail(Long seq);
	
	public List<QnAVO> findByIdWithList(String user_id);
	
	public List<QnAVO> findByTitle(String title);
	public List<QnAVO> findByText(String text);
	public List<QnAVO> findByUser(String user);
	
	public Integer countUpdate(Integer hit);

}
