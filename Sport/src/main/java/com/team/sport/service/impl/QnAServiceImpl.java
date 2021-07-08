package com.team.sport.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.sport.dao.QnADao;
import com.team.sport.model.QnAVO;
import com.team.sport.service.QnAService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class QnAServiceImpl implements QnAService{

	protected final QnADao qnaDao;
	@Override
	public List<QnAVO> selectAll() {
		// TODO Auto-generated method stub
		
		List<QnAVO> qnaList = qnaDao.selectAll(); 
		
		log.debug("qnaList: {}", qnaList);
		return qnaList;
	}

	@Override
	public Integer insert(QnAVO vo) {
		// TODO Auto-generated method stub
		
		Integer res = qnaDao.insert(vo);
		return res;
	}

	@Override
	public Integer update(QnAVO vo) {
		// TODO Auto-generated method stub
		
		Integer res = qnaDao.update(vo);
		return res;
	}

	@Override
	public Integer delete(Long pk) {
		// TODO Auto-generated method stub
		
		Integer res = qnaDao.delete(pk);
		return res;
	}


	@Override
	public QnAVO detail(Long seq) {
		// TODO Auto-generated method stub
		
		QnAVO vo = qnaDao.detail(seq);
		return vo;
	}

	@Override
	public QnAVO findById(Long seq) {
		// TODO Auto-generated method stub
		
		QnAVO vo = qnaDao.findById(seq);
		
		return vo;
	}

//	@Override
//	public List<QnAVO> selectAll(String search_option, String keyword) {
//		// TODO Auto-generated method stub
//		return null;
//	}




}