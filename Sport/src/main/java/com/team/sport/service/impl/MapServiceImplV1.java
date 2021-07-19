package com.team.sport.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.team.sport.dao.MapDao;
import com.team.sport.model.DetailVO;
import com.team.sport.service.MapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("mapServiceV1")
public class MapServiceImplV1 implements MapService{
	
	protected final MapDao mapDao;
	
	@Override
	public List<DetailVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(DetailVO vo) {
		return 0;
//		Map<String , String> map = new HashMap<String, String>();
//
//		int result = MapDao.update(map);
//
//		return result;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DetailVO> select() {
		// TODO Auto-generated method stub

		List<DetailVO> mapList = mapDao.select();

		return mapList;
	}
	
	@Override
	public List<DetailVO> selectAddr(String al_addr) {
		// TODO Auto-generated method stub
		
		List<DetailVO> mapList = mapDao.selectAll();
		log.debug("Service - mapList :{}", mapList.toString());
		
		return mapList;
	}

	@Override
	public int insert(DetailVO vo) {
		// TODO Auto-generated method stub
		Map<String , String> map = new HashMap<String, String>();
		
		int result = mapDao.insert(map);
		
		return result;
	}

	@Override
	public int insert(Map<String, String> map) {
		// TODO Auto-generated method stub
//		
//		int result = mapDao.insert(map);
		
		return 0;
	}

	@Override
	public int update(Map<String, String> map) {
		// TODO Auto-generated method stub
		int result = mapDao.update(map);
		
		return result;
	}

}