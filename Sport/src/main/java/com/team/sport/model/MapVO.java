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
public class MapVO {
	
	private Integer	m_lat; 		// 	위도
	private Integer	m_lng; 		// 	경도
	private String	m_paddress; // 	주소
	private String	m_pname; 	// 	장소명

}
