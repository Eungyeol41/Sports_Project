package com.team.sport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SearchVO {

	private Long sp_seq;
	private String sp_money;
	private String sp_district;
	private String sp_search;
	private String sp_sport;

	
}
