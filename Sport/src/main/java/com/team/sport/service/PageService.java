package com.team.sport.service;

import com.team.sport.model.PageDTO;

public interface PageService {

	public PageDTO makePagination(int totalListSize, int currentPage);
	
	public PageDTO makePaginationFree(int totalListSize, int currentPage);

}
