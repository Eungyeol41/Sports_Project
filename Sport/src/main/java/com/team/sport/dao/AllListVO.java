package com.team.sport.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AllListVO {

	private Long al_seq;
	private String al_code;
	private String al_name;
	private String al_tel;
	private String al_sport;
	private String al_addr;
	private String al_free;

}
