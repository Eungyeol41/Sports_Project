package com.team.map.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.team.map.dao.MapDao;
import com.team.map.model.MapVO;
import com.team.map.service.MapService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("mapServiceV1")
public class MapServiceImplV1 implements MapService{
	
	protected final MapDao mapDao;

	@Override
	public List<MapVO> selectAddr(String al_addr) {
		// TODO Auto-generated method stub
		
		List<MapVO> mapList = mapDao.selectAll();
//		log.debug("Service - mapList :{}", mapList.toString());
		
		return mapList;
	}

	@Override
	public int insert(MapVO vo) {
		// TODO Auto-generated method stub
		
		int result = mapDao.insert();
		
		return result;
	}

}
