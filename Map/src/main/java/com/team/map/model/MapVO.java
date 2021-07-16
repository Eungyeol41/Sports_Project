package com.team.map.model;

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
public class MapVO {

	private String al_addr;
	
	private String m_road;
	private String m_lat;
	private String m_lgt;
	
}
