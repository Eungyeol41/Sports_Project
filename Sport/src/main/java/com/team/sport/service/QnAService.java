package com.team.sport.service;

import java.util.List;

import com.team.sport.model.QnAVO;

public interface QnAService extends GenericService<QnAVO, Long> {

	public QnAVO findById(Long seq);
	public QnAVO detail(Long seq);
}
