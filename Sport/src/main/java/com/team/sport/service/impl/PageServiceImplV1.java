package com.team.sport.service.impl;

import org.springframework.stereotype.Service;

import com.team.sport.model.PageDTO;
import com.team.sport.service.PageService;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Service("pageServiceV1")
public class PageServiceImplV1 implements PageService{

	protected int listPerPage = 15;
	protected int navPerPage = 7;

	@Override
	public PageDTO makePagination(int totalListSize, int currentPage) {

		if(totalListSize < 1) return null;

		int startPage = 1;
		int endPage = totalListSize / this.listPerPage + 1;
		int totalPages = (int)Math.round((double)totalListSize / (double)this.listPerPage);
		
		endPage = endPage > totalPages ? totalPages : endPage;

		int offset = (currentPage - 1) * this.listPerPage;
		int limit = offset + this.listPerPage;
		limit = limit > totalListSize ? totalListSize : limit;

		PageDTO pageDTO = PageDTO.builder().startPage(startPage).endPage(endPage).totalPages(totalPages).offset(offset).limit(limit).build();

		return pageDTO;
	}

	@Override
	public PageDTO makePaginationFree(int totalListSize, int currentPage) {
		// TODO Auto-generated method stub
		if(totalListSize < 1) return null;

		int startPage = 1;
		int endPage = totalListSize / this.listPerPage + 1;
		int totalPages = (int)Math.round((double)totalListSize / (double)this.listPerPage);
		
		endPage = endPage > totalPages ? totalPages : endPage;

		int offset = (currentPage - 1) * this.listPerPage;
		int limit = offset + this.listPerPage;
		limit = limit > totalListSize ? totalListSize : limit;

		PageDTO pageDTO = PageDTO.builder().startPage(startPage).endPage(endPage).totalPages(totalPages).offset(offset).limit(limit).build();

		return pageDTO;
	}
}
