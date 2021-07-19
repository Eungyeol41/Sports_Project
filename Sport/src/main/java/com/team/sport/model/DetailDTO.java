package com.team.sport.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class DetailDTO {

	private Long v_seq;
	private String v_time;
	private String v_money;
	private String v_site;
	private String v_name;
	private String v_tel;
	private String v_sport;
	private String v_addr;
	private String v_free;
	private String v_lat;
	private String v_lgt;

}
