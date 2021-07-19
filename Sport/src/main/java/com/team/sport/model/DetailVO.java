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
public class DetailVO {

	private String dt_code; // char(4) PK 
	private String dt_time; // varchar(1000) 
	private String dt_money; // varchar(2000) 
	private String dt_site; // varchar(2000) 
	private String dt_lat; // decimal(10,7) 
	private String dt_lgt; // decimal(10,7) 
	private String dt_road; // varchar(255)

	private String al_addr;
	private String al_code;
<<<<<<< HEAD
=======

>>>>>>> 6bf5a2b65dec2595e320600f0ed031c9a08187b8
	
}
