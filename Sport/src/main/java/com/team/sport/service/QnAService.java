package com.team.sport.service;

import java.util.List;

import com.team.sport.model.QnAVO;

public interface QnAService extends GenericService<QnAVO, Long> {

	public QnAVO findById(Long seq);
	public QnAVO detail(Long seq);
//	public List<QnAVO> selectAll(String search_option, String keyword);
	
	public List<QnAVO> findByIdWithList(String qna_id);
	public List<QnAVO> findByTitle(String keyword);
	public List<QnAVO> findByText(String keyword);
	public List<QnAVO> findByUser(String keyword);
	
}
