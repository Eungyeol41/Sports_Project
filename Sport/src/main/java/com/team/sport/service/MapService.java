package com.team.sport.service;

import java.util.List;
import java.util.Map;

import com.team.sport.model.DetailVO;

public interface MapService extends GenericService<DetailVO, String>{

	public List<DetailVO> select();
	
	public List<DetailVO> selectAddr(String al_addr);

	public int insert(DetailVO vo);
	
<<<<<<< HEAD
	public int update(DetailVO vo);
=======
	public int insert(Map<String, String> map);
	
	public int update(Map<String, String> map);
	

	
>>>>>>> 6bf5a2b65dec2595e320600f0ed031c9a08187b8
	
}
