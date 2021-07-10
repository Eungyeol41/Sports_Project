package com.team.sport.dao;

import java.util.List;

<<<<<<< HEAD
import com.team.sport.model.AllListVO;
=======
>>>>>>> 5ed215614e1694fce11f6ec92709cd3fbe810cb5
import com.team.sport.model.DetailDTO;
import com.team.sport.model.SearchVO;

public interface SearchDao extends GenericDao<SearchVO, String>{
	
	public List<DetailDTO> selectView();
	
	public List<AllListVO> selectAllList();

<<<<<<< HEAD
	public DetailDTO findSeq(Long v_seq);
=======
>>>>>>> 5ed215614e1694fce11f6ec92709cd3fbe810cb5
}
