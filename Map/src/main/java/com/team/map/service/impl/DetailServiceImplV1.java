package com.team.map.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.team.map.dao.DetailDao;
import com.team.map.model.DetailVO;
import com.team.map.service.DetailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("mapServiceV1")
public class DetailServiceImplV1 implements DetailService{
	
	protected final DetailDao detailDao;

	@Override
	public List<DetailVO> selectAddr(String al_addr) {
		// TODO Auto-generated method stub
		
		List<DetailVO> mapList = detailDao.selectAll();
		log.debug("Service - mapList :{}", mapList.toString());
		
		return mapList;
	}

	@Override
	public int insert(DetailVO vo) {
		// TODO Auto-generated method stub
		Map<String , String> map = new HashMap<String, String>();
		
		int result = detailDao.insert(map);
		
		return result;
	}

	@Override
	public int update(DetailVO vo) {
		Map<String , String> map = new HashMap<String, String>();
		
		int result = detailDao.update(map);
		
		return result;
	}

}
