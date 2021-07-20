package com.team.sport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder

@Getter
@Setter
@ToString
@AllArgsConstructor 
@NoArgsConstructor
public class PageDTO {

	private int startPage;
	private int endPage;
	private int totalPages;
	
	private int offset;
	private int limit;
	
}
