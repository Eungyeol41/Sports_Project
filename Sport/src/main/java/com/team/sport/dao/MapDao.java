package com.team.sport.dao;

import com.team.sport.model.MapVO;
import com.team.sport.model.QnAVO;

public interface MapDao extends GenericDao<QnAVO, String>{

	MapVO insert(MapVO vo);
	
}
