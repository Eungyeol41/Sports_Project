package com.team.map.model;

import java.util.Map;

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
public class GeocodeDTO {

	private String name; // 광주광역시
	private Map<String, String> center; // 
	private String crs; // 좌표
	private String lat; // 위도(x)
	private String lgt; // 경도(y)
	private String alias;
	
}
