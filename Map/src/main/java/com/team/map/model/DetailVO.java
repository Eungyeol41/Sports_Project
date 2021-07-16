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
public class DetailVO {

	   private String dt_code; // char(4) PK 
	   private String dt_time; // varchar(1000) 
	   private String dt_money; // varchar(2000) 
	   private String dt_site; // varchar(2000) 
	   private String dt_lat; // decimal(10,7) 
	   private String dt_lgt; // decimal(10,7) 
	   private String dt_road; // varchar(255)
	   
	   private String al_addr;
	
}
