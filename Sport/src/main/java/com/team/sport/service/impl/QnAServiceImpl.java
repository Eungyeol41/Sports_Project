package com.team.sport.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
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
		
//		log.debug("qnaList: {}", qnaList);
		return qnaList;
	}

	@Override
	public int insert(QnAVO vo) {
		// TODO Auto-generated method stub
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		String curDate = sd.format(date);
		
		vo.setQna_date(curDate);
		
		Integer res = qnaDao.insert(vo);
		return res;
	}

	@Override
	public int update(QnAVO vo) {
		// TODO Auto-generated method stub
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		String curDate = sd.format(date);
		
		vo.setQna_date(curDate);
		
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

	@Override
	public List<QnAVO> findByIdWithList(String qna_id) {
		// TODO MyPage에서 문의리스트 띄우는 부분
		
		List<QnAVO> qnaList = qnaDao.findByIdWithList(qna_id);
		log.debug("Service - qnaList : {}", qnaList.toString());
		
		return qnaList;
	}

	@Override
	public List<QnAVO> findByTitle(String keyword) {
		// TODO 제목으로 검색하기
		
		List<QnAVO> qnaList = qnaDao.findByTitle(keyword);
		
		log.debug("title: {}" , qnaList.toString());
				
		return qnaList;
	}

	@Override
	public List<QnAVO> findByText(String keyword) {
		// TODO 내용으로 검색하기
		
		List<QnAVO> qnaList = qnaDao.findByText(keyword);
		
		log.debug("title: {}" , qnaList.toString());
				
		return qnaList;
	}

	@Override
	public List<QnAVO> findByUser(String keyword) {
		// TODO id로 검색하기
		List<QnAVO> qnaList = qnaDao.findByText(keyword);
		
		log.debug("title: {}" , qnaList.toString());
				
		return qnaList;
	}

	@Override
	public Integer countUpdate(Long seq) {
		// TODO Auto-generated method stub
		
		Integer res = qnaDao.countUpdate(seq);
		
		return res;
	}



}
