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

	protected int listPerPage = 10;
	protected int navPerPage = 5;

	@Override
	public PageDTO makePagination(int totalListSize, int currentPage) {

		if(totalListSize < 1) return null;

		int totalPages = (int)Math.round((double)totalListSize / (double)this.listPerPage);
		int startPage = currentPage - (this.navPerPage / 2);
		startPage = startPage < 1 ? 1 : startPage;

		int endPage = startPage + this.navPerPage - 1;
		endPage = endPage > totalPages ? totalPages : endPage;

		int floorData = totalListSize / this.listPerPage;
		int ceilData = floorData + 1;
		ceilData = ceilData > totalListSize ? totalListSize : ceilData;

		PageDTO pageDTO = PageDTO.builder().startPage(startPage).endPage(endPage).totalPages(totalPages).ceilData(ceilData).build();

		return pageDTO;
	}
}
