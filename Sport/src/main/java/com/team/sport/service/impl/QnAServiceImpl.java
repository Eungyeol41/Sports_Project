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
@Service("qnaServiceV1")
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
	public int insert(QnAVO vo) {
		// TODO Auto-generated method stub
		
		Integer res = qnaDao.insert(vo);
		return res;
	}

	@Override
	public int update(QnAVO vo) {
		// TODO Auto-generated method stub
		
		Integer res = qnaDao.update(vo);
		
		return res;
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		
		Integer res = qnaDao.delete(seq);
		
		return res;
	}


	@Override
	public QnAVO detail(Long seq) {
		// TODO Auto-generated method stub
		
		QnAVO vo = qnaDao.detail(seq);
		return vo;
	}

	@Override
	public QnAVO findById(Long pk) {
		// TODO Auto-generated method stub
		
		QnAVO vo = qnaDao.findById(pk);
		
		vo.setQna_text(ReplaceBr.enterToBr(vo.getQna_text()));
		
		
		return vo;
	}

//	@Override
//	public List<QnAVO> selectAll(String search_option, String keyword) {
//		// TODO Auto-generated method stub
//		return null;
//	}




}
